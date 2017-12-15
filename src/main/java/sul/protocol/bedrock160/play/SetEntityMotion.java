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

/**
 * Updates an entity's motion.
 */
public class SetEntityMotion extends Packet {

	public static final int ID = (int)40;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Entity which motion is updated. If the entity id is the player's, its motion is
	 * updated client-side and the player will send movement packets to the server (meaning
	 * that the server has no physical calculations to do). If not an animation will be
	 * done client-side but the server will have to calculate the new position applying
	 * the item's movement rules.
	 */
	public long entityId;

	/**
	 * New motion for the entity that will influence its movement.
	 */
	public Tuples.FloatXYZ motion = new Tuples.FloatXYZ();

	public SetEntityMotion() {}

	public SetEntityMotion(long entityId, Tuples.FloatXYZ motion) {
		this.entityId = entityId;
		this.motion = motion;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + 13;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		motion=new Tuples.FloatXYZ(); motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
	}

	public static SetEntityMotion fromBuffer(byte[] buffer) {
		SetEntityMotion ret = new SetEntityMotion();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetEntityMotion(entityId: " + this.entityId + ", motion: " + this.motion.toString() + ")";
	}

}