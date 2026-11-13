package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.BuildConfig
import com.example.ads.ConsentManager
import com.example.model.Language
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.PrimaryOrange
import com.example.ui.theme.PureWhite
import com.example.ui.theme.TextLightSecondary

@Composable
fun AboutDialog(
    language: Language,
    onDismiss: () -> Unit
) {
    val scrollState = rememberScrollState()
    val isBn = language == Language.BANGLA

    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier.testTag("about_dialog"),
        containerColor = DarkSurface,
        shape = RoundedCornerShape(24.dp),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isBn) "অ্যাপ সম্পর্কে" else "About Pick One!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = PureWhite
                )
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = if (isBn) "বন্ধ করুন" else "Close",
                        tint = TextLightSecondary
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // App Logo Badge
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(PrimaryOrange, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "🤔", fontSize = 32.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Pick One! – Would You Rather",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PureWhite,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Version ${BuildConfig.VERSION_NAME}",
                    fontSize = 12.sp,
                    color = TextLightSecondary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(14.dp))
                HorizontalDivider(color = DarkSurfaceVariant)
                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = if (isBn)
                        "একটি আকর্ষণীয় ও হালকা Would You Rather? গেম। বন্ধুদের সাথে আড্ডায়, পার্টিতে বা অবসরে উপভোগ করুন দারুণ সব মজার প্রশ্ন। গেমপ্লে সম্পূর্ণ অফলাইনে চলে; শুধু বিজ্ঞাপনে ইন্টারনেট লাগে।"
                    else
                        "A delightfully light, entertaining Would You Rather? party game. Perfect for sparking conversations, family games, road trips, and social laughs. Gameplay works fully offline; only ads need internet.",
                    fontSize = 14.sp,
                    color = PureWhite.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(DarkSurfaceVariant)
                        .padding(12.dp)
                ) {
                    Text(
                        text = if (isBn) "ডেভেলপার:" else "Developed by:",
                        fontSize = 12.sp,
                        color = TextLightSecondary
                    )
                    Text(
                        text = "ViveScript Solutions LLC",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = PureWhite
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (isBn) "কপিরাইট:" else "Copyright:",
                        fontSize = 12.sp,
                        color = TextLightSecondary
                    )
                    Text(
                        text = "© 2026 ViveScript Solutions LLC.",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = PureWhite
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (isBn) "লাইসেন্স:" else "License:",
                        fontSize = 12.sp,
                        color = TextLightSecondary
                    )
                    Text(
                        text = if (isBn) "সোর্স কোড: MIT লাইসেন্স" else "Source code: MIT License",
                        fontSize = 13.sp,
                        color = PureWhite
                    )
                    Text(
                        text = if (isBn) "ব্র্যান্ডিং ও আর্টওয়ার্ক: স্বত্বাধীন ViveScript Solutions LLC"
                        else "Branding & artwork: Proprietary ViveScript Solutions LLC",
                        fontSize = 12.sp,
                        color = TextLightSecondary
                    )
                }

                val privacyContext = LocalContext.current
                val privacyActivity = privacyContext as? android.app.Activity
                if (privacyActivity != null && ConsentManager.isPrivacyOptionsRequired(privacyContext)) {
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedButton(
                        onClick = { ConsentManager.showPrivacyOptions(privacyActivity) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("ad_privacy_options_button"),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (isBn) "বিজ্ঞাপন গোপনীয়তা সেটিংস" else "Ad Privacy Options",
                            color = PureWhite,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (isBn) "ঠিক আছে" else "Got it",
                    color = PureWhite,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}
