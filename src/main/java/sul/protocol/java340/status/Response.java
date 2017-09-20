/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java340.xml
 */
package sul.protocol.java340.status;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Response extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String json;

	public Response() {}

	public Response(String json) {
		this.json = json;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(json.getBytes(StandardCharsets.UTF_8).length) + json.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] anb=json.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)anb.length); this.writeBytes(anb);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvanb=this.readVaruint(); json=new String(this.readBytes(bvanb), StandardCharsets.UTF_8);
	}

	public static Response fromBuffer(byte[] buffer) {
		Response ret = new Response();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Response(json: " + this.json + ")";
	}

}