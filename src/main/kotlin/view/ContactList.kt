package view

import controller.ContactController
import javafx.scene.control.TableView
import model.User
import tornadofx.View
import tornadofx.addColumn
import tornadofx.cellFormat
import tornadofx.selectFirst
import java.time.LocalDate

class ContactList : View() {
    override val root = TableView<User>()
    val controller: ContactController by inject()

    init {
        title = "Contacts"

        addColumns()

        background {
            controller.listContacts()
        } ui {
            root.items = it
            root.selectFirst()
        }
    }

    private fun addColumns() {
        root.addColumn<User, String>("Name") { it.value.name }.apply {
            prefWidth = 200.0
            styleClass.add("name")

            // Configure icon and text for name cell
            cellFormat {
                with (tableRow.item as User) {
                    graphic = thumbnail()
                    text = name.value
                }
            }
        }
        root.addColumn<User, LocalDate>("Date of Birth") { it.value.dob }.apply { prefWidth = 100.0 }
        root.addColumn<User, String>("Email Address") { it.value.email }.apply { prefWidth = 300.0 }
        root.addColumn<User, String>("Phone") { it.value.phone }.apply { prefWidth = 150.0 }
    }
}
