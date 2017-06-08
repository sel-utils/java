/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft335.xml
 */
package sul.protocol.minecraft.clientbound;

import sul.utils.*;

public class CloseWindow extends Packet {

	public static final int ID = (int)18;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;

	public CloseWindow() {}

	public CloseWindow(byte window) {
		this.window = window;
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
	}

	public static CloseWindow fromBuffer(byte[] buffer) {
		CloseWindow ret = new CloseWindow();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CloseWindow(window: " + this.window + ")";
	}

}