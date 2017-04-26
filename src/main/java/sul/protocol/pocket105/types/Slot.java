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

/**
 * Informations about a slot, that, if not empty, contains an item id and meta, the
 * count (0-255) and, optionally, an nbt tag for enchantments, custom name, colours
 * and more.
 */
public class Slot extends Stream {

	/**
	 * Item's id or 0 if the slot is empty.
	 */
	public int id;

	/**
	 * Item's meta or uses (unsigned short) left-shifted 8 times and the count (unisgned
	 * byte).
	 * Examples:
	 * <code>
	 * var encoded = item.meta << 8 | item.count
	 * var meta = encoded >> 8
	 * var count = count & 255
	 * </code>
	 */
	public int metaAndCount;

	/**
	 * Optional nbt data encoded as a nameless little-endian compound tag.
	 */
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