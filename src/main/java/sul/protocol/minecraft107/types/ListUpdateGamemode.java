/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.types;

import java.util.UUID;

import sul.utils.*;

public class ListUpdateGamemode extends Stream {

	// gamemode
	public static final int SURVIVAL = 0;
	public static final int CREATIVE = 1;
	public static final int ADVENTURE = 2;
	public static final int SPECTATOR = 3;

	public UUID uuid;
	public int gamemode;

	public ListUpdateGamemode() {}

	public ListUpdateGamemode(UUID uuid, int gamemode) {
		this.uuid = uuid;
		this.gamemode = gamemode;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(gamemode) + 16;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeVaruint(gamemode);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		gamemode=this.readVaruint();
	}

	@Override
	public String toString() {
		return "ListUpdateGamemode(uuid: " + this.uuid.toString() + ", gamemode: " + this.gamemode + ")";
	}


}