/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket113.xml
 */
package sul.protocol.pocket113.play;

import sul.utils.*;

public class ContainerSetSlot extends Packet {

	public static final byte ID = (byte)50;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public int slot;
	public int hotbarSlot;
	public sul.protocol.pocket113.types.Slot item;
	public byte unknown4;

	public ContainerSetSlot() {}

	public ContainerSetSlot(byte window, int slot, int hotbarSlot, sul.protocol.pocket113.types.Slot item, byte unknown4) {
		this.window = window;
		this.slot = slot;
		this.hotbarSlot = hotbarSlot;
		this.item = item;
		this.unknown4 = unknown4;
	}

	@Override
	public int length() {
		return Buffer.varintLength(slot) + Buffer.varintLength(hotbarSlot) + item.length() + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(window);
		this.writeVarint(slot);
		this.writeVarint(hotbarSlot);
		this.writeBytes(item.encode());
		this.writeBigEndianByte(unknown4);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		window=readBigEndianByte();
		slot=this.readVarint();
		hotbarSlot=this.readVarint();
		item=new sul.protocol.pocket113.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
		unknown4=readBigEndianByte();
	}

	public static ContainerSetSlot fromBuffer(byte[] buffer) {
		ContainerSetSlot ret = new ContainerSetSlot();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ContainerSetSlot(window: " + this.window + ", slot: " + this.slot + ", hotbarSlot: " + this.hotbarSlot + ", item: " + this.item.toString() + ", unknown4: " + this.unknown4 + ")";
	}

}