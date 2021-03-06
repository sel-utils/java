/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package sul.protocol.bedrock137.play;

import sul.utils.*;

public class AddHangingEntity extends Packet {

	public static final int ID = (int)16;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public long runtimeId;
	public sul.protocol.bedrock137.types.BlockPosition position;
	public int unknown3;

	public AddHangingEntity() {}

	public AddHangingEntity(long entityId, long runtimeId, sul.protocol.bedrock137.types.BlockPosition position, int unknown3) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.position = position;
		this.unknown3 = unknown3;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varulongLength(runtimeId) + position.length() + Buffer.varintLength(unknown3) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeVarulong(runtimeId);
		this.writeBytes(position.encode());
		this.writeVarint(unknown3);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		runtimeId=this.readVarulong();
		position=new sul.protocol.bedrock137.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		unknown3=this.readVarint();
	}

	public static AddHangingEntity fromBuffer(byte[] buffer) {
		AddHangingEntity ret = new AddHangingEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddHangingEntity(entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", position: " + this.position.toString() + ", unknown3: " + this.unknown3 + ")";
	}

}