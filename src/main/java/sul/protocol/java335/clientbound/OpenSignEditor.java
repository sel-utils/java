/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java335.xml
 */
package sul.protocol.java335.clientbound;

import sul.utils.*;

public class OpenSignEditor extends Packet {

	public static final int ID = (int)42;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long position;

	public OpenSignEditor() {}

	public OpenSignEditor(long position) {
		this.position = position;
	}

	@Override
	public int length() {
		return 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
	}

	public static OpenSignEditor fromBuffer(byte[] buffer) {
		OpenSignEditor ret = new OpenSignEditor();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "OpenSignEditor(position: " + this.position + ")";
	}

}