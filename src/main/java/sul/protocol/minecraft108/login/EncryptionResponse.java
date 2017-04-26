/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.login;

import java.util.Arrays;

import sul.utils.*;

public class EncryptionResponse extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte[] sharedSecret = new byte[0];
	public byte[] verifyToken = new byte[0];

	public EncryptionResponse() {}

	public EncryptionResponse(byte[] sharedSecret, byte[] verifyToken) {
		this.sharedSecret = sharedSecret;
		this.verifyToken = verifyToken;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(sharedSecret.length) + sharedSecret.length + Buffer.varuintLength(verifyToken.length) + verifyToken.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)sharedSecret.length); this.writeBytes(sharedSecret);
		this.writeVaruint((int)verifyToken.length); this.writeBytes(verifyToken);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bnyjznyj=this.readVaruint(); sharedSecret=this.readBytes(bnyjznyj);
		int bzclerav=this.readVaruint(); verifyToken=this.readBytes(bzclerav);
	}

	public static EncryptionResponse fromBuffer(byte[] buffer) {
		EncryptionResponse ret = new EncryptionResponse();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EncryptionResponse(sharedSecret: " + Arrays.toString(this.sharedSecret) + ", verifyToken: " + Arrays.toString(this.verifyToken) + ")";
	}

}