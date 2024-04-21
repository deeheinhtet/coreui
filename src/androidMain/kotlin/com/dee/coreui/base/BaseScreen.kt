package com.dee.coreui.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dee.coreui.BaseEvent
import com.dee.coreui.BaseViewModel
import com.dee.coreui.CommonPopupDisplayData
import com.dee.coreui.ext.CommonDialog

/**
 * Created by Hein Htet
 */


@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    vm: BaseViewModel = BaseViewModel(),
    event: BaseEvent,
    content: @Composable () -> Unit,
) {
    val openDialog = rememberSaveable { mutableStateOf(false) }

    val loading = vm.outputs.loading.collectAsState()
    DisposableEffect(key1 = event) {
        if (event is BaseEvent.EventError) {
            openDialog.value = true
        }
        onDispose { }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .then(modifier)) {
        content()
        if (openDialog.value && event is BaseEvent.EventError) {
            CommonDialog(
                commonPopupDisplayData = CommonPopupDisplayData(
                    title = "Oops",
                    message = event.errorDisplay.message,
                    rightButtonPressed = {},
                    rightButtonTextMessage = "Okay",
                    leftButtonPressed = {},
                    leftButtonTextMessage = "Cancel"
                )
            ) {
                openDialog.value = false
            }
        }
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.Center),
            visible = loading.value
        ) {
            CircularProgressIndicator()
        }
    }
}