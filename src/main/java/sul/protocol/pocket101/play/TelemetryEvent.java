/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

public class TelemetryEvent extends Packet {

	public static final byte ID = (byte)64;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public int eventId;

	public TelemetryEvent() {}

	public TelemetryEvent(long entityId, int eventId) {
		this.entityId = entityId;
		this.eventId = eventId;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varintLength(eventId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarint(eventId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		eventId=this.readVarint();
	}

	public static TelemetryEvent fromBuffer(byte[] buffer) {
		TelemetryEvent ret = new TelemetryEvent();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "TelemetryEvent(entityId: " + this.entityId + ", eventId: " + this.eventId + ")";
	}

}