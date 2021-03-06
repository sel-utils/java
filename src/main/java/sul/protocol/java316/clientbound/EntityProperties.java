/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java316.xml
 */
package sul.protocol.java316.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class EntityProperties extends Packet {

	public static final int ID = (int)74;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public sul.protocol.java316.types.Attribute[] attributes = new sul.protocol.java316.types.Attribute[0];

	public EntityProperties() {}

	public EntityProperties(int entityId, sul.protocol.java316.types.Attribute[] attributes) {
		this.entityId = entityId;
		this.attributes = attributes;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(entityId) + 6; for(sul.protocol.java316.types.Attribute yrcldrc:attributes){ length+=yrcldrc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianInt((int)attributes.length); for(sul.protocol.java316.types.Attribute yrcldrc:attributes){ this.writeBytes(yrcldrc.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		int bfdjyvzm=readBigEndianInt(); attributes=new sul.protocol.java316.types.Attribute[bfdjyvzm]; for(int yrcldrc=0;yrcldrc<attributes.length;yrcldrc++){ attributes[yrcldrc]=new sul.protocol.java316.types.Attribute(); attributes[yrcldrc]._index=this._index; attributes[yrcldrc].decode(this._buffer); this._index=attributes[yrcldrc]._index; }
	}

	public static EntityProperties fromBuffer(byte[] buffer) {
		EntityProperties ret = new EntityProperties();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityProperties(entityId: " + this.entityId + ", attributes: " + Arrays.deepToString(this.attributes) + ")";
	}

}