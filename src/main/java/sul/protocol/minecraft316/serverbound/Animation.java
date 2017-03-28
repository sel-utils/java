/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import sul.utils.*;

public class Animation extends Packet {

	public static final int ID = (int)26;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// hand
	public static final int MAIN_HAND = 0;
	public static final int OFF_HAND = 1;

	public int hand;

	public Animation() {}

	public Animation(int hand) {
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

	public static Animation fromBuffer(byte[] buffer) {
		Animation ret = new Animation();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Animation(hand: " + this.hand + ")";
	}

}
