/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import sul.utils.*;

public class WindowProperty extends Packet {

	public static final int ID = (int)21;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// property
	public static final short FURNANCE_FIRE_ICON = 0;
	public static final short FURNACE_MAX_FUEL_BURN_TIME = 1;
	public static final short FURNACE_PROGRESS_ARROW = 2;
	public static final short FURNCE_MAX_PROGRESS = 3;
	public static final short ENCHANTMENT_LEVEL_REQUIREMENT_TOP = 0;
	public static final short ENCHANTMENT_LEVEL_REQUIREMENT_MIDDLE = 1;
	public static final short ENCHANTMENT_LEVEL_REQUIREMENT_BOTTOM = 2;
	public static final short ENCHANTMENT_SEED = 3;
	public static final short ENCHANTMENT_ID_TOP = 4;
	public static final short ENCHANTMENT_ID_MIDDLE = 5;
	public static final short ENCHANTMENT_ID_BOTTOM = 6;
	public static final short ENCHANTMENT_LEVEL_TOP = 7;
	public static final short ENCHANTMENT_LEVEL_MIDDLE = 8;
	public static final short ENCHANTMENT_LEVEL_BOTTOM = 9;
	public static final short BEACON_POWER_LEVEL = 0;
	public static final short BEACON_FIRST_EFFECT = 1;
	public static final short BEACON_SECOND_EFFECT = 2;
	public static final short ANVIL_REPAIR_COST = 0;
	public static final short BREWING_STAND_BREW_TIME = 0;

	public byte window;
	public short property;
	public short value;

	public WindowProperty() {}

	public WindowProperty(byte window, short property, short value) {
		this.window = window;
		this.property = property;
		this.value = value;
	}

	@Override
	public int length() {
		return 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(property);
		this.writeBigEndianShort(value);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		property=readBigEndianShort();
		value=readBigEndianShort();
	}

	public static WindowProperty fromBuffer(byte[] buffer) {
		WindowProperty ret = new WindowProperty();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "WindowProperty(window: " + this.window + ", property: " + this.property + ", value: " + this.value + ")";
	}

}