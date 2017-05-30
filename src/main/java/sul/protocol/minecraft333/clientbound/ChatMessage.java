/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft333.xml
 */
package sul.protocol.minecraft333.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ChatMessage extends Packet {

	public static final int ID = (int)15;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// position
	public static final byte CHAT = 0;
	public static final byte SYSTEM_MESSAGE = 1;
	public static final byte ABOVE_HOTBAR = 2;

	public String message;
	public byte position;

	public ChatMessage() {}

	public ChatMessage(String message, byte position) {
		this.message = message;
		this.position = position;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
		this.writeBigEndianByte(position);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
		position=readBigEndianByte();
	}

	public static ChatMessage fromBuffer(byte[] buffer) {
		ChatMessage ret = new ChatMessage();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChatMessage(message: " + this.message + ", position: " + this.position + ")";
	}

}