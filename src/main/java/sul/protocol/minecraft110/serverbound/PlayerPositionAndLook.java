/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.serverbound;

import sul.utils.*;

public class PlayerPositionAndLook extends Packet {

	public static final int ID = (int)13;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.DoubleXYZ position = new Tuples.DoubleXYZ();
	public float yaw;
	public float pitch;
	public boolean onGround;

	public PlayerPositionAndLook() {}

	public PlayerPositionAndLook(Tuples.DoubleXYZ position, float yaw, float pitch, boolean onGround) {
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return 34;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		onGround=this.readBool();
	}

	public static PlayerPositionAndLook fromBuffer(byte[] buffer) {
		PlayerPositionAndLook ret = new PlayerPositionAndLook();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerPositionAndLook(position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", onGround: " + this.onGround + ")";
	}

}
