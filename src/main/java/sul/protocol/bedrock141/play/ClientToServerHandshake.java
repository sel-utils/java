/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.play;

import sul.utils.*;

public class ClientToServerHandshake extends Packet {

	public static final int ID = (int)4;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

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
		this.writeVaruint(ID);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
	}

	public static ClientToServerHandshake fromBuffer(byte[] buffer) {
		ClientToServerHandshake ret = new ClientToServerHandshake();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ClientToServerHandshake()";
	}

}