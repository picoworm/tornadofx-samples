package view

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.shape.Circle
import model.User
import org.controlsfx.control.Notifications
import tornadofx.*

/**
 * The ContactEditor is a Fragment, meaning it is not a singleton like View is.
 * A new instance of ContactEditor is created every time it is needed. Most of the time
 * you will use View instead.
 */
class ContactEditor : Fragment() {
    override val root = VBox()

    init {
        // Give the root node an id so we can style it with css
        root.id = "contact-editor"

        // Configure styling programmatically
        with (root) {
            prefWidth = 300.0
            padding = Insets(20.0)
            spacing = 10.0
            alignment = Pos.TOP_CENTER
        }
    }

    // Called by the ContactList when a user is selected
    fun edit(contact: User) {
        // Add the contact image as the first node in the editor
        root += contact.image()

        // Add a label with the contact name
        root += Label(contact.name.value).apply { addClass("name") }

        // Add a gridpane with multiple rows for the editor using type safe builders
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

// Convenience functions to show images inside a circle. Added as extension functions to User
fun User.thumbnail() = CircleImage("/img/users/thumbnail-${name.value.hashCode()}.jpg", 40.0)
fun User.image() = CircleImage("/img/users/medium-${name.value.hashCode()}.jpg", 150.0)

class CircleImage(url: String, size: Double) : ImageView() {
    init {
        fitWidth = size
        isPreserveRatio = true
        isSmooth = true
        isCache = true

        this.image = Image(User::class.java.getResourceAsStream(url))
        val glass = Circle(size / 2, size / 2, size / 2)
        clip = glass
    }
}