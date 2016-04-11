package spring

import org.springframework.stereotype.Component

/**
 * Created by ronsmits on 11/04/16.
 */


interface helloservice {
    fun hello(message:String) : String
}

@Component
open class helloserviceImpl : helloservice {
    override fun hello(message: String): String {
        return "inserted with spring for $message"
    }

}