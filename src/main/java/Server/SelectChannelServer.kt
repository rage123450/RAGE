package Server


open class SelectChannelServer {
    var worldId = 0
    var channels: List<GameServer>
    val nPort = 9400

    constructor(w: Int, channelcount: Int) {
        worldId = w
        val channelList: MutableList<GameServer> = ArrayList()
        for (i in 1..channelcount) {
            channelList.add(GameServer("分流" + if (i > 9) "1" else "0" + i.toString(), i))
        }
        channels = channelList
    }

    fun getChannelById(id: Int): GameServer {
        return channels.stream().filter { c -> c.nId === id }.findFirst().orElse(null)
    }
}