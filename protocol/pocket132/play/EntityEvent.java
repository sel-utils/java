/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket132.xml
 */
package sul.protocol.pocket132.play;

import sul.utils.*;

public class EntityEvent extends Packet {

	public static final int ID = (int)27;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// event id
	public static final byte HURT_ANIMATION = (byte)2;
	public static final byte DEATH_ANIMATION = (byte)3;
	public static final byte TAME_FAIL = (byte)6;
	public static final byte TAME_SUCCESS = (byte)7;
	public static final byte SHAKE_WET = (byte)8;
	public static final byte USE_ITEM = (byte)9;
	public static final byte EAT_GRASS_ANIMATION = (byte)10;
	public static final byte FISH_HOOK_BUBBLES = (byte)11;
	public static final byte FISH_HOOK_POSITION = (byte)12;
	public static final byte FISH_HOOK_HOOK = (byte)13;
	public static final byte FISH_HOOK_TEASE = (byte)14;
	public static final byte SQUID_INK_CLOUD = (byte)15;
	public static final byte AMBIENT_SOUND = (byte)16;
	public static final byte RESPAWN = (byte)17;
	public static final byte UNLEASH = (byte)63;

	public long entityId;
	public byte eventId;
	public int unknown2;

	public EntityEvent() {}

	public EntityEvent(long entityId, byte eventId, int unknown2) {
		this.entityId = entityId;
		this.eventId = eventId;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varintLength(unknown2) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianByte(eventId);
		this.writeVarint(unknown2);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		eventId=readLittleEndianByte();
		unknown2=this.readVarint();
	}

	public static EntityEvent fromBuffer(byte[] buffer) {
		EntityEvent ret = new EntityEvent();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityEvent(entityId: " + this.entityId + ", eventId: " + this.eventId + ", unknown2: " + this.unknown2 + ")";
	}

}