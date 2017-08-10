/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket132.xml
 */
package sul.protocol.pocket132.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Parameter extends Stream {

	public String name;
	public int type;
	public boolean optional;

	public Parameter() {}

	public Parameter(String name, int type, boolean optional) {
		this.name = name;
		this.type = type;
		this.optional = optional;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeLittleEndianInt(type);
		this.writeBool(optional);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		type=readLittleEndianInt();
		optional=this.readBool();
	}

	@Override
	public String toString() {
		return "Parameter(name: " + this.name + ", type: " + this.type + ", optional: " + this.optional + ")";
	}


}