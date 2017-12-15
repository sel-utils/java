/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock150.xml
 */
package sul.protocol.bedrock150.types;

import sul.utils.*;

public class Link extends Stream {

	// action
	public static final byte ADD = (byte)0;
	public static final byte RIDE = (byte)1;
	public static final byte REMOVE = (byte)2;

	public long from;
	public long to;
	public byte action;
	public byte unknown3;

	public Link() {}

	public Link(long from, long to, byte action, byte unknown3) {
		this.from = from;
		this.to = to;
		this.action = action;
		this.unknown3 = unknown3;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(from) + Buffer.varlongLength(to) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarlong(from);
		this.writeVarlong(to);
		this.writeLittleEndianByte(action);
		this.writeLittleEndianByte(unknown3);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		from=this.readVarlong();
		to=this.readVarlong();
		action=readLittleEndianByte();
		unknown3=readLittleEndianByte();
	}

	@Override
	public String toString() {
		return "Link(from: " + this.from + ", to: " + this.to + ", action: " + this.action + ", unknown3: " + this.unknown3 + ")";
	}


}