package com.example

import com.example.data.QuestionRepository
import com.example.model.ChoiceItem
import com.example.model.Language
import com.example.model.Question
import com.example.model.QuestionCategory
import com.example.viewmodel.ChoiceSelection
import com.example.viewmodel.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ExampleUnitTest {
    private lateinit var viewModel: GameViewModel

    @Before
    fun setUp() {
        viewModel = GameViewModel()
    }

    @Test
    fun testRepositoryContainsQuestions() {
        val questions = QuestionRepository.sampleQuestions
        assertTrue("Questions list should not be empty", questions.isNotEmpty())
        assertTrue("Should have multiple curated questions", questions.size >= 20)
    }

    @Test
    fun testInitialState() {
        val state = viewModel.uiState.value
        assertEquals(ChoiceSelection.NONE, state.userSelection)
        assertEquals(0, state.currentQuestionIndex)
        assertEquals(QuestionCategory.ALL, state.selectedCategory)
        assertEquals(Language.ENGLISH, state.language)
        assertNotNull(state.currentQuestion)
    }

    @Test
    fun testVoteOptionA() {
        val initialVotesA = viewModel.uiState.value.votesA
        viewModel.selectOption(ChoiceSelection.OPTION_A)
        val updatedState = viewModel.uiState.value

        assertEquals(ChoiceSelection.OPTION_A, updatedState.userSelection)
        assertEquals(initialVotesA + 1, updatedState.votesA)
        assertEquals(1, updatedState.streak)
        assertEquals(1, updatedState.totalAnswered)
    }

    @Test
    fun testVotePercentageCalculation() {
        val state = viewModel.uiState.value
        val sum = state.percentA + state.percentB
        assertEquals("Percentages should sum to 100", 100, sum)
    }

    @Test
    fun testCategoryFilter() {
        viewModel.setCategory(QuestionCategory.FOOD)
        val filtered = viewModel.uiState.value.filteredQuestions
        assertTrue(filtered.all { it.category == QuestionCategory.FOOD })
    }

    @Test
    fun testLanguageToggle() {
        assertEquals(Language.ENGLISH, viewModel.uiState.value.language)
        viewModel.toggleLanguage()
        assertEquals(Language.BANGLA, viewModel.uiState.value.language)
        viewModel.toggleLanguage()
        assertEquals(Language.ENGLISH, viewModel.uiState.value.language)
    }

    @Test
    fun testNextQuestionNavigation() {
        val total = viewModel.uiState.value.filteredQuestions.size
        viewModel.nextQuestion()
        assertEquals(1, viewModel.uiState.value.currentQuestionIndex)
        assertEquals(ChoiceSelection.NONE, viewModel.uiState.value.userSelection)
    }
}
