/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class UpdateHealth extends Packet {

	public static final int ID = (int)62;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public float health;
	public int hunger;
	public float saturation;

	public UpdateHealth() {}

	public UpdateHealth(float health, int hunger, float saturation) {
		this.health = health;
		this.hunger = hunger;
		this.saturation = saturation;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hunger) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianFloat(health);
		this.writeVaruint(hunger);
		this.writeBigEndianFloat(saturation);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		health=readBigEndianFloat();
		hunger=this.readVaruint();
		saturation=readBigEndianFloat();
	}

	public static UpdateHealth fromBuffer(byte[] buffer) {
		UpdateHealth ret = new UpdateHealth();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateHealth(health: " + this.health + ", hunger: " + this.hunger + ", saturation: " + this.saturation + ")";
	}

}
