/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import sul.utils.*;

/**
 * Adds, removes or modifies an entity's boss bar. The percentage of the bar is calculated
 * using the entity's attributes for the health and the max health, updated with UpdateAttributes.
 */
public class BossEvent extends Packet {

	public static final byte ID = (byte)75;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// event id
	public static final int ADD = 0;
	public static final int UPDATE = 1;
	public static final int REMOVE = 2;

	public long entityId;
	public int eventId;

	public BossEvent() {}

	public BossEvent(long entityId, int eventId) {
		this.entityId = entityId;
		this.eventId = eventId;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varuintLength(eventId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVaruint(eventId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		eventId=this.readVaruint();
	}

	public static BossEvent fromBuffer(byte[] buffer) {
		BossEvent ret = new BossEvent();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "BossEvent(entityId: " + this.entityId + ", eventId: " + this.eventId + ")";
	}

}