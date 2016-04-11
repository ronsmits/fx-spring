package spring

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import tornadofx.View
import tornadofx.add

class CenterView : View() {
    override val root = VBox()

    val service : helloservice by inject()

    init {
        println("starting centerview")
        root.add(Label(service.hello("hello Guice")))
    }
}
