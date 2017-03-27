/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

/**
 * Spawns a player after adding it to the player's list using PlayerList. If PlayerList
 * is sent after this packet the player will appear to have the same skin as the player
 * who receives this packet.
 * Spawning a player to itself (using the same entity id given in the StartGame packet)
 * will crash the client's game.
 */
public class AddPlayer extends Packet {

	public static final byte ID = (byte)13;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Player's UUID, should match an UUID of a player in the list added through PlayerList.
	 */
	public UUID uuid;

	/**
	 * Player's username and text displayed on the nametag if something else is not specified
	 * in the metadata.
	 */
	public String username;
	public long entityId;
	public long runtimeId;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public Tuples.FloatXYZ motion = new Tuples.FloatXYZ();
	public float pitch;
	public float headYaw;
	public float yaw;
	public sul.protocol.pocket105.types.Slot heldItem;
	public sul.metadata.Pocket105 metadata;

	public AddPlayer() {}

	public AddPlayer(UUID uuid, String username, long entityId, long runtimeId, Tuples.FloatXYZ position, Tuples.FloatXYZ motion, float pitch, float headYaw, float yaw, sul.protocol.pocket105.types.Slot heldItem, sul.metadata.Pocket105 metadata) {
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
	}

	@Override
	public int length() {
		return Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length + Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + heldItem.length() + metadata.length() + 53;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		byte[] dnc5bu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dnc5bu.length); this.writeBytes(dnc5bu);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		this.writeLittleEndianFloat(pitch);
		this.writeLittleEndianFloat(headYaw);
		this.writeLittleEndianFloat(yaw);
		this.writeBytes(heldItem.encode());
		this.writeBytes(metadata.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		int bvdnc5bu=this.readVaruint(); username=new String(this.readBytes(bvdnc5bu), StandardCharsets.UTF_8);
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		motion=new Tuples.FloatXYZ(); motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
		headYaw=readLittleEndianFloat();
		yaw=readLittleEndianFloat();
		heldItem=new sul.protocol.pocket105.types.Slot(); heldItem._index=this._index; heldItem.decode(this._buffer); this._index=heldItem._index;
		metadata=new sul.metadata.Pocket105(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
	}

	public static AddPlayer fromBuffer(byte[] buffer) {
		AddPlayer ret = new AddPlayer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddPlayer(uuid: " + this.uuid.toString() + ", username: " + this.username + ", entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", position: " + this.position.toString() + ", motion: " + this.motion.toString() + ", pitch: " + this.pitch + ", headYaw: " + this.headYaw + ", yaw: " + this.yaw + ", heldItem: " + this.heldItem.toString() + ", metadata: " + this.metadata.toString() + ")";
	}

}
