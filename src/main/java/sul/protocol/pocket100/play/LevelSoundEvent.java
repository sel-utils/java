/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class LevelSoundEvent extends Packet {

	public static final byte ID = (byte)26;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// sound
	public static final byte ITEM_USE_ON = (byte)0;
	public static final byte HIT = (byte)1;
	public static final byte STEP = (byte)2;
	public static final byte JUMP = (byte)3;
	public static final byte BREAK = (byte)4;
	public static final byte PLACE = (byte)5;
	public static final byte HEAVY_STEP = (byte)6;
	public static final byte GALLOP = (byte)7;
	public static final byte FALL = (byte)8;
	public static final byte AMBIENT = (byte)9;
	public static final byte AMBIENT_BABY = (byte)10;
	public static final byte AMBIENT_IN_WATER = (byte)11;
	public static final byte BREATHE = (byte)12;
	public static final byte DEATH = (byte)13;
	public static final byte DEATH_IN_WATER = (byte)14;
	public static final byte DEATH_TO_ZOMBIE = (byte)15;
	public static final byte HURT = (byte)16;
	public static final byte HURT_IN_WATER = (byte)17;
	public static final byte MAD = (byte)18;
	public static final byte BOOST = (byte)19;
	public static final byte BOW = (byte)20;
	public static final byte SQUISH_BIG = (byte)21;
	public static final byte SQUISH_SMALL = (byte)22;
	public static final byte FALL_BIG = (byte)23;
	public static final byte FALL_SMALL = (byte)24;
	public static final byte SPLASH = (byte)25;
	public static final byte FIZZ = (byte)26;
	public static final byte FLAP = (byte)27;
	public static final byte SWIM = (byte)28;
	public static final byte DRINK = (byte)29;
	public static final byte EAT = (byte)30;
	public static final byte TAKEOFF = (byte)31;
	public static final byte SHAKE = (byte)32;
	public static final byte PLOP = (byte)33;
	public static final byte LAND = (byte)34;
	public static final byte SADDLE = (byte)35;
	public static final byte ARMOR = (byte)36;
	public static final byte ADD_CHEST = (byte)37;
	public static final byte THROW = (byte)38;
	public static final byte ATTACK = (byte)39;
	public static final byte ATTACK_NODAMAGE = (byte)40;
	public static final byte WARN = (byte)41;
	public static final byte SHEAR = (byte)42;
	public static final byte MILK = (byte)43;
	public static final byte THUNDER = (byte)44;
	public static final byte EXPLODE = (byte)45;
	public static final byte FIRE = (byte)46;
	public static final byte IGNITE = (byte)47;
	public static final byte FUSE = (byte)48;
	public static final byte STARE = (byte)49;
	public static final byte SPAWN = (byte)50;
	public static final byte SHOOT = (byte)51;
	public static final byte BREAK_BLOCK = (byte)52;
	public static final byte REMEDY = (byte)53;
	public static final byte UNFECT = (byte)54;
	public static final byte LEVELUP = (byte)55;
	public static final byte BOW_HIT = (byte)56;
	public static final byte BULLET_HIT = (byte)57;
	public static final byte EXTINGUISH_FIRE = (byte)58;
	public static final byte ITEM_FIZZ = (byte)59;
	public static final byte CHEST_OPEN = (byte)60;
	public static final byte CHEST_CLOSED = (byte)61;
	public static final byte POWER_ON = (byte)62;
	public static final byte POWER_OFF = (byte)63;
	public static final byte ATTACH = (byte)64;
	public static final byte DETACH = (byte)65;
	public static final byte DENY = (byte)66;
	public static final byte TRIPOD = (byte)67;
	public static final byte POP = (byte)68;
	public static final byte DROP_SLOT = (byte)69;
	public static final byte NOTE = (byte)70;
	public static final byte THORNS = (byte)71;
	public static final byte PISTON_IN = (byte)72;
	public static final byte PISTON_OUT = (byte)73;
	public static final byte PORTAL = (byte)74;
	public static final byte WATER = (byte)75;
	public static final byte LAVA_POP = (byte)76;
	public static final byte LAVA = (byte)77;
	public static final byte BURP = (byte)78;
	public static final byte BUCKET_FILL_WATER = (byte)79;
	public static final byte BUCKET_FILL_LAVA = (byte)80;
	public static final byte BUCKET_EMPTY_WATER = (byte)81;
	public static final byte BUCKET_EMPTY_LAVA = (byte)82;
	public static final byte GUARDIAN_FLOP = (byte)83;
	public static final byte ELDERGUARDIAN_CURSE = (byte)84;
	public static final byte MOB_WARNING = (byte)85;
	public static final byte MOB_WARNING_BABY = (byte)86;
	public static final byte TELEPORT = (byte)87;
	public static final byte SHULKER_OPEN = (byte)88;
	public static final byte SHULKER_CLOSE = (byte)89;
	public static final byte DEFAULT = (byte)90;
	public static final byte UNDEFINED = (byte)91;

	public byte sound;
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