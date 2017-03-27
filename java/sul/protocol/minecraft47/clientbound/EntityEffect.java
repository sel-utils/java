/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import sul.utils.*;

public class EntityEffect extends Packet {

	public static final int ID = (int)29;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public byte effectId;
	public byte amplifier;
	public int duration;
	public boolean hideParticles;

	public EntityEffect() {}

	public EntityEffect(int entityId, byte effectId, byte amplifier, int duration, boolean hideParticles) {
		this.entityId = entityId;
		this.effectId = effectId;
		this.amplifier = amplifier;
		this.duration = duration;
		this.hideParticles = hideParticles;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + Buffer.varuintLength(duration) + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(effectId);
		this.writeBigEndianByte(amplifier);
		this.writeVaruint(duration);
		this.writeBool(hideParticles);
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
		hideParticles=this.readBool();
	}

	public static EntityEffect fromBuffer(byte[] buffer) {
		EntityEffect ret = new EntityEffect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityEffect(entityId: " + this.entityId + ", effectId: " + this.effectId + ", amplifier: " + this.amplifier + ", duration: " + this.duration + ", hideParticles: " + this.hideParticles + ")";
	}

}
