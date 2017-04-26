/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.encapsulated;

import sul.utils.*;

public class ClientCancelConnection extends Packet {

	public static final byte ID = (byte)21;

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
		this.writeBigEndianByte(ID);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
	}

	public static ClientCancelConnection fromBuffer(byte[] buffer) {
		ClientCancelConnection ret = new ClientCancelConnection();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ClientCancelConnection()";
	}

}