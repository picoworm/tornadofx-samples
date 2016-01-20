package view

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import tornadofx.View
import tornadofx.control.ListMenu

/**
 * The main view features a BorderPane with a heading, a left menu and a main editor area - loaded from FXML.
 */
class Main : View() {
    override val root: BorderPane by fxml()

    val contactView: ContactView by inject()
    val projectList: ProjectList by inject()
    val settingsView: SettingsView by inject()

    @FXML lateinit var menu: ListMenu
    @FXML lateinit var headerText: Label

    init {
        title = "TornadoFX CRM Demo Application"

        // Listen to menu selection and show the corresponding view in the editor area
        menu.activeProperty().addListener { observableValue, oldItem, newItem ->
            when (newItem.text) {
                "Contacts" -> show(contactView)
                "Settings" -> show(settingsView)
                "Projects" -> show(projectList)
            }
        }
    }

    /**
     * Show the selected view by setting the root node of the view in the center
     * position of the BorderPane and binding the title of the view to the header.
     */
    private fun show(view: View) {
        root.center = view.root
        headerText.textProperty().bind(view.titleProperty)
    }
}