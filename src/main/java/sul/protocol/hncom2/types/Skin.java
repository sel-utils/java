/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.types;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Player's skin that will be sent to Minecraft: Pocket Edition clients.
 * If the server only allows Minecraft players this type's fields should be empty.
 */
public class Skin extends Stream {

	/**
	 * Name of the skin.
	 */
	public String name;

	/**
	 * RGBA map of the skin colours. Length should be, if the skin is not empty, 8192 (64x32)
	 * or 16384 (64x64) bytes.
	 */
	public byte[] data = new byte[0];

	public Skin() {}

	public Skin(String name, byte[] data) {
		this.name = name;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(data.length) + data.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		int brde=this.readVaruint(); data=this.readBytes(brde);
	}

	@Override
	public String toString() {
		return "Skin(name: " + this.name + ", data: " + Arrays.toString(this.data) + ")";
	}


}