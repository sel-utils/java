/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.utils.*;

public class EntityMetadata extends Packet {

	public static final int ID = (int)57;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public sul.metadata.Minecraft316 metadata;

	public EntityMetadata() {}

	public EntityMetadata(int entityId, sul.metadata.Minecraft316 metadata) {
		this.entityId = entityId;
		this.metadata = metadata;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + metadata.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBytes(metadata.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		metadata=new sul.metadata.Minecraft316(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
	}

	public static EntityMetadata fromBuffer(byte[] buffer) {
		EntityMetadata ret = new EntityMetadata();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityMetadata(entityId: " + this.entityId + ", metadata: " + this.metadata.toString() + ")";
	}

}
