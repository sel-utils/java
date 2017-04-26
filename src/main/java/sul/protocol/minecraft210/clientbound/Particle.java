/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class Particle extends Packet {

	public static final int ID = (int)34;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// particle id
	public static final int EXPLODE = 0;
	public static final int LARGE_EXPLOSION = 1;
	public static final int HUGE_EXPLOSION = 2;
	public static final int FIREWORK_SPARK = 3;
	public static final int BUBBLE = 4;
	public static final int SPLASH = 5;
	public static final int WAKE = 6;
	public static final int SUSPENDED = 7;
	public static final int DEPTH_SUSPEND = 8;
	public static final int CRIT = 9;
	public static final int MAGIC_CRIT = 10;
	public static final int SMOKE = 11;
	public static final int LARGE_SMOKE = 12;
	public static final int SPELL = 13;
	public static final int INSTANT_SPELL = 14;
	public static final int MOB_SPELL = 15;
	public static final int MOB_SPELL_AMBIENT = 16;
	public static final int WITCH_MAGIC = 17;
	public static final int DRIP_WATER = 18;
	public static final int DRIP_LAVA = 19;
	public static final int ANGRY_VILLAGER = 20;
	public static final int HAPPY_VILLAGER = 21;
	public static final int TOWN_AURA = 22;
	public static final int NOTE = 23;
	public static final int PORTAL = 24;
	public static final int ENCHANTMENT_TABLE = 25;
	public static final int FLAME = 26;
	public static final int LAVA = 27;
	public static final int FOOTSTEP = 28;
	public static final int CLOUD = 29;
	public static final int RED_DUST = 30;
	public static final int SNOWBALL_POOF = 31;
	public static final int SNOW_SHOVEL = 32;
	public static final int SLIME = 33;
	public static final int HEART = 34;
	public static final int BARRIER = 35;
	public static final int ITEM_CRACK = 36;
	public static final int BLOCK_CRACK = 37;
	public static final int BLOCK_DUST = 38;
	public static final int DROPLET = 39;
	public static final int TAKE = 40;
	public static final int MOB_APPEARANCE = 41;
	public static final int DRAGON_BREATH = 42;
	public static final int ENDROD = 43;
	public static final int DAMAGE_INDICATOR = 44;
	public static final int SWEEP_ATTACK = 45;
	public static final int FALLING_DUST = 46;

	public int particleId;
	public boolean longDistance;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public Tuples.FloatXYZ offset = new Tuples.FloatXYZ();
	public float data;
	public int count;
	public int[] additionalData = new int[2];

	public Particle() {}

	public Particle(int particleId, boolean longDistance, Tuples.FloatXYZ position, Tuples.FloatXYZ offset, float data, int count, int[] additionalData) {
		this.particleId = particleId;
		this.longDistance = longDistance;
		this.position = position;
		this.offset = offset;
		this.data = data;
		this.count = count;
		this.additionalData = additionalData;
	}

	@Override
	public int length() {
		int length=38; for(int yrarb5br:additionalData){ length+=Buffer.varuintLength(yrarb5br); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(particleId);
		this.writeBool(longDistance);
		this.writeBigEndianFloat(position.x); this.writeBigEndianFloat(position.y); this.writeBigEndianFloat(position.z);
		this.writeBigEndianFloat(offset.x); this.writeBigEndianFloat(offset.y); this.writeBigEndianFloat(offset.z);
		this.writeBigEndianFloat(data);
		this.writeBigEndianInt(count);
		for(int yrarb5br:additionalData){ this.writeVaruint(yrarb5br); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		particleId=readBigEndianInt();
		longDistance=this.readBool();
		position=new Tuples.FloatXYZ(); position.x=readBigEndianFloat(); position.y=readBigEndianFloat(); position.z=readBigEndianFloat();
		offset=new Tuples.FloatXYZ(); offset.x=readBigEndianFloat(); offset.y=readBigEndianFloat(); offset.z=readBigEndianFloat();
		data=readBigEndianFloat();
		count=readBigEndianInt();
		final int bfzla9yx=2; additionalData=new int[bfzla9yx]; for(int yrarb5br=0;yrarb5br<additionalData.length;yrarb5br++){ additionalData[yrarb5br]=this.readVaruint(); }
	}

	public static Particle fromBuffer(byte[] buffer) {
		Particle ret = new Particle();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Particle(particleId: " + this.particleId + ", longDistance: " + this.longDistance + ", position: " + this.position.toString() + ", offset: " + this.offset.toString() + ", data: " + this.data + ", count: " + this.count + ", additionalData: " + Arrays.toString(this.additionalData) + ")";
	}

}