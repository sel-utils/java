/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.play;

import sul.utils.*;

public class MoveEntity extends Packet {

	public static final byte ID = (byte)18;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public byte pitch;
	public byte headYaw;
	public byte yaw;
	public boolean onGround;
	public boolean teleported;

	public MoveEntity() {}

	public MoveEntity(long entityId, Tuples.FloatXYZ position, byte pitch, byte headYaw, byte yaw, boolean onGround, boolean teleported) {
		this.entityId = entityId;
		this.position = position;
		this.pitch = pitch;
		this.headYaw = headYaw;
		this.yaw = yaw;
		this.onGround = onGround;
		this.teleported = teleported;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + 18;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeBigEndianByte(pitch);
		this.writeBigEndianByte(headYaw);
		this.writeBigEndianByte(yaw);
		this.writeBool(onGround);
		this.writeBool(teleported);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		pitch=readBigEndianByte();
		headYaw=readBigEndianByte();
		yaw=readBigEndianByte();
		onGround=this.readBool();
		teleported=this.readBool();
	}

	public static MoveEntity fromBuffer(byte[] buffer) {
		MoveEntity ret = new MoveEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MoveEntity(entityId: " + this.entityId + ", position: " + this.position.toString() + ", pitch: " + this.pitch + ", headYaw: " + this.headYaw + ", yaw: " + this.yaw + ", onGround: " + this.onGround + ", teleported: " + this.teleported + ")";
	}

}