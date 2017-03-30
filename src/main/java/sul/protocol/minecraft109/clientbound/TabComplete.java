/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class TabComplete extends Packet {

	public static final int ID = (int)14;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String[] matches = new String[0];

	public TabComplete() {}

	public TabComplete(String[] matches) {
		this.matches = matches;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(matches.length) + 1; for(String bfyhc:matches){ length+=Buffer.varuintLength(bfyhc.getBytes(StandardCharsets.UTF_8).length)+bfyhc.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)matches.length); for(String bfyhc:matches){ byte[] yzam=bfyhc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yzam.length); this.writeBytes(yzam); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int b1dnzm=this.readVaruint(); matches=new String[b1dnzm]; for(int bfyhc=0;bfyhc<matches.length;bfyhc++){ int bvbfyhct=this.readVaruint(); matches[bfyhc]=new String(this.readBytes(bvbfyhct), StandardCharsets.UTF_8); }
	}

	public static TabComplete fromBuffer(byte[] buffer) {
		TabComplete ret = new TabComplete();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "TabComplete(matches: " + Arrays.deepToString(this.matches) + ")";
	}

}