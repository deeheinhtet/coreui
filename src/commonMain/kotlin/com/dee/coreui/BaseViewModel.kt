package com.dee.coreui

import com.dee.common.ErrorDisplay
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Created by Hein Htet
 */
expect open class BaseViewModel() : ViewModel {
    val scope: CoroutineScope
    open val inputs: BaseInputs
    open val outputs: BaseOutputs



    open inner class BaseInputs() {
        fun emitLoading(value : Boolean)
        fun emitError(errorDisplay: ErrorDisplay)
        fun emitEvent(event: BaseEvent)
    }

    open inner class BaseOutputs() {
        open val loading: CStateFlow<Boolean>
        open val eventFlow: CFlow<BaseEvent>
    }
}