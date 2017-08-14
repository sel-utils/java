/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java338.xml
 */
package sul.protocol.java338.serverbound;

import sul.utils.*;

public class Player extends Packet {

	public static final int ID = (int)12;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public boolean onGround;

	public Player() {}

	public Player(boolean onGround) {
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		onGround=this.readBool();
	}

	public static Player fromBuffer(byte[] buffer) {
		Player ret = new Player();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Player(onGround: " + this.onGround + ")";
	}

}