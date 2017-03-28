/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ScoreboardObjective extends Packet {

	public static final int ID = (int)63;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// mode
	public static final byte CREATE = 0;
	public static final byte REMOVE = 1;
	public static final byte UPDATE = 2;

	// type
	public static final String NUMERIC = "integer";
	public static final String GRAPHIC = "hearts";

	public String name;
	public byte mode;
	public String value;
	public String type;

	public ScoreboardObjective() {}

	public ScoreboardObjective(String name, byte mode, String value, String type) {
		this.name = name;
		this.mode = mode;
		this.value = value;
		this.type = type;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(value.getBytes(StandardCharsets.UTF_8).length) + value.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(type.getBytes(StandardCharsets.UTF_8).length) + type.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeBigEndianByte(mode);
		if(mode!=1){ byte[] dfdu=value.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dfdu.length); this.writeBytes(dfdu); }
		if(mode!=1){ byte[] dlz=type.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dlz.length); this.writeBytes(dlz); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		mode=readBigEndianByte();
		if(mode!=1){ int bvdfdu=this.readVaruint(); value=new String(this.readBytes(bvdfdu), StandardCharsets.UTF_8); }
		if(mode!=1){ int bvdlz=this.readVaruint(); type=new String(this.readBytes(bvdlz), StandardCharsets.UTF_8); }
	}

	public static ScoreboardObjective fromBuffer(byte[] buffer) {
		ScoreboardObjective ret = new ScoreboardObjective();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ScoreboardObjective(name: " + this.name + ", mode: " + this.mode + ", value: " + this.value + ", type: " + this.type + ")";
	}

}
