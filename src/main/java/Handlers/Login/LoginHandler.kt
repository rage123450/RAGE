package Handlers.Login

import EventID.*
import Handlers.Handler
import NetError.NET_OK
import Netty.InPacket
import Netty.NettyClient
import Netty.OutPacket
import Netty.Packet.Login
import Netty.Packet.Unknown

object LoginHandler {

    @Handler(op = ECH_START_REQ)
    @JvmStatic
    fun ECH_START_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.ECH_START_ACK())
    }

    @Handler(op = E_HEART_BEAT)
    @JvmStatic
    fun E_HEART_BEAT(c: NettyClient, inPacket: InPacket) {
    }

    @Handler(op = ECH_VERIFY_ACCOUNT_REQ)
    @JvmStatic
    fun ECH_VERIFY_ACCOUNT_REQ(c: NettyClient, inPacket: InPacket) {
        inPacket.decodeBoolean() // 第一次登入是true [first login are true]
        val acc = inPacket.decodeString()
        val password = inPacket.decodeString() // 中國服會使用md5加密
        val machineid = inPacket.decodeString(false)
        inPacket.decodeInt()
        val unk = inPacket.decodeBoolean() // 第二次登入是true [secondry login are true]

        println("帳號: $acc 密碼: $password")

        /*        var result = NET_OK
                lateinit var UserId: EntityID<Long>
                transaction {
                    val userData = Users.select { Users.name.eq(acc) }.firstOrNull()
                    when {
                        userData == null -> {
                            result = ERR_VERIFY_04
                        }

                        !userData.get(Users.password).equals(password) -> {
                            result = ERR_VERIFY_06
                        }

                        else -> {
                            UserId = userData.get(Users.id)
                        }
                    }
                }

        //        var a = User(UserId)
        //        println("$result ID $UserId")

                when (result) {
                    ERR_VERIFY_04 -> c.write(OutPacket(result, ECH_VERIFY_ACCOUNT_ACK))
                    NET_OK -> {*/
        c.write(
            Login.ECH_VERIFY_ACCOUNT_ACK(
                1000515070/*1*//*UserId.value*/ /*a.id.value*/,
                acc /*a.name*/,
                password /*a.password*/
            )
        )
        /*            }

                    else -> {}
                }*/

/*        if (!c.firstlogin) return

        c.write(Login.ECH_VERIFY_ACCOUNT_ACK(1000515070, acc, password))
        c.firstlogin == false*/

    }

    @Handler(op = ECH_GET_SERVERGROUP_LIST_REQ)
    @JvmStatic
    fun ECH_GET_SERVERGROUP_LIST_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(OutPacket(NET_OK, ECH_GET_SERVERGROUP_LIST_ACK))
        c.write(Login.ECH_GET_SERVERGROUP_LIST_NOT())
    }

    @Handler(op = ECH_GET_CHANNEL_LIST_REQ)
    @JvmStatic
    fun ECH_GET_CHANNEL_LIST_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(OutPacket(NET_OK, ECH_GET_CHANNEL_LIST_ACK))
        c.write(Login.ECH_GET_CHANNEL_LIST_NOT())
    }

    @Handler(op = EGS_ENTRY_POINT_GET_CHANNEL_LIST_REQ)
    @JvmStatic
    fun EGS_ENTRY_POINT_GET_CHANNEL_LIST_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_ENTRY_POINT_GET_CHANNEL_LIST_ACK())
    }

    @Handler(op = EGS_DISCONNECT_FOR_SERVER_SELECT_REQ)
    @JvmStatic
    fun EGS_DISCONNECT_FOR_SERVER_SELECT_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(OutPacket(NET_OK, EGS_DISCONNECT_FOR_SERVER_SELECT_ACK))
    }

    @Handler(op = EGS_CONNECT_REQ)
    @JvmStatic
    fun EGS_CONNECT_REQ(c: NettyClient, inPacket: InPacket) {
        val version = inPacket.decodeString() /*L.221013.1*/
        inPacket.decodeByte() /*107*/
        println("版本: $version")
        c.write(Login.EGS_UNK_3_ACK_1())
        c.write(Login.EGS_UNK_3_ACK_2())
        c.write(Login.EGS_UNK_3_ACK_3())
        c.write(Login.EGS_UNK_3_ACK_4())
        c.write(Login.EGS_CONNECT_ACK())
    }

    @Handler(op = EGS_UNK_3_REQ)
    @JvmStatic
    fun EGS_UNK_3_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(OutPacket(NET_OK, EGS_UNK_3_ACK))
    }

    @Handler(op = ECH_DISCONNECT_REQ)
    @JvmStatic
    fun ECH_DISCONNECT_REQ(c: NettyClient, inPacket: InPacket) {
        val o = OutPacket()
        o.end(ECH_DISCONNECT_ACK)
        c.write(o)
    }

    @Handler(op = EGS_ADMIN_MODIFY_UNIT_LEVEL_REQ)
    @JvmStatic
    fun EGS_ADMIN_MODIFY_UNIT_LEVEL_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Unknown.EGS_ADMIN_MODIFY_UNIT_LEVEL_ACK())
    }

    @Handler(op = EGS_VERIFY_ACCOUNT_REQ)
    @JvmStatic
    fun EGS_VERIFY_ACCOUNT_REQ(c: NettyClient, inPacket: InPacket) {
        // 這裡的順序會互換 而且被VM
        /*        lateinit var account: String
                val password = inPacket.decodeString()
                if (password.length >= 14) {
                    inPacket.decodeString()
                    val MachineID = inPacket.decodeString(false)
                    inPacket.decodeInt() // B0 13 D7 FD m_iChannelingCode?
                    inPacket.decodeByte(); // 00 m_bDebugAuth
                    val version = inPacket.decodeString()
                    val subversion = inPacket.decodeString()
                    account = inPacket.decodeString()
                    inPacket.decodeByte() // m_bManualLogin
                    inPacket.decodeString(false)
                } else {
                    inPacket.decodeByte(); // 00 m_bDebugAuth
                    val password = inPacket.decodeString()
                    account = inPacket.decodeString()
                    inPacket.decodeInt() // 00 00 00 00 m_iChannelingCode
                    val MachineID = inPacket.decodeString(false)
                    inPacket.decodeByte() // m_bManualLogin
                    val version = inPacket.decodeString()
                    val subversion = inPacket.decodeString()
                }*/
        println("頻道登入")
//        println("密碼: $password")

        c.write(Login.EGS_VERIFY_ACCOUNT_ACK("1234567"/*account*/, "1234567"/*password*/))
        c.write(Login.EGS_CHAT_OPTION_INFO_NOT())
        c.write(Login.EGS_KEYBOARD_MAPPING_INFO_NOT())
        c.write(Login.ENX_USER_LOGIN_NOT())
    }

    @Handler(op = EGS_CHECK_MACHINE_ID_REQ)
    @JvmStatic
    fun EGS_CHECK_MACHINE_ID_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_CHECK_MACHINE_ID_ACK(inPacket.decodeString(false)))
    }

    @Handler(op = EGS_GET_CREATE_UNIT_TODAY_COUNT_REQ)
    @JvmStatic
    fun EGS_GET_CREATE_UNIT_TODAY_COUNT_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_GET_CREATE_UNIT_TODAY_COUNT_ACK())
    }

    @Handler(op = EGS_STATE_CHANGE_SERVER_SELECT_REQ)
    @JvmStatic
    fun EGS_STATE_CHANGE_SERVER_SELECT_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.ENX_USER_LOGIN_NOT())
        c.write(OutPacket(NET_OK, EGS_STATE_CHANGE_SERVER_SELECT_ACK))
    }

    @Handler(op = EGS_CURRENT_TIME_REQ)
    @JvmStatic
    fun EGS_CURRENT_TIME_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_CURRENT_TIME_ACK())
    }

    @Handler(op = EGS_SELECT_SERVER_SET_REQ)
    @JvmStatic
    fun EGS_SELECT_SERVER_SET_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_SELECT_SERVER_SET_ACK())
    }

    @Handler(op = EGS_CHARACTER_LIST_REQ)
    @JvmStatic
    fun EGS_CHARACTER_LIST_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_SECOND_SECURITY_INFO_NOT())
