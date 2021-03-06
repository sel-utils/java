/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java315.xml
 */
package sul.protocol.java315.clientbound;

import sul.utils.*;

public class Animation extends Packet {

	public static final int ID = (int)6;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// animation
	public static final byte SWING_MAIN_ARM = (byte)0;
	public static final byte TAKE_DAMAGE = (byte)1;
	public static final byte LEAVE_BED = (byte)2;
	public static final byte SWING_OFFHAND = (byte)3;
	public static final byte CRITICAL_EFFECT = (byte)4;
	public static final byte MAGICAL_CRITICAL_EFFECT = (byte)5;

	public int entityId;
	public byte animation;

	public Animation() {}

	public Animation(int entityId, byte animation) {
		this.entityId = entityId;
		this.animation = animation;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(animation);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		animation=readBigEndianByte();
	}

	public static Animation fromBuffer(byte[] buffer) {
		Animation ret = new Animation();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Animation(entityId: " + this.entityId + ", animation: " + this.animation + ")";
	}

}