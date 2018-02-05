/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import java.util.Arrays;

import sul.utils.*;

public class UpdateAttributes extends Packet {

	public static final byte ID = (byte)31;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public sul.protocol.pocket105.types.Attribute[] attributes = new sul.protocol.pocket105.types.Attribute[0];

	public UpdateAttributes() {}

	public UpdateAttributes(long entityId, sul.protocol.pocket105.types.Attribute[] attributes) {
		this.entityId = entityId;
		this.attributes = attributes;
	}

	@Override
	public int length() {
		int length=Buffer.varlongLength(entityId) + Buffer.varuintLength(attributes.length) + 1; for(sul.protocol.pocket105.types.Attribute yrcldrc:attributes){ length+=yrcldrc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVaruint((int)attributes.length); for(sul.protocol.pocket105.types.Attribute yrcldrc:attributes){ this.writeBytes(yrcldrc.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		int bfdjyvzm=this.readVaruint(); attributes=new sul.protocol.pocket105.types.Attribute[bfdjyvzm]; for(int yrcldrc=0;yrcldrc<attributes.length;yrcldrc++){ attributes[yrcldrc]=new sul.protocol.pocket105.types.Attribute(); attributes[yrcldrc]._index=this._index; attributes[yrcldrc].decode(this._buffer); this._index=attributes[yrcldrc]._index; }
	}

	public static UpdateAttributes fromBuffer(byte[] buffer) {
		UpdateAttributes ret = new UpdateAttributes();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateAttributes(entityId: " + this.entityId + ", attributes: " + Arrays.deepToString(this.attributes) + ")";
	}

}