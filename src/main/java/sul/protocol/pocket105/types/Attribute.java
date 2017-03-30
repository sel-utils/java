/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Attribute extends Stream {

	public float min;
	public float max;
	public float value;
	public float def;
	public String name;

	public Attribute() {}

	public Attribute(float min, float max, float value, float def, String name) {
		this.min = min;
		this.max = max;
		this.value = value;
		this.def = def;
		this.name = name;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 16;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeLittleEndianFloat(min);
		this.writeLittleEndianFloat(max);
		this.writeLittleEndianFloat(value);
		this.writeLittleEndianFloat(def);
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		min=readLittleEndianFloat();
		max=readLittleEndianFloat();
		value=readLittleEndianFloat();
		def=readLittleEndianFloat();
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
	}

	@Override
	public String toString() {
		return "Attribute(min: " + this.min + ", max: " + this.max + ", value: " + this.value + ", def: " + this.def + ", name: " + this.name + ")";
	}


}