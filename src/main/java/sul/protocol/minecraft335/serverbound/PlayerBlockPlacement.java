/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft335.xml
 */
package sul.protocol.minecraft335.serverbound;

import sul.utils.*;

public class PlayerBlockPlacement extends Packet {

	public static final int ID = (int)31;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// hand
	public static final int MAIN_HAND = (int)0;
	public static final int OFF_HAND = (int)1;

	public long position;
	public int face;
	public int hand;
	public Tuples.FloatXYZ cursorPosition = new Tuples.FloatXYZ();

	public PlayerBlockPlacement() {}

	public PlayerBlockPlacement(long position, int face, int hand, Tuples.FloatXYZ cursorPosition) {
		this.position = position;
		this.face = face;
		this.hand = hand;
		this.cursorPosition = cursorPosition;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(face) + Buffer.varuintLength(hand) + 21;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeVaruint(face);
		this.writeVaruint(hand);
		this.writeBigEndianFloat(cursorPosition.x); this.writeBigEndianFloat(cursorPosition.y); this.writeBigEndianFloat(cursorPosition.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		face=this.readVaruint();
		hand=this.readVaruint();
		cursorPosition=new Tuples.FloatXYZ(); cursorPosition.x=readBigEndianFloat(); cursorPosition.y=readBigEndianFloat(); cursorPosition.z=readBigEndianFloat();
	}

	public static PlayerBlockPlacement fromBuffer(byte[] buffer) {
		PlayerBlockPlacement ret = new PlayerBlockPlacement();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerBlockPlacement(position: " + this.position + ", face: " + this.face + ", hand: " + this.hand + ", cursorPosition: " + this.cursorPosition.toString() + ")";
	}

}