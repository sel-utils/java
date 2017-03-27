/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class DisplayScoreboard extends Packet {

	public static final int ID = (int)56;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// position
	public static final byte LIST = 0;
	public static final byte SIDEBAR = 1;
	public static final byte BELOW_NAME = 2;

	public byte position;
	public String scoreName;

	public DisplayScoreboard() {}

	public DisplayScoreboard(byte position, String scoreName) {
		this.position = position;
		this.scoreName = scoreName;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(scoreName.getBytes(StandardCharsets.UTF_8).length) + scoreName.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(position);
		byte[] cncvy1=scoreName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cncvy1.length); this.writeBytes(cncvy1);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianByte();
		int bvcncvy1=this.readVaruint(); scoreName=new String(this.readBytes(bvcncvy1), StandardCharsets.UTF_8);
	}

	public static DisplayScoreboard fromBuffer(byte[] buffer) {
		DisplayScoreboard ret = new DisplayScoreboard();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "DisplayScoreboard(position: " + this.position + ", scoreName: " + this.scoreName + ")";
	}

}
