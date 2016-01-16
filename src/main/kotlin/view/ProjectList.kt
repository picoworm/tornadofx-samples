package view

import javafx.scene.layout.HBox
import tornadofx.View
import tornadofx.plusAssign

class ProjectList : View() {
    override val root = HBox()

    init {
        title = "Projects"

        root += ProjectChart::class
    }
}