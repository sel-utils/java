/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java210.xml
 */
package sul.protocol.java210.clientbound;

import sul.utils.*;

public class Camera extends Packet {

	public static final int ID = (int)54;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;

	public Camera() {}

	public Camera(int entityId) {
		this.entityId = entityId;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
	}

	public static Camera fromBuffer(byte[] buffer) {
		Camera ret = new Camera();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Camera(entityId: " + this.entityId + ")";
	}

}