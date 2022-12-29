package Netty.Packet

import Netty.OutPacket
import util.Util

class Helper {

    fun KUnitInfo(o: OutPacket) = with(o) {
        encodeLong(1000515070) // m_iOwnerUserUID
        encodeByte(0) // m_cAuthLevel
        encodeLong(1575190398) // m_nUnitUID
        encodeInt(1010443092) // m_uiKNMSerialNum
        encodeShort(162) // m_cUnitClass
        // 57->伊芙 58->澄 59->艾拉 60->愛姊 61->ADD 62->露希爾 63->亞殷 64->菈比 65->諾亞 4分支二轉
        // 66->艾索德 67-> 愛莎 68->蕾娜 69->雷文 4分支二轉
        // 79->艾索德 80->愛莎 81=蕾娜 82->雷玟 83->伊芙 84->澄 85->艾拉 4分支三轉
        // 86->ADD 87->愛姊 88->露希爾 89->亞殷 90->菈比 91->諾亞 4分支三轉
        // 137->菈比EW二轉 162->伊芙CU三轉
        // 180->蘿傑1分支三轉
        // 187->菈比EW三轉 188->菈比RS三轉 189->菈比泥莎三轉
        // 190->諾亞LI三轉 191->諾亞CEL三轉 192->諾亞NP三轉
        encodeInt(2) // 0->無 1->超越 2->大師轉職
        encodeString("力才") // m_wstrNickName
        encodeString("127.0.0.1") // m_wstrIP
        encodeShort(8441) // m_usPort udp port
        encodeLong(12345678) // m_iED
        encodeByte(99) // 等級
        encodeInt(390806200) // m_iEXP

        encodeInt(3) // size
        encodeInt(0)
        encodeInt(0)
        encodeInt(0)

        encodeInt(37364)
        encodeInt(0)
        encodeInt(0)
        encodeInt(0)
        encodeString("2000-01-01 00:00:00") // 戰神的祝福到期時間
        encodeInt(390806200) // EXP
        encodeInt(1011151800) // 升級所需EXP
        encodeInt(0)

        //kStat
        encodeFloat(157000F) // MAXHP
        encodeFloat(1202F)
        encodeFloat(1202F)
        encodeFloat(0F)
        encodeFloat(0F)
        encodeFloat(301F)
        encodeFloat(301F)

        //kStat
        encodeFloat(0F)
        encodeFloat(0F)
        encodeFloat(0F)
        encodeFloat(0F)
        encodeFloat(0F)
        encodeFloat(0F)
        encodeFloat(0F)

        //KLastPositionInfo
        encodeInt(20011) //mapID 20001->艾德 20010->艾利亞諾德 20011->菈比的想像空間 20012->某人的研究室 20013->瑪格梅利亞
        // 1007夜之休憩處 1009 紅焰邊界 1010 極光據點
        encodeByte(32) //m_ucLastTouchLineIndex
        encodeShort(76) //m_usLastPosValue
        encodeBoolean(false)

        //KBuffInfo
        encodeInt(0)

        //KDungeonClearInfo
        encodeInt(0)

        //KTCClearInfo
        encodeInt(0)

        //KInventoryInfo
        encodeInt(0)
        //KInventoryInfo
        encodeInt(0)

        encodeInt(0)

        encodeBoolean(false)//m_bIsParty
        encodeInt(0)//m_iSpiritMax
        encodeInt(0)//m_iSpirit
        encodeBoolean(false)//m_bIsGameBang
        encodeInt(0)//m_iPcBangType

        //KUserGuildInfo
        encodeInt(0) // m_iGuildUID
        encodeString("") // m_wstrGuildName
        encodeByte(0)
        encodeInt(0)
        encodeByte(0)
        encodeByte(0)
        encodeInt(0)
        encodeString("")
        encodeBoolean(false)
        encodeInt(0)//size
        encodeInt(0)//size
        encodeInt(0)
        encodeFloat(-575F)
        encodeFloat(1010F)
        encodeFloat(-161F)
        encodeByte(0)
        encodeByte(0)
        //end

        encodeString(Util.getCurrentTime())

        //sub開始
        encodeInt(0)
        encodeInt(0)
        encodeInt(0)
        encodeByte(0)
        encodeInt(0)
        encodeInt(0)
        encodeInt(0)
        //end

        //sub開始
        encodeByte(0)
        encodeByte(0)
        encodeInt(0)
        encodeInt(0) // size -> int int
        encodeInt(0)
        encodeInt(0)
        //end

        encodeInt(0)

        encodeInt(0)

        encodeString("")
    }
}