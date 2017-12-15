/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.types;

import sul.utils.*;

/**
 * Position of a block, where x and z are signed and y is always positive (as blocks
 * cannot be placed under 0).
 */
public class BlockPosition extends Stream {

	public int x;
	public int y;
	public int z;

	public BlockPosition() {}

	public BlockPosition(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int length() {
		return Buffer.varintLength(x) + Buffer.varuintLength(y) + Buffer.varintLength(z);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarint(x);
		this.writeVaruint(y);
		this.writeVarint(z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		x=this.readVarint();
		y=this.readVaruint();
		z=this.readVarint();
	}

	@Override
	public String toString() {
		return "BlockPosition(x: " + this.x + ", y: " + this.y + ", z: " + this.z + ")";
	}


}