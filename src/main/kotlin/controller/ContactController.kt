package controller

import javafx.collections.ObservableList
import model.User
import tornadofx.Controller
import tornadofx.observable
import javax.json.Json
import javax.json.JsonObject

class ContactController : Controller() {

    fun listContacts(): ObservableList<User> {
        ContactController::class.java.getResourceAsStream("/users.json").use {
            return Json.createReader(it).readArray().map {
                val user = User()
                user.updateModel(it as JsonObject)
                user
            }.observable()
        }
    }
}