/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java315.xml
 */
package sul.protocol.java315.clientbound;

import sul.utils.*;

public class ServerDifficulty extends Packet {

	public static final int ID = (int)13;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// difficulty
	public static final byte PEACEFUL = (byte)0;
	public static final byte EASY = (byte)1;
	public static final byte NORMAL = (byte)2;
	public static final byte HARD = (byte)3;

	public byte difficulty;

	public ServerDifficulty() {}

	public ServerDifficulty(byte difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(difficulty);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		difficulty=readBigEndianByte();
	}

	public static ServerDifficulty fromBuffer(byte[] buffer) {
		ServerDifficulty ret = new ServerDifficulty();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ServerDifficulty(difficulty: " + this.difficulty + ")";
	}

}