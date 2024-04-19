import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Hein Htet
 */
actual open class BaseViewModel : ViewModel() {
    actual val scope: CoroutineScope
        get() = viewModelScope
}