/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.util.UUID;

import sul.utils.*;

public class SpawnPlayer extends Packet {

	public static final int ID = (int)5;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public UUID uuid;
	public Tuples.DoubleXYZ position = new Tuples.DoubleXYZ();
	public byte yaw;
	public byte pitch;
	public sul.metadata.Minecraft108 metadata;

	public SpawnPlayer() {}

	public SpawnPlayer(int entityId, UUID uuid, Tuples.DoubleXYZ position, byte yaw, byte pitch, sul.metadata.Minecraft108 metadata) {
		this.entityId = entityId;
		this.uuid = uuid;
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.metadata = metadata;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + metadata.length() + 43;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianByte(pitch);
		this.writeBytes(metadata.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianByte();
		pitch=readBigEndianByte();
		metadata=new sul.metadata.Minecraft108(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
	}

	public static SpawnPlayer fromBuffer(byte[] buffer) {
		SpawnPlayer ret = new SpawnPlayer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SpawnPlayer(entityId: " + this.entityId + ", uuid: " + this.uuid.toString() + ", position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", metadata: " + this.metadata.toString() + ")";
	}

}