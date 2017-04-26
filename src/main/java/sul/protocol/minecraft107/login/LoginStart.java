/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class LoginStart extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public String username;

	public LoginStart() {}

	public LoginStart(String username) {
		this.username = username;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dnc5bu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dnc5bu.length); this.writeBytes(dnc5bu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvdnc5bu=this.readVaruint(); username=new String(this.readBytes(bvdnc5bu), StandardCharsets.UTF_8);
	}

	public static LoginStart fromBuffer(byte[] buffer) {
		LoginStart ret = new LoginStart();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "LoginStart(username: " + this.username + ")";
	}

}