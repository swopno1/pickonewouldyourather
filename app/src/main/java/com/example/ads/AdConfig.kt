package com.example.ads

/**
 * AdMob configuration for Pick One! – Would You Rather.
 *
 * Configured with provided AdMob App ID and Ad Unit IDs:
 * App ID: ca-app-pub-5222053984568989~7046666712
 * Banner 1 ID: ca-app-pub-5222053984568989/7491363151
 * Interstitial 1 ID: ca-app-pub-5222053984568989/5949207462
 */
object AdConfig {
    // AdMob App ID
    const val APP_ID = "ca-app-pub-5222053984568989~7046666712"

    // Active Ad Unit IDs
    const val BANNER_AD_UNIT_ID = "ca-app-pub-5222053984568989/7491363151"
    const val INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-5222053984568989/5949207462"

    // Official Google Test Fallbacks (if needed for testing in emulators/debug)
    const val TEST_BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"
    const val TEST_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

    // Ads toggle
    var isAdsEnabled: Boolean = true

    // Interstitial interval: show interstitial every N answered questions to comply with AdMob policy
    const val INTERSTITIAL_INTERVAL_QUESTIONS = 5

    /**
     * Returns the appropriate Banner Ad Unit ID based on the build configuration.
     * Uses official Google test ad IDs in debug builds to prevent invalid traffic policy violations
     * and emulator creative script errors.
     */
    fun getBannerAdUnitId(): String {
        return if (com.example.BuildConfig.DEBUG) TEST_BANNER_AD_UNIT_ID else BANNER_AD_UNIT_ID
    }

    /**
     * Returns the appropriate Interstitial Ad Unit ID based on the build configuration.
     * Uses official Google test ad IDs in debug builds to prevent invalid traffic policy violations
     * and emulator creative script errors.
     */
    fun getInterstitialAdUnitId(): String {
        return if (com.example.BuildConfig.DEBUG) TEST_INTERSTITIAL_AD_UNIT_ID else INTERSTITIAL_AD_UNIT_ID
    }
}
