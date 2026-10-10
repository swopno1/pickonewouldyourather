package com.example.model

enum class QuestionCategory(val displayNameEn: String, val displayNameBn: String, val emoji: String) {
    ALL("All", "সব", "✨"),
    FUNNY("Funny & Silly", "মজার ও হাস্যকর", "😂"),
    FOOD("Food & Treats", "খাবার ও স্বাদ", "🍕"),
    SUPERPOWERS("Superpowers & Magic", "অলৌকিক ক্ষমতা", "⚡"),
    DAILY_LIFE("Everyday Life", "প্রতিদিনের জীবন", "🛋️"),
    IMPOSSIBLE("Impossible Choices", "অসম্ভব সিদ্ধান্ত", "🤯"),
    TRAVEL("Travel & Adventure", "ভ্রমণ ও অ্যাডভেঞ্চার", "✈️"),
    ANIMALS("Animals & Nature", "পশুপাখি ও প্রকৃতি", "🐾")
}

enum class Language(val code: String, val label: String) {
    ENGLISH("en", "English"),
    BANGLA("bn", "বাংলা")
}

data class ChoiceItem(
    val textEn: String,
    val textBn: String,
    val iconEmoji: String,
    val initialVotes: Int
)

data class Question(
    val id: String,
    val category: QuestionCategory,
    val optionA: ChoiceItem,
    val optionB: ChoiceItem
)
