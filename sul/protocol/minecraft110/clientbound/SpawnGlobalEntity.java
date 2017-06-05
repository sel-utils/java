/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import sul.utils.*;

public class SpawnGlobalEntity extends Packet {

	public static final int ID = (int)2;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// type
	public static final byte THUNDERBOLT = 1;

	public int entityId;
	public byte type;
	public Tuples.DoubleXYZ position = new Tuples.DoubleXYZ();

	public SpawnGlobalEntity() {}

	public SpawnGlobalEntity(int entityId, byte type, Tuples.DoubleXYZ position) {
		this.entityId = entityId;
		this.type = type;
		this.position = position;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 26;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(type);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		type=readBigEndianByte();
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
	}

	public static SpawnGlobalEntity fromBuffer(byte[] buffer) {
		SpawnGlobalEntity ret = new SpawnGlobalEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SpawnGlobalEntity(entityId: " + this.entityId + ", type: " + this.type + ", position: " + this.position.toString() + ")";
	}

}