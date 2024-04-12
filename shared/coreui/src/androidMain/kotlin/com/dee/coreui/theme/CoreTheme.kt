package com.dee.coreui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily

/**
 * Created by Hein Htet
 */


/**
 * Theme Configs for core UI, accept the custom typography, color and dimension
 * @param appTypography
 * @param appColor
 * @param appDimen
 * @param fontFamily
 */
@Immutable
data class ThemeConfigs<Color, Typography, Dimen>(
    val appTypography: ProvidableCompositionLocal<Typography>,
    val appColor: ProvidableCompositionLocal<Color>,
    val appDimen: ProvidableCompositionLocal<Dimen>,
    val fontFamily: FontFamily = FontFamily.Default,
)

fun <T> getProvideLocalComposition(factory: () -> T): ProvidableCompositionLocal<T> {
    return staticCompositionLocalOf(factory)
}

/**
 * CoreAppTheme custom: provided given the core app theme config for LocalStaticComposition
 * @param themeConfigs
 * @param content
 */
@Composable
fun <Color, Typography, Dimen> CoreAppTheme(
    themeConfigs: ThemeConfigs<Color, Typography, Dimen>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        themeConfigs.appTypography provides themeConfigs.appTypography.current,
        themeConfigs.appColor provides themeConfigs.appColor.current,
        themeConfigs.appDimen provides themeConfigs.appDimen.current
    ) {
        content()
    }
}