package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ads.AdConfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdBannerView(
    modifier: Modifier = Modifier
) {
    if (!AdConfig.isAdsEnabled) return

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(vertical = 4.dp)
            .testTag("admob_banner_container"),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = AdConfig.getBannerAdUnitId()
                    loadAd(AdRequest.Builder().build())
                }
            },
            onRelease = { adView ->
                adView.destroy()
            }
        )
    }
}
