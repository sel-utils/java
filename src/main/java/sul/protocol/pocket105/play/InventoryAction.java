/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import sul.utils.*;

public class InventoryAction extends Packet {

	public static final byte ID = (byte)48;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int action;
	public sul.protocol.pocket105.types.Slot item;

	public InventoryAction() {}

	public InventoryAction(int action, sul.protocol.pocket105.types.Slot item) {
		this.action = action;
		this.item = item;
	}

	@Override
	public int length() {
		return Buffer.varintLength(action) + item.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(action);
		this.writeBytes(item.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=this.readVarint();
		item=new sul.protocol.pocket105.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static InventoryAction fromBuffer(byte[] buffer) {
		InventoryAction ret = new InventoryAction();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "InventoryAction(action: " + this.action + ", item: " + this.item.toString() + ")";
	}

}