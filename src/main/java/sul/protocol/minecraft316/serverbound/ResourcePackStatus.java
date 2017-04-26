/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import sul.utils.*;

public class ResourcePackStatus extends Packet {

	public static final int ID = (int)22;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// result
	public static final int LOADED = 0;
	public static final int DECLINED = 1;
	public static final int FAILED = 2;
	public static final int ACCEPTED = 3;

	public int result;

	public ResourcePackStatus() {}

	public ResourcePackStatus(int result) {
		this.result = result;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(result) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(result);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		result=this.readVaruint();
	}

	public static ResourcePackStatus fromBuffer(byte[] buffer) {
		ResourcePackStatus ret = new ResourcePackStatus();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackStatus(result: " + this.result + ")";
	}

}