package com.clinical.coordinator.workflow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 轻量级状态机工作流引擎
 * 基于 Spring WebFlux 实现异步非阻塞的多智能体调度
 * 
 * 工作流节点：
 * COLLECT -> RETRIEVE -> ANALYZE -> COMPLETE
 * 
 * 每个节点对应一个 Agent 的执行任务
 */
@Slf4j
@Component
public class WorkflowEngine {

    /** 工作流状态枚举 */
    public enum State {
        INIT, COLLECTING, RETRIEVING, ANALYZING, COMPLETED, FAILED
    }

    /** 状态转移规则 */
    private static final Map<State, Set<State>> TRANSITIONS = new HashMap<>();
    static {
        TRANSITIONS.put(State.INIT, Set.of(State.COLLECTING));
        TRANSITIONS.put(State.COLLECTING, Set.of(State.RETRIEVING, State.FAILED));
        TRANSITIONS.put(State.RETRIEVING, Set.of(State.ANALYZING, State.FAILED));
        TRANSITIONS.put(State.ANALYZING, Set.of(State.COMPLETED, State.FAILED));
    }

    /**
     * 执行状态转移
     * @param taskId 任务ID
     * @param current 当前状态
     * @param target 目标状态
     * @return 是否转移成功
     */
    public boolean transition(String taskId, State current, State target) {
        Set<State> allowed = TRANSITIONS.get(current);
        if (allowed == null || !allowed.contains(target)) {
            log.warn("非法状态转移: taskId={}, {} -> {}", taskId, current, target);
            return false;
        }
        log.info("状态转移: taskId={}, {} -> {}", taskId, current, target);
        return true;
    }

    /**
     * 启动工作流
     */
    public void startWorkflow(String taskId) {
        log.info("启动工作流: taskId={}", taskId);
        // 1. COLLECTING: 调用资料汇总 Agent
        // 2. RETRIEVING: 调用文献检索 Agent
        // 3. ANALYZING: 调用诊断分析 Agent
        // 4. COMPLETED: 汇总结果返回
    }
}
