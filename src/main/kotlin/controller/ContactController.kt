package controller

import javafx.collections.ObservableList
import model.User
import tornadofx.Controller
import tornadofx.Rest
import tornadofx.list
import tornadofx.toModel

class ContactController : Controller() {
    val api: Rest by inject()

    fun listContacts(): ObservableList<User> = api.get("users.json").list().toModel()

    fun saveContact(contact: User) {
        api.put("contact", contact)
    }

    init {
        // Configure the BASE URI of the Rest endpoint. The example just points to a static collection of files
        api.baseURI = "https://raw.githubusercontent.com/edvin/tornadofx-samples/master/src/main/resources"
    }
}