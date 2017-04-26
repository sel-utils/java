/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket111.xml
 */
package sul.protocol.pocket111.play;

import sul.utils.*;

public class LevelEvent extends Packet {

	public static final byte ID = (byte)26;

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
	public static final int SET_DATA = 4000;
	public static final int PLAYERS_SLEEPING = 9800;
	public static final int BUBBLE = 16385;
	public static final int CRITICAL = 16386;
	public static final int BLOCK_FORCE_FIELD = 16387;
	public static final int SMOKE = 16388;
	public static final int EXPLODE = 16389;
	public static final int EVAPORATION = 16390;
	public static final int FLAME = 16391;
	public static final int LAVA = 16392;
	public static final int LARGE_SMOKE = 16393;
	public static final int REDSTONE = 16394;
	public static final int RISING_RED_DUST = 16395;
	public static final int ITEM_BREAK = 16396;
	public static final int SNOWBALL_POOF = 16397;
	public static final int HUGE_EXPLODE = 16398;
	public static final int HUGE_EXPLODE_SEED = 16399;
	public static final int MOB_FLAME = 16400;
	public static final int HEART = 16401;
	public static final int TERRAIN = 16402;
	public static final int TOWN_AURA = 16403;
	public static final int PORTAL = 16404;
	public static final int WATER_SPLASH = 16405;
	public static final int WATER_WAKE = 16406;
	public static final int DRIP_WATER = 16407;
	public static final int DRIP_LAVA = 16408;
	public static final int FALLING_DUST = 16409;
	public static final int MOB_SPELL = 16410;
	public static final int MOB_SPELL_AMBIENT = 16411;
	public static final int MOB_SPELL_INSTANTANEOUS = 16412;
	public static final int INK = 16413;
	public static final int SLIME = 16414;
	public static final int RAIN_SPLASH = 16415;
	public static final int VILLAGER_ANGRY = 16416;
	public static final int VILLAGER_HAPPY = 16417;
	public static final int ENCHANTMENT_TABLE = 16418;
	public static final int TRACKING_EMITTER = 16419;
	public static final int NOTE = 16420;
	public static final int WITCH_SPELL = 16421;
	public static final int CARROT = 16422;
	public static final int END_ROD = 16424;
	public static final int DRAGON_BREATH = 16425;
	public static final int SHOOT = 2000;
	public static final int DESTROY = 2001;

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