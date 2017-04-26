/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket111.xml
 */
package sul.protocol.pocket111.types;

import sul.utils.*;

public class Link extends Stream {

	// action
	public static final byte ADD = 0;
	public static final byte RIDE = 1;
	public static final byte REMOVE = 2;

	public long from;
	public long to;
	public byte action;

	public Link() {}

	public Link(long from, long to, byte action) {
		this.from = from;
		this.to = to;
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(from) + Buffer.varlongLength(to) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarlong(from);
		this.writeVarlong(to);
		this.writeBigEndianByte(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		from=this.readVarlong();
		to=this.readVarlong();
		action=readBigEndianByte();
	}

	@Override
	public String toString() {
		return "Link(from: " + this.from + ", to: " + this.to + ", action: " + this.action + ")";
	}


}