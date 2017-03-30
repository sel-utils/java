/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import sul.utils.*;

public class TeleportConfirm extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int teleportId;

	public TeleportConfirm() {}

	public TeleportConfirm(int teleportId) {
		this.teleportId = teleportId;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(teleportId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(teleportId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		teleportId=this.readVaruint();
	}

	public static TeleportConfirm fromBuffer(byte[] buffer) {
		TeleportConfirm ret = new TeleportConfirm();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "TeleportConfirm(teleportId: " + this.teleportId + ")";
	}

}