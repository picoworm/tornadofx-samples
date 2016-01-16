package view

import javafx.animation.FadeTransition
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.util.Duration
import tornadofx.*

class SettingsView : View() {
    override val root = BorderPane()

    init {
        title = "Settings"

        root.center = GridPane().apply {
            addClass("settings")
            vgap = 20.0
            hgap = 20.0

            row {
                hbox {
                    configureItem(this)

                    imageview("/img/contacts.png")
                    vbox {
                        label("Contacts").addClass("h1")
                        label("Manage Contacts; set custom settings")
                    }

                    selectItem(this)
                }

                hbox {
                    configureItem(this)

                    imageview("/img/projects.png")
                    vbox {
                        label("Projects").addClass("h1")
                        label("Manage Projects; set custom settings")
                    }
                }

            }

            row {
                hbox {
                    configureItem(this)

                    imageview("/img/settings.png")
                    vbox {
                        label("Settings").addClass("h1")
                        label("Manage Settings; set custom settings")
                    }
                }
            }
        }
    }

    private fun configureItem(item: HBox) {
        item.addClass("item")

        item.setOnMouseClicked {
            selectItem(item)
        }
    }

    private fun selectItem(item: HBox) {
        for (i in item.parent.childrenUnmodifiable)
            i.removeClass("selected")

        item.addClass("selected")

        val title = item.lookup(".h1") as Label

        root.bottom = Label("Selected ${title.text}...").apply {
            FadeTransition(Duration.seconds(1.5), this).apply {
                toValue = 0.0
                play()
            }
        }
    }


}