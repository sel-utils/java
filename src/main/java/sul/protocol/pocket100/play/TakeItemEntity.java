/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class TakeItemEntity extends Packet {

	public static final byte ID = (byte)18;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long collected;
	public long collector;

	public TakeItemEntity() {}

	public TakeItemEntity(long collected, long collector) {
		this.collected = collected;
		this.collector = collector;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(collected) + Buffer.varlongLength(collector) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(collected);
		this.writeVarlong(collector);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		collected=this.readVarlong();
		collector=this.readVarlong();
	}

	public static TakeItemEntity fromBuffer(byte[] buffer) {
		TakeItemEntity ret = new TakeItemEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "TakeItemEntity(collected: " + this.collected + ", collector: " + this.collector + ")";
	}

}