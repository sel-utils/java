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

import sul.utils.*;

public class Motd extends Stream {

	// type
	public static final byte POCKET = 1;
	public static final byte MINECRAFT = 2;
	public static final byte CONSOLE = 3;

	public byte type;
	public String motd;

	public Motd() {}

	public Motd(byte type, String motd) {
		this.type = type;
		this.motd = motd;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(motd.getBytes(StandardCharsets.UTF_8).length) + motd.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(type);
		byte[] b9z=motd.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)b9z.length); this.writeBytes(b9z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		type=readBigEndianByte();
		int bvb9z=this.readVaruint(); motd=new String(this.readBytes(bvb9z), StandardCharsets.UTF_8);
	}

	@Override
	public String toString() {
		return "Motd(type: " + this.type + ", motd: " + this.motd + ")";
	}


}
