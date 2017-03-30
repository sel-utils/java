/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.status;

import sul.utils.*;

/**
 * Updates the number of players on the server.
 */
public class Players extends Packet {

	public static final byte ID = (byte)9;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// max
	public static final int UNLIMITED = -1;

	/**
	 * Players currently online in the whole server (connected to a node).
	 */
	public int online;

	/**
	 * Maximum number of players that can connect to server.
	 */
	public int max;

	public Players() {}

	public Players(int online, int max) {
		this.online = online;
		this.max = max;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(online) + Buffer.varintLength(max) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(online);
		this.writeVarint(max);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		online=this.readVaruint();
		max=this.readVarint();
	}

	public static Players fromBuffer(byte[] buffer) {
		Players ret = new Players();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Players(online: " + this.online + ", max: " + this.max + ")";
	}

}