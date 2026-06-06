package com.clinical.collector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 资料汇总智能体
 * 
 * 职责：
 * - 从 HIS（医院信息系统）获取患者基本信息、就诊记录
 * - 从 LIS（实验室信息系统）获取检验报告数据
 * - 从 PACS（影像归档系统）获取影像报告
 * - 整合汇总为结构化临床资料
 */
@Slf4j
@Component
public class CollectorAgent {

    /**
     * 收集患者临床资料
     * @param patientId 患者ID
     * @return 汇总后的临床资料
     */
    public String collectClinicalData(String patientId) {
        log.info("开始收集患者资料, patientId={}", patientId);
        
        // Step 1: 从 HIS 获取基本信息和就诊记录
        String hisData = fetchFromHIS(patientId);
        
        // Step 2: 从 LIS 获取检验报告
        String lisData = fetchFromLIS(patientId);
        
        // Step 3: 从 PACS 获取影像报告
        String pacsData = fetchFromPACS(patientId);
        
        // Step 4: 汇总整合
        return String.format("患者资料汇总:\n%s\n%s\n%s", hisData, lisData, pacsData);
    }

    private String fetchFromHIS(String patientId) {
        // 调用 HIS 系统接口
        return "HIS数据: 患者基本信息、就诊记录、诊断结果";
    }

    private String fetchFromLIS(String patientId) {
        // 调用 LIS 系统接口
        return "LIS数据: 血常规、生化检验、免疫检验结果";
    }

    private String fetchFromPACS(String patientId) {
        // 调用 PACS 系统接口
        return "PACS数据: CT影像报告、X光报告";
    }
}
