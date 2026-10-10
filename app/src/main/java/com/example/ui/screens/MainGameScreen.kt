package com.example.ui.screens

import android.app.Activity
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeMute
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ads.AdConfig
import com.example.ads.AdManager
import com.example.model.Language
import com.example.ui.components.AboutDialog
import com.example.ui.components.AdBannerView
import com.example.ui.components.CategoryPickerDialog
import com.example.ui.components.ChoiceCard
import com.example.ui.components.SocialShareSheet
import com.example.ui.theme.AccentGold
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.PrimaryCyan
import com.example.ui.theme.PrimaryCyanDark
import com.example.ui.theme.PrimaryCyanLight
import com.example.ui.theme.PrimaryOrange
import com.example.ui.theme.PrimaryOrangeDark
import com.example.ui.theme.PrimaryOrangeLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.TextLightSecondary
import com.example.util.SoundVibeHelper
import com.example.viewmodel.ChoiceSelection
import com.example.viewmodel.GameViewModel

@Composable
fun MainGameScreen(
    viewModel: GameViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top App Bar
            TopGameHeader(
                categoryName = if (uiState.language == Language.BANGLA)
                    uiState.selectedCategory.displayNameBn
                else
                    uiState.selectedCategory.displayNameEn,
                categoryEmoji = uiState.selectedCategory.emoji,
                isSoundEnabled = uiState.isSoundEnabled,
                currentLanguage = uiState.language,
                onCategoryClick = { viewModel.setShowCategoryDialog(true) },
                onLanguageToggle = { viewModel.toggleLanguage() },
                onSoundToggle = { viewModel.toggleSound() },
                onInfoClick = { viewModel.setShowAboutDialog(true) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Game Question Progress / Streak Header
            QuestionStatsPill(
                currentIndex = uiState.currentQuestionIndex + 1,
                totalQuestions = uiState.filteredQuestions.size,
                streak = uiState.streak,
                isBangla = uiState.language == Language.BANGLA
            )

            Spacer(modifier = Modifier.height(10.dp))

            val currentQuestion = uiState.currentQuestion

            if (currentQuestion != null) {
                BoxWithConstraints(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .widthIn(max = 680.dp)
                ) {
                    if (isLandscape || maxWidth > 600.dp) {
                        // Wide / Tablet / Landscape side-by-side layout
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ChoiceCard(
                                choiceItem = currentQuestion.optionA,
                                optionType = ChoiceSelection.OPTION_A,
                                userSelection = uiState.userSelection,
                                percentage = uiState.percentA,
                                language = uiState.language,
                                primaryColor = PrimaryOrange,
                                gradientColors = listOf(PrimaryOrangeLight, PrimaryOrange, PrimaryOrangeDark),
                                onClick = {
                                    SoundVibeHelper.playSelectionSound(uiState.isSoundEnabled)
                                    SoundVibeHelper.vibrateShort(context, uiState.isSoundEnabled)
                                    viewModel.selectOption(ChoiceSelection.OPTION_A)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            )

                            // VS Badge Center
                            VersusBadge(modifier = Modifier.align(Alignment.CenterVertically))

                            ChoiceCard(
                                choiceItem = currentQuestion.optionB,
                                optionType = ChoiceSelection.OPTION_B,
                                userSelection = uiState.userSelection,
                                percentage = uiState.percentB,
                                language = uiState.language,
                                primaryColor = PrimaryCyan,
                                gradientColors = listOf(PrimaryCyanLight, PrimaryCyan, PrimaryCyanDark),
                                onClick = {
                                    SoundVibeHelper.playSelectionSound(uiState.isSoundEnabled)
                                    SoundVibeHelper.vibrateShort(context, uiState.isSoundEnabled)
                                    viewModel.selectOption(ChoiceSelection.OPTION_B)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            )
                        }
                    } else {
                        // Portrait Phone vertical cards layout
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ChoiceCard(
                                choiceItem = currentQuestion.optionA,
                                optionType = ChoiceSelection.OPTION_A,
                                userSelection = uiState.userSelection,
                                percentage = uiState.percentA,
                                language = uiState.language,
                                primaryColor = PrimaryOrange,
                                gradientColors = listOf(PrimaryOrangeLight, PrimaryOrange, PrimaryOrangeDark),
                                onClick = {
                                    SoundVibeHelper.playSelectionSound(uiState.isSoundEnabled)
                                    SoundVibeHelper.vibrateShort(context, uiState.isSoundEnabled)
                                    viewModel.selectOption(ChoiceSelection.OPTION_A)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            VersusBadge()
                            Spacer(modifier = Modifier.height(10.dp))

                            ChoiceCard(
                                choiceItem = currentQuestion.optionB,
                                optionType = ChoiceSelection.OPTION_B,
                                userSelection = uiState.userSelection,
                                percentage = uiState.percentB,
                                language = uiState.language,
                                primaryColor = PrimaryCyan,
                                gradientColors = listOf(PrimaryCyanLight, PrimaryCyan, PrimaryCyanDark),
                                onClick = {
                                    SoundVibeHelper.playSelectionSound(uiState.isSoundEnabled)
                                    SoundVibeHelper.vibrateShort(context, uiState.isSoundEnabled)
                                    viewModel.selectOption(ChoiceSelection.OPTION_B)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Bottom Actions Bar
            BottomActionBar(
                hasVoted = uiState.userSelection != ChoiceSelection.NONE,
                isBangla = uiState.language == Language.BANGLA,
                onPrevious = {
                    SoundVibeHelper.playNextSound(uiState.isSoundEnabled)
                    viewModel.previousQuestion()
                },
                onNext = {
                    SoundVibeHelper.playNextSound(uiState.isSoundEnabled)
                    val nextTotal = uiState.totalAnswered
                    // Policy-compliant interstitial display during natural round break
                    if (nextTotal > 0 && nextTotal % AdConfig.INTERSTITIAL_INTERVAL_QUESTIONS == 0 && context is Activity) {
                        AdManager.showInterstitialIfReady(context) {
                            viewModel.nextQuestion()
                        }
                    } else {
                        viewModel.nextQuestion()
                    }
                },
                onShare = {
                    viewModel.setShowShareBottomSheet(true)
                }
            )

            // Inline Adaptive AdMob Banner
            AdBannerView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }

        // Dialogs & Bottom Sheet
        if (uiState.showCategoryDialog) {
            CategoryPickerDialog(
                currentCategory = uiState.selectedCategory,
                language = uiState.language,
                onCategorySelected = { viewModel.setCategory(it) },
                onDismiss = { viewModel.setShowCategoryDialog(false) }
            )
        }

        if (uiState.showAboutDialog) {
            AboutDialog(
                language = uiState.language,
                onDismiss = { viewModel.setShowAboutDialog(false) }
            )
        }

        if (uiState.showShareBottomSheet) {
            SocialShareSheet(
                shareText = viewModel.getShareableText(),
                language = uiState.language,
                onDismiss = { viewModel.setShowShareBottomSheet(false) }
            )
        }
    }
}

@Composable
fun TopGameHeader(
    categoryName: String,
    categoryEmoji: String,
    isSoundEnabled: Boolean,
    currentLanguage: Language,
    onCategoryClick: () -> Unit,
    onLanguageToggle: () -> Unit,
    onSoundToggle: () -> Unit,
    onInfoClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Category Pill
        Surface(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .clickable(onClick = onCategoryClick)
                .testTag("category_pill"),
            color = DarkSurface,
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = categoryEmoji, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = categoryName,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = PureWhite
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Category,
                    contentDescription = "Change Category",
                    tint = TextLightSecondary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        // Quick Controls
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // Language Button
            Surface(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onLanguageToggle)
                    .testTag("language_toggle_button"),
                color = DarkSurface,
                shape = CircleShape
            ) {
                Box(
                    modifier = Modifier.size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (currentLanguage == Language.ENGLISH) "বাং" else "EN",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = AccentGold
                    )
                }
            }

            // Sound Toggle
            Surface(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onSoundToggle)
                    .testTag("sound_toggle_button"),
                color = DarkSurface,
                shape = CircleShape
            ) {
                Box(
                    modifier = Modifier.size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isSoundEnabled) Icons.AutoMirrored.Filled.VolumeUp else Icons.AutoMirrored.Filled.VolumeMute,
                        contentDescription = "Toggle Sound",
                        tint = if (isSoundEnabled) PureWhite else TextLightSecondary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Info / About
            Surface(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onInfoClick)
                    .testTag("about_button"),
                color = DarkSurface,
                shape = CircleShape
            ) {
                Box(
                    modifier = Modifier.size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "About",
                        tint = PureWhite,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun QuestionStatsPill(
    currentIndex: Int,
    totalQuestions: Int,
    streak: Int,
    isBangla: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(DarkSurface.copy(alpha = 0.6f))
            .padding(horizontal = 14.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (isBangla) "প্রশ্ন $currentIndex / $totalQuestions" else "Question $currentIndex of $totalQuestions",
            fontSize = 12.sp,
            color = TextLightSecondary,
            fontWeight = FontWeight.Medium
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "🔥", fontSize = 14.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = if (isBangla) "ধারাবাহিকতা: $streak" else "Streak: $streak",
                fontSize = 12.sp,
                color = AccentGold,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun VersusBadge(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(44.dp)
            .background(Brush.radialGradient(listOf(DarkSurfaceVariant, DarkSurface)), CircleShape)
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "VS",
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
            color = PureWhite
        )
    }
}

@Composable
fun BottomActionBar(
    hasVoted: Boolean,
    isBangla: Boolean,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onShare: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Previous Button
        IconButton(
            onClick = onPrevious,
            modifier = Modifier
                .size(48.dp)
                .background(DarkSurface, CircleShape)
                .testTag("previous_button")
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Previous Question",
                tint = PureWhite,
                modifier = Modifier.size(20.dp)
            )
        }

        // Share Button (social focused)
        Button(
            onClick = onShare,
            colors = ButtonDefaults.buttonColors(containerColor = DarkSurface),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(48.dp)
                .testTag("social_share_button")
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = PureWhite,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isBangla) "শেয়ার করুন" else "Share",
                    color = PureWhite,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
        }

        // Next / Skip Button
        Button(
            onClick = onNext,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (hasVoted) PrimaryOrange else DarkSurfaceVariant
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(48.dp)
                .testTag("next_button")
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = if (hasVoted) {
                        if (isBangla) "পরবর্তী প্রশ্ন" else "Next Question"
                    } else {
                        if (isBangla) "এড়িয়ে যান" else "Skip"
                    },
                    color = PureWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next",
                    tint = PureWhite,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
