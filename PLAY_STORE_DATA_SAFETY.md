# Google Play Store Data Safety Guidance

**Application:** Pick One! – Would You Rather  
**Package:** `com.vivescriptsolutions.pickonewouldyourather`  
**Developer:** ViveScript Solutions LLC  
**Evaluation Date:** October 2026  

---

## 1. Executive Summary

- **Does this app collect or share any user personal data?**  
  **NO.** The developer (ViveScript Solutions LLC) does not collect or store user personal data, accounts, names, or contact info.
- **Does the app include third-party SDKs that collect data?**  
  **YES.** Google Mobile Ads SDK (AdMob `play-services-ads:23.6.0`) collects pseudonymous device IDs and diagnostics for ad delivery and fraud prevention.
- **Is all data encrypted in transit?**  
  **YES.** All AdMob network communications use secure TLS/HTTPS.
- **Can users request data deletion?**  
  **No / Not Applicable.** ViveScript does not store user accounts or personal profiles. Users can reset their advertising ID in Android device settings.
- **Does this app require an account?**  
  **NO.** The application is completely account-free.

---

## 2. Google Play Console Form Answers

### Data Collection & Security
| Question | Recommended Answer | Reason |
|---|---|---|
| Does your app collect or share any of the required user data types? | **Yes** | Google Mobile Ads SDK processes device identifiers & diagnostics. |
| Is all of the user data collected by your app encrypted in transit? | **Yes** | All network requests are encrypted over HTTPS. |
| Do you provide a way for users to request that their data be deleted? | **No** | No user account or persistent user identity exists. |

### Data Types Declarations (AdMob SDK)
1. **Device or Other Identifiers:**
   - **Collected:** Yes (by Google Play Services / AdMob)
   - **Shared:** Yes (with Google LLC for Advertising and Fraud Prevention)
   - **Ephemeral:** Yes / tied to pseudonymous Android Advertising ID
   - **Purposes:** Advertising or marketing, Analytics / Fraud prevention
2. **App Activity / Performance Diagnostics:**
   - **Collected:** Yes (Crash logs & diagnostic telemetry handled automatically by AdMob SDK)
   - **Purposes:** Analytics, App functionality, Fraud prevention

### Non-Collected Data Types
- **Location:** Not Collected (No fine or coarse location permissions declared)
- **Personal Info (Name, Email, Phone, Address):** Not Collected
- **Financial Info:** Not Collected
- **Health & Fitness:** Not Collected
- **Messages / Photos / Audio / Files:** Not Collected
- **Web Browsing History:** Not Collected

---

## 3. Ads Declaration in Google Play Console
- Under **App content > Ads**, select: **"Yes, my app contains ads"**.
