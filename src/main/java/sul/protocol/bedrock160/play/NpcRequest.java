/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class NpcRequest extends Packet {

	public static final int ID = (int)98;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public byte requestType;
	public String command;
	public byte actionType;

	public NpcRequest() {}

	public NpcRequest(long entityId, byte requestType, String command, byte actionType) {
		this.entityId = entityId;
		this.requestType = requestType;
		this.command = command;
		this.actionType = actionType;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varuintLength(command.getBytes(StandardCharsets.UTF_8).length) + command.getBytes(StandardCharsets.UTF_8).length + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianByte(requestType);
		byte[] y9bfz=command.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y9bfz.length); this.writeBytes(y9bfz);
		this.writeLittleEndianByte(actionType);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		requestType=readLittleEndianByte();
		int bvy9bfz=this.readVaruint(); command=new String(this.readBytes(bvy9bfz), StandardCharsets.UTF_8);
		actionType=readLittleEndianByte();
	}

	public static NpcRequest fromBuffer(byte[] buffer) {
		NpcRequest ret = new NpcRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "NpcRequest(entityId: " + this.entityId + ", requestType: " + this.requestType + ", command: " + this.command + ", actionType: " + this.actionType + ")";
	}

}