/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock150.xml
 */
package sul.protocol.bedrock150.play;

import sul.utils.*;

public class GuiDataPickItem extends Packet {

	public static final int ID = (int)54;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int slot;

	public GuiDataPickItem() {}

	public GuiDataPickItem(int slot) {
		this.slot = slot;
	}

	@Override
	public int length() {
		return 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeLittleEndianInt(slot);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		slot=readLittleEndianInt();
	}

	public static GuiDataPickItem fromBuffer(byte[] buffer) {
		GuiDataPickItem ret = new GuiDataPickItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "GuiDataPickItem(slot: " + this.slot + ")";
	}

}