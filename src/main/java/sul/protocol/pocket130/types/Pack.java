/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket130.xml
 */
package sul.protocol.pocket130.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Pack extends Stream {

	public String id;
	public String version;

	public Pack() {}

	public Pack(String id, String version) {
		this.id = id;
		this.version = version;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id.getBytes(StandardCharsets.UTF_8).length) + id.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(version.getBytes(StandardCharsets.UTF_8).length) + version.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] aq=id.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aq.length); this.writeBytes(aq);
		byte[] dvclb=version.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvclb.length); this.writeBytes(dvclb);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvaq=this.readVaruint(); id=new String(this.readBytes(bvaq), StandardCharsets.UTF_8);
		int bvdvclb=this.readVaruint(); version=new String(this.readBytes(bvdvclb), StandardCharsets.UTF_8);
	}

	@Override
	public String toString() {
		return "Pack(id: " + this.id + ", version: " + this.version + ")";
	}


}