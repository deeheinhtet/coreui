package com.dee.coreui.ext

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.dee.coreui.CommonPopupDisplayData

/**
 * Created by Hein Htet
 */

@Composable
fun ComponentActivity.ChangeSystemBarsTheme(lightTheme: Boolean, barColor: Int) {
    LaunchedEffect(lightTheme) {
        if (lightTheme) {
            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(
                    barColor, barColor,
                ),
                navigationBarStyle = SystemBarStyle.light(
                    barColor, barColor,
                ),
            )
        } else {
            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.dark(
                    barColor,
                ),
                navigationBarStyle = SystemBarStyle.dark(
                    barColor,
                ),
            )
        }
    }
}


fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}

@Composable
fun CommonDialog(
    commonPopupDisplayData: CommonPopupDisplayData,
    isDismissRequest: () -> Unit = {},
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    AlertDialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        modifier = Modifier.width(screenWidth - 40.dp),
        shape = RoundedCornerShape(8.dp),
        onDismissRequest = {
            isDismissRequest()
        },
        title = {
            Text(text = commonPopupDisplayData.title)
        },
        text = {
            Text(commonPopupDisplayData.message)
        },
        confirmButton = {
            Button(
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    commonPopupDisplayData.rightButtonPressed()
                    isDismissRequest()
                }) {
                Text(commonPopupDisplayData.rightButtonTextMessage)
            }
        },
        dismissButton = {
            if (commonPopupDisplayData.leftButtonTextMessage != null) {
                Button(
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        commonPopupDisplayData.leftButtonPressed()
                        isDismissRequest()
                    }) {
                    Text(commonPopupDisplayData.leftButtonTextMessage)
                }
            }
        }
    )
}

