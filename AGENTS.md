# blackjack engineering guidance

<!-- ecc-engineering-defaults:start -->
## Engineering defaults
For coding work, read [.engineering/defaults.md](.engineering/defaults.md).
These are shared fallback conventions; the existing project owner, nested instructions,
skills, model choices, domain contracts and stronger verification/release gates remain authoritative.
No hooks, permissions, MCP services or background automation are installed by this guidance.

### Project adaptation
Java 11 / Spring Boot Maven project with wrapper. Candidate check: `./mvnw test` (Windows: `.\mvnw.cmd test`) after inspecting tests for external services. Preserve game rules and test deterministic deck/score boundaries; do not change Java/dependency versions as part of unrelated work.
<!-- ecc-engineering-defaults:end -->
