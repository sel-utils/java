/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket130.xml
 */
package sul.protocol.pocket130.play;

import sul.utils.*;

public class StructureBlockUpdate extends Packet {

	public static final byte ID = (byte)90;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	@Override
	public int length() {
		return 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
	}

	public static StructureBlockUpdate fromBuffer(byte[] buffer) {
		StructureBlockUpdate ret = new StructureBlockUpdate();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "StructureBlockUpdate()";
	}

}