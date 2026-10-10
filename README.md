# Pick One! – Would You Rather

[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-purple.svg)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack_Compose-Material3-blue.svg)](https://developer.android.com/jetpack/compose)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A fun, lightweight, offline **Would You Rather?** Android party game developed by **ViveScript Solutions LLC**. Players choose between hilarious, difficult, surprising, or thought-provoking options, discover community vote percentages, and share spicy dilemmas with friends across social media.

---

## 🌟 Key Features

- **Instant Offline Play:** Works 100% offline without accounts, logins, internet connection, or external APIs.
- **Vibrant Material 3 Design:** Rich, contrasting choice cards with smooth animations, satisfying tactile feedback, and intuitive navigation.
- **Diverse Curated Categories:** Funny & Silly, Food & Treats, Superpowers & Magic, Everyday Life, Impossible Choices, Travel & Adventure, and Animals & Nature.
- **Bilingual Support (English & Bangla):** Switch seamlessly between English and বাংলা with a single tap.
- **Built-in Social Sharing:** Share questions directly to WhatsApp, Instagram Stories, TikTok, or copy them to your clipboard.
- **Adaptive Layout:** Responsive design that transitions smoothly between vertical phones and horizontal tablet / foldable screens.
- **Audio & Haptic Feedback:** Cheerful sound tones and gentle vibration with an instant mute toggle.
- **AdMob Ready:** Clean `AdConfig` architecture supporting the latest Google Mobile Ads SDK with official test IDs.

---

## 📱 Screenshots

Preview assets and Google Play promotional graphics are available under `/play_store_assets/`:
- `play_store_assets/app-icon/app-icon.png` (512x512 Google Play icon)
- `play_store_assets/feature-graphic/feature-graphic.png` (1024x500 Feature banner)
- `play_store_assets/phone/` (Phone screenshots 01 to 04)
- `play_store_assets/tablet/` (Tablet landscape screenshot)

---

## 🛠️ Technology Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose with Material Design 3
- **Architecture:** MVVM (Model-View-ViewModel) with StateFlow
- **Concurrency:** Kotlin Coroutines
- **Target SDK:** 36 (Android 15+)
- **Min SDK:** 24 (Android 7.0 Nougat)

---

## 🚀 Building & Running

### Prerequisites
- Android Studio Ladybug / Meerkat or later
- JDK 11 or later
- Android SDK 36

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/vivescriptsolutions/pick-one-would-you-rather.git
   cd pick-one-would-you-rather
   ```
2. Open the project in Android Studio.
3. Sync Gradle and build the debug APK:
   ```bash
   gradle :app:assembleDebug
   ```
4. Run unit and Robolectric tests:
   ```bash
   gradle :app:testDebugUnitTest
   ```

---

## 🔒 Privacy & Data Safety

- **No Personal Data Collected by App:** The application does not collect, record, track, or share any personal user profiles, emails, or names.
- **Offline Core Gameplay:** Complete question catalog is bundled within the APK/AAB and playable offline.
- **Advertising (AdMob):** Integrates Google Mobile Ads SDK (`play-services-ads:23.6.0`) for non-intrusive banner and interval interstitial ads. Pseudonymous advertising diagnostics are handled securely by Google Play Services in accordance with Google Play Data Safety rules.
- Refer to `PRIVACY_POLICY.md` and `PLAY_STORE_DATA_SAFETY.md` for full disclosures.

---

## 📄 Legal & Licensing

- **Source Code:** Released under the [MIT License](LICENSE).
- **Branding & Trademark:** The app name "Pick One! – Would You Rather", logos, icons, screenshots, and visual branding are the exclusive proprietary property of **ViveScript Solutions LLC**.

**© 2026 ViveScript Solutions LLC. All rights reserved.**  
Website: [https://www.vivescriptsolutions.com/](https://www.vivescriptsolutions.com/)
