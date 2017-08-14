/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket132.xml
 */
package sul.protocol.pocket132.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * A game rule that prevents the client from doing client-side actions and animations.
 */
public class Rule extends Stream {

	// name
	public static final String COMMAND_BLOCK_OUTPUT = "commandblockoutput";
	public static final String DO_DAYLIGHT_CYCLE = "dodaylightcycle";
	public static final String DO_ENTITY_DROPS = "doentitydrops";
	public static final String DO_FIRE_TICK = "dofiretick";
	public static final String DO_MOB_LOOT = "domobloot";
	public static final String DO_MOB_SPAWNING = "domobspawning";
	public static final String DO_TILE_DROPS = "dotiledrops";
	public static final String DO_WEATHER_CYCLE = "doweathercycle";
	public static final String DROWNING_DAMAGE = "drowningdamage";
	public static final String FALL_DAMAGE = "falldamage";
	public static final String FIRE_DAMAGE = "firedamage";
	public static final String KEEP_INVENTORY = "keepinventory";
	public static final String MOB_GRIEFING = "mobgriefing";
	public static final String PVP = "pvp";
	public static final String SEND_COMMAND_FEEDBACK = "sendcommandfeedback";

	// type
	public static final byte BOOLEAN = (byte)1;
	public static final byte INTEGER = (byte)2;
	public static final byte FLOATING = (byte)3;

	/**
	 * Name of the rule. Same of the `gamerule` command's field in the game.
	 * The behaviours indicated in the following constants' descriptions is enabled or
	 * disabled.
	 */
	public String name;
	public byte type;
	public boolean booleanValue;
	public int integerValue;
	public float floatingValue;

	public Rule() {}

	public Rule(String name, byte type, boolean booleanValue, int integerValue, float floatingValue) {
		this.name = name;
		this.type = type;
		this.booleanValue = booleanValue;
		this.integerValue = integerValue;
		this.floatingValue = floatingValue;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(integerValue) + 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeLittleEndianByte(type);
		if(type==1){ this.writeBool(booleanValue); }
		if(type==2){ this.writeVaruint(integerValue); }
		if(type==3){ this.writeLittleEndianFloat(floatingValue); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		type=readLittleEndianByte();
		if(type==1){ booleanValue=this.readBool(); }
		if(type==2){ integerValue=this.readVaruint(); }
		if(type==3){ floatingValue=readLittleEndianFloat(); }
	}

	@Override
	public String toString() {
		return "Rule(name: " + this.name + ", type: " + this.type + ", booleanValue: " + this.booleanValue + ", integerValue: " + this.integerValue + ", floatingValue: " + this.floatingValue + ")";
	}


}