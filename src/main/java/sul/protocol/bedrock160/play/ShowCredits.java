/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import sul.utils.*;

public class ShowCredits extends Packet {

	public static final int ID = (int)75;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// status
	public static final int START = (int)0;
	public static final int END = (int)1;

	public long entityId;
	public int status;

	public ShowCredits() {}

	public ShowCredits(long entityId, int status) {
		this.entityId = entityId;
		this.status = status;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varintLength(status) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeVarint(status);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		status=this.readVarint();
	}

	public static ShowCredits fromBuffer(byte[] buffer) {
		ShowCredits ret = new ShowCredits();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ShowCredits(entityId: " + this.entityId + ", status: " + this.status + ")";
	}

}