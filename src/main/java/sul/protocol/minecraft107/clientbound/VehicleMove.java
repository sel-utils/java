/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.utils.*;

public class VehicleMove extends Packet {

	public static final int ID = (int)41;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.DoubleXYZ position = new Tuples.DoubleXYZ();
	public float yaw;
	public float pitch;

	public VehicleMove() {}

	public VehicleMove(Tuples.DoubleXYZ position, float yaw, float pitch) {
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
	}

	@Override
	public int length() {
		return 33;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
	}

	public static VehicleMove fromBuffer(byte[] buffer) {
		VehicleMove ret = new VehicleMove();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "VehicleMove(position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ")";
	}

}