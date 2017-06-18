/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.status;

import java.util.Arrays;

import sul.utils.*;

/**
 * Receives a binary message sent by another node using MessageServerbound.
 */
public class MessageClientbound extends Packet {

	public static final byte ID = (byte)10;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Id of the node that has sent the message.
	 */
	public int sender;

	/**
	 * Bytes received. It could be a serialised packet of a plugin-defined packet.
	 */
	public byte[] payload = new byte[0];

	public MessageClientbound() {}

	public MessageClientbound(int sender, byte[] payload) {
		this.sender = sender;
		this.payload = payload;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(sender) + Buffer.varuintLength(payload.length) + payload.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(sender);
		this.writeVaruint((int)payload.length); this.writeBytes(payload);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		sender=this.readVaruint();
		int bbexyq=this.readVaruint(); payload=this.readBytes(bbexyq);
	}

	public static MessageClientbound fromBuffer(byte[] buffer) {
		MessageClientbound ret = new MessageClientbound();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MessageClientbound(sender: " + this.sender + ", payload: " + Arrays.toString(this.payload) + ")";
	}

}