/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package sul.protocol.bedrock137.play;

import sul.utils.*;

public class Login extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int protocol = 137;
	public sul.protocol.bedrock137.types.LoginBody body;

	public Login() {}

	public Login(int protocol, sul.protocol.bedrock137.types.LoginBody body) {
		this.protocol = protocol;
		this.body = body;
	}

	@Override
	public int length() {
		return body.length() + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(protocol);
		this.writeBytes(body.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		protocol=readBigEndianInt();
		body=new sul.protocol.bedrock137.types.LoginBody(); body._index=this._index; body.decode(this._buffer); this._index=body._index;
	}

	public static Login fromBuffer(byte[] buffer) {
		Login ret = new Login();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Login(protocol: " + this.protocol + ", body: " + this.body.toString() + ")";
	}

}