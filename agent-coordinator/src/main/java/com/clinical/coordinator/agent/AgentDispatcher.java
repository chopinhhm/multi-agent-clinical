package com.clinical.coordinator.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * 智能体调度器
 * 负责将任务分发给对应的 Agent 执行
 * 
 * 设计原则：
 * - Agent 职责解耦，支持独立扩容
 * - 基于响应式模型，非阻塞调度
 * - 每个Agent有独立的超时和重试策略
 */
@Slf4j
@Service
public class AgentDispatcher {

    /**
     * 调度资料汇总 Agent
     */
    public Mono<String> dispatchCollector(String taskId) {
        log.info("调度资料汇总 Agent, taskId={}", taskId);
        // 调用 agent-collector 服务
        return Mono.just("collector result");
    }

    /**
     * 调度文献检索 Agent
     */
    public Mono<String> dispatchRetriever(String taskId) {
        log.info("调度文献检索 Agent, taskId={}", taskId);
        return Mono.just("retriever result");
    }

    /**
     * 调度诊断分析 Agent
     */
    public Mono<String> dispatchAnalyzer(String taskId) {
        log.info("调度诊断分析 Agent, taskId={}", taskId);
        return Mono.just("analyzer result");
    }
}
