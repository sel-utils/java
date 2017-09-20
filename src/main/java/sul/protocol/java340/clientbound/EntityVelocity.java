/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java340.xml
 */
package sul.protocol.java340.clientbound;

import sul.utils.*;

public class EntityVelocity extends Packet {

	public static final int ID = (int)62;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public Tuples.ShortXYZ velocity = new Tuples.ShortXYZ();

	public EntityVelocity() {}

	public EntityVelocity(int entityId, Tuples.ShortXYZ velocity) {
		this.entityId = entityId;
		this.velocity = velocity;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 7;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianShort(velocity.x); this.writeBigEndianShort(velocity.y); this.writeBigEndianShort(velocity.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		velocity=new Tuples.ShortXYZ(); velocity.x=readBigEndianShort(); velocity.y=readBigEndianShort(); velocity.z=readBigEndianShort();
	}

	public static EntityVelocity fromBuffer(byte[] buffer) {
		EntityVelocity ret = new EntityVelocity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityVelocity(entityId: " + this.entityId + ", velocity: " + this.velocity.toString() + ")";
	}

}