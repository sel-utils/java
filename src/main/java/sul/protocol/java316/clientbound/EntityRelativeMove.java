/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java316.xml
 */
package sul.protocol.java316.clientbound;

import sul.utils.*;

public class EntityRelativeMove extends Packet {

	public static final int ID = (int)37;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public Tuples.ShortXYZ delta = new Tuples.ShortXYZ();
	public boolean onGround;

	public EntityRelativeMove() {}

	public EntityRelativeMove(int entityId, Tuples.ShortXYZ delta, boolean onGround) {
		this.entityId = entityId;
		this.delta = delta;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianShort(delta.x); this.writeBigEndianShort(delta.y); this.writeBigEndianShort(delta.z);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		delta=new Tuples.ShortXYZ(); delta.x=readBigEndianShort(); delta.y=readBigEndianShort(); delta.z=readBigEndianShort();
		onGround=this.readBool();
	}

	public static EntityRelativeMove fromBuffer(byte[] buffer) {
		EntityRelativeMove ret = new EntityRelativeMove();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityRelativeMove(entityId: " + this.entityId + ", delta: " + this.delta.toString() + ", onGround: " + this.onGround + ")";
	}

}