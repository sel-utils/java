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

public class PlayerAction extends Packet {

	public static final byte ID = (byte)36;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final int START_BREAK = 0;
	public static final int ABORT_BREAK = 1;
	public static final int STOP_BREAK = 2;
	public static final int RELEASE_ITEM = 4;
	public static final int STOP_SLEEPING = 5;
	public static final int RESPAWN = 6;
	public static final int JUMP = 7;
	public static final int START_SPRINT = 8;
	public static final int STOP_SPRINT = 9;
	public static final int START_SNEAK = 10;
	public static final int STOP_SNEAK = 11;
	public static final int START_GLIDING = 14;
	public static final int STOP_GLIDING = 15;
	public static final int CONTINUE_BREAK = 17;

	public long entityId;
	public int action;
	public sul.protocol.pocket131.types.BlockPosition position;
	public int face;

	public PlayerAction() {}

	public PlayerAction(long entityId, int action, sul.protocol.pocket131.types.BlockPosition position, int face) {
		this.entityId = entityId;
		this.action = action;
		this.position = position;
		this.face = face;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varintLength(action) + position.length() + Buffer.varintLength(face) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarint(action);
		this.writeBytes(position.encode());
		this.writeVarint(face);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		action=this.readVarint();
		position=new sul.protocol.pocket131.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		face=this.readVarint();
	}

	public static PlayerAction fromBuffer(byte[] buffer) {
		PlayerAction ret = new PlayerAction();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerAction(entityId: " + this.entityId + ", action: " + this.action + ", position: " + this.position.toString() + ", face: " + this.face + ")";
	}

}