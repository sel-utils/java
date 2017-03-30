/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.unconnected;

import java.util.Arrays;

import sul.utils.*;

public class OpenConnectionRequest1 extends Packet {

	public static final byte ID = (byte)5;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte[] magic = new byte[16];
	public byte protocol;
	public byte[] mtu = new byte[0];

	public OpenConnectionRequest1() {}

	public OpenConnectionRequest1(byte[] magic, byte protocol, byte[] mtu) {
		this.magic = magic;
		this.protocol = protocol;
		this.mtu = mtu;
	}

	@Override
	public int length() {
		return mtu.length + 18;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(magic);
		this.writeBigEndianByte(protocol);
		this.writeBytes(mtu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		final int b1zl=16; magic=this.readBytes(b1zl);
		protocol=readBigEndianByte();
		mtu=this.readBytes(this._buffer.length-this._index);
	}

	public static OpenConnectionRequest1 fromBuffer(byte[] buffer) {
		OpenConnectionRequest1 ret = new OpenConnectionRequest1();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "OpenConnectionRequest1(magic: " + Arrays.toString(this.magic) + ", protocol: " + this.protocol + ", mtu: " + Arrays.toString(this.mtu) + ")";
	}

}