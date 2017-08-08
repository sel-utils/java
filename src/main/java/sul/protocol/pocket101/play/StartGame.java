/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class StartGame extends Packet {

	public static final byte ID = (byte)12;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// dimension
	public static final int OVERWORLD = (int)0;
	public static final int NETHER = (int)1;
	public static final int END = (int)2;

	// generator
	public static final int OLD = (int)0;
	public static final int INFINITE = (int)1;
	public static final int FLAT = (int)2;

	// world gamemode
	public static final int SURVIVAL = (int)0;
	public static final int CREATIVE = (int)1;

	// difficulty
	public static final int PEACEFUL = (int)0;
	public static final int EASY = (int)1;
	public static final int NORMAL = (int)2;
	public static final int HARD = (int)3;

	// edition
	public static final byte CLASSIC = (byte)0;
	public static final byte EDUCATION = (byte)1;

	/**
	 * Player's entity id that uniquely identifies the entity of the server.
	 */
	public long entityId;
	public long runtimeId;

	/**
	 * Position where the player will spawn.
	 */
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public float yaw;
	public float pitch;

	/**
	 * World's seed. It's displayed in the game's world settings and in beta's debug informations
	 * on top of the screen.
	 */
	public int seed;

	/**
	 * World's dimension. Different dimensions have different sky colours and render distances.
	 */
	public int dimension = 0;

	/**
	 * World's type. It's displayed in the game's world settings.
	 * In old and infinite world the sky becomes darker at 32 blocks of altitude and in
	 * flat worlds it only becomes darker under 0.
	 */
	public int generator = 1;

	/**
	 * Default's world gamemode. If the player's gamemode is different from the default's
	 * one a SetPlayerGameType should be sent after this.
	 */
	public int worldGamemode;

	/**
	 * World's difficulty. The value is visible in the client's world settings.
	 */
	public int difficulty;

	/**
	 * Position where the client's compass will point to.
	 */
	public Tuples.IntXYZ spawnPosition = new Tuples.IntXYZ();
	public boolean loadedInCreative;

	/**
	 * Time of the day that should be in a range from 0 to 24000. If not the absolute value
	 * is moduled per 24000.
	 * If the world's time is stopped a SetTime packet should be sent after this.
	 */
	public int time;

	/**
	 * Game's edition. Some behaviours (some entities for example) may only work in a version
	 * and not in the other.
	 */
	public byte edition;

	/**
	 * Intensity of the rain or the snow. Any value lower than or equals to 0 means no
	 * rain.
	 */
	public float rainLevel;
	public float lightningLevel;

	/**
	 * Indicates whether the cheats are enabled. If the cheats are disabled the player
	 * cannot send commands.
	 */
	public boolean commandsEnabled;
	public boolean textureRequired;
	public String levelId;

	/**
	 * World's name that will be displayed in the game's world settings. It can contain
	 * formatting codes.
	 */
	public String worldName;

	public StartGame() {}

	public StartGame(long entityId, long runtimeId, Tuples.FloatXYZ position, float yaw, float pitch, int seed, int dimension, int generator, int worldGamemode, int difficulty, Tuples.IntXYZ spawnPosition, boolean loadedInCreative, int time, byte edition, float rainLevel, float lightningLevel, boolean commandsEnabled, boolean textureRequired, String levelId, String worldName) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.seed = seed;
		this.dimension = dimension;
		this.generator = generator;
		this.worldGamemode = worldGamemode;
		this.difficulty = difficulty;
		this.spawnPosition = spawnPosition;
		this.loadedInCreative = loadedInCreative;
		this.time = time;
		this.edition = edition;
		this.rainLevel = rainLevel;
		this.lightningLevel = lightningLevel;
		this.commandsEnabled = commandsEnabled;
		this.textureRequired = textureRequired;
		this.levelId = levelId;
		this.worldName = worldName;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + Buffer.varintLength(seed) + Buffer.varintLength(dimension) + Buffer.varintLength(generator) + Buffer.varintLength(worldGamemode) + Buffer.varintLength(difficulty) + Buffer.varintLength(spawnPosition.x) + Buffer.varintLength(spawnPosition.y) + Buffer.varintLength(spawnPosition.z) + Buffer.varintLength(time) + Buffer.varuintLength(levelId.getBytes(StandardCharsets.UTF_8).length) + levelId.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(worldName.getBytes(StandardCharsets.UTF_8).length) + worldName.getBytes(StandardCharsets.UTF_8).length + 33;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(yaw);
		this.writeLittleEndianFloat(pitch);
		this.writeVarint(seed);
		this.writeVarint(dimension);
		this.writeVarint(generator);
		this.writeVarint(worldGamemode);
		this.writeVarint(difficulty);
		this.writeVarint(spawnPosition.x); this.writeVarint(spawnPosition.y); this.writeVarint(spawnPosition.z);
		this.writeBool(loadedInCreative);
		this.writeVarint(time);
		this.writeBigEndianByte(edition);
		this.writeLittleEndianFloat(rainLevel);
		this.writeLittleEndianFloat(lightningLevel);
		this.writeBool(commandsEnabled);
		this.writeBool(textureRequired);
		byte[] bvzxz=levelId.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvzxz.length); this.writeBytes(bvzxz);
		byte[] d9bry1=worldName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d9bry1.length); this.writeBytes(d9bry1);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		yaw=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
		seed=this.readVarint();
		dimension=this.readVarint();
		generator=this.readVarint();
		worldGamemode=this.readVarint();
		difficulty=this.readVarint();
		spawnPosition=new Tuples.IntXYZ(); spawnPosition.x=this.readVarint(); spawnPosition.y=this.readVarint(); spawnPosition.z=this.readVarint();
		loadedInCreative=this.readBool();
		time=this.readVarint();
		edition=readBigEndianByte();
		rainLevel=readLittleEndianFloat();
		lightningLevel=readLittleEndianFloat();
		commandsEnabled=this.readBool();
		textureRequired=this.readBool();
		int bvbvzxz=this.readVaruint(); levelId=new String(this.readBytes(bvbvzxz), StandardCharsets.UTF_8);
		int bvd9bry1=this.readVaruint(); worldName=new String(this.readBytes(bvd9bry1), StandardCharsets.UTF_8);
	}

	public static StartGame fromBuffer(byte[] buffer) {
		StartGame ret = new StartGame();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "StartGame(entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", seed: " + this.seed + ", dimension: " + this.dimension + ", generator: " + this.generator + ", worldGamemode: " + this.worldGamemode + ", difficulty: " + this.difficulty + ", spawnPosition: " + this.spawnPosition.toString() + ", loadedInCreative: " + this.loadedInCreative + ", time: " + this.time + ", edition: " + this.edition + ", rainLevel: " + this.rainLevel + ", lightningLevel: " + this.lightningLevel + ", commandsEnabled: " + this.commandsEnabled + ", textureRequired: " + this.textureRequired + ", levelId: " + this.levelId + ", worldName: " + this.worldName + ")";
	}

}