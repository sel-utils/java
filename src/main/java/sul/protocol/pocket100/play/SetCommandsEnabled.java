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

public class SetCommandsEnabled extends Packet {

	public static final byte ID = (byte)59;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public boolean enabled;

	public SetCommandsEnabled() {}

	public SetCommandsEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBool(enabled);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		enabled=this.readBool();
	}

	public static SetCommandsEnabled fromBuffer(byte[] buffer) {
		SetCommandsEnabled ret = new SetCommandsEnabled();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetCommandsEnabled(enabled: " + this.enabled + ")";
	}

}