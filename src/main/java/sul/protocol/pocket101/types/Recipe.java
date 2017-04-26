/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.types;

import java.util.Arrays;

import sul.utils.*;

public class Recipe extends Stream {

	// type
	public static final int SHAPELESS = 0;
	public static final int SHAPED = 1;
	public static final int FURNACE = 2;
	public static final int FURNACE_DATA = 3;
	public static final int MULTI = 4;

	public int type;
	public byte[] data = new byte[0];

	public Recipe() {}

	public Recipe(int type, byte[] data) {
		this.type = type;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varintLength(type) + data.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarint(type);
		this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		type=this.readVarint();
		data=this.readBytes(this._buffer.length-this._index);
	}

	@Override
	public String toString() {
		return "Recipe(type: " + this.type + ", data: " + Arrays.toString(this.data) + ")";
	}


}