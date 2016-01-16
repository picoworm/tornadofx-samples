package view

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import tornadofx.View
import tornadofx.addClass
import tornadofx.control.ListMenu

class Main : View() {
    override val root: BorderPane by fxml()

    val contactView: ContactView by inject()
    val projectList: ProjectList by inject()
    val settingsView: SettingsView by inject()

    @FXML lateinit var menu: ListMenu
    @FXML lateinit var headerText: Label

    init {
        title = "TornadoFX CRM Demo Application"

        menu.activeProperty().addListener { observableValue, oldItem, newItem ->
            when (newItem.text) {
                "Contacts" -> show(contactView)
                "Settings" -> show(settingsView)
                "Projects" -> show(projectList)
            }
        }
    }

    private fun show(view: View) {
        view.root.addClass("content")
        root.center = view.root
        headerText.textProperty().bind(view.titleProperty)
    }
}