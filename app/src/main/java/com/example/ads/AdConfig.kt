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

    // Official Google Test IDs (kept for explicit emulator/test-device use)
    const val TEST_BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"
    const val TEST_INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

    // Ads toggle
    var isAdsEnabled: Boolean = true

    // Interstitial interval: show interstitial every N answered questions to comply with AdMob policy
    const val INTERSTITIAL_INTERVAL_QUESTIONS = 5

    /**
     * Resolves the active banner ad unit ID (demo in debug, live in release).
     * Live IDs come from per-variant BuildConfig fields so they can never
     * ship in debug binaries and taint live ad traffic.
     */
    fun getBannerAdUnitId(): String = com.example.BuildConfig.ADMOB_BANNER_AD_UNIT_ID

    /**
     * Resolves the active interstitial ad unit ID (demo in debug, live in release).
     */
    fun getInterstitialAdUnitId(): String = com.example.BuildConfig.ADMOB_INTERSTITIAL_AD_UNIT_ID

    @Volatile
    private var adsConsentGranted = false

    /** Called from MainActivity once UMP consent resolves. */
    fun setAdsConsent(granted: Boolean) {
        adsConsentGranted = granted
    }

    /** True only when ads are enabled and UMP consent allows ad requests. */
    fun canShowAdsFlow(): Boolean = isAdsEnabled && adsConsentGranted
}
