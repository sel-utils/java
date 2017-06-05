/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom.player;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Kicks a player from the node and the whole server. When a player is disconnected
 * from the node using this packet the hub will not send the Remove packet.
 */
public class Kick extends Packet {

	public static final byte ID = (byte)19;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int hubId;

	/**
	 * Reason of the disconnection that will be displayed in the client's disconnection
	 * screen.
	 */
	public String reason;

	/**
	 * Whether the previous string should be translated client-side or not.
	 */
	public boolean translation;

	/**
	 * Optional parameters for the translation.
	 */
	public String[] parameters = new String[0];

	public Kick() {}

	public Kick(int hubId, String reason, boolean translation, String[] parameters) {
		this.hubId = hubId;
		this.reason = reason;
		this.translation = translation;
		this.parameters = parameters;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(hubId) + Buffer.varuintLength(reason.getBytes(StandardCharsets.UTF_8).length) + reason.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(parameters.length) + 2; for(String cfy1dvc:parameters){ length+=Buffer.varuintLength(cfy1dvc.getBytes(StandardCharsets.UTF_8).length)+cfy1dvc.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		byte[] cvc9=reason.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvc9.length); this.writeBytes(cvc9);
		this.writeBool(translation);
		if(translation==true){ this.writeVaruint((int)parameters.length); for(String cfy1dvc:parameters){ byte[] yzmry=cfy1dvc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yzmry.length); this.writeBytes(yzmry); } }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		int bvcvc9=this.readVaruint(); reason=new String(this.readBytes(bvcvc9), StandardCharsets.UTF_8);
		translation=this.readBool();
		if(translation==true){ int bbcfzrcm=this.readVaruint(); parameters=new String[bbcfzrcm]; for(int cfy1dvc=0;cfy1dvc<parameters.length;cfy1dvc++){ int bvcfy1dv=this.readVaruint(); parameters[cfy1dvc]=new String(this.readBytes(bvcfy1dv), StandardCharsets.UTF_8); } }
	}

	public static Kick fromBuffer(byte[] buffer) {
		Kick ret = new Kick();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Kick(hubId: " + this.hubId + ", reason: " + this.reason + ", translation: " + this.translation + ", parameters: " + Arrays.deepToString(this.parameters) + ")";
	}

}