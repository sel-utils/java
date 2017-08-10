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

/**
 * Updates an entity's metadata.
 */
public class SetEntityData extends Packet {

	public static final int ID = (int)39;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public sul.metadata.Pocket132 metadata;

	public SetEntityData() {}

	public SetEntityData(long entityId, sul.metadata.Pocket132 metadata) {
		this.entityId = entityId;
		this.metadata = metadata;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + metadata.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeBytes(metadata.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		metadata=new sul.metadata.Pocket132(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
	}

	public static SetEntityData fromBuffer(byte[] buffer) {
		SetEntityData ret = new SetEntityData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetEntityData(entityId: " + this.entityId + ", metadata: " + this.metadata.toString() + ")";
	}

}