package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.ads.AdConfig
import com.example.ads.AdManager
import com.example.ads.ConsentManager
import com.example.ui.screens.MainGameScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Gather UMP consent first; Mobile Ads only initializes with clearance.
        // The game stays fully playable even if ads never initialize.
        try {
            ConsentManager.gatherConsent(this) { canRequestAds ->
                AdConfig.setAdsConsent(canRequestAds)
                if (!canRequestAds) return@gatherConsent
                try {
                    AdManager.initialize(this@MainActivity)
                } catch (_: Throwable) {
                }
            }
        } catch (_: Throwable) {
        }

        setContent {
            MyApplicationTheme {
                MainGameScreen(viewModel = viewModel)
            }
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level >= TRIM_MEMORY_UI_HIDDEN) {
            com.example.util.SoundVibeHelper.release()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        com.example.util.SoundVibeHelper.release()
    }
}
