package com.dee.coreui

import com.dee.common.ErrorDisplay
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Created by Hein Htet
 */
actual open class BaseViewModel : ViewModel() {
    actual val scope: CoroutineScope
        get() = viewModelScope
    actual open val inputs: BaseViewModel.BaseInputs
        get() = BaseInputs()
    actual open val outputs: BaseViewModel.BaseOutputs
        get() = BaseOutputs()

    private val _loading = MutableStateFlow<Boolean>(false)
    private val _eventChannel = Channel<BaseEvent>()

    actual open inner class BaseInputs {
        actual fun emitLoading(value: Boolean) {
            _loading.value = value
        }

        actual fun emitError(errorDisplay: ErrorDisplay) {
            scope.launch {
                _eventChannel.send(BaseEvent.EventError(errorDisplay))
            }
        }

        actual fun emitEvent(event: BaseEvent) {
            scope.launch {
                _eventChannel.send(event)
            }
        }
    }

    actual open inner class BaseOutputs {
        actual open val loading: CStateFlow<Boolean>
            get() = _loading.cStateFlow()
        actual open val eventFlow: CFlow<BaseEvent>
            get() = _eventChannel.receiveAsFlow().cFlow()
    }
}