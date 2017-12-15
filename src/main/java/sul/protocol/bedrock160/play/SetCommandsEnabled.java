/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import sul.utils.*;

/**
 * Indicates whether the cheats are enabled. If not the client cannot send commands.
 */
public class SetCommandsEnabled extends Packet {

	public static final int ID = (int)59;

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
		this.writeVaruint(ID);
		this.writeBool(enabled);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
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