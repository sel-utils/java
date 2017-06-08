/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft335.xml
 */
package sul.protocol.minecraft335.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Statistic extends Stream {

	public String name;
	public int value;

	public Statistic() {}

	public Statistic(String name, int value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(value);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeVaruint(value);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		value=this.readVaruint();
	}

	@Override
	public String toString() {
		return "Statistic(name: " + this.name + ", value: " + this.value + ")";
	}


}