/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket130.xml
 */
package sul.protocol.pocket130.play;

import sul.utils.*;

public class MovePlayer extends Packet {

	public static final byte ID = (byte)19;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// animation
	public static final byte FULL = 0;
	public static final byte NONE = 1;
	public static final byte TELEPORT = 2;
	public static final byte PITCH = 3;

	public long entityId;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public float pitch;
	public float headYaw;
	public float yaw;
	public byte animation;
	public boolean onGround;
	public long unknown7;
	public int unknown8;
	public int unknown9;

	public MovePlayer() {}

	public MovePlayer(long entityId, Tuples.FloatXYZ position, float pitch, float headYaw, float yaw, byte animation, boolean onGround, long unknown7, int unknown8, int unknown9) {
		this.entityId = entityId;
		this.position = position;
		this.pitch = pitch;
		this.headYaw = headYaw;
		this.yaw = yaw;
		this.animation = animation;
		this.onGround = onGround;
		this.unknown7 = unknown7;
		this.unknown8 = unknown8;
		this.unknown9 = unknown9;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varlongLength(unknown7) + 35;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(pitch);
		this.writeLittleEndianFloat(headYaw);
		this.writeLittleEndianFloat(yaw);
		this.writeBigEndianByte(animation);
		this.writeBool(onGround);
		this.writeVarlong(unknown7);
		if(animation==3){ this.writeLittleEndianInt(unknown8); }
		if(animation==3){ this.writeLittleEndianInt(unknown9); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
		headYaw=readLittleEndianFloat();
		yaw=readLittleEndianFloat();
		animation=readBigEndianByte();
		onGround=this.readBool();
		unknown7=this.readVarlong();
		if(animation==3){ unknown8=readLittleEndianInt(); }
		if(animation==3){ unknown9=readLittleEndianInt(); }
	}

	public static MovePlayer fromBuffer(byte[] buffer) {
		MovePlayer ret = new MovePlayer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MovePlayer(entityId: " + this.entityId + ", position: " + this.position.toString() + ", pitch: " + this.pitch + ", headYaw: " + this.headYaw + ", yaw: " + this.yaw + ", animation: " + this.animation + ", onGround: " + this.onGround + ", unknown7: " + this.unknown7 + ", unknown8: " + this.unknown8 + ", unknown9: " + this.unknown9 + ")";
	}

}