/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class UpdateTrade extends Packet {

	public static final byte ID = (byte)80;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public byte windowType = 15;
	public int unknown2;
	public int unknown3;
	public boolean willing;
	public long trader;
	public long player;
	public String displayName;
	public byte[] offers = new byte[0];

	public UpdateTrade() {}

	public UpdateTrade(byte window, byte windowType, int unknown2, int unknown3, boolean willing, long trader, long player, String displayName, byte[] offers) {
		this.window = window;
		this.windowType = windowType;
		this.unknown2 = unknown2;
		this.unknown3 = unknown3;
		this.willing = willing;
		this.trader = trader;
		this.player = player;
		this.displayName = displayName;
		this.offers = offers;
	}

	@Override
	public int length() {
		return Buffer.varintLength(unknown2) + Buffer.varintLength(unknown3) + Buffer.varlongLength(trader) + Buffer.varlongLength(player) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + offers.length + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianByte(windowType);
		this.writeVarint(unknown2);
		this.writeVarint(unknown3);
		this.writeBool(willing);
		this.writeVarlong(trader);
		this.writeVarlong(player);
		byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
		this.writeBytes(offers);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		window=readBigEndianByte();
		windowType=readBigEndianByte();
		unknown2=this.readVarint();
		unknown3=this.readVarint();
		willing=this.readBool();
		trader=this.readVarlong();
		player=this.readVarlong();
		int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
		offers=this.readBytes(this._buffer.length-this._index);
	}

	public static UpdateTrade fromBuffer(byte[] buffer) {
		UpdateTrade ret = new UpdateTrade();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateTrade(window: " + this.window + ", windowType: " + this.windowType + ", unknown2: " + this.unknown2 + ", unknown3: " + this.unknown3 + ", willing: " + this.willing + ", trader: " + this.trader + ", player: " + this.player + ", displayName: " + this.displayName + ", offers: " + Arrays.toString(this.offers) + ")";
	}

}