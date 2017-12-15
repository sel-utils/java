/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.play;

import sul.utils.*;

public class MobEffect extends Packet {

	public static final int ID = (int)28;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// event id
	public static final byte ADD = (byte)1;
	public static final byte MODIFY = (byte)2;
	public static final byte REMOVE = (byte)3;

	public long entityId;
	public byte eventId;
	public int effect;
	public int amplifier;
	public boolean particles;
	public int duration;

	public MobEffect() {}

	public MobEffect(long entityId, byte eventId, int effect, int amplifier, boolean particles, int duration) {
		this.entityId = entityId;
		this.eventId = eventId;
		this.effect = effect;
		this.amplifier = amplifier;
		this.particles = particles;
		this.duration = duration;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varintLength(effect) + Buffer.varintLength(amplifier) + Buffer.varintLength(duration) + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianByte(eventId);
		this.writeVarint(effect);
		this.writeVarint(amplifier);
		this.writeBool(particles);
		this.writeVarint(duration);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		eventId=readLittleEndianByte();
		effect=this.readVarint();
		amplifier=this.readVarint();
		particles=this.readBool();
		duration=this.readVarint();
	}

	public static MobEffect fromBuffer(byte[] buffer) {
		MobEffect ret = new MobEffect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MobEffect(entityId: " + this.entityId + ", eventId: " + this.eventId + ", effect: " + this.effect + ", amplifier: " + this.amplifier + ", particles: " + this.particles + ", duration: " + this.duration + ")";
	}

}