package com.dee.coreui

import kotlinx.serialization.Serializable

/**
 * Created by Hein Htet
 */

@Serializable
data class CommonPopupDisplayData(
    val title: String,
    val message: String,
    val leftButtonTextMessage: String? = null,
    val rightButtonTextMessage: String,
    val leftButtonPressed: () -> Unit = {},
    val rightButtonPressed:() -> Unit = {},
)