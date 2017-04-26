/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.util.Arrays;

import sul.utils.*;

/**
 * Sets a block entity's nbt tag, block's additional data that cannot be indicated
 * in the block's meta. More informations about block entities and their tag format
 * can be found on Minecraft Wiki.
 */
public class BlockEntityData extends Packet {

	public static final byte ID = (byte)56;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Position of the block that will be associated with tag.
	 */
	public sul.protocol.pocket101.types.BlockPosition position;

	/**
	 * Named binary tag of the block. The format varies from the classic format of Minecraft:
	 * Pocket Edition (which is like Minecraft's but little endian) introducing the use
	 * of varints for some types:
	 * + The tag `Int` is encoded as a signed varint instead of a simple signed 32-bits
	 * integer
	 * + The length of the `ByteArray` and the `IntArray` is encoded as an unsigned varint
	 * instead of a 32-bits integer
	 * + The length of the `String` tag and the named tag's name length are encoded as
	 * an unisgned varint instead of a 16-bits integer
	 */
	public byte[] nbt = new byte[0];

	public BlockEntityData() {}

	public BlockEntityData(sul.protocol.pocket101.types.BlockPosition position, byte[] nbt) {
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
		position=new sul.protocol.pocket101.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
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