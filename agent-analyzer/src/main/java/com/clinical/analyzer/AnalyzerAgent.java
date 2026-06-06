package com.clinical.analyzer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

/**
 * 诊断分析智能体
 * 
 * 职责：
 * - 综合临床资料和文献检索结果
 * - 利用大模型生成辅助诊断建议
 * - 输出结构化的分析报告
 */
@Slf4j
@Component
public class AnalyzerAgent {

    private final ChatClient.Builder chatClientBuilder;

    public AnalyzerAgent(ChatClient.Builder chatClientBuilder) {
        this.chatClientBuilder = chatClientBuilder;
    }

    /**
     * 生成辅助诊断报告
     * @param clinicalData 临床资料汇总
     * @param literature 文献检索结果
     * @return 诊断分析报告
     */
    public String analyze(String clinicalData, List<String> literature) {
        log.info("开始诊断分析");
        
        StringBuilder prompt = new StringBuilder();
        prompt.append("你是一位经验丰富的临床诊断顾问。\n\n");
        prompt.append("【临床资料】\n").append(clinicalData).append("\n\n");
        prompt.append("【相关文献】\n");
        for (String lit : literature) {
            prompt.append("- ").append(lit).append("\n");
        }
        prompt.append("\n请基于以上资料，给出辅助诊断建议，包括：\n");
        prompt.append("1. 可能的诊断方向\n");
        prompt.append("2. 建议的进一步检查\n");
        prompt.append("3. 治疗参考方案\n");
        
        ChatClient chatClient = chatClientBuilder.build();
        return chatClient.prompt().user(prompt.toString()).call().content();
    }
}
