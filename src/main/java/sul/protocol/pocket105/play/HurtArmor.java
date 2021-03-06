/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import sul.utils.*;

public class HurtArmor extends Packet {

	public static final byte ID = (byte)39;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int unknown0;

	public HurtArmor() {}

	public HurtArmor(int unknown0) {
		this.unknown0 = unknown0;
	}

	@Override
	public int length() {
		return Buffer.varintLength(unknown0) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(unknown0);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		unknown0=this.readVarint();
	}

	public static HurtArmor fromBuffer(byte[] buffer) {
		HurtArmor ret = new HurtArmor();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "HurtArmor(unknown0: " + this.unknown0 + ")";
	}

}