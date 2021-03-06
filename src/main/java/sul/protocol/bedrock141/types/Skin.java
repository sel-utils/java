/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.types;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class Skin extends Stream {

	public String name;
	public byte[] data = new byte[0];
	public byte[] capeData = new byte[0];
	public String geometryName;
	public byte[] geometryData = new byte[0];

	public Skin() {}

	public Skin(String name, byte[] data, byte[] capeData, String geometryName, byte[] geometryData) {
		this.name = name;
		this.data = data;
		this.capeData = capeData;
		this.geometryName = geometryName;
		this.geometryData = geometryData;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(data.length) + data.length + Buffer.varuintLength(capeData.length) + capeData.length + Buffer.varuintLength(geometryName.getBytes(StandardCharsets.UTF_8).length) + geometryName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(geometryData.length) + geometryData.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		this.writeVaruint((int)capeData.length); this.writeBytes(capeData);
		byte[] zvbvcly1=geometryName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zvbvcly1.length); this.writeBytes(zvbvcly1);
		this.writeVaruint((int)geometryData.length); this.writeBytes(geometryData);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		int brde=this.readVaruint(); data=this.readBytes(brde);
		int bncvyr=this.readVaruint(); capeData=this.readBytes(bncvyr);
		int bvzvbvcl=this.readVaruint(); geometryName=new String(this.readBytes(bvzvbvcl), StandardCharsets.UTF_8);
		int bdb1djrf=this.readVaruint(); geometryData=this.readBytes(bdb1djrf);
	}

	@Override
	public String toString() {
		return "Skin(name: " + this.name + ", data: " + Arrays.toString(this.data) + ", capeData: " + Arrays.toString(this.capeData) + ", geometryName: " + this.geometryName + ", geometryData: " + Arrays.toString(this.geometryData) + ")";
	}


}