package com.dee.coreui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by Hein Htet
 */


interface CoreDimensI {
    val dimen16: Dp
    val dimen18: Dp
    val dimen20: Dp
    val dimen22: Dp
    val dimen24: Dp
    val dimen26: Dp
    val dimen28: Dp
    val dimen30: Dp
    val dimen32: Dp
    val dimen34: Dp
    val dimen38: Dp
    val dimen40: Dp
    val dimen42: Dp
    val dimen44: Dp
    val dimen46: Dp
    val dimen48: Dp
    val dimen50: Dp
}

data class CoreDimens(
    override val dimen16: Dp = 16.dp,
    override val dimen18: Dp = 18.dp,
    override val dimen20: Dp = 20.dp,
    override val dimen22: Dp = 22.dp,
    override val dimen24: Dp = 24.dp,
    override val dimen26: Dp = 26.dp,
    override val dimen28: Dp = 28.dp,
    override val dimen30: Dp = 30.dp,
    override val dimen32: Dp = 32.dp,
    override val dimen34: Dp = 34.dp,
    override val dimen38: Dp = 38.dp,
    override val dimen40: Dp = 40.dp,
    override val dimen42: Dp = 42.dp,
    override val dimen44: Dp = 44.dp,
    override val dimen46: Dp = 46.dp,
    override val dimen48: Dp = 48.dp,
    override val dimen50: Dp = 50.dp,
) : CoreDimensI