//        c.write(Unknown.EGS_UNK_1206_NOT())
//        c.write(Unknown.EGS_UNK_1918_NOT())
        c.write(Login.EGS_CHARACTER_LIST_ACK())
//        c.write(Unknown.EGS_UNK_2393_NOT())
//        c.write(Unknown.EGS_UNK_2727_NOT())
    }

    @Handler(op = EGS_SELECT_UNIT_REQ)
    @JvmStatic
    fun EGS_SELECT_UNIT_REQ(c: NettyClient, inPacket: InPacket) {
        val m_nUnitUID = inPacket.decodeLong()
        inPacket.decodeInt() // 00 00 26 7C
        val size1 = inPacket.decodeInt()
        for (i in 1..size1) {
            inPacket.decodeInt()
        }
        val size2 = inPacket.decodeInt()
        for (i in 1..size2) {
            inPacket.decodeInt()
            inPacket.decodeLong()
            inPacket.decodeLong()
            inPacket.decodeInt()
            inPacket.decodeShort()
            val size = inPacket.decodeInt()
            for (i in 1..size) {
                inPacket.decodeLong()
            }
            inPacket.decodeInt()
            inPacket.decodeInt()
            inPacket.decodeByte()
            inPacket.decodeInt()
            inPacket.decodeBoolean()
        }
        inPacket.decodeBoolean()

        inPacket.decodeInt()
        //sub
        inPacket.decodeLong()
        inPacket.decodeString()
        inPacket.decodeString()
        inPacket.decodeInt()
        inPacket.decodeBoolean()
        //sub
        inPacket.decodeBoolean()
        //sub
        inPacket.decodeString()
        inPacket.decodeString()
        inPacket.decodeByte()
        inPacket.decodeString()
        inPacket.decodeString()
        //end
        inPacket.decodeBoolean()
        inPacket.decodeBoolean()
        inPacket.decodeString()
        inPacket.decodeString()
        inPacket.decodeString()
        inPacket.decodeInt()
        //end

/*        inPacket.decodeByte()
        inPacket.decodeString()
        inPacket.decodeBoolean()
        inPacket.decodeInt()
        inPacket.decodeInt()
        inPacket.decodeString()
        inPacket.decodeByte()
        inPacket.decodeString()
        inPacket.decodeInt()
        inPacket.decodeBoolean()

        val unk1 = inPacket.decodeInt() // 00 15 34 CB
        val unk2 = inPacket.decodeInt() // 40 EB 00 00
        val unk3 = inPacket.decodeInt() // 78 D5 32 DD

        inPacket.decodeInt()

        inPacket.decodeInt()
        inPacket.decodeBoolean()
        inPacket.decodeInt() // 道具size
        inPacket.decodeInt()
        inPacket.decodeLong()
        inPacket.decodeInt() // FF FF FF FF
        inPacket.decodeInt()
        inPacket.decodeInt()

        inPacket.decodeInt()
        inPacket.decodeInt()
        inPacket.decodeInt()

        inPacket.decodeInt()
        inPacket.decodeInt()
        inPacket.decodeInt()
        inPacket.decodeBoolean()

        inPacket.decodeString()
        inPacket.decodeString()
        inPacket.decodeInt()*/

        c.write(Unknown.EGS_UNK_1552_NOT())
        c.write(Unknown.EGS_UNK_2393_NOT())
        c.write(Unknown.EGS_UNK_2727_NOT())
        c.write(Unknown.EGS_UNK_2855_NOT())
        c.write(Unknown.EGS_UNK_1371_NOT())
        c.write(Unknown.EGS_NEW_QUEST_ACK(156))
        c.write(Unknown.EGS_NEW_QUEST_ACK(157))
        c.write(Unknown.EGS_NEW_QUEST_ACK(156))
        c.write(Unknown.EGS_NEW_QUEST_ACK(157))
        c.write(Unknown.EGS_NEW_QUEST_ACK(157))
        c.write(Unknown.EGS_NEW_QUEST_ACK(157))
        c.write(Unknown.EGS_NEW_QUEST_ACK(157))
        c.write(Unknown.EGS_NEW_QUEST_ACK(156))
        c.write(Unknown.EGS_NEW_QUEST_ACK(156))
        c.write(Unknown.EGS_NEW_QUEST_ACK(156))
        c.write(Unknown.EGS_NEW_QUEST_ACK(156))
        c.write(Unknown.EGS_NEW_QUEST_ACK(156))
        c.write(Unknown.EGS_UNK_1992_NOT())
        c.write(Unknown.EGS_UNK_1994_NOT())
        c.write(Unknown.EGS_UNK_792_NOT())
        c.write(Unknown.EGS_UNK_1431_NOT())
        c.write(Unknown.EGS_UNK_1884_NOT())
        c.write(Unknown.EGS_UNK_2882_NOT())
        c.write(Unknown.EGS_UNK_1687_NOT())
        c.write(Unknown.EGS_UNK_2064_NOT())
        c.write(Unknown.EGS_UNK_2854_NOT())

        c.write(Login.EGS_SELECT_UNIT_1_NOT())
        c.write(Login.EGS_SELECT_UNIT_2_NOT())
        c.write(Login.EGS_SELECT_UNIT_3_NOT())
        c.write(Login.EGS_SELECT_UNIT_4_NOT())
        c.write(Login.EGS_SELECT_UNIT_5_NOT())//
        c.write(Login.EGS_SELECT_UNIT_6_NOT())
        c.write(Login.EGS_SELECT_UNIT_7_NOT())
        c.write(Login.EGS_SELECT_UNIT_8_NOT())

        c.write(Unknown.EGS_UNK_2873_NOT())

/*        for (i in 0..40) {
            c.write(Unknown.EGS_TEST(230 + i))
        }*/

        c.write(OutPacket(NET_OK, EGS_SELECT_UNIT_ACK))

        c.write(Unknown.EGS_UNK_1625_NOT())
    }

    @Handler(op = EGS_GET_PET_LIST_REQ)
    @JvmStatic
    fun EGS_GET_PET_LIST_REQ(c: NettyClient, inPacket: InPacket) {
        /*        val o = OutPacket()
                o.encodeArr("00 00 00 00 00 00 00 01 00 00 00 01 00 00 00 01 01 63 45 78 5D A0 8D 77 00 00 00 54 00 00 00 08 F5 5B 69 72 2C 6E 66 8A 00 11 DD 00 00 43 31 00 00 00 04 00 00 00 00 00 00 00 00 00 01 00 00 00 00 00 02 00 00 00 00 00 03 00 00 00 00 00 00 5D 4D CF D0 00 0A 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 00 00 96 77 62 80 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00")
                o.end(EGS_GET_PET_LIST_ACK)
                c.write(o)*/
    }

    @Handler(op = EGS_UNK_4_REQ)
    @JvmStatic
    fun EGS_UNK_4_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Unknown.EGS_UNK_4_ACK())
    }

    @Handler(op = EGS_UNK_5_REQ)
    @JvmStatic
    fun EGS_UNK_5_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Unknown.EGS_UNK_5_ACK())
    }

    @Handler(op = EGS_UNK_6_REQ)
    @JvmStatic
    fun EGS_UNK_6_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Unknown.EGS_UNK_6_ACK())
    }

    @Handler(op = EGS_UNK_7_REQ)
    @JvmStatic
    fun EGS_UNK_7_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(OutPacket(NET_OK, EGS_UNK_7_ACK))
    }

    @Handler(op = EGS_GATHER_GIVE_UP_QUEST_REQ)
    @JvmStatic
    fun EGS_GATHER_GIVE_UP_QUEST_REQ(c: NettyClient, inPacket: InPacket) {
//        c.write(Login.EGS_GIVE_UP_QUEST_ACK())
    }

    @Handler(op = EGS_CREATE_PERSONAL_SHOP_REQ)
    @JvmStatic
    fun EGS_CREATE_PERSONAL_SHOP_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_CREATE_PERSONAL_SHOP_ACK())
    }

    @Handler(op = EGS_GET_MY_INVENTORY_REQ)
    @JvmStatic
    fun EGS_GET_MY_INVENTORY_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Login.EGS_GET_MY_INVENTORY_ACK())
    }

    @Handler(op = EGS_GET_MY_INVENTORY_SPLIT_REQ)
    @JvmStatic
    fun EGS_GET_MY_INVENTORY_SPLIT_REQ(c: NettyClient, inPacket: InPacket) {
        var a = inPacket.decodeInt()
        var b = inPacket.decodeInt()
        if (a == 0 && b == 0) {
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(1, 28))
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(2, 14))
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(3, 40))
            c.write(Login.EGS_GET_MY_INVENTORY_SPLIT_ACK(3, 11))
        } else if (a == 3 && b == 11) {
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(4, 18))
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(5, 4))
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(6, 36))
            c.write(Login.EGS_GET_MY_INVENTORY_SPLIT_ACK(6, 11))
        } else if (a == 6 && b == 11) {
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(7, 1))
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(21, 6))
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(22, 2))
            c.write(Login.EGS_GET_MY_INVENTORY_SPLIT_ACK(9, 11))
        } else if (a == 9 && b == 11) {
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(23, 1))
            c.write(Login.EGS_SELECT_UNIT_INVENTORY_INFO_NOT(25, 5))
            c.write(Login.EGS_GET_MY_INVENTORY_SPLIT_ACK(11, 11))
        }
    }

    @Handler(op = EGS_STATE_CHANGE_FIELD_REQ)
    @JvmStatic
    fun EGS_STATE_CHANGE_FIELD_REQ(c: NettyClient, inPacket: InPacket) {
        var mapid = inPacket.decodeInt()
        inPacket.decodeByte() // 00
        c.write(Login.EGS_STATE_CHANGE_FIELD_UNK())
        c.write(Login.EGS_STATE_CHANGE_FIELD_ACK())
    }

    @Handler(op = EGS_FIELD_LOADING_COMPLETE_REQ)
    @JvmStatic
    fun EGS_FIELD_LOADING_COMPLETE_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(Unknown.EGS_UNK_1676_NOT())
        c.write(OutPacket(NET_OK, EGS_FIELD_LOADING_COMPLETE_ACK))
    }

    @Handler(op = EGS_OPTION_UPDATE_REQ)
    @JvmStatic
    fun EGS_OPTION_UPDATE_REQ(c: NettyClient, inPacket: InPacket) {
        c.write(OutPacket(NET_OK, EGS_OPTION_UPDATE_ACK))
    }

    @Handler(op = ETR_REG_UID)
    @JvmStatic
    fun ETR_REG_UID(c: NettyClient, inPacket: InPacket) {
/*        val unituid = inPacket.decodeLong()
        val o = OutPacket().apply {
            encodeInt(1) // size
            encodeLong(unituid) // 角色ID
            encodeLong(0)
            encodeByte(0)
            end(ETR_REG_UID_NOT)
        }
        c.write(o)*/
    }

    @Handler(op = EGS_CHAT_REQ)
    @JvmStatic
    fun EGS_CHAT_REQ(c: NettyClient, inPacket: InPacket) {
        // 00
        // 00
        // FF FF FF FF FF FF FF FF
        // 00 00 00 00 對方名字
        // 00 00 00 04 2F 00 12 60 訊息
        // 00 00 00 00 FF FF FF FF FF FF FF FF FF FF FF FF 01 00 00 09 D0 00 00 00 00 00 00 00 00 00 00 00 00
        val channel = inPacket.decodeByte(); // 0 = 全體 1 = 隊伍 5 = 好友
        inPacket.decodeByte(); // 0 = 一般 2 = 好友
        val targetcharid = inPacket.decodeLong()
        val targetcharname = inPacket.decodeString()
        val message = inPacket.decodeString()
        inPacket.decodeString()
        inPacket.decodeArr(12) // FF FF FF FF FF FF FF FF FF FF FF FF
        inPacket.decodeByte() // 01
        val unk = inPacket.decodeInt() // 00 00 09 D3
        // 00 00 00 00 00 00 00 00 00 00 00 00
        c.write(Login.EGS_CHAT_NOT(message, unk))
        c.write(Login.EGS_CHAT_ACK())
    }
}