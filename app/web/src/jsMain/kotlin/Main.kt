
import androidx.compose.ui.window.Window
import com.hx.like.demo.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
  onWasmReady {
    Window("ComposeLikeButton") {
      App()
    }
  }
}
