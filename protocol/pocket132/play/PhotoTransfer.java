/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket132.xml
 */
package sul.protocol.pocket132.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class PhotoTransfer extends Packet {

	public static final int ID = (int)99;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public String unknown0;
	public String unknown1;
	public String unknown2;

	public PhotoTransfer() {}

	public PhotoTransfer(String unknown0, String unknown1, String unknown2) {
		this.unknown0 = unknown0;
		this.unknown1 = unknown1;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(unknown0.getBytes(StandardCharsets.UTF_8).length) + unknown0.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(unknown1.getBytes(StandardCharsets.UTF_8).length) + unknown1.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(unknown2.getBytes(StandardCharsets.UTF_8).length) + unknown2.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] d5b9ba=unknown0.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d5b9ba.length); this.writeBytes(d5b9ba);
		byte[] d5b9be=unknown1.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d5b9be.length); this.writeBytes(d5b9be);
		byte[] d5b9bi=unknown2.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d5b9bi.length); this.writeBytes(d5b9bi);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvd5b9ba=this.readVaruint(); unknown0=new String(this.readBytes(bvd5b9ba), StandardCharsets.UTF_8);
		int bvd5b9be=this.readVaruint(); unknown1=new String(this.readBytes(bvd5b9be), StandardCharsets.UTF_8);
		int bvd5b9bi=this.readVaruint(); unknown2=new String(this.readBytes(bvd5b9bi), StandardCharsets.UTF_8);
	}

	public static PhotoTransfer fromBuffer(byte[] buffer) {
		PhotoTransfer ret = new PhotoTransfer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PhotoTransfer(unknown0: " + this.unknown0 + ", unknown1: " + this.unknown1 + ", unknown2: " + this.unknown2 + ")";
	}

}