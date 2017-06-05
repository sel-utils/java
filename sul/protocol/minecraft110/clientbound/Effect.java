/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import sul.utils.*;

public class Effect extends Packet {

	public static final int ID = (int)33;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// effect id
	public static final int DISPENSER_DISPENSE = 1000;
	public static final int DISPENSER_FAIL_DISPENSE = 1001;
	public static final int DISPENSER_SHOOT = 1002;
	public static final int ENDER_EYE_LAUNCH = 1003;
	public static final int FIREWORK_SHOT = 1004;
	public static final int IRON_DOOR_OPEN = 1005;
	public static final int WOODEN_DOOR_OPEN = 1006;
	public static final int WOODEN_TRAPDOOR_OPEN = 1007;
	public static final int FENCE_GATE_OPEN = 1008;
	public static final int FIRE_EXTINGUISH = 1009;
	public static final int PLAY_RECORD = 1010;
	public static final int IRON_DOOR_CLOSE = 1011;
	public static final int WOODEN_DOOR_CLOSE = 1012;
	public static final int WOODEN_TRAPDOOR_CLOSE = 1013;
	public static final int FENCE_GATE_CLOSE = 1014;
	public static final int GHAST_WARN = 1015;
	public static final int GHAST_SHOOT = 1016;
	public static final int ENDERDRAGON_SHOOT = 1017;
	public static final int BLAZE_SHOOT = 1018;
	public static final int ZOMBIE_ATTACK_WOOD_DOOR = 1019;
	public static final int ZOMBIE_ATTACK_IRON_DOOR = 1020;
	public static final int ZOMBIE_BREAK_WOOD_DOOR = 1021;
	public static final int WITHER_BREAK_BLOCK = 1022;
	public static final int WITHER_SPAWN = 1023;
	public static final int WITHER_SHOOT = 1024;
	public static final int BAT_TAKE_OFF = 1025;
	public static final int ZOMBIE_INFECT_VILLAGER = 1026;
	public static final int ZOMBIE_VILLAGER_CONVERT = 1027;
	public static final int ENDER_DRAGON_BREATH = 1028;
	public static final int ANVIL_BREAK = 1029;
	public static final int ANVIL_USE = 1030;
	public static final int ANVIL_LAND = 1031;
	public static final int PORTAL_TRAVEL = 1032;
	public static final int CHORUS_FLOWER_GROW = 1033;
	public static final int CHORUS_FLOWER_DIE = 1034;
	public static final int BREWING_STAND_BREW = 1035;
	public static final int IRON_TRAPDOOR_OPEN = 1036;
	public static final int IRON_TRAPDOOR_CLOSE = 1037;
	public static final int SPAWN_10_SMOKE_PARTICLES = 2000;
	public static final int BREAK_BREAK_PARTICLES_AND_SOUND = 2001;
	public static final int SPLASH_POTION_PARTICLES_AND_SOUND = 2002;
	public static final int ENDER_EYE_BREAK_PARTICLES_AND_SOUND = 2003;
	public static final int MOB_SPAWN_PARTICLES = 2004;
	public static final int BONEMEAL_PARTICLES = 2005;
	public static final int DRAGON_BREATH = 2006;
	public static final int END_GATEWAY_SPAWN = 3000;
	public static final int ENDERDRAGON_GROWL = 3001;

	public int effectId;
	public long position;
	public int data;
	public boolean disableVolume;

	public Effect() {}

	public Effect(int effectId, long position, int data, boolean disableVolume) {
		this.effectId = effectId;
		this.position = position;
		this.data = data;
		this.disableVolume = disableVolume;
	}

	@Override
	public int length() {
		return 18;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(effectId);
		this.writeBigEndianLong(position);
		this.writeBigEndianInt(data);
		this.writeBool(disableVolume);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		effectId=readBigEndianInt();
		position=readBigEndianLong();
		data=readBigEndianInt();
		disableVolume=this.readBool();
	}

	public static Effect fromBuffer(byte[] buffer) {
		Effect ret = new Effect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Effect(effectId: " + this.effectId + ", position: " + this.position + ", data: " + this.data + ", disableVolume: " + this.disableVolume + ")";
	}

}