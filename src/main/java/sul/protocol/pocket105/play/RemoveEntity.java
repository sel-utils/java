/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import sul.utils.*;

/**
 * Despawns an entity or a player.
 */
public class RemoveEntity extends Packet {

	public static final byte ID = (byte)15;

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
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
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