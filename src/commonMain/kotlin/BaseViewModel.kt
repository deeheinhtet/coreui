import kotlinx.coroutines.CoroutineScope

/**
 * Created by Hein Htet
 */
expect open class BaseViewModel() {
    val scope: CoroutineScope
}