/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class Map extends Packet {

	public static final int ID = (int)36;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int mapId;
	public byte scale;
	public boolean showIcons;
	public sul.protocol.minecraft210.types.Icon[] icons = new sul.protocol.minecraft210.types.Icon[0];
	public byte colums;
	public byte rows;
	public Tuples.ByteXZ offset = new Tuples.ByteXZ();
	public byte[] data = new byte[0];

	public Map() {}

	public Map(int mapId, byte scale, boolean showIcons, sul.protocol.minecraft210.types.Icon[] icons, byte colums, byte rows, Tuples.ByteXZ offset, byte[] data) {
		this.mapId = mapId;
		this.scale = scale;
		this.showIcons = showIcons;
		this.icons = icons;
		this.colums = colums;
		this.rows = rows;
		this.offset = offset;
		this.data = data;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(mapId) + Buffer.varuintLength(icons.length) + Buffer.varuintLength(data.length) + data.length + 7; for(sul.protocol.minecraft210.types.Icon anbm:icons){ length+=anbm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(mapId);
		this.writeBigEndianByte(scale);
		this.writeBool(showIcons);
		this.writeVaruint((int)icons.length); for(sul.protocol.minecraft210.types.Icon anbm:icons){ this.writeBytes(anbm.encode()); }
		this.writeBigEndianByte(colums);
		this.writeBigEndianByte(rows);
		this.writeBigEndianByte(offset.x); this.writeBigEndianByte(offset.z);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		mapId=this.readVaruint();
		scale=readBigEndianByte();
		showIcons=this.readBool();
		int blb5=this.readVaruint(); icons=new sul.protocol.minecraft210.types.Icon[blb5]; for(int anbm=0;anbm<icons.length;anbm++){ icons[anbm]=new sul.protocol.minecraft210.types.Icon(); icons[anbm]._index=this._index; icons[anbm].decode(this._buffer); this._index=icons[anbm]._index; }
		colums=readBigEndianByte();
		rows=readBigEndianByte();
		offset=new Tuples.ByteXZ(); offset.x=readBigEndianByte(); offset.z=readBigEndianByte();
		int brde=this.readVaruint(); data=this.readBytes(brde);
	}

	public static Map fromBuffer(byte[] buffer) {
		Map ret = new Map();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Map(mapId: " + this.mapId + ", scale: " + this.scale + ", showIcons: " + this.showIcons + ", icons: " + Arrays.deepToString(this.icons) + ", colums: " + this.colums + ", rows: " + this.rows + ", offset: " + this.offset.toString() + ", data: " + Arrays.toString(this.data) + ")";
	}

}