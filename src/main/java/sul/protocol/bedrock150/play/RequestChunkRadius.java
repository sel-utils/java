/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock150.xml
 */
package sul.protocol.bedrock150.play;

import sul.utils.*;

public class RequestChunkRadius extends Packet {

	public static final int ID = (int)69;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int radius;

	public RequestChunkRadius() {}

	public RequestChunkRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int length() {
		return Buffer.varintLength(radius) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarint(radius);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		radius=this.readVarint();
	}

	public static RequestChunkRadius fromBuffer(byte[] buffer) {
		RequestChunkRadius ret = new RequestChunkRadius();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "RequestChunkRadius(radius: " + this.radius + ")";
	}

}