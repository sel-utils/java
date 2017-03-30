/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import sul.utils.*;

/**
 * Reply sent after the ConnectionRequest packet if the node's ip has been accepted.
 * It indicates the status of the connection.
 */
public class ConnectionResponse extends Packet {

	public static final byte ID = (byte)2;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// status
	public static final byte OK = 0;
	public static final byte OUTDATED_HUB = 1;
	public static final byte OUTDATED_NODE = 2;
	public static final byte PASSWORD_REQUIRED = 3;
	public static final byte WRONG_PASSWORD = 4;
	public static final byte INVALID_NAME_LENGTH = 5;
	public static final byte INVALID_NAME_CHARACTERS = 6;
	public static final byte NAME_ALREADY_USED = 7;
	public static final byte NAME_RESERVED = 8;

	/**
	 * Indicates the status of connection. If not 0, it indicates an error.
	 */
	public byte status;

	/**
	 * Indicates the version of the protocol used by the hub when the status code indicates
	 * that the hub or the node is obsolete.
	 */
	public int protocol;

	public ConnectionResponse() {}

	public ConnectionResponse(byte status, int protocol) {
		this.status = status;
		this.protocol = protocol;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(protocol) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(status);
		if(status==1||status==2){ this.writeVaruint(protocol); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		status=readBigEndianByte();
		if(status==1||status==2){ protocol=this.readVaruint(); }
	}

	public static ConnectionResponse fromBuffer(byte[] buffer) {
		ConnectionResponse ret = new ConnectionResponse();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ConnectionResponse(status: " + this.status + ", protocol: " + this.protocol + ")";
	}

}