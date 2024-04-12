package com.dee.coreui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Created by Hein Htet
 */


/**
 * Core App TextStyle for different font style
 */
interface CoreAppTextStyleI {
    val regular: TextStyle
    val medium: TextStyle
    val semiBold: TextStyle
    val bold: TextStyle
}

/**
 * Core App TextStyle implementation for different font style
 */
class CoreAppTextStyle(
    baseTextStyle: TextStyle = TextStyle(),
    fontSize: TextUnit,
) : CoreAppTextStyleI {
    override val regular: TextStyle =
        baseTextStyle.copy(fontSize = fontSize, fontWeight = FontWeight.Normal)
    override val medium: TextStyle =
        baseTextStyle.copy(fontSize = fontSize, fontWeight = FontWeight.Medium)
    override val semiBold: TextStyle =
        baseTextStyle.copy(fontSize = fontSize, fontWeight = FontWeight.SemiBold)
    override val bold: TextStyle =
        baseTextStyle.copy(fontSize = fontSize, fontWeight = FontWeight.Bold)
}


/**
 * Core App custom Typography
 */
interface CoreTypographyI {
    val text16: CoreAppTextStyleI
    val text18: CoreAppTextStyleI
    val text20: CoreAppTextStyleI
    val text22: CoreAppTextStyleI
    val text24: CoreAppTextStyleI
    val text26: CoreAppTextStyleI
    val text28: CoreAppTextStyleI
    val text32: CoreAppTextStyleI
}


/**
 * Core App custom Typography implementation
 */
class CoreTypography(fontFamily: FontFamily) : CoreTypographyI {

    private val baseTextStyle = TextStyle(fontFamily = fontFamily)
    override val text16: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 16.sp)

    override val text18: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 18.sp)

    override val text20: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 20.sp)

    override val text22: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 22.sp)

    override val text24: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 24.sp)

    override val text26: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 26.sp)

    override val text28: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 28.sp)

    override val text32: CoreAppTextStyleI
        get() = CoreAppTextStyle(baseTextStyle, fontSize = 32.sp)

}


// extension to apply color on textStyle
fun TextStyle.color(color: Color) = this.copy(color = color)