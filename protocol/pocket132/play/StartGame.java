/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket132.xml
 */
package sul.protocol.pocket132.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class StartGame extends Packet {

	public static final int ID = (int)11;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// gamemode
	public static final int SURVIVAL = (int)0;
	public static final int CREATIVE = (int)1;
	public static final int ADVENTURE = (int)2;

	// dimension
	public static final int OVERWORLD = (int)0;
	public static final int NETHER = (int)1;
	public static final int END = (int)2;

	// generator
	public static final int OLD = (int)0;
	public static final int INFINITE = (int)1;
	public static final int FLAT = (int)2;

	// difficulty
	public static final int PEACEFUL = (int)0;
	public static final int EASY = (int)1;
	public static final int NORMAL = (int)2;
	public static final int HARD = (int)3;

	// version
	public static final byte VANILLA = (byte)0;
	public static final byte EDUCATION = (byte)1;

	/**
	 * Player's entity id that uniquely identifies the entity of the server.
	 */
	public long entityId;
	public long runtimeId;

	/**
	 * Player's gamemode that may differ from the world's gamemode.
	 */
	public int gamemode;

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
	 * Default's world gamemode.
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
	 */
	public int time;

	/**
	 * Game's edition. Some behaviours (some entities for example) may only work in a version
	 * and not in the other.
	 */
	public byte version;

	/**
	 * Intensity of the rain or the snow. Any value lower than or equals to 0 means no
	 * rain.
	 */
	public float rainLevel;
	public float lightningLevel;
	public boolean multiplayerGame = true;
	public boolean broadcastToLan;
	public boolean broadcastToXbl;

	/**
	 * Indicates whether the cheats are enabled. If the cheats are disabled the player
	 * cannot send commands.
	 */
	public boolean commandsEnabled;
	public boolean textureRequired;
	public sul.protocol.pocket132.types.Rule[] gameRules = new sul.protocol.pocket132.types.Rule[0];
	public boolean bonusChestEnabled;
	public boolean startWithMapEnabled;
	public boolean trustPlayersEnabled;
	public int permissionLevel;
	public int unknown27;
	public String levelId;

	/**
	 * World's name that will be displayed in the game's world settings. It can contain
	 * formatting codes.
	 */
	public String worldName;
	public String premiumWorldTemplate;
	public boolean unknown31;
	public long worldTicks;
	public int unknown33;

	public StartGame() {}

	public StartGame(long entityId, long runtimeId, int gamemode, Tuples.FloatXYZ position, float yaw, float pitch, int seed, int dimension, int generator, int worldGamemode, int difficulty, Tuples.IntXYZ spawnPosition, boolean loadedInCreative, int time, byte version, float rainLevel, float lightningLevel, boolean multiplayerGame, boolean broadcastToLan, boolean broadcastToXbl, boolean commandsEnabled, boolean textureRequired, sul.protocol.pocket132.types.Rule[] gameRules, boolean bonusChestEnabled, boolean startWithMapEnabled, boolean trustPlayersEnabled, int permissionLevel, int unknown27, String levelId, String worldName, String premiumWorldTemplate, boolean unknown31, long worldTicks, int unknown33) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.gamemode = gamemode;
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
		this.version = version;
		this.rainLevel = rainLevel;
		this.lightningLevel = lightningLevel;
		this.multiplayerGame = multiplayerGame;
		this.broadcastToLan = broadcastToLan;
		this.broadcastToXbl = broadcastToXbl;
		this.commandsEnabled = commandsEnabled;
		this.textureRequired = textureRequired;
		this.gameRules = gameRules;
		this.bonusChestEnabled = bonusChestEnabled;
		this.startWithMapEnabled = startWithMapEnabled;
		this.trustPlayersEnabled = trustPlayersEnabled;
		this.permissionLevel = permissionLevel;
		this.unknown27 = unknown27;
		this.levelId = levelId;
		this.worldName = worldName;
		this.premiumWorldTemplate = premiumWorldTemplate;
		this.unknown31 = unknown31;
		this.worldTicks = worldTicks;
		this.unknown33 = unknown33;
	}

	@Override
	public int length() {
		int length=Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + Buffer.varintLength(gamemode) + Buffer.varintLength(seed) + Buffer.varintLength(dimension) + Buffer.varintLength(generator) + Buffer.varintLength(worldGamemode) + Buffer.varintLength(difficulty) + Buffer.varintLength(spawnPosition.x) + Buffer.varintLength(spawnPosition.y) + Buffer.varintLength(spawnPosition.z) + Buffer.varintLength(time) + Buffer.varuintLength(gameRules.length) + Buffer.varintLength(permissionLevel) + Buffer.varintLength(unknown27) + Buffer.varuintLength(levelId.getBytes(StandardCharsets.UTF_8).length) + levelId.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(worldName.getBytes(StandardCharsets.UTF_8).length) + worldName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(premiumWorldTemplate.getBytes(StandardCharsets.UTF_8).length) + premiumWorldTemplate.getBytes(StandardCharsets.UTF_8).length + Buffer.varintLength(unknown33) + 48; for(sul.protocol.pocket132.types.Rule zfzjbv:gameRules){ length+=zfzjbv.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeVarint(gamemode);
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
		this.writeLittleEndianByte(version);
		this.writeLittleEndianFloat(rainLevel);
		this.writeLittleEndianFloat(lightningLevel);
		this.writeBool(multiplayerGame);
		this.writeBool(broadcastToLan);
		this.writeBool(broadcastToXbl);
		this.writeBool(commandsEnabled);
		this.writeBool(textureRequired);
		this.writeVaruint((int)gameRules.length); for(sul.protocol.pocket132.types.Rule zfzjbv:gameRules){ this.writeBytes(zfzjbv.encode()); }
		this.writeBool(bonusChestEnabled);
		this.writeBool(startWithMapEnabled);
		this.writeBool(trustPlayersEnabled);
		this.writeVarint(permissionLevel);
		this.writeVarint(unknown27);
		byte[] bvzxz=levelId.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvzxz.length); this.writeBytes(bvzxz);
		byte[] d9bry1=worldName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d9bry1.length); this.writeBytes(d9bry1);
		byte[] cjblbdcx=premiumWorldTemplate.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cjblbdcx.length); this.writeBytes(cjblbdcx);
		this.writeBool(unknown31);
		this.writeLittleEndianLong(worldTicks);
		this.writeVarint(unknown33);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		gamemode=this.readVarint();
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
		version=readLittleEndianByte();
		rainLevel=readLittleEndianFloat();
		lightningLevel=readLittleEndianFloat();
		multiplayerGame=this.readBool();
		broadcastToLan=this.readBool();
		broadcastToXbl=this.readBool();
		commandsEnabled=this.readBool();
		textureRequired=this.readBool();
		int bdbvdxc=this.readVaruint(); gameRules=new sul.protocol.pocket132.types.Rule[bdbvdxc]; for(int zfzjbv=0;zfzjbv<gameRules.length;zfzjbv++){ gameRules[zfzjbv]=new sul.protocol.pocket132.types.Rule(); gameRules[zfzjbv]._index=this._index; gameRules[zfzjbv].decode(this._buffer); this._index=gameRules[zfzjbv]._index; }
		bonusChestEnabled=this.readBool();
		startWithMapEnabled=this.readBool();
		trustPlayersEnabled=this.readBool();
		permissionLevel=this.readVarint();
		unknown27=this.readVarint();
		int bvbvzxz=this.readVaruint(); levelId=new String(this.readBytes(bvbvzxz), StandardCharsets.UTF_8);
		int bvd9bry1=this.readVaruint(); worldName=new String(this.readBytes(bvd9bry1), StandardCharsets.UTF_8);
		int bvcjblbd=this.readVaruint(); premiumWorldTemplate=new String(this.readBytes(bvcjblbd), StandardCharsets.UTF_8);
		unknown31=this.readBool();
		worldTicks=readLittleEndianLong();
		unknown33=this.readVarint();
	}

	public static StartGame fromBuffer(byte[] buffer) {
		StartGame ret = new StartGame();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "StartGame(entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", gamemode: " + this.gamemode + ", position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", seed: " + this.seed + ", dimension: " + this.dimension + ", generator: " + this.generator + ", worldGamemode: " + this.worldGamemode + ", difficulty: " + this.difficulty + ", spawnPosition: " + this.spawnPosition.toString() + ", loadedInCreative: " + this.loadedInCreative + ", time: " + this.time + ", version: " + this.version + ", rainLevel: " + this.rainLevel + ", lightningLevel: " + this.lightningLevel + ", multiplayerGame: " + this.multiplayerGame + ", broadcastToLan: " + this.broadcastToLan + ", broadcastToXbl: " + this.broadcastToXbl + ", commandsEnabled: " + this.commandsEnabled + ", textureRequired: " + this.textureRequired + ", gameRules: " + Arrays.deepToString(this.gameRules) + ", bonusChestEnabled: " + this.bonusChestEnabled + ", startWithMapEnabled: " + this.startWithMapEnabled + ", trustPlayersEnabled: " + this.trustPlayersEnabled + ", permissionLevel: " + this.permissionLevel + ", unknown27: " + this.unknown27 + ", levelId: " + this.levelId + ", worldName: " + this.worldName + ", premiumWorldTemplate: " + this.premiumWorldTemplate + ", unknown31: " + this.unknown31 + ", worldTicks: " + this.worldTicks + ", unknown33: " + this.unknown33 + ")";
	}

}