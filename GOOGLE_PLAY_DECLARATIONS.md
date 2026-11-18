# Google Play Console Declarations & Approval Master Reference

**App Name:** Pick One! – Would You Rather  
**Package Name:** `com.vivescriptsolutions.pickonewouldyourather`  
**Current Release:** Version Code `3`, Version Name `3.0`  
**Developer:** ViveScript Solutions LLC  
**Support Email:** support@vivescriptsolutions.com  
**Privacy Policy URL:** https://www.vivescriptsolutions.com/en/apps/pick-one *(assumed from sibling-app pattern — human must confirm the page is live)*  
**Terms of Service URL:** https://www.vivescriptsolutions.com/en/apps/pick-one/terms *(assumed — human must confirm)*

---

## 1. App Access
**Question:** Is access to any part of your app restricted?  
**Selection:**  
`All functionality is available without special access`  
**Reviewer Notes (if requested):**  
> *"Pick One! is an offline-first party game. It requires no login credentials, username, password, subscription, or account. Reviewers can access 100% of the app immediately upon launch."*

---

## 2. Ads Declaration
**Question:** Does your app contain advertising?  
**Selection:**  
`Yes, my app contains ads`  
**Explanation for reviewers:** *"Google AdMob banner plus interstitials shown every 5 answered questions. Ads are gated by Google UMP consent (UMP SDK 4.0.0) — EU users who decline see no ads; US opt-out users receive restricted processing. Debug builds use Google demo units; release builds use production units ca-app-pub-5222053984568989/7491363151 (banner) and ca-app-pub-5222053984568989/5949207462 (interstitial). An About-dialog entry point ('Ad Privacy Options') lets users revisit consent choices."*

---

## 3. Advertising ID
**Question:** Does your app use advertising ID?  
**Selection:** `Yes`  
**Purpose:** `Advertising or marketing` (Google AdMob SDK; `AD_ID` permission explicitly declared in the manifest).

---

## 4. Content Rating Questionnaire (IARC)
- **Category:** Trivia / party game
- **Does the app share user-provided personal info with third parties?** `No` first-party (AdMob declared separately under Data Safety; share sheet sends text only to the app the user explicitly picks)
- **Does the app share physical location with other users?** `No`
- **Does the app allow users to purchase digital goods?** `No`
- **Recommended Rating:** `Everyone`. Human must answer the questionnaire honestly; no objectionable content exists in the app.

---

## 5. Target Audience & Content
- **Target Age Group:** `13 and older`
- **Could the store listing unintentionally appeal to children?** `No` (party-game positioning for teens/adults; not directed at young children)
- **Designed for Families:** `No` (opt out — contains ads)

---

## 6. Special Category Declarations
- **COVID-19 Contact Tracing or Status App:** `No`
- **Government App:** `No`
- **Financial Services / Crypto / Loans:** `No`
- **News App:** `No`
- **Health / Medical / Health Connect App:** `No`

---

## 7. Data Safety Form

### Overview
- **Data Collection:** `Yes` (Google Mobile Ads SDK: Device IDs + Diagnostics + App activity for advertising).
- **Data Sharing:** `Yes` (with Google for ad serving/reporting; no first-party sharing — game state stays on-device).
- **Data Encryption in Transit:** `Yes` (AdMob SDK uses HTTPS).
- **Data Deletion:** `Yes` (clear app data or uninstall removes all on-device data; no accounts exist).

### Data Types Declaration
| Data Category | Data Type | Collected | Shared | Ephemeral | Purpose |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Device or other IDs** | Device or other IDs (Ad ID) | Yes (AdMob SDK) | Yes (Google) | No (resettable) | Advertising or marketing |
| **App activity** | App interactions | Yes (AdMob SDK) | Yes (Google) | Yes | Advertising / Analytics (SDK-internal) |
| **App info and performance** | Diagnostics / Crash logs | Yes (AdMob SDK) | Yes (Google) | Yes | Advertising / Analytics (SDK-internal) |
| **Personal Info** | Name / Email / Phone | **No** | No | N/A | None (no registration) |
| **Photos & Videos / Audio** | Media | **No** | No | N/A | None (no camera/mic/storage) |
| **Location** | Any location | **No** | No | N/A | Zero location permissions |

---

## 8. Permissions Declarations

### 8.1 Internet (`INTERNET`)
- **Declaration Statement:**
```text
Used solely to load Google AdMob banner and interstitial ads and Google UMP consent messaging. Gameplay runs 100% on-device and works in airplane mode; no gameplay data is ever transmitted.
```

### 8.2 Network State (`ACCESS_NETWORK_STATE`)
- **Declaration Statement:**
```text
Used by the Google Mobile Ads SDK to check connectivity before requesting ads.
```

### 8.3 Vibrate (`VIBRATE`)
- **Declaration Statement:**
```text
Normal permission used for haptic feedback on votes and verdicts. No data involved.
```

### 8.4 Advertising ID (`com.google.android.gms.permission.AD_ID`)
- **Declaration Statement:**
```text
Used by the Google Mobile Ads SDK for ad serving and reporting. Users can reset or delete their advertising ID in Android Settings.
```

---

## 9. Reviewer Testing Guidance

```text
STEP-BY-STEP REVIEWER TESTING INSTRUCTIONS:

1. Launch Pick One! on any test device or emulator.
2. A UMP consent form may appear; accept or dismiss it (dismissing disables ads).
3. Pick a category, then tap Option A or B to vote and reveal community percentages.
4. Use Previous / Next to navigate questions; open the share sheet from any question.
5. Toggle the home language switch (English / বাংলা) to verify both UI languages.
6. Open the About dialog (info icon) for version, license, and privacy summary.
7. Answer 5+ questions to observe the interstitial pacing.
8. Enable airplane mode to verify gameplay works fully offline (ads will not load).
```

---

## 10. Copy-Paste Appeal Templates

### Appeal for Data Safety / Privacy Inquiry:
> **Subject:** Clarification on Data Safety Declaration - `com.vivescriptsolutions.pickonewouldyourather`  
> **Dear Google Play Review Team,**  
> Pick One! is an offline-first party game. It collects no first-party data: no accounts, no analytics, no crash SDK, no servers — game state stays on-device. The only collection comes from the embedded Google Mobile Ads SDK (Advertising ID + diagnostics + app activity), declared accordingly, encrypted in transit, and gated by Google UMP consent so declined users never load ads.

### Appeal for Ads / Interstitial Inquiry:
> **Subject:** Clarification on Interstitial Ads - `com.vivescriptsolutions.pickonewouldyourather`  
> **Dear Google Play Review Team,**  
> Pick One! shows an interstitial at most every 5 answered questions, only between questions — never mid-tap on a vote button. The banner sits in a fixed position and never overlaps interactive content. Both formats are gated by UMP consent.

---

## 11. EU Digital Services Act (DSA) & Trader Status Declaration

Google Play requires all developers distributing in the European Economic Area (EEA) to declare their trader status under **Policy and programs > Trader status**:

- **Recommended Selection:** **"Yes, I am a trader"** (for ViveScript Solutions LLC)  
  - Legal Name: `ViveScript Solutions LLC`
  - Email: `support@vivescriptsolutions.com`
  - Website: `https://www.vivescriptsolutions.com/`
  - Address: `1209 Orange Street, Wilmington, DE 19801, USA`
- See full legal analysis in `EU_TRADE_POLICY_COMPLIANCE.md`.
