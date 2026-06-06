-- 多智能体临床系统 数据库初始化脚本
CREATE DATABASE IF NOT EXISTS multi_agent_clinical DEFAULT CHARACTER SET utf8mb4;
USE multi_agent_clinical;

-- 工作流任务表
CREATE TABLE workflow_task (
    id VARCHAR(36) PRIMARY KEY,
    patient_id VARCHAR(36) NOT NULL,
    state VARCHAR(30) NOT NULL DEFAULT 'INIT',
    clinical_data TEXT COMMENT '汇总的临床资料',
    literature TEXT COMMENT '检索的文献结果',
    analysis_report TEXT COMMENT '诊断分析报告',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_patient (patient_id)
) ENGINE=InnoDB COMMENT='工作流任务表';
