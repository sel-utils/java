/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.play;

import sul.utils.*;

public class LevelEvent extends Packet {

	public static final int ID = (int)25;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// event id
	public static final int START_RAIN = (int)3001;
	public static final int START_THUNDER = (int)3002;
	public static final int STOP_RAIN = (int)3003;
	public static final int STOP_THUNDER = (int)3004;
	public static final int START_BLOCK_BREAK = (int)3600;
	public static final int STOP_BLOCK_BREAK = (int)3601;
	public static final int SET_DATA = (int)4000;
	public static final int PLAYERS_SLEEPING = (int)9800;
	public static final int PARTICLE_BUBBLE = (int)16385;
	public static final int PARTICLE_CRITICAL = (int)16386;
	public static final int PARTICLE_BLOCK_FORCE_FIELD = (int)16387;
	public static final int PARTICLE_SMOKE = (int)16388;
	public static final int PARTICLE_EXPLODE = (int)16389;
	public static final int PARTICLE_EVAPORATION = (int)16390;
	public static final int PARTICLE_FLAME = (int)16391;
	public static final int PARTICLE_LAVA = (int)16392;
	public static final int PARTICLE_LARGE_SMOKE = (int)16393;
	public static final int PARTICLE_REDSTONE = (int)16394;
	public static final int PARTICLE_RISING_RED_DUST = (int)16395;
	public static final int PARTICLE_ITEM_BREAK = (int)16396;
	public static final int PARTICLE_SNOWBALL_POOF = (int)16397;
	public static final int PARTICLE_HUGE_EXPLODE = (int)16398;
	public static final int PARTICLE_HUGE_EXPLODE_SEED = (int)16399;
	public static final int PARTICLE_MOB_FLAME = (int)16400;
	public static final int PARTICLE_HEART = (int)16401;
	public static final int PARTICLE_TERRAIN = (int)16402;
	public static final int PARTICLE_TOWN_AURA = (int)16403;
	public static final int PARTICLE_PORTAL = (int)16404;
	public static final int PARTICLE_WATER_SPLASH = (int)16405;
	public static final int PARTICLE_WATER_WAKE = (int)16406;
	public static final int PARTICLE_DRIP_WATER = (int)16407;
	public static final int PARTICLE_DRIP_LAVA = (int)16408;
	public static final int PARTICLE_FALLING_DUST = (int)16409;
	public static final int PARTICLE_MOB_SPELL = (int)16410;
	public static final int PARTICLE_MOB_SPELL_AMBIENT = (int)16411;
	public static final int PARTICLE_MOB_SPELL_INSTANTANEOUS = (int)16412;
	public static final int PARTICLE_INK = (int)16413;
	public static final int PARTICLE_SLIME = (int)16414;
	public static final int PARTICLE_RAIN_SPLASH = (int)16415;
	public static final int PARTICLE_VILLAGER_ANGRY = (int)16416;
	public static final int PARTICLE_VILLAGER_HAPPY = (int)16417;
	public static final int PARTICLE_ENCHANTMENT_TABLE = (int)16418;
	public static final int PARTICLE_TRACKING_EMITTER = (int)16419;
	public static final int PARTICLE_NOTE = (int)16420;
	public static final int PARTICLE_WITCH_SPELL = (int)16421;
	public static final int PARTICLE_CARROT = (int)16422;
	public static final int PARTICLE_END_ROD = (int)16424;
	public static final int PARTICLE_DRAGON_BREATH = (int)16425;
	public static final int PARTICLE_SHOOT = (int)2000;
	public static final int PARTICLE_DESTROY = (int)2001;
	public static final int PARTICLE_SPLASH = (int)2002;
	public static final int PARTICLE_EYE_DESPAWN = (int)2003;
	public static final int PARTICLE_SPAWN = (int)2004;

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
		this.writeVaruint(ID);
		this.writeVarint(eventId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeVarint(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
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