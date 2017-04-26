/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.player;

import sul.utils.*;

/**
 * Removes a player from the node. If the player is removed using Kick or Transfer
 * this packet is not sent.
 */
public class Remove extends Packet {

	public static final byte ID = (byte)18;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// reason
	public static final byte LEFT = 0;
	public static final byte TIMED_OUT = 1;
	public static final byte KICKED = 2;
	public static final byte TRANSFERRED = 3;

	public int hubId;

	/**
	 * Reason of the disconnection.
	 */
	public byte reason;

	public Remove() {}

	public Remove(int hubId, byte reason) {
		this.hubId = hubId;
		this.reason = reason;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		this.writeBigEndianByte(reason);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		reason=readBigEndianByte();
	}

	public static Remove fromBuffer(byte[] buffer) {
		Remove ret = new Remove();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Remove(hubId: " + this.hubId + ", reason: " + this.reason + ")";
	}

}