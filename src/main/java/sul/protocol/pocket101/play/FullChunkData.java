/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

/**
 * Sends a 16x16 chunk to the client with its blocks, lights and block entities (tiles).
 */
public class FullChunkData extends Packet {

	public static final byte ID = (byte)58;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Coordinates of the chunk.
	 */
	public Tuples.IntXZ position = new Tuples.IntXZ();
	public sul.protocol.pocket101.types.ChunkData data;

	public FullChunkData() {}

	public FullChunkData(Tuples.IntXZ position, sul.protocol.pocket101.types.ChunkData data) {
		this.position = position;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varintLength(position.x) + Buffer.varintLength(position.z) + data.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(position.x); this.writeVarint(position.z);
		this.writeBytes(data.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new Tuples.IntXZ(); position.x=this.readVarint(); position.z=this.readVarint();
		data=new sul.protocol.pocket101.types.ChunkData(); data._index=this._index; data.decode(this._buffer); this._index=data._index;
	}

	public static FullChunkData fromBuffer(byte[] buffer) {
		FullChunkData ret = new FullChunkData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "FullChunkData(position: " + this.position.toString() + ", data: " + this.data.toString() + ")";
	}

}
