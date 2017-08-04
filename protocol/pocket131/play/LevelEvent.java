/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.play;

import sul.utils.*;

public class LevelEvent extends Packet {

	public static final byte ID = (byte)25;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// event id
	public static final int START_RAIN = 3001;
	public static final int START_THUNDER = 3002;
	public static final int STOP_RAIN = 3003;
	public static final int STOP_THUNDER = 3004;
	public static final int START_BLOCK_BREAK = 3600;
	public static final int STOP_BLOCK_BREAK = 3601;
	public static final int SET_DATA = 4000;
	public static final int PLAYERS_SLEEPING = 9800;
	public static final int PARTICLE_BUBBLE = 16385;
	public static final int PARTICLE_CRITICAL = 16386;
	public static final int PARTICLE_BLOCK_FORCE_FIELD = 16387;
	public static final int PARTICLE_SMOKE = 16388;
	public static final int PARTICLE_EXPLODE = 16389;
	public static final int PARTICLE_EVAPORATION = 16390;
	public static final int PARTICLE_FLAME = 16391;
	public static final int PARTICLE_LAVA = 16392;
	public static final int PARTICLE_LARGE_SMOKE = 16393;
	public static final int PARTICLE_REDSTONE = 16394;
	public static final int PARTICLE_RISING_RED_DUST = 16395;
	public static final int PARTICLE_ITEM_BREAK = 16396;
	public static final int PARTICLE_SNOWBALL_POOF = 16397;
	public static final int PARTICLE_HUGE_EXPLODE = 16398;
	public static final int PARTICLE_HUGE_EXPLODE_SEED = 16399;
	public static final int PARTICLE_MOB_FLAME = 16400;
	public static final int PARTICLE_HEART = 16401;
	public static final int PARTICLE_TERRAIN = 16402;
	public static final int PARTICLE_TOWN_AURA = 16403;
	public static final int PARTICLE_PORTAL = 16404;
	public static final int PARTICLE_WATER_SPLASH = 16405;
	public static final int PARTICLE_WATER_WAKE = 16406;
	public static final int PARTICLE_DRIP_WATER = 16407;
	public static final int PARTICLE_DRIP_LAVA = 16408;
	public static final int PARTICLE_FALLING_DUST = 16409;
	public static final int PARTICLE_MOB_SPELL = 16410;
	public static final int PARTICLE_MOB_SPELL_AMBIENT = 16411;
	public static final int PARTICLE_MOB_SPELL_INSTANTANEOUS = 16412;
	public static final int PARTICLE_INK = 16413;
	public static final int PARTICLE_SLIME = 16414;
	public static final int PARTICLE_RAIN_SPLASH = 16415;
	public static final int PARTICLE_VILLAGER_ANGRY = 16416;
	public static final int PARTICLE_VILLAGER_HAPPY = 16417;
	public static final int PARTICLE_ENCHANTMENT_TABLE = 16418;
	public static final int PARTICLE_TRACKING_EMITTER = 16419;
	public static final int PARTICLE_NOTE = 16420;
	public static final int PARTICLE_WITCH_SPELL = 16421;
	public static final int PARTICLE_CARROT = 16422;
	public static final int PARTICLE_END_ROD = 16424;
	public static final int PARTICLE_DRAGON_BREATH = 16425;
	public static final int PARTICLE_SHOOT = 2000;
	public static final int PARTICLE_DESTROY = 2001;
	public static final int PARTICLE_SPLASH = 2002;
	public static final int PARTICLE_EYE_DESPAWN = 2003;
	public static final int PARTICLE_SPAWN = 2004;

	public int eventId;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public int data;

	public LevelEvent() {}

	public LevelEvent(int eventId, Tuples.FloatXYZ position, int data) {
		this.eventId = eventId;
		this.position = position;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varintLength(eventId) + Buffer.varintLength(data) + 13;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(eventId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeVarint(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		eventId=this.readVarint();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		data=this.readVarint();
	}

	public static LevelEvent fromBuffer(byte[] buffer) {
		LevelEvent ret = new LevelEvent();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "LevelEvent(eventId: " + this.eventId + ", position: " + this.position.toString() + ", data: " + this.data + ")";
	}

}