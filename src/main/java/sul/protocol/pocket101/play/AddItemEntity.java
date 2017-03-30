/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

/**
 * Spawns a dropped item.
 */
public class AddItemEntity extends Packet {

	public static final byte ID = (byte)16;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public long runtimeId;
	public sul.protocol.pocket101.types.Slot item;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public Tuples.FloatXYZ motion = new Tuples.FloatXYZ();

	public AddItemEntity() {}

	public AddItemEntity(long entityId, long runtimeId, sul.protocol.pocket101.types.Slot item, Tuples.FloatXYZ position, Tuples.FloatXYZ motion) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.item = item;
		this.position = position;
		this.motion = motion;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + item.length() + 25;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeBytes(item.encode());
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		item=new sul.protocol.pocket101.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		motion=new Tuples.FloatXYZ(); motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
	}

	public static AddItemEntity fromBuffer(byte[] buffer) {
		AddItemEntity ret = new AddItemEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddItemEntity(entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", item: " + this.item.toString() + ", position: " + this.position.toString() + ", motion: " + this.motion.toString() + ")";
	}

}