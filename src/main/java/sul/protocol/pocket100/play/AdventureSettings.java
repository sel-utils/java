/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class AdventureSettings extends Packet {

	public static final byte ID = (byte)55;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// flags
	public static final int IMMUTABLE_WORLD = 1;
	public static final int PVP_DISABLED = 2;
	public static final int PVM_DISABLED = 4;
	public static final int MVP_DISBALED = 8;
	public static final int EVP_DISABLED = 16;
	public static final int AUTO_JUMP = 32;
	public static final int ALLOW_FLIGHT = 64;
	public static final int NO_CLIP = 128;
	public static final int FLYING = 512;

	// permissions
	public static final int USER = 0;
	public static final int OPERATOR = 1;
	public static final int HOST = 2;
	public static final int AUTOMATION = 3;
	public static final int ADMIN = 4;

	public int flags;
	public int permissions;

	public AdventureSettings() {}

	public AdventureSettings(int flags, int permissions) {
		this.flags = flags;
		this.permissions = permissions;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(flags) + Buffer.varuintLength(permissions) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(flags);
		this.writeVaruint(permissions);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		flags=this.readVaruint();
		permissions=this.readVaruint();
	}

	public static AdventureSettings fromBuffer(byte[] buffer) {
		AdventureSettings ret = new AdventureSettings();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AdventureSettings(flags: " + this.flags + ", permissions: " + this.permissions + ")";
	}

}