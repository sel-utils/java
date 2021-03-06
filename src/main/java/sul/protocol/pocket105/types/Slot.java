/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.types;

import java.util.Arrays;

import sul.utils.*;

public class Slot extends Stream {

	public int id;
	public int metaAndCount;
	public byte[] nbt = new byte[0];

	public Slot() {}

	public Slot(int id, int metaAndCount, byte[] nbt) {
		this.id = id;
		this.metaAndCount = metaAndCount;
		this.nbt = nbt;
	}

	@Override
	public int length() {
		return Buffer.varintLength(id) + Buffer.varintLength(metaAndCount) + nbt.length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarint(id);
		if(id>0){ this.writeVarint(metaAndCount); }
		if(id>0){ this.writeLittleEndianShort((short)nbt.length); this.writeBytes(nbt); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		id=this.readVarint();
		if(id>0){ metaAndCount=this.readVarint(); }
		if(id>0){ int b5d=readLittleEndianShort(); nbt=this.readBytes(b5d); }
	}

	@Override
	public String toString() {
		return "Slot(id: " + this.id + ", metaAndCount: " + this.metaAndCount + ", nbt: " + Arrays.toString(this.nbt) + ")";
	}


}