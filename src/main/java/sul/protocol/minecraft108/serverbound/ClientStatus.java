/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.serverbound;

import sul.utils.*;

public class ClientStatus extends Packet {

	public static final int ID = (int)3;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final int RESPAWN = 0;
	public static final int REQUEST_STATS = 1;
	public static final int OPEN_INVENTORY = 2;

	public int action;

	public ClientStatus() {}

	public ClientStatus(int action) {
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(action) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		action=this.readVaruint();
	}

	public static ClientStatus fromBuffer(byte[] buffer) {
		ClientStatus ret = new ClientStatus();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ClientStatus(action: " + this.action + ")";
	}

}