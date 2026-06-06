<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0D1117&height=150&section=header&text=%E5%A4%9A%E6%99%BA%E8%83%BD%E4%BD%93%E4%B8%B4%E5%BA%8A%E7%B3%BB%E7%BB%9F&fontSize=36&fontColor=58A6FF&animation=fadeIn" />

[![Spring AI](https://img.shields.io/badge/Spring_AI-6DB33F?style=flat-square&logo=spring&logoColor=white)]()
[![WebFlux](https://img.shields.io/badge/Spring_WebFlux-6DB33F?style=flat-square&logo=reactivex&logoColor=white)]()
[![Multi-Agent](https://img.shields.io/badge/Multi-Agent-FF6B6B?style=flat-square)]()
[![Milvus](https://img.shields.io/badge/Milvus-00A1EA?style=flat-square)]()

</div>

---

## ✨ Features

<div align="center">

<table>
<tr>
<td width="33%" align="center">🤖<br/><b>多智能体解耦</b><br/>Collector / Retriever / Analyzer</td>
<td width="33%" align="center">⚙️<br/><b>状态机工作流</b><br/>WebFlux 轻量级引擎</td>
<td width="33%" align="center">🔗<br/><b>异构集成</b><br/>HIS / LIS / PACS</td>
</tr>
</table>

</div>

---

## 🏗️ Multi-Agent Architecture

```
                    ┌──────────────────┐
                    │  Workflow Engine │
                    │  (State Machine) │
                    └──┬───┬───┬───────┘
                       │   │   │
          ┌────────────▼┐ │   └────────────▼┐
          │  Collector   │ │      Retriever   │
          │  Agent       │ │      Agent       │
          │  HIS/LIS/    │ │      RAG         │
          │  PACS 集成   │ │      Milvus      │
          └──────┬───────┘ └──────┬──────────┘
                 │                │
                 └────────┬───────┘
                          ▼
                  ┌──────────────┐
                  │   Analyzer   │
                  │    Agent     │
                  │  AI 诊断建议  │
                  └──────────────┘
```

**Workflow States:** `INIT → COLLECTING → RETRIEVING → ANALYZING → COMPLETED`

---

## 🛠️ Tech Stack

| Agent | Responsibility | Tech |
|-------|---------------|------|
| **Coordinator** | 工作流调度、状态管理 | Spring WebFlux + StateMachine |
| **Collector** | 资料汇总（HIS/LIS/PACS） | Spring AI + HTTP Client |
| **Retriever** | 文献检索（RAG） | Milvus + Embedding Model |
| **Analyzer** | 辅助诊断分析 | ChatClient + Prompt Engineering |

---

## 🚀 Quick Start

\`\`\`bash
git clone https://github.com/chopinhhm/multi-agent-clinical.git
cd multi-agent-clinical
mvn clean package -DskipTests
java -jar agent-coordinator/target/*.jar
\`\`\`

---

## 📄 License

MIT © [chopinhhm](https://github.com/chopinhhm)
