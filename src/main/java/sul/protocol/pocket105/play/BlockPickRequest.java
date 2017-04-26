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

public class BlockPickRequest extends Packet {

	public static final byte ID = (byte)35;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.IntXYZ position = new Tuples.IntXYZ();
	public byte slot;

	public BlockPickRequest() {}

	public BlockPickRequest(Tuples.IntXYZ position, byte slot) {
		this.position = position;
		this.slot = slot;
	}

	@Override
	public int length() {
		return Buffer.varintLength(position.x) + Buffer.varintLength(position.y) + Buffer.varintLength(position.z) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(position.x); this.writeVarint(position.y); this.writeVarint(position.z);
		this.writeBigEndianByte(slot);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new Tuples.IntXYZ(); position.x=this.readVarint(); position.y=this.readVarint(); position.z=this.readVarint();
		slot=readBigEndianByte();
	}

	public static BlockPickRequest fromBuffer(byte[] buffer) {
		BlockPickRequest ret = new BlockPickRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "BlockPickRequest(position: " + this.position.toString() + ", slot: " + this.slot + ")";
	}

}