import java.util.*

enum class EventID_UDP {
    SP_CONNECT_TEST_REQ(1),
    SP_CONNECT_TEST_ACK(2),
    SP_CONNECT_RELAY_REQ(3),
    SP_CONNECT_RELAY_ACK(4),
    SP_DEFENCE_PORT(5),
    SP_RELAY(6),
    // 改原野前最後一版多這幾個
    SP_HEART_BEAT_REQ(),
    SP_HEART_BEAT_ACK(),
    SP_RETRY_INTERNAL_CONNECT_REQ(),
    SP_RETRY_INTERNAL_CONNECT_ACK(),

    XPT_BASIC(7),
    XPT_PORT_CHECK_REQ(17),
    XPT_PORT_CHECK_ACK(18),
    XPT_PING_TEST_REQ(10),
    XPT_PING_TEST_ACK(11),

    ;

    var op: Int = 0

    constructor() {
        this.op = 0xFFFF
    }

    constructor(o: Int) {
        this.op = o
    }

    companion object {

        private val spam = Arrays.asList<EventID_UDP?>(

        )

        private val opToEventIDMap: MutableMap<Int, EventID_UDP?> = HashMap()

        fun getEventIDByOp(op: Int): EventID_UDP? {
            return opToEventIDMap.getOrDefault(op, null)
        }

        fun isSpam(inHeaderByOp: EventID_UDP?): Boolean {
            return spam.contains(inHeaderByOp)
        }

        fun reload() {
            opToEventIDMap.clear()
            for (ih in values()) {
                opToEventIDMap.put(ih.op, ih)
            }
        }

        init {
            for (ih in values()) {
                opToEventIDMap.put(ih.op, ih)
            }
        }
    }
}