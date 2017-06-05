/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class PlayerListHeaderAndFooter extends Packet {

	public static final int ID = (int)72;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String header;
	public String footer;

	public PlayerListHeaderAndFooter() {}

	public PlayerListHeaderAndFooter(String header, String footer) {
		this.header = header;
		this.footer = footer;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(header.getBytes(StandardCharsets.UTF_8).length) + header.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(footer.getBytes(StandardCharsets.UTF_8).length) + footer.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] avzv=header.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)avzv.length); this.writeBytes(avzv);
		byte[] z9dv=footer.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)z9dv.length); this.writeBytes(z9dv);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvavzv=this.readVaruint(); header=new String(this.readBytes(bvavzv), StandardCharsets.UTF_8);
		int bvz9dv=this.readVaruint(); footer=new String(this.readBytes(bvz9dv), StandardCharsets.UTF_8);
	}

	public static PlayerListHeaderAndFooter fromBuffer(byte[] buffer) {
		PlayerListHeaderAndFooter ret = new PlayerListHeaderAndFooter();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerListHeaderAndFooter(header: " + this.header + ", footer: " + this.footer + ")";
	}

}