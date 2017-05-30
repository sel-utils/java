/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft333.xml
 */
package sul.protocol.minecraft333.serverbound;

import sul.utils.*;

public class SteerBoat extends Packet {

	public static final int ID = (int)18;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public boolean rightPaddleTurning;
	public boolean leftPaddleTurning;

	public SteerBoat() {}

	public SteerBoat(boolean rightPaddleTurning, boolean leftPaddleTurning) {
		this.rightPaddleTurning = rightPaddleTurning;
		this.leftPaddleTurning = leftPaddleTurning;
	}

	@Override
	public int length() {
		return 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBool(rightPaddleTurning);
		this.writeBool(leftPaddleTurning);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		rightPaddleTurning=this.readBool();
		leftPaddleTurning=this.readBool();
	}

	public static SteerBoat fromBuffer(byte[] buffer) {
		SteerBoat ret = new SteerBoat();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SteerBoat(rightPaddleTurning: " + this.rightPaddleTurning + ", leftPaddleTurning: " + this.leftPaddleTurning + ")";
	}

}