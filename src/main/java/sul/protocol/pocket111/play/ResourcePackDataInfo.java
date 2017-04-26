/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket111.xml
 */
package sul.protocol.pocket111.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ResourcePackDataInfo extends Packet {

	public static final byte ID = (byte)83;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String id;
	public int maxChunkSize;
	public int chunkCount;
	public long compressedPackSize;
	public String sha256;

	public ResourcePackDataInfo() {}

	public ResourcePackDataInfo(String id, int maxChunkSize, int chunkCount, long compressedPackSize, String sha256) {
		this.id = id;
		this.maxChunkSize = maxChunkSize;
		this.chunkCount = chunkCount;
		this.compressedPackSize = compressedPackSize;
		this.sha256 = sha256;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id.getBytes(StandardCharsets.UTF_8).length) + id.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(maxChunkSize) + Buffer.varuintLength(chunkCount) + Buffer.varulongLength(compressedPackSize) + Buffer.varuintLength(sha256.getBytes(StandardCharsets.UTF_8).length) + sha256.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] aq=id.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aq.length); this.writeBytes(aq);
		this.writeVaruint(maxChunkSize);
		this.writeVaruint(chunkCount);
		this.writeVarulong(compressedPackSize);
		byte[] chmu=sha256.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)chmu.length); this.writeBytes(chmu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvaq=this.readVaruint(); id=new String(this.readBytes(bvaq), StandardCharsets.UTF_8);
		maxChunkSize=this.readVaruint();
		chunkCount=this.readVaruint();
		compressedPackSize=this.readVarulong();
		int bvchmu=this.readVaruint(); sha256=new String(this.readBytes(bvchmu), StandardCharsets.UTF_8);
	}

	public static ResourcePackDataInfo fromBuffer(byte[] buffer) {
		ResourcePackDataInfo ret = new ResourcePackDataInfo();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackDataInfo(id: " + this.id + ", maxChunkSize: " + this.maxChunkSize + ", chunkCount: " + this.chunkCount + ", compressedPackSize: " + this.compressedPackSize + ", sha256: " + this.sha256 + ")";
	}

}