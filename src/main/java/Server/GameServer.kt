package Server

class GameServer (n: String, id: Int) {
    val nName = n
    val nId = id
    val nPort = 9300 + ((id - 1) * 200)
    val nSubPort = 9300 + ((id - 1) * 200) + 1
    val BeginLv = 1
    val EndLv = 99
    val PerExp = 0
    val PerED = 0
}