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

class PacketDecoder : ByteToMessageDecoder() {
    override fun decode(chc: ChannelHandlerContext, buffer: ByteBuf, out: MutableList<Any>) {
        val c = chc.channel().attr(NettyClient.CLIENT_KEY).get() ?: return

        var L = buffer.readUnsignedIntLE().toInt()
//        println("接收整體長度: $L")
        if (buffer.readableBytes() < 40/* || L != buffer.readableBytes() + 4*/) {
            buffer.resetReaderIndex()
            return
        }
        buffer.readIntLE() // packetnum

        buffer.skipBytes(2) // prefix (頻道副端口TcpRelay(9301) 只到這邊 然後不用加解密)
        buffer.readIntLE() // packetnum
        val iv = ByteArray(8)
        buffer.readBytes(iv)

        val dec = ByteArray(L - 32)
        buffer.readBytes(dec)

        buffer.skipBytes(HMAC_SIZE) // 10

        val inPacket = InPacket(DESCrypt.decrypt(c.packetKey, iv, dec))
        inPacket.decodeInt() // 00 00 00 00 如果 a = 1 的話是 00 00 01 01
        inPacket.a = inPacket.decodeInt() != 0
        if (inPacket.a) inPacket.decodeLong()
        inPacket.decodeLong() // -1
        inPacket.decodeLong() // -1
        val op = inPacket.decodeShort().toInt()
        val length = inPacket.decodeInt()
        inPacket.header = op
        inPacket.length = length
        if (length > 0) inPacket.compress = inPacket.decodeBoolean()

//        EventID.reload()
        val ID = EventID.getEventIDByOp(op)
        if (!EventID.isSpam(ID)) println(String.format("[In]\t| %s, %d/0x%s\t| %s", if (ID == null) "未知" else ID, op, Integer.toHexString(op).uppercase(Locale.getDefault()), inPacket))
        out.add(inPacket)
    }
}