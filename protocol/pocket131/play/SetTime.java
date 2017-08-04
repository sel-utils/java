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

/**
 * Sets the time.
 */
public class SetTime extends Packet {

	public static final byte ID = (byte)10;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Time of the day in a range from 0 to 24000. If higher or lower it will be moduled
	 * to 24000.
	 */
	public int time;

	public SetTime() {}

	public SetTime(int time) {
		this.time = time;
	}

	@Override
	public int length() {
		return Buffer.varintLength(time) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(time);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		time=this.readVarint();
	}

	public static SetTime fromBuffer(byte[] buffer) {
		SetTime ret = new SetTime();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetTime(time: " + this.time + ")";
	}

}