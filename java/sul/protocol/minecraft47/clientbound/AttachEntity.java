/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import sul.utils.*;

public class AttachEntity extends Packet {

	public static final int ID = (int)27;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int target;
	public int holder;
	public boolean leash;

	public AttachEntity() {}

	public AttachEntity(int target, int holder, boolean leash) {
		this.target = target;
		this.holder = holder;
		this.leash = leash;
	}

	@Override
	public int length() {
		return 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(target);
		this.writeBigEndianInt(holder);
		this.writeBool(leash);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		target=readBigEndianInt();
		holder=readBigEndianInt();
		leash=this.readBool();
	}

	public static AttachEntity fromBuffer(byte[] buffer) {
		AttachEntity ret = new AttachEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AttachEntity(target: " + this.target + ", holder: " + this.holder + ", leash: " + this.leash + ")";
	}

}
