/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ResourcePackSend extends Packet {

	public static final int ID = (int)50;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String url;
	public String hash;

	public ResourcePackSend() {}

	public ResourcePackSend(String url, String hash) {
		this.url = url;
		this.hash = hash;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(url.getBytes(StandardCharsets.UTF_8).length) + url.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(hash.getBytes(StandardCharsets.UTF_8).length) + hash.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dj=url.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dj.length); this.writeBytes(dj);
		byte[] afa=hash.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)afa.length); this.writeBytes(afa);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvdj=this.readVaruint(); url=new String(this.readBytes(bvdj), StandardCharsets.UTF_8);
		int bvafa=this.readVaruint(); hash=new String(this.readBytes(bvafa), StandardCharsets.UTF_8);
	}

	public static ResourcePackSend fromBuffer(byte[] buffer) {
		ResourcePackSend ret = new ResourcePackSend();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackSend(url: " + this.url + ", hash: " + this.hash + ")";
	}

}