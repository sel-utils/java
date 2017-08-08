/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.types;

import sul.utils.*;

public class InventoryAction extends Stream {

	// source
	public static final int CONTAINER = (int)0;
	public static final int WORLD = (int)2;
	public static final int CREATIVE = (int)3;

	public int source;
	public int container = -1;
	public int unknown2;
	public int slot;
	public sul.protocol.pocket131.types.Slot oldItem;
	public sul.protocol.pocket131.types.Slot newItem;

	public InventoryAction() {}

	public InventoryAction(int source, int container, int unknown2, int slot, sul.protocol.pocket131.types.Slot oldItem, sul.protocol.pocket131.types.Slot newItem) {
		this.source = source;
		this.container = container;
		this.unknown2 = unknown2;
		this.slot = slot;
		this.oldItem = oldItem;
		this.newItem = newItem;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(source) + Buffer.varintLength(container) + Buffer.varuintLength(unknown2) + Buffer.varuintLength(slot) + oldItem.length() + newItem.length();
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(source);
		if(source==0){ this.writeVarint(container); }
		if(source==2){ this.writeVaruint(unknown2); }
		this.writeVaruint(slot);
		this.writeBytes(oldItem.encode());
		this.writeBytes(newItem.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		source=this.readVaruint();
		if(source==0){ container=this.readVarint(); }
		if(source==2){ unknown2=this.readVaruint(); }
		slot=this.readVaruint();
		oldItem=new sul.protocol.pocket131.types.Slot(); oldItem._index=this._index; oldItem.decode(this._buffer); this._index=oldItem._index;
		newItem=new sul.protocol.pocket131.types.Slot(); newItem._index=this._index; newItem.decode(this._buffer); this._index=newItem._index;
	}

	@Override
	public String toString() {
		return "InventoryAction(source: " + this.source + ", container: " + this.container + ", unknown2: " + this.unknown2 + ", slot: " + this.slot + ", oldItem: " + this.oldItem.toString() + ", newItem: " + this.newItem.toString() + ")";
	}


}