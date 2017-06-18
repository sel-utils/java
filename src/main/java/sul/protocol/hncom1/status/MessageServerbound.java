/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.status;

import java.util.Arrays;

import sul.utils.*;

/**
 * Sends a binary message to some selected nodes or broadcast it.
 */
public class MessageServerbound extends Packet {

	public static final byte ID = (byte)7;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Addressees of the message. If the array is empty the message is broadcasted to every
	 * connected node.
	 */
	public int[] addressees = new int[0];

	/**
	 * Bytes to be sent/broadcasted. It may be a serialised packet of a plugin-defined
	 * protocol.
	 */
	public byte[] payload = new byte[0];

	public MessageServerbound() {}

	public MessageServerbound(int[] addressees, byte[] payload) {
		this.addressees = addressees;
		this.payload = payload;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(addressees.length) + Buffer.varuintLength(payload.length) + payload.length + 1; for(int yrcvcvc:addressees){ length+=Buffer.varuintLength(yrcvcvc); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint((int)addressees.length); for(int yrcvcvc:addressees){ this.writeVaruint(yrcvcvc); }
		this.writeVaruint((int)payload.length); this.writeBytes(payload);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bfzjcnzm=this.readVaruint(); addressees=new int[bfzjcnzm]; for(int yrcvcvc=0;yrcvcvc<addressees.length;yrcvcvc++){ addressees[yrcvcvc]=this.readVaruint(); }
		int bbexyq=this.readVaruint(); payload=this.readBytes(bbexyq);
	}

	public static MessageServerbound fromBuffer(byte[] buffer) {
		MessageServerbound ret = new MessageServerbound();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MessageServerbound(addressees: " + Arrays.toString(this.addressees) + ", payload: " + Arrays.toString(this.payload) + ")";
	}

}