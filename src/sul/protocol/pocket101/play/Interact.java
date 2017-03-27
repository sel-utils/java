/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

public class Interact extends Packet {

	public static final byte ID = (byte)34;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte ATTACK = 1;
	public static final byte INTERACT = 2;
	public static final byte LEAVE_VEHICLE = 3;
	public static final byte HOVER = 4;

	public byte action;
	public long target;

	public Interact() {}

	public Interact(byte action, long target) {
		this.action = action;
		this.target = target;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(target) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(action);
		this.writeVarlong(target);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=readBigEndianByte();
		target=this.readVarlong();
	}

	public static Interact fromBuffer(byte[] buffer) {
		Interact ret = new Interact();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Interact(action: " + this.action + ", target: " + this.target + ")";
	}

}
