/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class AddPlayer extends Packet {

	public static final int ID = (int)12;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public sul.protocol.bedrock160.types.McpeUuid uuid;
	public String username;
	public long entityId;
	public long runtimeId;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public Tuples.FloatXYZ motion = new Tuples.FloatXYZ();
	public float pitch;
	public float headYaw;
	public float yaw;
	public sul.protocol.bedrock160.types.Slot heldItem;
	public sul.metadata.Bedrock160 metadata;
	public int unknown11;
	public int unknown12;
	public int unknown13;
	public int unknown14;
	public int unknown15;
	public long unknown16;
	public sul.protocol.bedrock160.types.Link[] links = new sul.protocol.bedrock160.types.Link[0];

	public AddPlayer() {}

	public AddPlayer(sul.protocol.bedrock160.types.McpeUuid uuid, String username, long entityId, long runtimeId, Tuples.FloatXYZ position, Tuples.FloatXYZ motion, float pitch, float headYaw, float yaw, sul.protocol.bedrock160.types.Slot heldItem, sul.metadata.Bedrock160 metadata, int unknown11, int unknown12, int unknown13, int unknown14, int unknown15, long unknown16, sul.protocol.bedrock160.types.Link[] links) {
		this.uuid = uuid;
		this.username = username;
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.position = position;
		this.motion = motion;
		this.pitch = pitch;
		this.headYaw = headYaw;
		this.yaw = yaw;
		this.heldItem = heldItem;
		this.metadata = metadata;
		this.unknown11 = unknown11;
		this.unknown12 = unknown12;
		this.unknown13 = unknown13;
		this.unknown14 = unknown14;
		this.unknown15 = unknown15;
		this.unknown16 = unknown16;
		this.links = links;
	}

	@Override
	public int length() {
		int length=uuid.length() + Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length + Buffer.varlongLength(entityId) + Buffer.varulongLength(runtimeId) + heldItem.length() + metadata.length() + Buffer.varuintLength(unknown11) + Buffer.varuintLength(unknown12) + Buffer.varuintLength(unknown13) + Buffer.varuintLength(unknown14) + Buffer.varuintLength(unknown15) + Buffer.varuintLength(links.length) + 45; for(sul.protocol.bedrock160.types.Link blam:links){ length+=blam.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBytes(uuid.encode());
		byte[] dnc5bu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dnc5bu.length); this.writeBytes(dnc5bu);
		this.writeVarlong(entityId);
		this.writeVarulong(runtimeId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		this.writeLittleEndianFloat(pitch);
		this.writeLittleEndianFloat(headYaw);
		this.writeLittleEndianFloat(yaw);
		this.writeBytes(heldItem.encode());
		this.writeBytes(metadata.encode());
		this.writeVaruint(unknown11);
		this.writeVaruint(unknown12);
		this.writeVaruint(unknown13);
		this.writeVaruint(unknown14);
		this.writeVaruint(unknown15);
		this.writeLittleEndianLong(unknown16);
		this.writeVaruint((int)links.length); for(sul.protocol.bedrock160.types.Link blam:links){ this.writeBytes(blam.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		uuid=new sul.protocol.bedrock160.types.McpeUuid(); uuid._index=this._index; uuid.decode(this._buffer); this._index=uuid._index;
		int bvdnc5bu=this.readVaruint(); username=new String(this.readBytes(bvdnc5bu), StandardCharsets.UTF_8);
		entityId=this.readVarlong();
		runtimeId=this.readVarulong();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		motion=new Tuples.FloatXYZ(); motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
		headYaw=readLittleEndianFloat();
		yaw=readLittleEndianFloat();
		heldItem=new sul.protocol.bedrock160.types.Slot(); heldItem._index=this._index; heldItem.decode(this._buffer); this._index=heldItem._index;
		metadata=new sul.metadata.Bedrock160(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
		unknown11=this.readVaruint();
		unknown12=this.readVaruint();
		unknown13=this.readVaruint();
		unknown14=this.readVaruint();
		unknown15=this.readVaruint();
		unknown16=readLittleEndianLong();
		int bxbt=this.readVaruint(); links=new sul.protocol.bedrock160.types.Link[bxbt]; for(int blam=0;blam<links.length;blam++){ links[blam]=new sul.protocol.bedrock160.types.Link(); links[blam]._index=this._index; links[blam].decode(this._buffer); this._index=links[blam]._index; }
	}

	public static AddPlayer fromBuffer(byte[] buffer) {
		AddPlayer ret = new AddPlayer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddPlayer(uuid: " + this.uuid.toString() + ", username: " + this.username + ", entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", position: " + this.position.toString() + ", motion: " + this.motion.toString() + ", pitch: " + this.pitch + ", headYaw: " + this.headYaw + ", yaw: " + this.yaw + ", heldItem: " + this.heldItem.toString() + ", metadata: " + this.metadata.toString() + ", unknown11: " + this.unknown11 + ", unknown12: " + this.unknown12 + ", unknown13: " + this.unknown13 + ", unknown14: " + this.unknown14 + ", unknown15: " + this.unknown15 + ", unknown16: " + this.unknown16 + ", links: " + Arrays.deepToString(this.links) + ")";
	}

}