/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class ConfirmTransaction extends Packet {

	public static final int ID = (int)17;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public short action;
	public boolean accepted;

	public ConfirmTransaction() {}

	public ConfirmTransaction(byte window, short action, boolean accepted) {
		this.window = window;
		this.action = action;
		this.accepted = accepted;
	}

	@Override
	public int length() {
		return 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(action);
		this.writeBool(accepted);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		action=readBigEndianShort();
		accepted=this.readBool();
	}

	public static ConfirmTransaction fromBuffer(byte[] buffer) {
		ConfirmTransaction ret = new ConfirmTransaction();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ConfirmTransaction(window: " + this.window + ", action: " + this.action + ", accepted: " + this.accepted + ")";
	}

}
