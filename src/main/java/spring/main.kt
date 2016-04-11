package spring

import com.google.inject.AbstractModule
import com.google.inject.Guice
import javafx.scene.layout.BorderPane
import tornadofx.*
import kotlin.reflect.KClass

/**
 * Created by ronsmits on 11/04/16.
 */

class Main : App() {
    override val primaryView = MainView::class

    override fun init() {
        val guice = Guice.createInjector(MyModule())
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T =
                    guice.getInstance(type.java)
        }

    }
}

class MyModule : AbstractModule() {
    override fun configure() {
        bind(helloservice::class.java).to(helloserviceImpl::class.java)
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