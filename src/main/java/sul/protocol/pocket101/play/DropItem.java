/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

public class DropItem extends Packet {

	public static final byte ID = (byte)46;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte DROP = 0;

	public byte action;
	public sul.protocol.pocket101.types.Slot item;

	public DropItem() {}

	public DropItem(byte action, sul.protocol.pocket101.types.Slot item) {
		this.action = action;
		this.item = item;
	}

	@Override
	public int length() {
		return item.length() + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(action);
		this.writeBytes(item.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=readBigEndianByte();
		item=new sul.protocol.pocket101.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static DropItem fromBuffer(byte[] buffer) {
		DropItem ret = new DropItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "DropItem(action: " + this.action + ", item: " + this.item.toString() + ")";
	}

}