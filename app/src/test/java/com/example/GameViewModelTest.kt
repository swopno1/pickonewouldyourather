package com.example

import com.example.model.Language
import com.example.viewmodel.ChoiceSelection
import com.example.viewmodel.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setUp() {
        viewModel = GameViewModel()
    }

    @Test
    fun testPreviousQuestionWrapsAround() {
        val size = viewModel.uiState.value.filteredQuestions.size
        assertTrue(size > 1)
        // From index 0, previous wraps to the last question.
        assertEquals(0, viewModel.uiState.value.currentQuestionIndex)
        viewModel.previousQuestion()
        assertEquals(size - 1, viewModel.uiState.value.currentQuestionIndex)
        viewModel.nextQuestion()
        assertEquals(0, viewModel.uiState.value.currentQuestionIndex)
    }

    @Test
    fun testDoubleVoteIsIgnored() {
        viewModel.selectOption(ChoiceSelection.OPTION_A)
        val afterFirst = viewModel.uiState.value
        viewModel.selectOption(ChoiceSelection.OPTION_B)
        val afterSecond = viewModel.uiState.value
        assertEquals(afterFirst.votesA, afterSecond.votesA)
        assertEquals(afterFirst.votesB, afterSecond.votesB)
        assertEquals(ChoiceSelection.OPTION_A, afterSecond.userSelection)
    }

    @Test
    fun testStreakIncrementsPerAnswer() {
        assertEquals(0, viewModel.uiState.value.streak)
        viewModel.selectOption(ChoiceSelection.OPTION_A)
        assertEquals(1, viewModel.uiState.value.streak)
        viewModel.nextQuestion()
        viewModel.selectOption(ChoiceSelection.OPTION_B)
        assertEquals(2, viewModel.uiState.value.streak)
    }

    @Test
    fun testSoundToggle() {
        val initial = viewModel.uiState.value.isSoundEnabled
        viewModel.toggleSound()
        assertEquals(!initial, viewModel.uiState.value.isSoundEnabled)
    }

    @Test
    fun testShareTextContainsStoreLinkBothLanguages() {
        val en = viewModel.getShareableText()
        assertTrue(en.contains("play.google.com/store/apps/details?id=com.vivescriptsolutions.pickonewouldyourather"))
        viewModel.toggleLanguage()
        assertEquals(Language.BANGLA, viewModel.uiState.value.language)
        val bn = viewModel.getShareableText()
        assertTrue(bn.contains("play.google.com/store/apps/details?id=com.vivescriptsolutions.pickonewouldyourather"))
    }

    @Test
    fun testAdUnitsAreDemoInDebug() {
        // Unit tests run the debug variant: only Google demo units may resolve.
        assertEquals(
            "ca-app-pub-3940256099942544/6300978111",
            com.example.ads.AdConfig.getBannerAdUnitId()
        )
        assertEquals(
            "ca-app-pub-3940256099942544/1033173712",
            com.example.ads.AdConfig.getInterstitialAdUnitId()
        )
    }

    @Test
    fun testAdsGatedUntilConsentGranted() {
        com.example.ads.AdConfig.setAdsConsent(false)
        assertEquals(false, com.example.ads.AdConfig.canShowAdsFlow())
        com.example.ads.AdConfig.setAdsConsent(true)
        assertEquals(true, com.example.ads.AdConfig.canShowAdsFlow())
        com.example.ads.AdConfig.setAdsConsent(false)
    }
}
