/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.login;

import java.util.Arrays;

import sul.utils.*;

/**
 * Performs authentication following the instruncions given by the AuthCredentials
 * packet.
 */
public class Auth extends Packet {

	public static final byte ID = (byte)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Pasword encoded as UTF-8 if AuthCredentials.hash is `false` or the hash (specified
	 * in AuthCredentials.hashAlgorithm) of the password encoded as UTF-8 concatenated
	 * with the bytes from AuthCredentials.payload if `true`.
	 * The hash can be done with a function (if hashAlgorithm is `sha1`) in D:
	 * <code>
	 * sha1Of(cast(ubyte[])password ~ authCredentials.payload);
	 * </code>
	 * Or using `MessageDigest` in Java:
	 * <code>
	 * MessageDigest md = MessageDigest.getInstance(authCredentials.hashAlgorithm);
	 * md.update(password.getBytes(StandardCharsets.UTF_8));
	 * md.update(authCredentials.payload);
	 * byte[] hash = md.digest();
	 * </code>
	 */
	public byte[] hash = new byte[0];

	public Auth() {}

	public Auth(byte[] hash) {
		this.hash = hash;
	}

	@Override
	public int length() {
		return hash.length + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianShort((short)hash.length); this.writeBytes(hash);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bhcg=readBigEndianShort(); hash=this.readBytes(bhcg);
	}

	public static Auth fromBuffer(byte[] buffer) {
		Auth ret = new Auth();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Auth(hash: " + Arrays.toString(this.hash) + ")";
	}

}