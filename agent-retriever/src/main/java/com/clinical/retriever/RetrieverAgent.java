package com.clinical.retriever;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 文献检索智能体
 * 
 * 职责：
 * - 接收临床资料摘要，提取关键信息
 * - 在私有化 RAG 知识库中检索相关医学文献
 * - 返回 Top-K 相关文献摘要
 */
@Slf4j
@Component
public class RetrieverAgent {

    private final VectorStore vectorStore;
    private final EmbeddingModel embeddingModel;

    public RetrieverAgent(VectorStore vectorStore, EmbeddingModel embeddingModel) {
        this.vectorStore = vectorStore;
        this.embeddingModel = embeddingModel;
    }

    /**
     * 检索相关医学文献
     * @param clinicalSummary 临床资料摘要
     * @param topK 返回数量
     * @return 相关文献列表
     */
    public List<String> retrieveLiterature(String clinicalSummary, int topK) {
        log.info("检索医学文献, topK={}", topK);
        
        List<Document> documents = vectorStore.similaritySearch(clinicalSummary);
        
        return documents.stream()
                .limit(topK)
                .map(Document::getText)
                .collect(Collectors.toList());
    }
}
