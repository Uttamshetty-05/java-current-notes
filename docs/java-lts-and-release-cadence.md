# Java LTS and release cadence

Oracle publishes a new JDK every six months. Long-Term Support (LTS) releases are the ones most companies standardize on.

## Versions that matter in production

| Release | Role | Why teams care |
| --- | --- | --- |
| Java 17 | Previous LTS | Still common in banks and older Spring Boot 2/3 upgrades |
| Java 21 | Current mainstream LTS | Virtual threads, sequenced collections, pattern matching for `switch` |
| Java 25 | Newest LTS (Sept 2025) | Next enterprise target after 21 |

Non-LTS releases (22, 23, 24, 26, …) are useful for trying language features early, but most product teams wait for LTS.

## Practical upgrade advice

1. Treat **21** as the default for new services in 2026 unless the org has already moved to **25**.
2. Keep bytecode and CI on the same major as production.
3. Prefer the Temurin, Microsoft, Amazon Corretto, or Oracle JDK builds your security team already approves.
4. Enable preview features only in spike branches, never in production.

## Language features that landed around 21+

- Virtual threads (`java.lang.Thread.startVirtualThread`)
- Record patterns and `switch` pattern matching
- Sequenced collections (`SequencedCollection`)
- String templates were dropped; use `formatted()` or a library instead
