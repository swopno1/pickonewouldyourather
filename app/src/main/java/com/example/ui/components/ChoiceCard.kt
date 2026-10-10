package com.example.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ChoiceItem
import com.example.model.Language
import com.example.ui.theme.PureWhite
import com.example.viewmodel.ChoiceSelection

@Composable
fun ChoiceCard(
    choiceItem: ChoiceItem,
    optionType: ChoiceSelection,
    userSelection: ChoiceSelection,
    percentage: Int,
    language: Language,
    primaryColor: Color,
    gradientColors: List<Color>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isSelected = userSelection == optionType
    val hasVoted = userSelection != ChoiceSelection.NONE
    val scaleAnim by animateFloatAsState(
        targetValue = if (isSelected) 1.02f else if (hasVoted) 0.98f else 1.0f,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "card_scale"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .scale(scaleAnim)
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
            .testTag(if (optionType == ChoiceSelection.OPTION_A) "choice_card_a" else "choice_card_b"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(
            width = if (isSelected) 3.dp else 1.5.dp,
            color = if (isSelected) PureWhite else primaryColor.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 10.dp else 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(gradientColors))
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .animateContentSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Top Tag & Emoji
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .background(PureWhite.copy(alpha = 0.2f), CircleShape)
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = if (optionType == ChoiceSelection.OPTION_A) "OPTION A" else "OPTION B",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PureWhite
                        )
                    }

                    Text(
                        text = choiceItem.iconEmoji,
                        fontSize = 32.sp
                    )
                }

                // Main Text
                Text(
                    text = if (language == Language.BANGLA) choiceItem.textBn else choiceItem.textEn,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PureWhite,
                    textAlign = TextAlign.Start,
                    lineHeight = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                )

                // Results / Percentage Bar
                if (hasVoted) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(PureWhite.copy(alpha = 0.15f))
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Selected",
                                        tint = PureWhite,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.size(6.dp))
                                }
                                Text(
                                    text = if (isSelected) "You Picked!" else "Other Players",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PureWhite
                                )
                            }

                            Text(
                                text = "$percentage%",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = PureWhite
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        val progressAnim by animateFloatAsState(
                            targetValue = percentage / 100f,
                            animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
                            label = "progress_anim"
                        )

                        LinearProgressIndicator(
                            progress = { progressAnim },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(CircleShape),
                            color = PureWhite,
                            trackColor = PureWhite.copy(alpha = 0.3f)
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(PureWhite.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (language == Language.BANGLA) "ট্যাপ করে বেছে নিন 👆" else "Tap to choose 👆",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = PureWhite
                        )
                    }
                }
            }
        }
    }
}
