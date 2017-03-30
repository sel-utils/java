/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Disconnect extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String reason;

	public Disconnect() {}

	public Disconnect(String reason) {
		this.reason = reason;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(reason.getBytes(StandardCharsets.UTF_8).length) + reason.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] cvc9=reason.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvc9.length); this.writeBytes(cvc9);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvcvc9=this.readVaruint(); reason=new String(this.readBytes(bvcvc9), StandardCharsets.UTF_8);
	}

	public static Disconnect fromBuffer(byte[] buffer) {
		Disconnect ret = new Disconnect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Disconnect(reason: " + this.reason + ")";
	}

}