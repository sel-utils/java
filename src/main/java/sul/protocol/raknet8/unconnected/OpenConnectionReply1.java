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

public class OpenConnectionReply1 extends Packet {

	public static final byte ID = (byte)6;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte[] magic = new byte[16];
	public long serverId;
	public boolean security;
	public short mtuLength;

	public OpenConnectionReply1() {}

	public OpenConnectionReply1(byte[] magic, long serverId, boolean security, short mtuLength) {
		this.magic = magic;
		this.serverId = serverId;
		this.security = security;
		this.mtuLength = mtuLength;
	}

	@Override
	public int length() {
		return 28;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(magic);
		this.writeBigEndianLong(serverId);
		this.writeBool(security);
		this.writeBigEndianShort(mtuLength);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		final int b1zl=16; magic=this.readBytes(b1zl);
		serverId=readBigEndianLong();
		security=this.readBool();
		mtuLength=readBigEndianShort();
	}

	public static OpenConnectionReply1 fromBuffer(byte[] buffer) {
		OpenConnectionReply1 ret = new OpenConnectionReply1();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "OpenConnectionReply1(magic: " + Arrays.toString(this.magic) + ", serverId: " + this.serverId + ", security: " + this.security + ", mtuLength: " + this.mtuLength + ")";
	}

}