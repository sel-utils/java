/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Spawns a painting entity in the world.
 */
public class AddPainting extends Packet {

	public static final byte ID = (byte)24;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public long runtimeId;
	public sul.protocol.pocket102.types.BlockPosition position;
	public int direction;
	public String title;

	public AddPainting() {}

	public AddPainting(long entityId, long runtimeId, sul.protocol.pocket102.types.BlockPosition position, int direction, String title) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.position = position;
		this.direction = direction;
		this.title = title;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + position.length() + Buffer.varintLength(direction) + Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeBytes(position.encode());
		this.writeVarint(direction);
		byte[] dlbu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dlbu.length); this.writeBytes(dlbu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		position=new sul.protocol.pocket102.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		direction=this.readVarint();
		int bvdlbu=this.readVaruint(); title=new String(this.readBytes(bvdlbu), StandardCharsets.UTF_8);
	}

	public static AddPainting fromBuffer(byte[] buffer) {
		AddPainting ret = new AddPainting();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddPainting(entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", position: " + this.position.toString() + ", direction: " + this.direction + ", title: " + this.title + ")";
	}

}
