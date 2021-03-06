/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java338.xml
 */
package sul.protocol.java338.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class JoinGame extends Packet {

	public static final int ID = (int)35;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// gamemode
	public static final byte SURVIVAL = (byte)0;
	public static final byte CREATIVE = (byte)1;
	public static final byte ADVENTURE = (byte)2;
	public static final byte SPECTATOR = (byte)3;

	// dimension
	public static final int NETHER = (int)-1;
	public static final int OVERWORLD = (int)0;
	public static final int END = (int)1;

	// difficulty
	public static final byte PEACEFUL = (byte)0;
	public static final byte EASY = (byte)1;
	public static final byte NORMAL = (byte)2;
	public static final byte HARD = (byte)3;

	// level type
	public static final String INFINITY = "default";
	public static final String FLAT = "flat";
	public static final String AMPLIFIED = "amplified";
	public static final String LARGE_BIOMES = "largeBiomes";

	public int entityId;
	public byte gamemode;
	public int dimension;
	public byte difficulty;
	public byte maxPlayers;
	public String levelType;
	public boolean reducedDebug;

	public JoinGame() {}

	public JoinGame(int entityId, byte gamemode, int dimension, byte difficulty, byte maxPlayers, String levelType, boolean reducedDebug) {
		this.entityId = entityId;
		this.gamemode = gamemode;
		this.dimension = dimension;
		this.difficulty = difficulty;
		this.maxPlayers = maxPlayers;
		this.levelType = levelType;
		this.reducedDebug = reducedDebug;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(levelType.getBytes(StandardCharsets.UTF_8).length) + levelType.getBytes(StandardCharsets.UTF_8).length + 13;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(entityId);
		this.writeBigEndianByte(gamemode);
		this.writeBigEndianInt(dimension);
		this.writeBigEndianByte(difficulty);
		this.writeBigEndianByte(maxPlayers);
		byte[] bvzxeb=levelType.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvzxeb.length); this.writeBytes(bvzxeb);
		this.writeBool(reducedDebug);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=readBigEndianInt();
		gamemode=readBigEndianByte();
		dimension=readBigEndianInt();
		difficulty=readBigEndianByte();
		maxPlayers=readBigEndianByte();
		int bvbvzxeb=this.readVaruint(); levelType=new String(this.readBytes(bvbvzxeb), StandardCharsets.UTF_8);
		reducedDebug=this.readBool();
	}

	public static JoinGame fromBuffer(byte[] buffer) {
		JoinGame ret = new JoinGame();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "JoinGame(entityId: " + this.entityId + ", gamemode: " + this.gamemode + ", dimension: " + this.dimension + ", difficulty: " + this.difficulty + ", maxPlayers: " + this.maxPlayers + ", levelType: " + this.levelType + ", reducedDebug: " + this.reducedDebug + ")";
	}

}