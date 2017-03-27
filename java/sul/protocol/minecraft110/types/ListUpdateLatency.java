/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.types;

import java.util.UUID;

import sul.utils.*;

public class ListUpdateLatency extends Stream {

	public UUID uuid;
	public int latency;

	public ListUpdateLatency() {}

	public ListUpdateLatency(UUID uuid, int latency) {
		this.uuid = uuid;
		this.latency = latency;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(latency) + 16;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeVaruint(latency);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		latency=this.readVaruint();
	}

	@Override
	public String toString() {
		return "ListUpdateLatency(uuid: " + this.uuid.toString() + ", latency: " + this.latency + ")";
	}


}
