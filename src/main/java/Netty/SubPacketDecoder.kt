/*
 This file is part of the OdinMS Maple Story Server
 Copyright (C) 2008 ~ 2010 Patrick Huy <patrick.huy@frz.cc> 
 Matthias Butz <matze@odinms.de>
 Jan Christian Meyer <vimes@odinms.de>

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License version 3
 as published by the Free Software Foundation. You may not use, modify
 or distribute this program under any other version of the
 GNU Affero General Public License.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Netty

import EventID
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import java.util.*

class SubPacketDecoder : ByteToMessageDecoder() {
    override fun decode(chc: ChannelHandlerContext, buffer: ByteBuf, out: MutableList<Any>) {
        val c = chc.channel().attr(NettyClient.CLIENT_KEY).get() ?: return

        if (c.nDecodeLen == -1) {
            if (buffer.readableBytes() < 4) {
                return
            }

            var L = buffer.readIntLE()
            val packetnum = buffer.readIntLE() // packetnum

            c.nDecodeLen = L - 8
//            println("sub接收整體長度: " + c.nDecodeLen + " | packetNum: $packetnum")
        }

        if (buffer.readableBytes() >= c.nDecodeLen) {
            var dec = ByteArray(c.nDecodeLen)
            buffer.readBytes(dec)
//            println(Util.readableByteArray(dec))
            val inPacket = InPacket(dec)
            inPacket.decodeInt() // 00 00 00 00 如果 a = 1 的話是 00 00 01 01
            inPacket.SerializeHelperSize = inPacket.decodeInt()
            for (i in 0 until inPacket.SerializeHelperSize) {
                inPacket.decodeLong()
            }
            inPacket.decodeLong() // -1
            inPacket.decodeLong() // -1
            val op = inPacket.decodeShort().toInt()
            val length = inPacket.decodeInt()
            inPacket.header = op
            inPacket.length = length
            if (length > 0) inPacket.compress = inPacket.decodeBoolean()
//            EventID.reload()
            val ID = EventID.getEventIDByOp(op)
            if (!EventID.isSpam(ID)) println(
                String.format(
                    "[Sub In]\t| %s, %d/0x%s\t| %s",
                    if (ID == null) "未知" else ID,
                    op,
                    Integer.toHexString(op).uppercase(Locale.getDefault()),
                    inPacket
                )
            )
            c.nDecodeLen = -1;
            out.add(inPacket)
        }
    }
}