/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.play;

import sul.utils.*;

public class PlayerInput extends Packet {

	public static final int ID = (int)57;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public float sideways;
	public float forward;
	public boolean unknown2;
	public boolean unknown3;

	public PlayerInput() {}

	public PlayerInput(float sideways, float forward, boolean unknown2, boolean unknown3) {
		this.sideways = sideways;
		this.forward = forward;
		this.unknown2 = unknown2;
		this.unknown3 = unknown3;
	}

	@Override
	public int length() {
		return 11;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeLittleEndianFloat(sideways);
		this.writeLittleEndianFloat(forward);
		this.writeBool(unknown2);
		this.writeBool(unknown3);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		sideways=readLittleEndianFloat();
		forward=readLittleEndianFloat();
		unknown2=this.readBool();
		unknown3=this.readBool();
	}

	public static PlayerInput fromBuffer(byte[] buffer) {
		PlayerInput ret = new PlayerInput();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerInput(sideways: " + this.sideways + ", forward: " + this.forward + ", unknown2: " + this.unknown2 + ", unknown3: " + this.unknown3 + ")";
	}

}