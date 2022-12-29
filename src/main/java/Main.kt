
import Handlers.Handler
import Netty.GameServerAcceptor
import Netty.SelectChannelServerAcceptor
import Netty.SubGameServerAcceptor
import Server.SelectChannelServer
import network.netty.UDPAcceptor
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.LongIdTable
import util.Util
import java.io.File
import java.lang.reflect.Method
import java.nio.charset.Charset


val UTF16LE = Charset.forName("UTF-16LE")
val UTF8 = Charset.forName("UTF-8")

val channelcount = 1/*6*/
val server = SelectChannelServer(0, channelcount)

val handlersDir = System.getProperty("user.dir") + "/src/main/java/Handlers"
var handlers: MutableMap<EventID, Method> = HashMap()

fun main() {

//    DatabaseFactory.init()

    initHandlers(false)

    val scsa = SelectChannelServerAcceptor()
    scsa.scs = server
    Thread(scsa).start()
    Thread(UDPAcceptor()).start()

    server.channels.forEach { channel ->
        val ca = GameServerAcceptor()
        ca.gs = channel
        Thread(ca).start()

        val subca = SubGameServerAcceptor()
        subca.gs = channel
        Thread(subca).start()
    }
}

fun initHandlers(mayOverride: Boolean) {
    val start = System.currentTimeMillis()
    val files: MutableSet<File> = HashSet()
    Util.findAllFilesInDirectory(files, File(handlersDir))
    for (file in files) {
        try {
//            println(file.name)
            val className = file.path
                .replace("[\\\\|/]".toRegex(), ".")
                .split("src\\.main\\.java\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                .replace("\\.kt".toRegex(), "")
                .replace("\\.java".toRegex(), "")
            val clazz = Class.forName(className)
            for (method in clazz.methods) {
                val handler = method.getAnnotation(Handler::class.java)
                if (handler != null) {
                    val header: EventID = handler.op
                    if (header != EventID.NO) {
                        require(!(handlers.containsKey(header) && !mayOverride)) {
                            String.format(
                                "Multiple handlers found for header %s! " +
                                        "Had method %s, but also found %s.",
                                header,
                                handlers.get(header)!!.getName(),
                                method.name
                            )
                        }
                        handlers.put(header, method)
//                        println("|op| $header / $method")
                    }

                    val headers: Array<EventID> = handler.ops
                    for (h in headers) {
                        handlers.put(h, method)
//                        println("|ops| $header / $method")
                    }
                }
            }
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
//    println("Initialized " + handlers.size + " handlers in " + (System.currentTimeMillis() - start) + "ms.");
}

object Users : LongIdTable() {
    val name = varchar("name", 255).uniqueIndex()
    val password = varchar("password", 255)
    /*    val ravencard = byte("ravencard")
        val evecard = byte("evecard")
        val chungcard = byte("chungcard")
        val unitslot = byte("unitslot")*/
}

object Units : LongIdTable() {
    val owneruseruid = long("owneruseruid")
    val name = varchar("name", 255).uniqueIndex()
    val level = byte("level")
    val unitclass = byte("unitclass")
    val exp = byte("exp")
    val ed = integer("ed")
    val skillslot1 = short("skillslot1")
    val skillslot2 = short("skillslot2")
    val skillslot3 = short("skillslot3")
    val skillslot4 = short("skillslot4")
    val skillslot5 = short("skillslot5")
    val skillslot6 = short("skillslot6")
    val skillslot7 = short("skillslot7")
    val skillslot8 = short("skillslot8")
    val titleid = integer("titleid")
    val guildid = integer("guildid")
    val equipslot = integer("equipslot")
    val accessoryslot = integer("accessoryslot")
    val materialslot = integer("materialslot")
    val specialslot = integer("specialslot")
    val questslot = integer("questslot")
    val quickslot = integer("quickslot")
    val avatarslot = integer("avatarslot")
    val bankslot = integer("bankslot")
}

object guilds : IntIdTable() {
    val grade = byte("grade")
    val honorpoint = integer("honorpoint")
    val name = varchar("name", 255)
}