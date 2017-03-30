/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.utils.*;

public class KeepAlive extends Packet {

	public static final int ID = (int)31;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int id;

	public KeepAlive() {}

	public KeepAlive(int id) {
		this.id = id;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(id);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		id=this.readVaruint();
	}

	public static KeepAlive fromBuffer(byte[] buffer) {
		KeepAlive ret = new KeepAlive();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "KeepAlive(id: " + this.id + ")";
	}

}