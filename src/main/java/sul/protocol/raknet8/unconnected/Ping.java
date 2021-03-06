/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.unconnected;

import java.util.Arrays;

import sul.utils.*;

public class Ping extends Packet {

	public static final byte ID = (byte)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long pingId;
	public byte[] magic = new byte[16];
	public long guid;

	public Ping() {}

	public Ping(long pingId, byte[] magic, long guid) {
		this.pingId = pingId;
		this.magic = magic;
		this.guid = guid;
	}

	@Override
	public int length() {
		return 33;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianLong(pingId);
		this.writeBytes(magic);
		this.writeBigEndianLong(guid);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		pingId=readBigEndianLong();
		final int b1zl=16; magic=this.readBytes(b1zl);
		guid=readBigEndianLong();
	}

	public static Ping fromBuffer(byte[] buffer) {
		Ping ret = new Ping();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Ping(pingId: " + this.pingId + ", magic: " + Arrays.toString(this.magic) + ", guid: " + this.guid + ")";
	}

}