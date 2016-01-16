package view

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import model.User
import org.controlsfx.control.Notifications
import tornadofx.*

class ContactEditor : Fragment() {
    override val root = VBox()

    init {
        root.id = "contact-editor"

        with (root) {
            prefWidth = 300.0
            padding = Insets(20.0)
            spacing = 10.0
            alignment = Pos.TOP_CENTER
        }
    }

    fun edit(contact: User) {
        root += contact.image()
        root += Label(contact.name.value).apply { addClass("name") }

        root += GridPane().apply {
            vgap = 10.0
            hgap = 10.0

            row {
                label("Email")
                textfield {
                    textProperty().bindBidirectional(contact.email)
                }
            }

            row {
                label("Phone")
                textfield {
                    textProperty().bindBidirectional(contact.phone)
                }

            }
            row {
                label("DOB")
                datepicker {
                    valueProperty().bindBidirectional(contact.dob)
                }
            }

            row {
                button("Save").apply {
                    GridPane.setColumnSpan(this, 2)

                    setOnAction {
                        Notifications.create()
                                .title("The contact was saved")
                                .text("${contact.name.value} was saved")
                                .graphic(contact.thumbnail())
                                .owner(root)
                                .show()
                    }
                }
            }
        }
    }
}