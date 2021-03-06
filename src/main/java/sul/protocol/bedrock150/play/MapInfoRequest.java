/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock150.xml
 */
package sul.protocol.bedrock150.play;

import sul.utils.*;

public class MapInfoRequest extends Packet {

	public static final int ID = (int)68;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long mapId;

	public MapInfoRequest() {}

	public MapInfoRequest(long mapId) {
		this.mapId = mapId;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(mapId) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(mapId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		mapId=this.readVarlong();
	}

	public static MapInfoRequest fromBuffer(byte[] buffer) {
		MapInfoRequest ret = new MapInfoRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MapInfoRequest(mapId: " + this.mapId + ")";
	}

}