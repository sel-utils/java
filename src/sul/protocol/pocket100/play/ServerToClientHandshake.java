/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class ServerToClientHandshake extends Packet {

	public static final byte ID = (byte)3;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String serverPublicKey;
	public byte[] token = new byte[0];

	public ServerToClientHandshake() {}

	public ServerToClientHandshake(String serverPublicKey, byte[] token) {
		this.serverPublicKey = serverPublicKey;
		this.token = token;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(serverPublicKey.getBytes(StandardCharsets.UTF_8).length) + serverPublicKey.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(token.length) + token.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] cvdvuvbl=serverPublicKey.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvdvuvbl.length); this.writeBytes(cvdvuvbl);
		this.writeVaruint((int)token.length); this.writeBytes(token);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvcvdvuv=this.readVaruint(); serverPublicKey=new String(this.readBytes(bvcvdvuv), StandardCharsets.UTF_8);
		int brav=this.readVaruint(); token=this.readBytes(brav);
	}

	public static ServerToClientHandshake fromBuffer(byte[] buffer) {
		ServerToClientHandshake ret = new ServerToClientHandshake();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ServerToClientHandshake(serverPublicKey: " + this.serverPublicKey + ", token: " + Arrays.toString(this.token) + ")";
	}

}
