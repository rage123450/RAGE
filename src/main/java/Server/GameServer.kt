package Server

class GameServer (n: String, id: Int) {
    val nName = n
    val nId = id
    val nPort = 9400 + id
}