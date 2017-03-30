/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class UpdateTrade extends Packet {

	public static final byte ID = (byte)79;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte unknown0;
	public byte unknown1;
	public int unknown2;
	public int unknown3;
	public boolean unknown4;
	public long trader;
	public long player;
	public String unknown7;
	public byte[] offers = new byte[0];

	public UpdateTrade() {}

	public UpdateTrade(byte unknown0, byte unknown1, int unknown2, int unknown3, boolean unknown4, long trader, long player, String unknown7, byte[] offers) {
		this.unknown0 = unknown0;
		this.unknown1 = unknown1;
		this.unknown2 = unknown2;
		this.unknown3 = unknown3;
		this.unknown4 = unknown4;
		this.trader = trader;
		this.player = player;
		this.unknown7 = unknown7;
		this.offers = offers;
	}

	@Override
	public int length() {
		return Buffer.varintLength(unknown2) + Buffer.varintLength(unknown3) + Buffer.varlongLength(trader) + Buffer.varlongLength(player) + Buffer.varuintLength(unknown7.getBytes(StandardCharsets.UTF_8).length) + unknown7.getBytes(StandardCharsets.UTF_8).length + offers.length + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(unknown0);
		this.writeBigEndianByte(unknown1);
		this.writeVarint(unknown2);
		this.writeVarint(unknown3);
		this.writeBool(unknown4);
		this.writeVarlong(trader);
		this.writeVarlong(player);
		byte[] d5b9bc=unknown7.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d5b9bc.length); this.writeBytes(d5b9bc);
		this.writeBytes(offers);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		unknown0=readBigEndianByte();
		unknown1=readBigEndianByte();
		unknown2=this.readVarint();
		unknown3=this.readVarint();
		unknown4=this.readBool();
		trader=this.readVarlong();
		player=this.readVarlong();
		int bvd5b9bc=this.readVaruint(); unknown7=new String(this.readBytes(bvd5b9bc), StandardCharsets.UTF_8);
		offers=this.readBytes(this._buffer.length-this._index);
	}

	public static UpdateTrade fromBuffer(byte[] buffer) {
		UpdateTrade ret = new UpdateTrade();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateTrade(unknown0: " + this.unknown0 + ", unknown1: " + this.unknown1 + ", unknown2: " + this.unknown2 + ", unknown3: " + this.unknown3 + ", unknown4: " + this.unknown4 + ", trader: " + this.trader + ", player: " + this.player + ", unknown7: " + this.unknown7 + ", offers: " + Arrays.toString(this.offers) + ")";
	}

}