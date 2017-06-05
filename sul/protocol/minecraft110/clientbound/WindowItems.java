/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class WindowItems extends Packet {

	public static final int ID = (int)20;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public sul.protocol.minecraft110.types.Slot[] slots = new sul.protocol.minecraft110.types.Slot[0];

	public WindowItems() {}

	public WindowItems(byte window, sul.protocol.minecraft110.types.Slot[] slots) {
		this.window = window;
		this.slots = slots;
	}

	@Override
	public int length() {
		int length=4; for(sul.protocol.minecraft110.types.Slot cxdm:slots){ length+=cxdm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort((short)slots.length); for(sul.protocol.minecraft110.types.Slot cxdm:slots){ this.writeBytes(cxdm.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		int bnbr=readBigEndianShort(); slots=new sul.protocol.minecraft110.types.Slot[bnbr]; for(int cxdm=0;cxdm<slots.length;cxdm++){ slots[cxdm]=new sul.protocol.minecraft110.types.Slot(); slots[cxdm]._index=this._index; slots[cxdm].decode(this._buffer); this._index=slots[cxdm]._index; }
	}

	public static WindowItems fromBuffer(byte[] buffer) {
		WindowItems ret = new WindowItems();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "WindowItems(window: " + this.window + ", slots: " + Arrays.deepToString(this.slots) + ")";
	}

}