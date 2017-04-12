/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket110.xml
 */
package sul.protocol.pocket110.play;

import java.util.Arrays;

import sul.utils.*;

/**
 * First MCPE packet sent after the establishment of the connection through raknet.
 * It contains informations about the player.
 */
public class Login extends Packet {

	public static final byte ID = (byte)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// version
	public static final byte VANILLA = 0;
	public static final byte EDUCATION = 1;

	/**
	 * Version of the protocol used by the player.
	 */
	public int protocol = 110;

	/**
	 * Edition that the player is using to join the server. The different editions may
	 * have different features and servers may block the access from unaccepted editions
	 * of the game.
	 */
	public byte version;

	/**
	 * Zlib-compressed bytes that contains 2 JWTs with more informations about the player
	 * and its account. Once uncompressed the resulting payload will contain 2 JWTs which
	 * length is indicated by a little-endian unsigned integer each.
	 */
	public byte[] body = new byte[0];

	public Login() {}

	public Login(int protocol, byte version, byte[] body) {
		this.protocol = protocol;
		this.version = version;
		this.body = body;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(body.length) + body.length + 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianInt(protocol);
		this.writeBigEndianByte(version);
		this.writeVaruint((int)body.length); this.writeBytes(body);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		protocol=readBigEndianInt();
		version=readBigEndianByte();
		int bjzk=this.readVaruint(); body=this.readBytes(bjzk);
	}

	public static Login fromBuffer(byte[] buffer) {
		Login ret = new Login();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Login(protocol: " + this.protocol + ", version: " + this.version + ", body: " + Arrays.toString(this.body) + ")";
	}

}