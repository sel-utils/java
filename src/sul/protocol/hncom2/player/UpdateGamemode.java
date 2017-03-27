/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.player;

import sul.utils.*;

/**
 * The client (node) always send a confirmation to the hub when this packet is received.
 */
public class UpdateGamemode extends Packet {

	public static final byte ID = (byte)25;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int hubId;
	public byte gamemode;

	public UpdateGamemode() {}

	public UpdateGamemode(int hubId, byte gamemode) {
		this.hubId = hubId;
		this.gamemode = gamemode;
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
		this.writeBigEndianByte(gamemode);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		gamemode=readBigEndianByte();
	}

	public static UpdateGamemode fromBuffer(byte[] buffer) {
		UpdateGamemode ret = new UpdateGamemode();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateGamemode(hubId: " + this.hubId + ", gamemode: " + this.gamemode + ")";
	}

}
