package spring

import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import org.springframework.stereotype.Component
import tornadofx.View
import tornadofx.add

@Component class CenterView : View() {
    override val root = VBox()

    val service : helloservice by inject()

    init {
        println("starting centerview")
        root.add(TextField("Kotlin FX"))
        root.add(Label(service.hello("springed")))
    }
}
