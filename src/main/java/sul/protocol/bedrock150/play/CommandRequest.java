/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock150.xml
 */
package sul.protocol.bedrock150.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class CommandRequest extends Packet {

	public static final int ID = (int)77;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// type
	public static final int PLAYER = (int)0;
	public static final int COMMAND_BLOCK = (int)1;
	public static final int MINECART_COMMAND_BLOCK = (int)2;
	public static final int DEV_CONSOLE = (int)3;

	public String command;
	public int type;
	public sul.protocol.bedrock150.types.McpeUuid uuid;
	public String requestId;
	public int playerId;
	public boolean internal;

	public CommandRequest() {}

	public CommandRequest(String command, int type, sul.protocol.bedrock150.types.McpeUuid uuid, String requestId, int playerId, boolean internal) {
		this.command = command;
		this.type = type;
		this.uuid = uuid;
		this.requestId = requestId;
		this.playerId = playerId;
		this.internal = internal;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(command.getBytes(StandardCharsets.UTF_8).length) + command.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(type) + uuid.length() + Buffer.varuintLength(requestId.getBytes(StandardCharsets.UTF_8).length) + requestId.getBytes(StandardCharsets.UTF_8).length + Buffer.varintLength(playerId) + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] y9bfz=command.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y9bfz.length); this.writeBytes(y9bfz);
		this.writeVaruint(type);
		this.writeBytes(uuid.encode());
		byte[] cvdvdl=requestId.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvdvdl.length); this.writeBytes(cvdvdl);
		if(type==3){ this.writeVarint(playerId); }
		this.writeBool(internal);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvy9bfz=this.readVaruint(); command=new String(this.readBytes(bvy9bfz), StandardCharsets.UTF_8);
		type=this.readVaruint();
		uuid=new sul.protocol.bedrock150.types.McpeUuid(); uuid._index=this._index; uuid.decode(this._buffer); this._index=uuid._index;
		int bvcvdvdl=this.readVaruint(); requestId=new String(this.readBytes(bvcvdvdl), StandardCharsets.UTF_8);
		if(type==3){ playerId=this.readVarint(); }
		internal=this.readBool();
	}

	public static CommandRequest fromBuffer(byte[] buffer) {
		CommandRequest ret = new CommandRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CommandRequest(command: " + this.command + ", type: " + this.type + ", uuid: " + this.uuid.toString() + ", requestId: " + this.requestId + ", playerId: " + this.playerId + ", internal: " + this.internal + ")";
	}

}