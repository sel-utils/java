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

public class TimeUpdate extends Packet {

	public static final int ID = (int)68;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long worldAge;
	public long time;

	public TimeUpdate() {}

	public TimeUpdate(long worldAge, long time) {
		this.worldAge = worldAge;
		this.time = time;
	}

	@Override
	public int length() {
		return 18;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(worldAge);
		this.writeBigEndianLong(time);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		worldAge=readBigEndianLong();
		time=readBigEndianLong();
	}

	public static TimeUpdate fromBuffer(byte[] buffer) {
		TimeUpdate ret = new TimeUpdate();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "TimeUpdate(worldAge: " + this.worldAge + ", time: " + this.time + ")";
	}

}