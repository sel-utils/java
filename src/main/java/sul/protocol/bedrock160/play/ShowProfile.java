/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import sul.utils.*;

public class ShowProfile extends Packet {

	public static final int ID = (int)104;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
	}

	public static ShowProfile fromBuffer(byte[] buffer) {
		ShowProfile ret = new ShowProfile();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ShowProfile()";
	}

}