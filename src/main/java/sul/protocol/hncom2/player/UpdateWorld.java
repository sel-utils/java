/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.player;

import sul.utils.*;

/**
 * Updates player's world and dimension.
 */
public class UpdateWorld extends Packet {

	public static final byte ID = (byte)22;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int hubId;
	public int world;

	public UpdateWorld() {}

	public UpdateWorld(int hubId, int world) {
		this.hubId = hubId;
		this.world = world;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + Buffer.varuintLength(world) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		this.writeVaruint(world);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		world=this.readVaruint();
	}

	public static UpdateWorld fromBuffer(byte[] buffer) {
		UpdateWorld ret = new UpdateWorld();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateWorld(hubId: " + this.hubId + ", world: " + this.world + ")";
	}

}