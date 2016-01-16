package samples.component

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.shape.Circle

class CircleImage(image: Image, size: Double) : ImageView() {
    init {
        fitWidth = size
        isPreserveRatio = true
        isSmooth = true
        isCache = true

        this.image = image
        val glass = Circle(size/2, size/2, size/2)
        clip = glass
    }
}