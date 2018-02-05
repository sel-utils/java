/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock150.xml
 */
package sul.protocol.bedrock150.play;

import sul.utils.*;

public class SetPlayerGameType extends Packet {

	public static final int ID = (int)62;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// gamemode
	public static final int SURVIVAL = (int)0;
	public static final int CREATIVE = (int)1;
	public static final int ADVENTURE = (int)2;

	public int gamemode;

	public SetPlayerGameType() {}

	public SetPlayerGameType(int gamemode) {
		this.gamemode = gamemode;
	}

	@Override
	public int length() {
		return Buffer.varintLength(gamemode) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarint(gamemode);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		gamemode=this.readVarint();
	}

	public static SetPlayerGameType fromBuffer(byte[] buffer) {
		SetPlayerGameType ret = new SetPlayerGameType();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetPlayerGameType(gamemode: " + this.gamemode + ")";
	}

}