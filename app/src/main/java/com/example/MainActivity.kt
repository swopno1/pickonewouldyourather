package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.ads.AdManager
import com.example.ui.screens.MainGameScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize Google Mobile Ads SDK with provided App ID and preload interstitial
        AdManager.initialize(this)

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
