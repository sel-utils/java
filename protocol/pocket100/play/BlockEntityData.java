/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.Arrays;

import sul.utils.*;

public class BlockEntityData extends Packet {

	public static final byte ID = (byte)56;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public sul.protocol.pocket100.types.BlockPosition position;
	public byte[] nbt = new byte[0];

	public BlockEntityData() {}

	public BlockEntityData(sul.protocol.pocket100.types.BlockPosition position, byte[] nbt) {
		this.position = position;
		this.nbt = nbt;
	}

	@Override
	public int length() {
		return position.length() + nbt.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(position.encode());
		this.writeBytes(nbt);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new sul.protocol.pocket100.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		nbt=this.readBytes(this._buffer.length-this._index);
	}

	public static BlockEntityData fromBuffer(byte[] buffer) {
		BlockEntityData ret = new BlockEntityData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "BlockEntityData(position: " + this.position.toString() + ", nbt: " + Arrays.toString(this.nbt) + ")";
	}

}