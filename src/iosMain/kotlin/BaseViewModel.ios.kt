import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * Created by Hein Htet
 */
actual open class BaseViewModel : ViewModel() {
    actual val scope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)
    actual open val inputs: BaseViewModel.BaseInputs
        get() = BaseInputs()
    actual open val outputs: BaseViewModel.BaseOutputs
        get() = BaseOutputs()

    actual open inner class BaseInputs actual constructor() {
    }

    actual open inner class BaseOutputs actual constructor() {

    }

}