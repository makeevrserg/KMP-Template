
import javax.swing.SwingUtilities

internal fun <T> runOnUiThread(block: () -> T): T {
    if (SwingUtilities.isEventDispatchThread()) {
        return block.invoke()
    }

    var error: Throwable? = null
    var result: T? = null

    SwingUtilities.invokeAndWait {
        try {
            result = block.invoke()
        } catch (e: Throwable) {
            error = e
        }
    }

    error?.also { throwable -> throw throwable }

    @Suppress("UNCHECKED_CAST")
    return result as T
}
