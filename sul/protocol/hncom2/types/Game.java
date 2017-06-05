/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.types;

import java.util.Arrays;

import sul.utils.*;

/**
 * Indicates a game and informations about its accepted protocols.
 */
public class Game extends Stream {

	// type
	public static final byte POCKET = 1;
	public static final byte MINECRAFT = 2;
	public static final byte CONSOLE = 3;

	/**
	 * Identifier of the game.
	 */
	public byte type;

	/**
	 * Protocols accepted by the server for the game. They should be ordered from oldest
	 * to newest.
	 */
	public int[] protocols = new int[0];

	public Game() {}

	public Game(byte type, int[] protocols) {
		this.type = type;
		this.protocols = protocols;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(protocols.length) + 1; for(int cjd9bx:protocols){ length+=Buffer.varuintLength(cjd9bx); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(type);
		this.writeVaruint((int)protocols.length); for(int cjd9bx:protocols){ this.writeVaruint(cjd9bx); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		type=readBigEndianByte();
		int bbbry9c=this.readVaruint(); protocols=new int[bbbry9c]; for(int cjd9bx=0;cjd9bx<protocols.length;cjd9bx++){ protocols[cjd9bx]=this.readVaruint(); }
	}

	@Override
	public String toString() {
		return "Game(type: " + this.type + ", protocols: " + Arrays.toString(this.protocols) + ")";
	}


}