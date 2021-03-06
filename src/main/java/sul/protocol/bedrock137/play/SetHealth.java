/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package sul.protocol.bedrock137.play;

import sul.utils.*;

public class SetHealth extends Packet {

	public static final int ID = (int)42;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int health;

	public SetHealth() {}

	public SetHealth(int health) {
		this.health = health;
	}

	@Override
	public int length() {
		return Buffer.varintLength(health) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarint(health);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		health=this.readVarint();
	}

	public static SetHealth fromBuffer(byte[] buffer) {
		SetHealth ret = new SetHealth();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetHealth(health: " + this.health + ")";
	}

}