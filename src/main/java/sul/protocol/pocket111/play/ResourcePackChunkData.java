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
import java.util.Arrays;

import sul.utils.*;

public class ResourcePackChunkData extends Packet {

	public static final byte ID = (byte)84;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String id;
	public int chunkIndex;
	public long progress;
	public byte[] data = new byte[0];

	public ResourcePackChunkData() {}

	public ResourcePackChunkData(String id, int chunkIndex, long progress, byte[] data) {
		this.id = id;
		this.chunkIndex = chunkIndex;
		this.progress = progress;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id.getBytes(StandardCharsets.UTF_8).length) + id.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(chunkIndex) + Buffer.varulongLength(progress) + Buffer.varuintLength(data.length) + data.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] aq=id.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aq.length); this.writeBytes(aq);
		this.writeVaruint(chunkIndex);
		this.writeVarulong(progress);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvaq=this.readVaruint(); id=new String(this.readBytes(bvaq), StandardCharsets.UTF_8);
		chunkIndex=this.readVaruint();
		progress=this.readVarulong();
		int brde=this.readVaruint(); data=this.readBytes(brde);
	}

	public static ResourcePackChunkData fromBuffer(byte[] buffer) {
		ResourcePackChunkData ret = new ResourcePackChunkData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackChunkData(id: " + this.id + ", chunkIndex: " + this.chunkIndex + ", progress: " + this.progress + ", data: " + Arrays.toString(this.data) + ")";
	}

}