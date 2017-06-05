/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.util;

import java.util.Arrays;

import sul.utils.*;

public class Uncompressed extends Packet {

	public static final byte ID = (byte)1;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte[][] packets = new byte[0][0];

	public Uncompressed() {}

	public Uncompressed(byte[][] packets) {
		this.packets = packets;
	}

	@Override
	public int length() {
		int length=1; for(byte[] cfavc:packets){ length+=Buffer.varuintLength(cfavc.length)+cfavc.length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint((int)packets.length); for(byte[] cfavc:packets){ this.writeVaruint((int)cfavc.length); this.writeBytes(cfavc); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bbytdm=this.readVaruint(); packets=new byte[bbytdm][]; for(int cfavc=0;cfavc<packets.length;cfavc++){ int bbytdnyz=this.readVaruint(); packets[cfavc]=this.readBytes(bbytdnyz); }
	}

	public static Uncompressed fromBuffer(byte[] buffer) {
		Uncompressed ret = new Uncompressed();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Uncompressed(packets: " + Arrays.toString(this.packets) + ")";
	}

}