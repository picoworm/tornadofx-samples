package model

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.image.Image
import samples.component.CircleImage
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.date
import tornadofx.string
import java.time.LocalDate
import javax.json.JsonObject

class User : JsonModel {
    enum class ImageSize { thumbnail, medium }

    val name = SimpleStringProperty()
    val dob = SimpleObjectProperty<LocalDate>()
    val email = SimpleStringProperty()
    val phone = SimpleObjectProperty<String>()

    fun thumbnail() = CircleImage(Image(imageURL(ImageSize.thumbnail)), 40.0)
    fun image() = CircleImage(Image(imageURL(ImageSize.medium)), 150.0)

    private fun imageURL(size: User.ImageSize) =
            User::class.java.getResource("/img/users/$size-${name.value.hashCode()}.jpg").toString()

    override fun updateModel(json: JsonObject) {
        name.value = json.string("name")
        dob.value = json.date("dob")
        email.value = json.string("email")
        phone.value = json.string("phone")
    }

    override fun toJSON(json: JsonBuilder) {
        with (json) {
            add("name", name)
            add("dob", dob)
            add("email", email)
            add("phone", phone)
        }
    }
}
