/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class ChunkData extends Packet {

	public static final int ID = (int)32;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.IntXZ position = new Tuples.IntXZ();
	public boolean full;
	public int sections;
	public byte[] data = new byte[0];
	public int tilesCount;
	public byte[] tiles = new byte[0];

	public ChunkData() {}

	public ChunkData(Tuples.IntXZ position, boolean full, int sections, byte[] data, int tilesCount, byte[] tiles) {
		this.position = position;
		this.full = full;
		this.sections = sections;
		this.data = data;
		this.tilesCount = tilesCount;
		this.tiles = tiles;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(sections) + Buffer.varuintLength(data.length) + data.length + Buffer.varuintLength(tilesCount) + tiles.length + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.z);
		this.writeBool(full);
		this.writeVaruint(sections);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		this.writeVaruint(tilesCount);
		this.writeBytes(tiles);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=new Tuples.IntXZ(); position.x=readBigEndianInt(); position.z=readBigEndianInt();
		full=this.readBool();
		sections=this.readVaruint();
		int brde=this.readVaruint(); data=this.readBytes(brde);
		tilesCount=this.readVaruint();
		tiles=this.readBytes(this._buffer.length-this._index);
	}

	public static ChunkData fromBuffer(byte[] buffer) {
		ChunkData ret = new ChunkData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChunkData(position: " + this.position.toString() + ", full: " + this.full + ", sections: " + this.sections + ", data: " + Arrays.toString(this.data) + ", tilesCount: " + this.tilesCount + ", tiles: " + Arrays.toString(this.tiles) + ")";
	}

}