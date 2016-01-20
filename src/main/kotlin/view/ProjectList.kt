package view

import javafx.scene.layout.HBox
import tornadofx.View
import tornadofx.addClass
import tornadofx.plusAssign

class ProjectList : View() {
    override val root = HBox()

    init {
        title = "Projects"
        root.addClass("content")

        root += ProjectChart::class
    }
}