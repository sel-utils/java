/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * A game rule that prevents the client from doing client-side actions and animations.
 */
public class Rule extends Stream {

	// name
	public static final String DROWNING_DAMAGE = "drowningdamage";
	public static final String FALL_DAMAGE = "falldamage";
	public static final String FIRE_DAMAGE = "firedamage";
	public static final String IMMUTABLE_WORLD = "immutableworld";
	public static final String PVP = "pvp";

	/**
	 * Name of the rule. Same of the `gamerule` command's field in Minecraft: Education
	 * Edition.
	 * The behaviours indicated in the following constants' descriptions is enabled or
	 * disabled.
	 */
	public String name;

	/**
	 * Indicates whether the game rule is enabled.
	 */
	public boolean value;
	public boolean unknown2;

	public Rule() {}

	public Rule(String name, boolean value, boolean unknown2) {
		this.name = name;
		this.value = value;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeBool(value);
		this.writeBool(unknown2);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		value=this.readBool();
		unknown2=this.readBool();
	}

	@Override
	public String toString() {
		return "Rule(name: " + this.name + ", value: " + this.value + ", unknown2: " + this.unknown2 + ")";
	}


}