/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import sul.utils.*;

public class HeldItemChange extends Packet {

	public static final int ID = (int)9;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public short slot;

	public HeldItemChange() {}

	public HeldItemChange(short slot) {
		this.slot = slot;
	}

	@Override
	public int length() {
		return 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianShort(slot);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		slot=readBigEndianShort();
	}

	public static HeldItemChange fromBuffer(byte[] buffer) {
		HeldItemChange ret = new HeldItemChange();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "HeldItemChange(slot: " + this.slot + ")";
	}

}
