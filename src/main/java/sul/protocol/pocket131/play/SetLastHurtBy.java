/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.play;

import sul.utils.*;

public class SetLastHurtBy extends Packet {

	public static final int ID = (int)96;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int unknown0;

	public SetLastHurtBy() {}

	public SetLastHurtBy(int unknown0) {
		this.unknown0 = unknown0;
	}

	@Override
	public int length() {
		return Buffer.varintLength(unknown0) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarint(unknown0);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		unknown0=this.readVarint();
	}

	public static SetLastHurtBy fromBuffer(byte[] buffer) {
		SetLastHurtBy ret = new SetLastHurtBy();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetLastHurtBy(unknown0: " + this.unknown0 + ")";
	}

}