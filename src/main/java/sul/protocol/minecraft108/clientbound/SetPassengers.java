/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class SetPassengers extends Packet {

	public static final int ID = (int)64;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public int[] passengers = new int[0];

	public SetPassengers() {}

	public SetPassengers(int entityId, int[] passengers) {
		this.entityId = entityId;
		this.passengers = passengers;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(entityId) + Buffer.varuintLength(passengers.length) + 2; for(int cfcvzvc:passengers){ length+=Buffer.varuintLength(cfcvzvc); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeVaruint((int)passengers.length); for(int cfcvzvc:passengers){ this.writeVaruint(cfcvzvc); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		int bbcnbdcm=this.readVaruint(); passengers=new int[bbcnbdcm]; for(int cfcvzvc=0;cfcvzvc<passengers.length;cfcvzvc++){ passengers[cfcvzvc]=this.readVaruint(); }
	}

	public static SetPassengers fromBuffer(byte[] buffer) {
		SetPassengers ret = new SetPassengers();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetPassengers(entityId: " + this.entityId + ", passengers: " + Arrays.toString(this.passengers) + ")";
	}

}