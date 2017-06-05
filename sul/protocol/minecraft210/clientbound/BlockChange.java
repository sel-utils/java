/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import sul.utils.*;

public class BlockChange extends Packet {

	public static final int ID = (int)11;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long position;
	public int block;

	public BlockChange() {}

	public BlockChange(long position, int block) {
		this.position = position;
		this.block = block;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(block) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeVaruint(block);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		block=this.readVaruint();
	}

	public static BlockChange fromBuffer(byte[] buffer) {
		BlockChange ret = new BlockChange();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "BlockChange(position: " + this.position + ", block: " + this.block + ")";
	}

}