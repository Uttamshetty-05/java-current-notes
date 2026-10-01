# Java and AI in 2026

Python still dominates research notebooks. Java still dominates **production backends**. The overlap is now real:

## Libraries

| Library | Use |
| --- | --- |
| [Spring AI](https://docs.spring.io/spring-ai/reference/) | Chat clients, advisors, vector store adapters inside Spring Boot |
| [LangChain4j](https://docs.langchain4j.dev/) | Prompts, tools, RAG, embedding stores without tying you to Spring |
| OpenAI / Azure OpenAI Java SDKs | Direct HTTP clients when you want fewer abstractions |
| DJL (Deep Java Library) | On-JVM model inference (PyTorch / ONNX) |

## Patterns that show up in real services

1. **RAG**: chunk docs → embeddings → vector DB (pgvector, Redis, Qdrant) → retrieve → prompt.
2. **Tool calling**: the model picks a Java method (search, book, query DB) with a JSON schema.
3. **Guards**: max tokens, timeouts, PII filters, and audit logs around every call.
4. **Streaming**: SSE from Spring WebFlux or MVC so the UI can render tokens.

## Interview talking points

- Keep prompts and model names in config, not hardcoded.
- Treat the LLM like an unreliable dependency: retries, circuit breakers, fallbacks.
- Never send secrets or raw PII in prompts.
- Evaluate answers with a golden set; do not ship on “it looked good once”.
