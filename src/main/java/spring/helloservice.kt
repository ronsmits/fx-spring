package spring


/**
 * Created by ronsmits on 11/04/16.
 */


interface helloservice {
    fun hello(message:String) : String
}

open class helloserviceImpl : helloservice {
    override fun hello(message: String): String {
        return "inserted with guice for $message"
    }

}