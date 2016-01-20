package view

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.animation.FadeTransition
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.util.Duration
import tornadofx.*

/**
 * This view features a kind of adhoc menu component created with type safe builders.
 * It also shows how to add nodes that are not created with builders inside the builder itself.
 */
class SettingsView : View() {
    override val root = BorderPane()

    init {
        title = "Settings"
        root.addClass("content")

        root.center = GridPane().apply {
            addClass("settings")
            vgap = 20.0
            hgap = 20.0

            row {
                hbox {
                    configureItem(this)

                    this += icon(FontAwesomeIcon.USER, "#3FFF7D")
                    vbox {
                        label("Contacts").addClass("h1")
                        label("Manage Contacts; set custom settings")
                    }

                    selectItem(this)
                }

                hbox {
                    configureItem(this)

                    this += icon(FontAwesomeIcon.SUITCASE, "#FFB151")
                    vbox {
                        label("Projects").addClass("h1")
                        label("Manage Projects; set custom settings")
                    }
                }

            }

            row {
                hbox {
                    configureItem(this)

                    this += icon(FontAwesomeIcon.COG, "darkblue")
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

    private fun icon(img: FontAwesomeIcon, color: String): Node {
        val icon = FontAwesomeIconView(img)
        icon.glyphSize = 50.0
        icon.glyphStyle = "-fx-fill: " + color
        return icon
    }
}