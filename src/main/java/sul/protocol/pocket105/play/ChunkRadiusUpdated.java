/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import sul.utils.*;

/**
 * Packet sent always and only in response to RequestChunkRadius to change the client's
 * view distance.
 */
public class ChunkRadiusUpdated extends Packet {

	public static final byte ID = (byte)70;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * View distance that may be different from the client's one if the server sets a limit
	 * on the view distance.
	 */
	public int radius;

	public ChunkRadiusUpdated() {}

	public ChunkRadiusUpdated(int radius) {
		this.radius = radius;
	}

	@Override
	public int length() {
		return Buffer.varintLength(radius) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(radius);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		radius=this.readVarint();
	}

	public static ChunkRadiusUpdated fromBuffer(byte[] buffer) {
		ChunkRadiusUpdated ret = new ChunkRadiusUpdated();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChunkRadiusUpdated(radius: " + this.radius + ")";
	}

}