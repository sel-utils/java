/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Decoration extends Stream {

	public int rotationAndIcon;
	public Tuples.ByteXZ position = new Tuples.ByteXZ();
	public String label;

	/**
	 * ARGB colour.
	 */
	public int color;

	public Decoration() {}

	public Decoration(int rotationAndIcon, Tuples.ByteXZ position, String label, int color) {
		this.rotationAndIcon = rotationAndIcon;
		this.position = position;
		this.label = label;
		this.color = color;
	}

	@Override
	public int length() {
		return Buffer.varintLength(rotationAndIcon) + Buffer.varuintLength(label.getBytes(StandardCharsets.UTF_8).length) + label.getBytes(StandardCharsets.UTF_8).length + 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarint(rotationAndIcon);
		this.writeBigEndianByte(position.x); this.writeBigEndianByte(position.z);
		byte[] bfzw=label.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfzw.length); this.writeBytes(bfzw);
		this.writeLittleEndianInt(color);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		rotationAndIcon=this.readVarint();
		position=new Tuples.ByteXZ(); position.x=readBigEndianByte(); position.z=readBigEndianByte();
		int bvbfzw=this.readVaruint(); label=new String(this.readBytes(bvbfzw), StandardCharsets.UTF_8);
		color=readLittleEndianInt();
	}

	@Override
	public String toString() {
		return "Decoration(rotationAndIcon: " + this.rotationAndIcon + ", position: " + this.position.toString() + ", label: " + this.label + ", color: " + this.color + ")";
	}


}
