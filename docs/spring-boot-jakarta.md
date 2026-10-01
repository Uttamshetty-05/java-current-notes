# Spring Boot 3 and Jakarta

Spring Boot 3 requires **Java 17+** and uses the **Jakarta** namespace (`jakarta.*`) instead of `javax.*`.

## What changed

- `javax.servlet` → `jakarta.servlet`
- `javax.persistence` → `jakarta.persistence`
- Validation, inject, and mail packages followed the same rename

If you still see `javax.*` imports, the project is on Boot 2 or an incomplete upgrade.

## Current stack that recruiters recognize

- Spring Boot 3.4 / 3.5 line (check start.spring.io for the latest GA)
- Spring Security 6
- Spring Data JPA with Hibernate 6
- Observability via Micrometer + OpenTelemetry
- Native images with GraalVM for cold-start sensitive services

## REST style that still wins interviews

- Constructor injection, not field `@Autowired`
- Records as request/response DTOs
- `@Valid` on the API boundary
- Problem Details (`application/problem+json`) for errors
- Test slices: `@WebMvcTest`, `@DataJpaTest`, Testcontainers for integration
