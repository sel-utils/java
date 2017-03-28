/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.serverbound;

import sul.utils.*;

public class PlayerLook extends Packet {

	public static final int ID = (int)14;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public float yaw;
	public float pitch;
	public boolean onGround;

	public PlayerLook() {}

	public PlayerLook(float yaw, float pitch, boolean onGround) {
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		onGround=this.readBool();
	}

	public static PlayerLook fromBuffer(byte[] buffer) {
		PlayerLook ret = new PlayerLook();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerLook(yaw: " + this.yaw + ", pitch: " + this.pitch + ", onGround: " + this.onGround + ")";
	}

}
