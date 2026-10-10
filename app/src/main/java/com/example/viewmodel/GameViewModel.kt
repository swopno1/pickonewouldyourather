package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.QuestionRepository
import com.example.model.Language
import com.example.model.Question
import com.example.model.QuestionCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class ChoiceSelection {
    NONE, OPTION_A, OPTION_B
}

data class GameUiState(
    val currentQuestionIndex: Int = 0,
    val selectedCategory: QuestionCategory = QuestionCategory.ALL,
    val language: Language = Language.ENGLISH,
    val isSoundEnabled: Boolean = true,
    val userSelection: ChoiceSelection = ChoiceSelection.NONE,
    val totalAnswered: Int = 0,
    val streak: Int = 0,
    val showAboutDialog: Boolean = false,
    val showCategoryDialog: Boolean = false,
    val showShareBottomSheet: Boolean = false,
    val votesA: Int = 0,
    val votesB: Int = 0
) {
    val filteredQuestions: List<Question>
        get() = if (selectedCategory == QuestionCategory.ALL) {
            QuestionRepository.sampleQuestions
        } else {
            QuestionRepository.sampleQuestions.filter { it.category == selectedCategory }
        }

    val currentQuestion: Question?
        get() {
            val list = filteredQuestions
            return if (list.isNotEmpty() && currentQuestionIndex in list.indices) {
                list[currentQuestionIndex]
            } else null
        }

    val percentA: Int
        get() {
            val total = votesA + votesB
            return if (total > 0) ((votesA.toFloat() / total) * 100).toInt() else 50
        }

    val percentB: Int
        get() {
            val total = votesA + votesB
            return if (total > 0) (100 - percentA) else 50
        }
}

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    init {
        loadQuestionVotes()
    }

    private fun loadQuestionVotes() {
        val q = _uiState.value.currentQuestion
        if (q != null) {
            _uiState.update {
                it.copy(
                    votesA = q.optionA.initialVotes,
                    votesB = q.optionB.initialVotes,
                    userSelection = ChoiceSelection.NONE
                )
            }
        }
    }

    fun selectOption(choice: ChoiceSelection) {
        if (_uiState.value.userSelection != ChoiceSelection.NONE) return // already voted this round

        _uiState.update { state ->
            val newVotesA = if (choice == ChoiceSelection.OPTION_A) state.votesA + 1 else state.votesA
            val newVotesB = if (choice == ChoiceSelection.OPTION_B) state.votesB + 1 else state.votesB
            state.copy(
                userSelection = choice,
                votesA = newVotesA,
                votesB = newVotesB,
                totalAnswered = state.totalAnswered + 1,
                streak = state.streak + 1
            )
        }
    }

    fun nextQuestion() {
        val list = _uiState.value.filteredQuestions
        if (list.isEmpty()) return

        val nextIndex = (_uiState.value.currentQuestionIndex + 1) % list.size
        _uiState.update {
            it.copy(
                currentQuestionIndex = nextIndex,
                userSelection = ChoiceSelection.NONE
            )
        }
        loadQuestionVotes()
    }

    fun previousQuestion() {
        val list = _uiState.value.filteredQuestions
        if (list.isEmpty()) return

        val prevIndex = if (_uiState.value.currentQuestionIndex - 1 < 0) list.size - 1 else _uiState.value.currentQuestionIndex - 1
        _uiState.update {
            it.copy(
                currentQuestionIndex = prevIndex,
                userSelection = ChoiceSelection.NONE
            )
        }
        loadQuestionVotes()
    }

    fun setCategory(category: QuestionCategory) {
        _uiState.update {
            it.copy(
                selectedCategory = category,
                currentQuestionIndex = 0,
                userSelection = ChoiceSelection.NONE,
                showCategoryDialog = false
            )
        }
        loadQuestionVotes()
    }

    fun toggleLanguage() {
        _uiState.update {
            val nextLang = if (it.language == Language.ENGLISH) Language.BANGLA else Language.ENGLISH
            it.copy(language = nextLang)
        }
    }

    fun toggleSound() {
        _uiState.update {
            it.copy(isSoundEnabled = !it.isSoundEnabled)
        }
    }

    fun setShowAboutDialog(show: Boolean) {
        _uiState.update { it.copy(showAboutDialog = show) }
    }

    fun setShowCategoryDialog(show: Boolean) {
        _uiState.update { it.copy(showCategoryDialog = show) }
    }

    fun setShowShareBottomSheet(show: Boolean) {
        _uiState.update { it.copy(showShareBottomSheet = show) }
    }

    fun getShareableText(): String {
        val q = _uiState.value.currentQuestion ?: return ""
        val isBn = _uiState.value.language == Language.BANGLA
        val header = if (isBn) "🤔 আপনি কোনটি বেছে নেবেন? (Would You Rather?)" else "🤔 Would You Rather?"
        val optA = if (isBn) "🅰️ ${q.optionA.iconEmoji} ${q.optionA.textBn}" else "🅰️ ${q.optionA.iconEmoji} ${q.optionA.textEn}"
        val optB = if (isBn) "🅱️ ${q.optionB.iconEmoji} ${q.optionB.textBn}" else "🅱️ ${q.optionB.iconEmoji} ${q.optionB.textEn}"
        val footer = if (isBn) "খেলাটি উপভোগ করুন Pick One! অ্যাপে 📲✨\n© ViveScript Solutions LLC" else "Play Pick One! – Would You Rather 📲✨\n© ViveScript Solutions LLC"
        return "$header\n\n$optA\n\n— বা / OR —\n\n$optB\n\n$footer"
    }
}
