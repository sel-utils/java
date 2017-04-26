/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.util.UUID;

import sul.utils.*;

public class SpawnObject extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public UUID uuid;
	public byte type;
	public Tuples.DoubleXYZ position = new Tuples.DoubleXYZ();
	public byte pitch;
	public byte yaw;
	public int data;
	public Tuples.ShortXYZ velocity = new Tuples.ShortXYZ();

	public SpawnObject() {}

	public SpawnObject(int entityId, UUID uuid, byte type, Tuples.DoubleXYZ position, byte pitch, byte yaw, int data, Tuples.ShortXYZ velocity) {
		this.entityId = entityId;
		this.uuid = uuid;
		this.type = type;
		this.position = position;
		this.pitch = pitch;
		this.yaw = yaw;
		this.data = data;
		this.velocity = velocity;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 54;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeBigEndianByte(type);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianByte(pitch);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianInt(data);
		this.writeBigEndianShort(velocity.x); this.writeBigEndianShort(velocity.y); this.writeBigEndianShort(velocity.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		type=readBigEndianByte();
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		pitch=readBigEndianByte();
		yaw=readBigEndianByte();
		data=readBigEndianInt();
		velocity=new Tuples.ShortXYZ(); velocity.x=readBigEndianShort(); velocity.y=readBigEndianShort(); velocity.z=readBigEndianShort();
	}

	public static SpawnObject fromBuffer(byte[] buffer) {
		SpawnObject ret = new SpawnObject();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SpawnObject(entityId: " + this.entityId + ", uuid: " + this.uuid.toString() + ", type: " + this.type + ", position: " + this.position.toString() + ", pitch: " + this.pitch + ", yaw: " + this.yaw + ", data: " + this.data + ", velocity: " + this.velocity.toString() + ")";
	}

}