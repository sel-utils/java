/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock150.xml
 */
package sul.protocol.bedrock150.play;

import sul.utils.*;

public class EntityPickRequest extends Packet {

	public static final int ID = (int)35;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long entityType;
	public byte slot;

	public EntityPickRequest() {}

	public EntityPickRequest(long entityType, byte slot) {
		this.entityType = entityType;
		this.slot = slot;
	}

	@Override
	public int length() {
		return 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeLittleEndianLong(entityType);
		this.writeLittleEndianByte(slot);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityType=readLittleEndianLong();
		slot=readLittleEndianByte();
	}

	public static EntityPickRequest fromBuffer(byte[] buffer) {
		EntityPickRequest ret = new EntityPickRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityPickRequest(entityType: " + this.entityType + ", slot: " + this.slot + ")";
	}

}