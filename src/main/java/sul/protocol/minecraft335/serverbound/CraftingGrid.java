/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft335.xml
 */
package sul.protocol.minecraft335.serverbound;

import java.util.Arrays;

import sul.utils.*;

public class CraftingGrid extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public short action;
	public sul.protocol.minecraft335.types.Entry[] returnEntry = new sul.protocol.minecraft335.types.Entry[0];
	public sul.protocol.minecraft335.types.Entry[] prepareEntry = new sul.protocol.minecraft335.types.Entry[0];

	public CraftingGrid() {}

	public CraftingGrid(byte window, short action, sul.protocol.minecraft335.types.Entry[] returnEntry, sul.protocol.minecraft335.types.Entry[] prepareEntry) {
		this.window = window;
		this.action = action;
		this.returnEntry = returnEntry;
		this.prepareEntry = prepareEntry;
	}

	@Override
	public int length() {
		int length=8; for(sul.protocol.minecraft335.types.Entry cvdjr5ck:returnEntry){ length+=cvdjr5ck.length(); };for(sul.protocol.minecraft335.types.Entry cjcfzvdj:prepareEntry){ length+=cjcfzvdj.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(action);
		this.writeBigEndianShort((short)returnEntry.length); for(sul.protocol.minecraft335.types.Entry cvdjr5ck:returnEntry){ this.writeBytes(cvdjr5ck.encode()); }
		this.writeBigEndianShort((short)prepareEntry.length); for(sul.protocol.minecraft335.types.Entry cjcfzvdj:prepareEntry){ this.writeBytes(cjcfzvdj.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		action=readBigEndianShort();
		int bjdvbvdj=readBigEndianShort(); returnEntry=new sul.protocol.minecraft335.types.Entry[bjdvbvdj]; for(int cvdjr5ck=0;cvdjr5ck<returnEntry.length;cvdjr5ck++){ returnEntry[cvdjr5ck]=new sul.protocol.minecraft335.types.Entry(); returnEntry[cvdjr5ck]._index=this._index; returnEntry[cvdjr5ck].decode(this._buffer); this._index=returnEntry[cvdjr5ck]._index; }
		int bbzbcvbr=readBigEndianShort(); prepareEntry=new sul.protocol.minecraft335.types.Entry[bbzbcvbr]; for(int cjcfzvdj=0;cjcfzvdj<prepareEntry.length;cjcfzvdj++){ prepareEntry[cjcfzvdj]=new sul.protocol.minecraft335.types.Entry(); prepareEntry[cjcfzvdj]._index=this._index; prepareEntry[cjcfzvdj].decode(this._buffer); this._index=prepareEntry[cjcfzvdj]._index; }
	}

	public static CraftingGrid fromBuffer(byte[] buffer) {
		CraftingGrid ret = new CraftingGrid();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CraftingGrid(window: " + this.window + ", action: " + this.action + ", returnEntry: " + Arrays.deepToString(this.returnEntry) + ", prepareEntry: " + Arrays.deepToString(this.prepareEntry) + ")";
	}

}