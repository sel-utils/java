/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package sul.protocol.bedrock137.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class InitiateWebSocketConnection extends Packet {

	public static final int ID = (int)95;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String unknown0;

	public InitiateWebSocketConnection() {}

	public InitiateWebSocketConnection(String unknown0) {
		this.unknown0 = unknown0;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(unknown0.getBytes(StandardCharsets.UTF_8).length) + unknown0.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] d5b9ba=unknown0.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d5b9ba.length); this.writeBytes(d5b9ba);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvd5b9ba=this.readVaruint(); unknown0=new String(this.readBytes(bvd5b9ba), StandardCharsets.UTF_8);
	}

	public static InitiateWebSocketConnection fromBuffer(byte[] buffer) {
		InitiateWebSocketConnection ret = new InitiateWebSocketConnection();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "InitiateWebSocketConnection(unknown0: " + this.unknown0 + ")";
	}

}