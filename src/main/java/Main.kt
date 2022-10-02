

import Netty.GameServerAcceptor
import Netty.SelectChannelServerAcceptor
import Server.SelectChannelServer
import network.netty.UDPAcceptor
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.LongIdTable
import java.nio.charset.Charset

const val channelcount = 3
val UTF16LE = Charset.forName("UTF-16LE")
val UTF8 = Charset.forName("UTF-8")

val server = SelectChannelServer(0, channelcount)

fun main() {
    DatabaseFactory.init()

    val scsa = SelectChannelServerAcceptor()
    scsa.scs = server
    Thread(scsa).start()
    Thread(UDPAcceptor()).start()

    server.channels.forEach { channel -> val ca = GameServerAcceptor()
        ca.gs = channel
        Thread(ca).start()
    }
}

object Users: LongIdTable() {
    val name = varchar("name", 255).uniqueIndex()
    val password = varchar("password", 255)
/*    val ravencard = byte("ravencard")
    val evecard = byte("evecard")
    val chungcard = byte("chungcard")
    val unitslot = byte("unitslot")*/
}

object Units: LongIdTable() {
    val accessoryslot = integer("accessoryslot")
    val avatarslot = integer("avatarslot")
    val bankslot = integer("bankslot")
    val ed = integer("ed")
    val equipslot = integer("equipslot")
    val exp = integer("exp")
    val guildid = integer("guildid")
    val level = byte("level")
    val materialslot = integer("materialslot")
    val name = varchar("name", 255).uniqueIndex()
    val questslot = integer("questslot")
    val quickslot = integer("quickslot")
    val skillslot1 = short("skillslot1")
    val skillslot2 = short("skillslot2")
    val skillslot3 = short("skillslot3")
    val skillslot4 = short("skillslot4")
    val skillslot5 = short("skillslot5")
    val skillslot6 = short("skillslot6")
    val skillslot7 = short("skillslot7")
    val skillslot8 = short("skillslot8")
    val specialslot = integer("specialslot")
    val titleid = integer("titleid")
    val unitclass = byte("unitclass")
    val useruid = long("useruid")
}

object guilds: IntIdTable() {
    val grade = byte("grade")
    val honorpoint = integer("honorpoint")
    val name = varchar("name", 255)
}