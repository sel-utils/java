/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft335.xml
 */
package sul.protocol.minecraft335.clientbound;

import sul.utils.*;

public class EntityLookAndRelativeMove extends Packet {

	public static final int ID = (int)39;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public Tuples.ShortXYZ delta = new Tuples.ShortXYZ();
	public byte yaw;
	public byte pitch;
	public boolean onGround;

	public EntityLookAndRelativeMove() {}

	public EntityLookAndRelativeMove(int entityId, Tuples.ShortXYZ delta, byte yaw, byte pitch, boolean onGround) {
		this.entityId = entityId;
		this.delta = delta;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianShort(delta.x); this.writeBigEndianShort(delta.y); this.writeBigEndianShort(delta.z);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianByte(pitch);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		delta=new Tuples.ShortXYZ(); delta.x=readBigEndianShort(); delta.y=readBigEndianShort(); delta.z=readBigEndianShort();
		yaw=readBigEndianByte();
		pitch=readBigEndianByte();
		onGround=this.readBool();
	}

	public static EntityLookAndRelativeMove fromBuffer(byte[] buffer) {
		EntityLookAndRelativeMove ret = new EntityLookAndRelativeMove();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityLookAndRelativeMove(entityId: " + this.entityId + ", delta: " + this.delta.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", onGround: " + this.onGround + ")";
	}

}