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
 * Plays a sound at a certain position.
 */
public class LevelSoundEvent extends Packet {

	public static final byte ID = (byte)26;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// sound
	public static final byte ITEM_USE_ON = 0;
	public static final byte HIT = 1;
	public static final byte STEP = 2;
	public static final byte JUMP = 3;
	public static final byte BREAK = 4;
	public static final byte PLACE = 5;
	public static final byte HEAVY_STEP = 6;
	public static final byte GALLOP = 7;
	public static final byte FALL = 8;
	public static final byte AMBIENT = 9;
	public static final byte AMBIENT_BABY = 10;
	public static final byte AMBIENT_IN_WATER = 11;
	public static final byte BREATHE = 12;
	public static final byte DEATH = 13;
	public static final byte DEATH_IN_WATER = 14;
	public static final byte DEATH_TO_ZOMBIE = 15;
	public static final byte HURT = 16;
	public static final byte HURT_IN_WATER = 17;
	public static final byte MAD = 18;
	public static final byte BOOST = 19;
	public static final byte BOW = 20;
	public static final byte SQUISH_BIG = 21;
	public static final byte SQUISH_SMALL = 22;
	public static final byte FALL_BIG = 23;
	public static final byte FALL_SMALL = 24;
	public static final byte SPLASH = 25;
	public static final byte FIZZ = 26;
	public static final byte FLAP = 27;
	public static final byte SWIM = 28;
	public static final byte DRINK = 29;
	public static final byte EAT = 30;
	public static final byte TAKEOFF = 31;
	public static final byte SHAKE = 32;
	public static final byte PLOP = 33;
	public static final byte LAND = 34;
	public static final byte SADDLE = 35;
	public static final byte ARMOR = 36;
	public static final byte ADD_CHEST = 37;
	public static final byte THROW = 38;
	public static final byte ATTACK = 39;
	public static final byte ATTACK_NODAMAGE = 40;
	public static final byte WARN = 41;
	public static final byte SHEAR = 42;
	public static final byte MILK = 43;
	public static final byte THUNDER = 44;
	public static final byte EXPLODE = 45;
	public static final byte FIRE = 46;
	public static final byte IGNITE = 47;
	public static final byte FUSE = 48;
	public static final byte STARE = 49;
	public static final byte SPAWN = 50;
	public static final byte SHOOT = 51;
	public static final byte BREAK_BLOCK = 52;
	public static final byte REMEDY = 53;
	public static final byte UNFECT = 54;
	public static final byte LEVELUP = 55;
	public static final byte BOW_HIT = 56;
	public static final byte BULLET_HIT = 57;
	public static final byte EXTINGUISH_FIRE = 58;
	public static final byte ITEM_FIZZ = 59;
	public static final byte CHEST_OPEN = 60;
	public static final byte CHEST_CLOSED = 61;
	public static final byte POWER_ON = 62;
	public static final byte POWER_OFF = 63;
	public static final byte ATTACH = 64;
	public static final byte DETACH = 65;
	public static final byte DENY = 66;
	public static final byte TRIPOD = 67;
	public static final byte POP = 68;
	public static final byte DROP_SLOT = 69;
	public static final byte NOTE = 70;
	public static final byte THORNS = 71;
	public static final byte PISTON_IN = 72;
	public static final byte PISTON_OUT = 73;
	public static final byte PORTAL = 74;
	public static final byte WATER = 75;
	public static final byte LAVA_POP = 76;
	public static final byte LAVA = 77;
	public static final byte BURP = 78;
	public static final byte BUCKET_FILL_WATER = 79;
	public static final byte BUCKET_FILL_LAVA = 80;
	public static final byte BUCKET_EMPTY_WATER = 81;
	public static final byte BUCKET_EMPTY_LAVA = 82;
	public static final byte GUARDIAN_FLOP = 83;
	public static final byte ELDERGUARDIAN_CURSE = 84;
	public static final byte MOB_WARNING = 85;
	public static final byte MOB_WARNING_BABY = 86;
	public static final byte TELEPORT = 87;
	public static final byte SHULKER_OPEN = 88;
	public static final byte SHULKER_CLOSE = 89;
	public static final byte HAGGLE = 90;
	public static final byte HAGGLE_YES = 91;
	public static final byte HAGGLE_NO = 92;
	public static final byte HAGGLE_IDLE = 93;
	public static final byte DEFAULT = 94;
	public static final byte UNDEFINED = 95;

	public byte sound;

	/**
	 * Position where the sound was generated. The closer to the player the more intense
	 * will be on the client.
	 */
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public int volume;
	public int pitch;
	public boolean unknown4;

	public LevelSoundEvent() {}

	public LevelSoundEvent(byte sound, Tuples.FloatXYZ position, int volume, int pitch, boolean unknown4) {
		this.sound = sound;
		this.position = position;
		this.volume = volume;
		this.pitch = pitch;
		this.unknown4 = unknown4;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(volume) + Buffer.varintLength(pitch) + 15;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(sound);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeVaruint(volume);
		this.writeVarint(pitch);
		this.writeBool(unknown4);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		sound=readBigEndianByte();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		volume=this.readVaruint();
		pitch=this.readVarint();
		unknown4=this.readBool();
	}

	public static LevelSoundEvent fromBuffer(byte[] buffer) {
		LevelSoundEvent ret = new LevelSoundEvent();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "LevelSoundEvent(sound: " + this.sound + ", position: " + this.position.toString() + ", volume: " + this.volume + ", pitch: " + this.pitch + ", unknown4: " + this.unknown4 + ")";
	}

}