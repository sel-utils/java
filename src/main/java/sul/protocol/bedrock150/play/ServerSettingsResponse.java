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

public class ServerSettingsResponse extends Packet {

	public static final int ID = (int)103;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int formId;
	public String data;

	public ServerSettingsResponse() {}

	public ServerSettingsResponse(int formId, String data) {
		this.formId = formId;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(formId) + Buffer.varuintLength(data.getBytes(StandardCharsets.UTF_8).length) + data.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(formId);
		byte[] zfy=data.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zfy.length); this.writeBytes(zfy);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		formId=this.readVaruint();
		int bvzfy=this.readVaruint(); data=new String(this.readBytes(bvzfy), StandardCharsets.UTF_8);
	}

	public static ServerSettingsResponse fromBuffer(byte[] buffer) {
		ServerSettingsResponse ret = new ServerSettingsResponse();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ServerSettingsResponse(formId: " + this.formId + ", data: " + this.data + ")";
	}

}