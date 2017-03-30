/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import java.util.Arrays;

import sul.utils.*;

public class AddEntity extends Packet {

	public static final byte ID = (byte)14;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public long runtimeId;
	public int type;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public Tuples.FloatXYZ motion = new Tuples.FloatXYZ();
	public float pitch;
	public float yaw;
	public sul.protocol.pocket102.types.Attribute[] attributes = new sul.protocol.pocket102.types.Attribute[0];
	public sul.metadata.Pocket102 metadata;
	public sul.protocol.pocket102.types.Link[] links = new sul.protocol.pocket102.types.Link[0];

	public AddEntity() {}

	public AddEntity(long entityId, long runtimeId, int type, Tuples.FloatXYZ position, Tuples.FloatXYZ motion, float pitch, float yaw, sul.protocol.pocket102.types.Attribute[] attributes, sul.metadata.Pocket102 metadata, sul.protocol.pocket102.types.Link[] links) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.type = type;
		this.position = position;
		this.motion = motion;
		this.pitch = pitch;
		this.yaw = yaw;
		this.attributes = attributes;
		this.metadata = metadata;
		this.links = links;
	}

	@Override
	public int length() {
		int length=Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + Buffer.varuintLength(type) + Buffer.varuintLength(attributes.length) + metadata.length() + Buffer.varuintLength(links.length) + 33; for(sul.protocol.pocket102.types.Attribute yrcldrc:attributes){ length+=yrcldrc.length(); };for(sul.protocol.pocket102.types.Link blam:links){ length+=blam.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeVaruint(type);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		this.writeLittleEndianFloat(pitch);
		this.writeLittleEndianFloat(yaw);
		this.writeVaruint((int)attributes.length); for(sul.protocol.pocket102.types.Attribute yrcldrc:attributes){ this.writeBytes(yrcldrc.encode()); }
		this.writeBytes(metadata.encode());
		this.writeVaruint((int)links.length); for(sul.protocol.pocket102.types.Link blam:links){ this.writeBytes(blam.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		type=this.readVaruint();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		motion=new Tuples.FloatXYZ(); motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
		yaw=readLittleEndianFloat();
		int bfdjyvzm=this.readVaruint(); attributes=new sul.protocol.pocket102.types.Attribute[bfdjyvzm]; for(int yrcldrc=0;yrcldrc<attributes.length;yrcldrc++){ attributes[yrcldrc]=new sul.protocol.pocket102.types.Attribute(); attributes[yrcldrc]._index=this._index; attributes[yrcldrc].decode(this._buffer); this._index=attributes[yrcldrc]._index; }
		metadata=new sul.metadata.Pocket102(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
		int bxbt=this.readVaruint(); links=new sul.protocol.pocket102.types.Link[bxbt]; for(int blam=0;blam<links.length;blam++){ links[blam]=new sul.protocol.pocket102.types.Link(); links[blam]._index=this._index; links[blam].decode(this._buffer); this._index=links[blam]._index; }
	}

	public static AddEntity fromBuffer(byte[] buffer) {
		AddEntity ret = new AddEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddEntity(entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", type: " + this.type + ", position: " + this.position.toString() + ", motion: " + this.motion.toString() + ", pitch: " + this.pitch + ", yaw: " + this.yaw + ", attributes: " + Arrays.deepToString(this.attributes) + ", metadata: " + this.metadata.toString() + ", links: " + Arrays.deepToString(this.links) + ")";
	}

}