/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket112.xml
 */
package sul.protocol.pocket112.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class PackWithSize extends Stream {

	public String id;
	public String version;
	public long size;

	public PackWithSize() {}

	public PackWithSize(String id, String version, long size) {
		this.id = id;
		this.version = version;
		this.size = size;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id.getBytes(StandardCharsets.UTF_8).length) + id.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(version.getBytes(StandardCharsets.UTF_8).length) + version.getBytes(StandardCharsets.UTF_8).length + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] aq=id.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aq.length); this.writeBytes(aq);
		byte[] dvclb=version.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvclb.length); this.writeBytes(dvclb);
		this.writeLittleEndianLong(size);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvaq=this.readVaruint(); id=new String(this.readBytes(bvaq), StandardCharsets.UTF_8);
		int bvdvclb=this.readVaruint(); version=new String(this.readBytes(bvdvclb), StandardCharsets.UTF_8);
		size=readLittleEndianLong();
	}

	@Override
	public String toString() {
		return "PackWithSize(id: " + this.id + ", version: " + this.version + ", size: " + this.size + ")";
	}


}