/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.player;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Updates the player's language when the client changes it.
 */
public class UpdateLanguage extends Packet {

	public static final byte ID = (byte)24;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int hubId;

	/**
	 * Player's language in the same format as HubInfo.language.
	 */
	public String language;

	public UpdateLanguage() {}

	public UpdateLanguage(int hubId, String language) {
		this.hubId = hubId;
		this.language = language;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + Buffer.varuintLength(language.getBytes(StandardCharsets.UTF_8).length) + language.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		byte[] bfzvzu=language.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfzvzu.length); this.writeBytes(bfzvzu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		int bvbfzvzu=this.readVaruint(); language=new String(this.readBytes(bvbfzvzu), StandardCharsets.UTF_8);
	}

	public static UpdateLanguage fromBuffer(byte[] buffer) {
		UpdateLanguage ret = new UpdateLanguage();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateLanguage(hubId: " + this.hubId + ", language: " + this.language + ")";
	}

}