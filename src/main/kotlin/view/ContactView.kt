package view

import javafx.scene.layout.BorderPane
import model.User
import tornadofx.View
import tornadofx.find
import tornadofx.onSelectionChange

class ContactView : View() {
    override val root = BorderPane()

    val contactList: ContactList by inject()

    init {
        title = "Contacts"

        with (contactList.root) {
            root.center = this

            onSelectionChange {
                selectionChanged(it)
            }
        }

        selectionChanged(null)
    }

    private fun selectionChanged(selectedUser: User?) {
        val detail = find(ContactEditor::class)
        if (selectedUser != null)
            detail.edit(selectedUser)
        root.right = detail.root
    }
}