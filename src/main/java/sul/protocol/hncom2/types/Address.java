/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.types;

import java.util.Arrays;

import sul.utils.*;

/**
 * Internet protocol address. Could be either version 4 or 6.
 */
public class Address extends Stream {

	/**
	 * Bytes of the address. The length may be 4 (for ipv4 addresses) or 16 (for ipv6 addresses).
	 * The byte order is always big-endian (network order).
	 */
	public byte[] bytes = new byte[0];

	/**
	 * Port of the address.
	 */
	public short port;

	public Address() {}

	public Address(byte[] bytes, short port) {
		this.bytes = bytes;
		this.port = port;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(bytes.length) + bytes.length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint((int)bytes.length); this.writeBytes(bytes);
		this.writeBigEndianShort(port);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bjdv=this.readVaruint(); bytes=this.readBytes(bjdv);
		port=readBigEndianShort();
	}

	@Override
	public String toString() {
		return "Address(bytes: " + Arrays.toString(this.bytes) + ", port: " + this.port + ")";
	}


}