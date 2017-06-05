/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class Camera extends Packet {

	public static final byte ID = (byte)73;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public long unknown0;
	public long unknown1;

	public Camera() {}

	public Camera(long unknown0, long unknown1) {
		this.unknown0 = unknown0;
		this.unknown1 = unknown1;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(unknown0) + Buffer.varlongLength(unknown1) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(unknown0);
		this.writeVarlong(unknown1);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		unknown0=this.readVarlong();
		unknown1=this.readVarlong();
	}

	public static Camera fromBuffer(byte[] buffer) {
		Camera ret = new Camera();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Camera(unknown0: " + this.unknown0 + ", unknown1: " + this.unknown1 + ")";
	}

}