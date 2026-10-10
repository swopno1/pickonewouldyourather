package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Language
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.PureWhite
import com.example.ui.theme.TextLightSecondary
import com.example.util.SoundVibeHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialShareSheet(
    shareText: String,
    language: Language,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = DarkSurface,
        scrimColor = Color.Black.copy(alpha = 0.6f),
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .testTag("social_share_sheet"),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (language == Language.BANGLA) "বন্ধুদের সাথে শেয়ার করুন" else "Share With Friends",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = PureWhite
                )

                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = TextLightSecondary
                    )
                }
            }

            Text(
                text = if (language == Language.BANGLA)
                    "এই মজার প্রশ্নটি হোয়াটসঅ্যাপ, ইনস্টাগ্রাম বা টিকটকে শেয়ার করুন"
                else
                    "Send this spicy question directly to WhatsApp, Instagram Stories, or TikTok!",
                fontSize = 14.sp,
                color = TextLightSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Social Buttons Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SocialActionButton(
                    iconText = "💬",
                    name = "WhatsApp",
                    backgroundColor = Color(0xFF25D366),
                    onClick = {
                        shareToSpecificApp(context, shareText, "com.whatsapp", onDismiss)
                    }
                )

                SocialActionButton(
                    iconText = "📸",
                    name = "Instagram",
                    backgroundColor = Color(0xFFE1306C),
                    onClick = {
                        shareToSpecificApp(context, shareText, "com.instagram.android", onDismiss)
                    }
                )

                SocialActionButton(
                    iconText = "🎵",
                    name = "TikTok",
                    backgroundColor = Color(0xFF000000),
                    onClick = {
                        shareToSpecificApp(context, shareText, "com.zhiliaoapp.musically", onDismiss)
                    }
                )

                SocialActionButton(
                    iconText = "🔗",
                    name = "Copy",
                    backgroundColor = Color(0xFF475569),
                    onClick = {
                        SoundVibeHelper.copyToClipboard(
                            context,
                            shareText,
                            if (language == Language.BANGLA) "প্রশ্ন কপি করা হয়েছে!" else "Question copied!"
                        )
                        onDismiss()
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // General System Share Sheet Button
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        SoundVibeHelper.shareQuestion(context, shareText)
                        onDismiss()
                    }
                    .testTag("more_share_options_button"),
                color = DarkSurfaceVariant,
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp, horizontal = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "More share options",
                        tint = PureWhite,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = if (language == Language.BANGLA) "অন্যান্য অ্যাপসে শেয়ার করুন" else "More Share Options…",
                        color = PureWhite,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun SocialActionButton(
    iconText: String,
    name: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(54.dp)
                .background(backgroundColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = iconText,
                fontSize = 24.sp
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = name,
            fontSize = 12.sp,
            color = PureWhite,
            fontWeight = FontWeight.Medium
        )
    }
}

private fun shareToSpecificApp(
    context: Context,
    text: String,
    packageName: String,
    onComplete: () -> Unit
) {
    try {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
            setPackage(packageName)
        }
        context.startActivity(intent)
        onComplete()
    } catch (_: Exception) {
        // Fallback to normal share chooser if specific app isn't installed
        val fallback = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        context.startActivity(Intent.createChooser(fallback, "Share via"))
        onComplete()
    }
}
