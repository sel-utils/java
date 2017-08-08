/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class EntityEffect extends Packet {

	public static final int ID = (int)75;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// flags
	public static final byte AMBIENT = (byte)1;
	public static final byte SHOW_PARTICLES = (byte)2;

	public int entityId;
	public byte effectId;
	public byte amplifier;
	public int duration;
	public byte flags;

	public EntityEffect() {}

	public EntityEffect(int entityId, byte effectId, byte amplifier, int duration, byte flags) {
		this.entityId = entityId;
		this.effectId = effectId;
		this.amplifier = amplifier;
		this.duration = duration;
		this.flags = flags;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + Buffer.varuintLength(duration) + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(effectId);
		this.writeBigEndianByte(amplifier);
		this.writeVaruint(duration);
		this.writeBigEndianByte(flags);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		effectId=readBigEndianByte();
		amplifier=readBigEndianByte();
		duration=this.readVaruint();
		flags=readBigEndianByte();
	}

	public static EntityEffect fromBuffer(byte[] buffer) {
		EntityEffect ret = new EntityEffect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityEffect(entityId: " + this.entityId + ", effectId: " + this.effectId + ", amplifier: " + this.amplifier + ", duration: " + this.duration + ", flags: " + this.flags + ")";
	}

}