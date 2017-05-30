/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft333.xml
 */
package sul.protocol.minecraft333.types;

import sul.utils.*;

public class Entry extends Stream {

	public sul.protocol.minecraft333.types.Slot item;
	public byte craftingSlot;
	public byte playerSlot;

	public Entry() {}

	public Entry(sul.protocol.minecraft333.types.Slot item, byte craftingSlot, byte playerSlot) {
		this.item = item;
		this.craftingSlot = craftingSlot;
		this.playerSlot = playerSlot;
	}

	@Override
	public int length() {
		return item.length() + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBytes(item.encode());
		this.writeBigEndianByte(craftingSlot);
		this.writeBigEndianByte(playerSlot);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		item=new sul.protocol.minecraft333.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
		craftingSlot=readBigEndianByte();
		playerSlot=readBigEndianByte();
	}

	@Override
	public String toString() {
		return "Entry(item: " + this.item.toString() + ", craftingSlot: " + this.craftingSlot + ", playerSlot: " + this.playerSlot + ")";
	}


}