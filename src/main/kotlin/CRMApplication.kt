import tornadofx.App
import tornadofx.importStylesheet
import view.Main

class CRMApplication : App() {
    override val primaryView = Main::class

    init {
        importStylesheet("/styles.css")
    }
}