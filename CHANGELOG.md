# Changelog

All notable changes to **Pick One! – Would You Rather** will be documented in this file.

## [3.0] - 2026-11-12

### Added
- **UMP Consent Gating:** Google User Messaging Platform (UMP SDK 4.0.0) consent flow gates all ads; EU/UK users who decline never initialize the Mobile Ads SDK. Covers both European regulations and US state regulations AdMob messages.
- **Ad Privacy Options entry point:** About dialog exposes the UMP privacy-options form (EN/BN) when required.
- **Per-Variant Ad Units:** Debug builds use Google demo units; release builds use production units (`.../7491363151` banner, `.../5949207462` interstitial). Verified demo-only in debug dex.
- **Explicit permissions:** `ACCESS_NETWORK_STATE` and `AD_ID` declared (previously merger-only).
- **ViewModel test suite:** 7 tests covering navigation wrap-around, vote locking, streaks, sound toggle, share text (both languages + store link), demo-ID pinning, and consent gating.
- **Share-to-install loop:** every share text now ends with a Play Store install link.
- **Play compliance doc set:** `GOOGLE_PLAY_DECLARATIONS.md`, `EU_TRADE_POLICY_COMPLIANCE.md`, root `pickonewouldyourather_PlayStore_Details.md`, `release-notes-en.txt`, `release-notes-bn.txt`.

### Changed
- **Dependency Pruning:** Removed KSP, secrets, and google-services plugins (all unused), the firebase BOM platform, the unused direct fragment dependency (replaced by a 1.9.1 constraint), and ~30 unused catalog entries.
- **Java 17 toolchain** (was 11).
- **About dialog:** version now reads from `BuildConfig` (was hardcoded 1.0.0).
- **Full BN Coverage:** option labels, vote badges, all content descriptions, legal block, share sheet, and chooser titles now follow the language toggle.
- **`.values()` → `.entries`**; deprecated `Divider` import removed.
- **Listing Honesty:** fixed title char miscount; "100% offline" claims corrected to offline-first with ads disclosure.
- **Store Graphics:** icon/graphic/phone-01 flattened to no-alpha.

### Fixed
- Play Console outdated-SDK class of warning: transitive fragment pinned to 1.9.1.
- Invalid launcher background drawable (`<color>` in drawable/) rewritten as a proper `<shape>` (was a lint error).
- Data Safety deletion answer corrected (Yes); privacy children’s section aligned with 13+ positioning (was COPPA/Families claim).
- Misleading mockup screenshots (phone-02/03/04, tablet-01) removed — showed nonexistent UI and fake vote counts.
- metadata.json phantom `MAJOR_CAPABILITY_SERVER_SIDE_GEMINI_API` removed.

## [1.0.0] - 2026-10-10

### Initial Release
- **Core Gameplay:** Two contrasting choice cards (Option A & Option B) with instant percentage reveals.
- **Offline Library:** Curated question database spanning 7 unique categories: Funny, Food, Superpowers, Daily Life, Impossible Choices, Travel, and Animals.
- **Bilingual Localization:** Complete English and বাংলা (Bangla) translation with real-time toggle.
- **Social Sharing:** Instant share intent sheet optimized for WhatsApp, Instagram Stories, TikTok, and clipboard copy.
- **Adaptive UI:** Material 3 responsive layout adapting seamlessly from vertical phones to landscape tablets and foldables.
- **Audio & Haptics:** Sound effect synthesizer and gentle haptic feedback with global mute control.
- **Google Play Compliance:** Zero user tracking, zero accounts, full Play Store metadata, privacy policy, and design assets included.
