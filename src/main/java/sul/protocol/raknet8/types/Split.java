/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.types;

import sul.utils.*;

public class Split extends Stream {

	public int count;
	public short id;
	public int order;

	public Split() {}

	public Split(int count, short id, int order) {
		this.count = count;
		this.id = id;
		this.order = order;
	}

	@Override
	public int length() {
		return 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianInt(count);
		this.writeBigEndianShort(id);
		this.writeBigEndianInt(order);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		count=readBigEndianInt();
		id=readBigEndianShort();
		order=readBigEndianInt();
	}

	@Override
	public String toString() {
		return "Split(count: " + this.count + ", id: " + this.id + ", order: " + this.order + ")";
	}


}