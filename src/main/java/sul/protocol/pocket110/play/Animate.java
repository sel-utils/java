/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket110.xml
 */
package sul.protocol.pocket110.play;

import sul.utils.*;

public class Animate extends Packet {

	public static final byte ID = (byte)44;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final int BREAKING = 1;
	public static final int WAKE_UP = 3;

	public int action;
	public long entityId;
	public float unknown2;

	public Animate() {}

	public Animate(int action, long entityId, float unknown2) {
		this.action = action;
		this.entityId = entityId;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return Buffer.varintLength(action) + Buffer.varlongLength(entityId) + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(action);
		this.writeVarlong(entityId);
		if(action>128){ this.writeLittleEndianFloat(unknown2); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=this.readVarint();
		entityId=this.readVarlong();
		if(action>128){ unknown2=readLittleEndianFloat(); }
	}

	public static Animate fromBuffer(byte[] buffer) {
		Animate ret = new Animate();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Animate(action: " + this.action + ", entityId: " + this.entityId + ", unknown2: " + this.unknown2 + ")";
	}

}