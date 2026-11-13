# Production Readiness — Pick One! 3.0 (versionCode 3)

**Package:** `com.vivescriptsolutions.pickonewouldyourather`
**Assessment date:** 2026-11-12
**Previous release:** v1.0 (versionCode 1, per docs; Console state unconfirmed)
**Proposed release:** v3.0 (versionCode 3)

## Category results

| Category                 | Result  |
| ------------------------ | ------- |
| Android SDK & Gradle     | Pass    |
| Dependencies             | Pass    |
| Build stability          | Pass    |
| Security                 | Pass    |
| Privacy                  | Pass    |
| EU compliance assessment | Warning |
| Google Play declarations | Warning |
| Data Safety              | Pass    |
| UI/UX                    | Pass    |
| Device compatibility     | Warning |
| Localization             | Pass    |
| Documentation            | Pass    |
| Store listing            | Warning |
| Release configuration    | Warning |
| Testing                  | Pass    |

Warnings are all human-side prerequisites (console messages, hosted policy pages, screenshots, questionnaire answers, keystore) plus the missing on-device run — not code defects.

## Final verdict

**PRODUCTION READY WITH WARNINGS**

The application is functional and all critical checks passed. Remaining items are operator actions in Play Console / AdMob Console, hosted legal pages, real screenshots, and a recommended on-device pass.

## Quality score: 87/100

Solid offline-first game, complete bilingual UI, tested consent gating. Points held for: 3 missing phone screenshots + tablet shot, no on-device verification this session.

## Tests executed

- `assembleDebug`: BUILD SUCCESSFUL
- `testDebugUnitTest`: 15/15 PASS on JDK 21 (7 new ViewModel tests: wrap-around nav, vote lock, streaks, sound, bilingual share + store link, demo-ID pinning, consent gate)
- `lintDebug`: BUILD SUCCESSFUL, 0 errors
- Debug dex ad-ID scan: demo units only — no live IDs
- Release dependency graph: fragment 1.1.0 → 1.9.1
- NOT verified on-device: no device was attached during this session.

## Critical unresolved issues

None in code.

## Non-critical recommendations

1. Capture the 3 missing phone screenshots + tablet shot on-device.
2. Publish AdMob GDPR + US-state messages for `~7046666712`.
3. Migrate the in-code strings to `values/` + `values-bn/` resources (long-term).
4. Add Compose UI tests reusing testTags (current suite covers ViewModel + config).

## Required human decisions

1. Confirm Play Console shows versionCode ≤ 2 as latest upload (else bump past it).
2. Publish privacy/terms pages at the assumed URLs; confirm live.
3. Answer the IARC questionnaire honestly (recommended: Everyone).
4. Create AdMob regulatory messages (GDPR required for EEA; US-state recommended).
5. Build the signed AAB with the operator-owned release keystore; verify with `apksigner`.
