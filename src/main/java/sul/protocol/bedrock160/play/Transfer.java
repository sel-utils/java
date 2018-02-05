/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Transfer extends Packet {

	public static final int ID = (int)85;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String ip;
	public short port = 19132;

	public Transfer() {}

	public Transfer(String ip, short port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ip.getBytes(StandardCharsets.UTF_8).length) + ip.getBytes(StandardCharsets.UTF_8).length + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] aa=ip.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aa.length); this.writeBytes(aa);
		this.writeLittleEndianShort(port);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvaa=this.readVaruint(); ip=new String(this.readBytes(bvaa), StandardCharsets.UTF_8);
		port=readLittleEndianShort();
	}

	public static Transfer fromBuffer(byte[] buffer) {
		Transfer ret = new Transfer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Transfer(ip: " + this.ip + ", port: " + this.port + ")";
	}

}