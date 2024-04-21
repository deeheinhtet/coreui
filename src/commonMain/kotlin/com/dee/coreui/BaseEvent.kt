package com.dee.coreui

import com.dee.common.ErrorDisplay

/**
 * Created by Hein Htet
 */
sealed class BaseEvent {
    data object Idle :BaseEvent()
    data class EventError(val errorDisplay: ErrorDisplay) : BaseEvent()
}
