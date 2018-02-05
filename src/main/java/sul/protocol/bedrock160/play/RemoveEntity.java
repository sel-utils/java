/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import sul.utils.*;

public class RemoveEntity extends Packet {

	public static final int ID = (int)14;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;

	public RemoveEntity() {}

	public RemoveEntity(long entityId) {
		this.entityId = entityId;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
	}

	public static RemoveEntity fromBuffer(byte[] buffer) {
		RemoveEntity ret = new RemoveEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "RemoveEntity(entityId: " + this.entityId + ")";
	}

}