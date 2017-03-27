/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.serverbound;

import sul.utils.*;

public class EnchantItem extends Packet {

	public static final int ID = (int)6;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public byte enchantment;

	public EnchantItem() {}

	public EnchantItem(byte window, byte enchantment) {
		this.window = window;
		this.enchantment = enchantment;
	}

	@Override
	public int length() {
		return 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianByte(enchantment);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		enchantment=readBigEndianByte();
	}

	public static EnchantItem fromBuffer(byte[] buffer) {
		EnchantItem ret = new EnchantItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EnchantItem(window: " + this.window + ", enchantment: " + this.enchantment + ")";
	}

}
