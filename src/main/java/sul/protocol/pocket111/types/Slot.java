/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket111.xml
 */
package sul.protocol.pocket111.types;

import java.nio.charset.StandardCharsets;
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
	public String[] canPlaceOn = new String[0];
	public String[] canDestroy = new String[0];

	public Slot() {}

	public Slot(int id, int metaAndCount, byte[] nbt, String[] canPlaceOn, String[] canDestroy) {
		this.id = id;
		this.metaAndCount = metaAndCount;
		this.nbt = nbt;
		this.canPlaceOn = canPlaceOn;
		this.canDestroy = canDestroy;
	}

	@Override
	public int length() {
		int length=Buffer.varintLength(id) + Buffer.varintLength(metaAndCount) + nbt.length + Buffer.varuintLength(canPlaceOn.length) + Buffer.varuintLength(canDestroy.length) + 2; for(String yfuxyvb:canPlaceOn){ length+=Buffer.varuintLength(yfuxyvb.getBytes(StandardCharsets.UTF_8).length)+yfuxyvb.getBytes(StandardCharsets.UTF_8).length; };for(String yfrvdje:canDestroy){ length+=Buffer.varuintLength(yfrvdje.getBytes(StandardCharsets.UTF_8).length)+yfrvdje.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarint(id);
		if(id>0){ this.writeVarint(metaAndCount); }
		if(id>0){ this.writeLittleEndianShort((short)nbt.length); this.writeBytes(nbt); }
		this.writeVaruint((int)canPlaceOn.length); for(String yfuxyvb:canPlaceOn){ byte[] ezely=yfuxyvb.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)ezely.length); this.writeBytes(ezely); }
		this.writeVaruint((int)canDestroy.length); for(String yfrvdje:canDestroy){ byte[] ezdrz=yfrvdje.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)ezdrz.length); this.writeBytes(ezdrz); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		id=this.readVarint();
		if(id>0){ metaAndCount=this.readVarint(); }
		if(id>0){ int b5d=readLittleEndianShort(); nbt=this.readBytes(b5d); }
		int bnbbynt4=this.readVaruint(); canPlaceOn=new String[bnbbynt4]; for(int yfuxyvb=0;yfuxyvb<canPlaceOn.length;yfuxyvb++){ int bvyfuxyv=this.readVaruint(); canPlaceOn[yfuxyvb]=new String(this.readBytes(bvyfuxyv), StandardCharsets.UTF_8); }
		int bnbrcrbk=this.readVaruint(); canDestroy=new String[bnbrcrbk]; for(int yfrvdje=0;yfrvdje<canDestroy.length;yfrvdje++){ int bvyfrvdj=this.readVaruint(); canDestroy[yfrvdje]=new String(this.readBytes(bvyfrvdj), StandardCharsets.UTF_8); }
	}

	@Override
	public String toString() {
		return "Slot(id: " + this.id + ", metaAndCount: " + this.metaAndCount + ", nbt: " + Arrays.toString(this.nbt) + ", canPlaceOn: " + Arrays.deepToString(this.canPlaceOn) + ", canDestroy: " + Arrays.deepToString(this.canDestroy) + ")";
	}


}