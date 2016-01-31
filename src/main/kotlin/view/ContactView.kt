package view

import javafx.scene.layout.BorderPane
import model.User
import tornadofx.View
import tornadofx.addClass
import tornadofx.find
import tornadofx.onSelectionChange

/**
 * A Master/Detail example with TableView injected in the center and
 * a ContactEditor fragment loaded in the right part of the BorderPane
 * when a Contact is selected.
 *
 */
class ContactView : View() {
    override val root = BorderPane()

    val contactList: ContactList by inject()

    init {
        title = "Contacts"
        root.addClass("content")

        with (contactList.root) {
            root.center = this

            onSelectionChange {
                editUser(it)
            }
        }

        editUser(null)
    }

    private fun editUser(selectedUser: User?) {
        val detail = find(ContactEditor::class)
        if (selectedUser != null)
            detail.edit(selectedUser)
        root.right = detail.root
    }
}