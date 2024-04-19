import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Hein Htet
 */
expect open class BaseViewModel() : ViewModel {
    val scope: CoroutineScope
    open val inputs: BaseInputs
    open val outputs: BaseOutputs

    open inner class BaseInputs() {
    }

    open inner class BaseOutputs() {

    }
}

