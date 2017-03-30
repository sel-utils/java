/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.types;

import java.util.Arrays;

import sul.utils.*;

public class Address extends Stream {

	public byte type;
	public int ipv4;
	public byte[] ipv6 = new byte[16];
	public short port;

	public Address() {}

	public Address(byte type, int ipv4, byte[] ipv6, short port) {
		this.type = type;
		this.ipv4 = ipv4;
		this.ipv6 = ipv6;
		this.port = port;
	}

	@Override
	public int length() {
		return 23;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(type);
		if(type==4){ this.writeBigEndianInt(ipv4); }
		if(type==6){ this.writeBytes(ipv6); }
		this.writeBigEndianShort(port);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		type=readBigEndianByte();
		if(type==4){ ipv4=readBigEndianInt(); }
		if(type==6){ final int bldy=16; ipv6=this.readBytes(bldy); }
		port=readBigEndianShort();
	}

	@Override
	public String toString() {
		return "Address(type: " + this.type + ", ipv4: " + this.ipv4 + ", ipv6: " + Arrays.toString(this.ipv6) + ", port: " + this.port + ")";
	}


}