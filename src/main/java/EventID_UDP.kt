import java.util.*

enum class EventID_UDP {
    SP_CONNECT_TEST_REQ(1),
    SP_CONNECT_TEST_ACK(2),
    SP_DEFENCE_PORT(3),
    SP_RETRY_INTERNAL_CONNECT_REQ(4),
    SP_RETRY_INTERNAL_CONNECT_ACK(5),
    SP_CONNECT_RELAY_REQ(6),
    SP_CONNECT_RELAY_ACK(7),
    SP_RELAY_SET_UID_LIST_REQ(8),
    SP_RELAY_SET_UID_LIST_ACK(9),
    SP_RELAY_PRECONFIG(10),
    SP_RELAY(11),
    SP_CONNECT_CHECK_REQ(12),
    SP_CONNECT_CHECK_ACK(13),
    SP_HEART_BEAT_REQ(14),
    SP_HEART_BEAT_ACK(15),

    XPT_BASIC(18/*16*/),
    XPT_PORT_CHECK_REQ(19/*17*/), // 2022/11/09 added i'm not sure on which
    XPT_PORT_CHECK_ACK(20/*18*/),
    XPT_PING_TEST_REQ(21/*19*/),
    XPT_PING_TEST_ACK(22/*20*/),

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