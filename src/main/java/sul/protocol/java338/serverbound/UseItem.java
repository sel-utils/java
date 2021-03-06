/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java338.xml
 */
package sul.protocol.java338.serverbound;

import sul.utils.*;

public class UseItem extends Packet {

	public static final int ID = (int)32;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// hand
	public static final int MAIN_HAND = (int)0;
	public static final int OFF_HAND = (int)1;

	public int hand;

	public UseItem() {}

	public UseItem(int hand) {
		this.hand = hand;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hand) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(hand);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		hand=this.readVaruint();
	}

	public static UseItem fromBuffer(byte[] buffer) {
		UseItem ret = new UseItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UseItem(hand: " + this.hand + ")";
	}

}