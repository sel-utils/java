/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import sul.utils.*;

/**
 * Packet sent as response to Login to indicate whether the connection has been accepted
 * and when the player is ready to spawn in the world.
 */
public class PlayStatus extends Packet {

	public static final byte ID = (byte)2;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// status
	public static final int OK = 0;
	public static final int OUTDATED_CLIENT = 1;
	public static final int OUTDATED_SERVER = 2;
	public static final int SPAWNED = 3;
	public static final int INVALID_TENANT = 4;
	public static final int EDITION_MISMATCH = 5;

	public int status;

	public PlayStatus() {}

	public PlayStatus(int status) {
		this.status = status;
	}

	@Override
	public int length() {
		return 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianInt(status);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		status=readBigEndianInt();
	}

	public static PlayStatus fromBuffer(byte[] buffer) {
		PlayStatus ret = new PlayStatus();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayStatus(status: " + this.status + ")";
	}

}