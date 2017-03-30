/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class PlayerAbilities extends Packet {

	public static final int ID = (int)43;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// flags
	public static final byte INVULNERABLE = 1;
	public static final byte FLYING = 2;
	public static final byte ALLOW_FLYING = 4;
	public static final byte CREATIVE_MODE = 8;

	public byte flags;
	public float flyingSpeed;
	public float fovModifier;

	public PlayerAbilities() {}

	public PlayerAbilities(byte flags, float flyingSpeed, float fovModifier) {
		this.flags = flags;
		this.flyingSpeed = flyingSpeed;
		this.fovModifier = fovModifier;
	}

	@Override
	public int length() {
		return 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(flags);
		this.writeBigEndianFloat(flyingSpeed);
		this.writeBigEndianFloat(fovModifier);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		flags=readBigEndianByte();
		flyingSpeed=readBigEndianFloat();
		fovModifier=readBigEndianFloat();
	}

	public static PlayerAbilities fromBuffer(byte[] buffer) {
		PlayerAbilities ret = new PlayerAbilities();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerAbilities(flags: " + this.flags + ", flyingSpeed: " + this.flyingSpeed + ", fovModifier: " + this.fovModifier + ")";
	}

}