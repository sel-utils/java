/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.play;

import sul.utils.*;

/**
 * Packet sent by the client when its view-distance is updated and when it spawns for
 * the first time a world. A ChunkRadiusUpdate should always be sent in response, otherwise
 * the player will not update its view distance.
 */
public class RequestChunkRadius extends Packet {

	public static final int ID = (int)69;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Number of chunks before the fog starts to appear in the client's view. The value
	 * of this field is usually between 8 and 14.
	 */
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