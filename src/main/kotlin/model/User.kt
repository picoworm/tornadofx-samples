package model

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.date
import tornadofx.string
import java.time.LocalDate
import javax.json.JsonObject

class User : JsonModel {
    val name = SimpleStringProperty()
    val dob = SimpleObjectProperty<LocalDate>()
    val email = SimpleStringProperty()
    val phone = SimpleObjectProperty<String>()

    // Convert properties of a javax.json.JsonObject to properties of our domain object
    override fun updateModel(json: JsonObject) {
        name.value = json.string("name")
        dob.value = json.date("dob")
        email.value = json.string("email")
        phone.value = json.string("phone")
    }

    // Convert our domain object to JSON, typically used for POST and PUT operations by the Rest API
    override fun toJSON(json: JsonBuilder) {
        with (json) {
            add("name", name)
            add("dob", dob)
            add("email", email)
            add("phone", phone)
        }
    }
}
