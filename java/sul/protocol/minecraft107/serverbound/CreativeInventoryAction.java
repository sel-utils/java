/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.serverbound;

import sul.utils.*;

public class CreativeInventoryAction extends Packet {

	public static final int ID = (int)24;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public short slot;
	public sul.protocol.minecraft107.types.Slot clickedItem;

	public CreativeInventoryAction() {}

	public CreativeInventoryAction(short slot, sul.protocol.minecraft107.types.Slot clickedItem) {
		this.slot = slot;
		this.clickedItem = clickedItem;
	}

	@Override
	public int length() {
		return clickedItem.length() + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianShort(slot);
		this.writeBytes(clickedItem.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		slot=readBigEndianShort();
		clickedItem=new sul.protocol.minecraft107.types.Slot(); clickedItem._index=this._index; clickedItem.decode(this._buffer); this._index=clickedItem._index;
	}

	public static CreativeInventoryAction fromBuffer(byte[] buffer) {
		CreativeInventoryAction ret = new CreativeInventoryAction();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CreativeInventoryAction(slot: " + this.slot + ", clickedItem: " + this.clickedItem.toString() + ")";
	}

}
