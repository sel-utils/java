/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import java.util.Arrays;

import sul.utils.*;

public class ContainerSetContent extends Packet {

	public static final byte ID = (byte)52;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public sul.protocol.pocket102.types.Slot[] slots = new sul.protocol.pocket102.types.Slot[0];
	public int[] hotbar = new int[0];

	public ContainerSetContent() {}

	public ContainerSetContent(byte window, sul.protocol.pocket102.types.Slot[] slots, int[] hotbar) {
		this.window = window;
		this.slots = slots;
		this.hotbar = hotbar;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(slots.length) + Buffer.varuintLength(hotbar.length) + 2; for(sul.protocol.pocket102.types.Slot cxdm:slots){ length+=cxdm.length(); };for(int a9yf:hotbar){ length+=Buffer.varintLength(a9yf); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(window);
		this.writeVaruint((int)slots.length); for(sul.protocol.pocket102.types.Slot cxdm:slots){ this.writeBytes(cxdm.encode()); }
		this.writeVaruint((int)hotbar.length); for(int a9yf:hotbar){ this.writeVarint(a9yf); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		window=readBigEndianByte();
		int bnbr=this.readVaruint(); slots=new sul.protocol.pocket102.types.Slot[bnbr]; for(int cxdm=0;cxdm<slots.length;cxdm++){ slots[cxdm]=new sul.protocol.pocket102.types.Slot(); slots[cxdm]._index=this._index; slots[cxdm].decode(this._buffer); this._index=slots[cxdm]._index; }
		int bhdjc=this.readVaruint(); hotbar=new int[bhdjc]; for(int a9yf=0;a9yf<hotbar.length;a9yf++){ hotbar[a9yf]=this.readVarint(); }
	}

	public static ContainerSetContent fromBuffer(byte[] buffer) {
		ContainerSetContent ret = new ContainerSetContent();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ContainerSetContent(window: " + this.window + ", slots: " + Arrays.deepToString(this.slots) + ", hotbar: " + Arrays.toString(this.hotbar) + ")";
	}

}