/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java338.xml
 */
package sul.protocol.java338.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class OpenWindow extends Packet {

	public static final int ID = (int)19;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public String type;
	public String title;
	public byte slots;

	public OpenWindow() {}

	public OpenWindow(byte window, String type, String title, byte slots) {
		this.window = window;
		this.type = type;
		this.title = title;
		this.slots = slots;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(type.getBytes(StandardCharsets.UTF_8).length) + type.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		byte[] dlz=type.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dlz.length); this.writeBytes(dlz);
		byte[] dlbu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dlbu.length); this.writeBytes(dlbu);
		this.writeBigEndianByte(slots);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		int bvdlz=this.readVaruint(); type=new String(this.readBytes(bvdlz), StandardCharsets.UTF_8);
		int bvdlbu=this.readVaruint(); title=new String(this.readBytes(bvdlbu), StandardCharsets.UTF_8);
		slots=readBigEndianByte();
	}

	public static OpenWindow fromBuffer(byte[] buffer) {
		OpenWindow ret = new OpenWindow();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "OpenWindow(window: " + this.window + ", type: " + this.type + ", title: " + this.title + ", slots: " + this.slots + ")";
	}

}