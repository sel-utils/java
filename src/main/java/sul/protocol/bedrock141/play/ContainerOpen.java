/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.play;

import sul.utils.*;

public class ContainerOpen extends Packet {

	public static final int ID = (int)46;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public byte type;
	public sul.protocol.bedrock141.types.BlockPosition position;
	public long entityId;

	public ContainerOpen() {}

	public ContainerOpen(byte window, byte type, sul.protocol.bedrock141.types.BlockPosition position, long entityId) {
		this.window = window;
		this.type = type;
		this.position = position;
		this.entityId = entityId;
	}

	@Override
	public int length() {
		return position.length() + Buffer.varlongLength(entityId) + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeLittleEndianByte(window);
		this.writeLittleEndianByte(type);
		this.writeBytes(position.encode());
		this.writeVarlong(entityId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readLittleEndianByte();
		type=readLittleEndianByte();
		position=new sul.protocol.bedrock141.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		entityId=this.readVarlong();
	}

	public static ContainerOpen fromBuffer(byte[] buffer) {
		ContainerOpen ret = new ContainerOpen();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ContainerOpen(window: " + this.window + ", type: " + this.type + ", position: " + this.position.toString() + ", entityId: " + this.entityId + ")";
	}

}