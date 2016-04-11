package spring

import javafx.scene.layout.BorderPane
import org.springframework.context.support.ClassPathXmlApplicationContext
import tornadofx.*
import kotlin.reflect.KClass

/**
 * Created by ronsmits on 11/04/16.
 */

class Main : App() {
    override val primaryView = MainView::class

    override fun init() {
        val spring = ClassPathXmlApplicationContext("/spring.xml")
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T {
                println("looking for $type")
                    return spring.getBean(type.java)
                    }
        }

    }
}

class MainView : View() {
    override val root = BorderPane()

    val centerview: CenterView by inject()

    init {
        with(root) {
            center {
                this += centerview.root
            }
        }
    }
}