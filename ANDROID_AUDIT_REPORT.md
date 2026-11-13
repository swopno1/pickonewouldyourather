# Android Audit Report — Pick One! – Would You Rather

**Application:** Pick One! – Would You Rather
**Package ID:** `com.vivescriptsolutions.pickonewouldyourather` (namespace `com.example`)
**Version audited:** versionCode 3, versionName 3.0
**Audit date:** 2026-11-12
**Method:** Multi-agent inspection (source, build, docs, UI surface) + verification builds/tests
**Supersedes:** `FINAL_RELEASE_AUDIT.md` (v1.0-era, preserved for history)

---

## 1. Project condition

Single-activity MVVM Compose party game in good structural shape: 25 bilingual questions, category filtering, vote percentages, streak tracking, prev/next navigation, ACTION_SEND share sheet, EN/BN in-app toggle, testTags throughout, landscape/tablet-aware layouts. Git history is short and the tree was clean at audit start.

## 2. Findings and fixes (this modernization)

| # | Finding | Severity | Disposition |
|---|---------|----------|-------------|
| 1 | No UMP consent integration; live ad units resolvable in all builds | High | Fixed: UMP 4.0.0 + ConsentManager gating + per-variant units (dex verified demo-only) |
| 2 | KSP/secrets/google-services plugins + firebase BOM applied but entirely unused | Medium | Fixed: all removed; ~30 dead catalog entries pruned |
| 3 | Privacy claimed COPPA/Families compliance while running standard ads untargeted at children | Medium | Fixed: rewritten to 13+ positioning, no Families enrollment |
| 4 | Mockup screenshots showed nonexistent UI + fake vote counts (misleading-listing risk) | Medium | Fixed: 4 mockups deleted (git history retains them); phone-01 verified real |
| 5 | Transitive fragment outdated class of warning | Medium | Fixed: constrained to 1.9.1, verified in release graph |
| 6 | Invalid launcher background (`<color>` in drawable/) — lint error | Medium | Fixed: rewritten as proper `<shape>` |
| 7 | Zero permissions beyond merger for ads (no AD_ID/ACCESS_NETWORK_STATE) | Low | Fixed: both declared explicitly |
| 8 | BN gaps: option labels, vote badges, all contentDescriptions, legal block, share sheet, choosers | Low | Fixed: all follow the language toggle |
| 9 | About dialog hardcoded Version 1.0.0; deprecated Divider import | Low | Fixed: BuildConfig version; import removed |
| 10 | metadata.json phantom Gemini capability; title miscount (30 vs 28) | Low | Fixed |
| 11 | All docs stale at v1.0; missing declarations/EU/listing/notes docs | Low | Fixed: full doc set created/updated |
| 12 | Test gaps: previous nav, share text, streak, sound, consent gating | Low | Fixed: 7-test ViewModel suite added |
| 13 | No `gradlew`/wrapper jar in repo; no debug keystore | Low | Fixed: wrapper committed; gitignored debug keystore generated locally |

## 3. Intentionally not changed

- **Namespace `com.example`:** branding-inconsistent but fully functional (`applicationId` is correct). A package rename is high-risk churn with zero user benefit.
- **In-code EN/BN toggle (no `values-bn/`):** works, complete (all 25 questions), now gap-free. Migrating to resources risks breakage for no functional gain. Recommended as future work, not a blocker.
- **Guarded vibrator/audio deprecations:** SDK-branched legacy paths for old devices; benign and intentional.
- **Interstitial every 5 answers:** preserved exactly as designed (policy-compliant pacing).
- **AGP 9.1.1 / Kotlin 2.2.10 / BOM 2024.09.00:** kept aligned with the sibling-app family stack.
- **Release signing:** operator-owned per standing rule (fail-fast without secrets).

## 4. Verification results

- `assembleDebug`: BUILD SUCCESSFUL
- `testDebugUnitTest`: 15/15 PASS on JDK 21 (7 new ViewModel tests included)
- `lintDebug`: 0 errors, 33 pre-existing cosmetic warnings
- Debug dex ad-ID scan: demo units only (`ca-app-pub-3940256099942544/...`); no live unit IDs
- Release dependency graph: `androidx.fragment:fragment:1.1.0 -> 1.9.1`
- Release notes: EN 362 chars, BN 350 chars (limit 500)
- Short description 75 chars, title 28 chars (limits 80 / 30)

## 5. Residual risks / human confirmations

1. Latest uploaded Play versionCode unconfirmed — local is 3/3.0; verify Console shows ≤2 before uploading, else bump.
2. AdMob GDPR + US-state messages must be published for App ID `~7046666712`; EEA ads stay disabled by design until then.
3. Privacy/terms hosting URLs assumed from sibling-app pattern; pages must be live before review.
4. Only 1 of 4 phone screenshots + 0 tablet shots exist — capture the rest on a device before submission.
5. IARC questionnaire must be answered honestly by a human (recommended: Everyone).
6. No on-device run performed in this session (no device attached); runtime verification is recommended before upload.
