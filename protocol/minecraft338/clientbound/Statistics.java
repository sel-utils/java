/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft338.xml
 */
package sul.protocol.minecraft338.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class Statistics extends Packet {

	public static final int ID = (int)7;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public sul.protocol.minecraft338.types.Statistic[] statistics = new sul.protocol.minecraft338.types.Statistic[0];

	public Statistics() {}

	public Statistics(sul.protocol.minecraft338.types.Statistic[] statistics) {
		this.statistics = statistics;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(statistics.length) + 1; for(sul.protocol.minecraft338.types.Statistic crdldlc:statistics){ length+=crdldlc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)statistics.length); for(sul.protocol.minecraft338.types.Statistic crdldlc:statistics){ this.writeBytes(crdldlc.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bnyrcrym=this.readVaruint(); statistics=new sul.protocol.minecraft338.types.Statistic[bnyrcrym]; for(int crdldlc=0;crdldlc<statistics.length;crdldlc++){ statistics[crdldlc]=new sul.protocol.minecraft338.types.Statistic(); statistics[crdldlc]._index=this._index; statistics[crdldlc].decode(this._buffer); this._index=statistics[crdldlc]._index; }
	}

	public static Statistics fromBuffer(byte[] buffer) {
		Statistics ret = new Statistics();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Statistics(statistics: " + Arrays.deepToString(this.statistics) + ")";
	}

}