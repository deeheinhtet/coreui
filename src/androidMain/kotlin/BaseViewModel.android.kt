import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope

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

    actual open inner class BaseInputs {
    }

    actual open inner class BaseOutputs {

    }
}