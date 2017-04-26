/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.types;

import java.util.Arrays;

import sul.utils.*;

public class Section extends Stream {

	public byte storageVersion = 0;
	public byte[] blockIds = new byte[4096];
	public byte[] blockMetas = new byte[2048];
	public byte[] skyLight = new byte[2048];
	public byte[] blockLight = new byte[2048];

	public Section() {}

	public Section(byte storageVersion, byte[] blockIds, byte[] blockMetas, byte[] skyLight, byte[] blockLight) {
		this.storageVersion = storageVersion;
		this.blockIds = blockIds;
		this.blockMetas = blockMetas;
		this.skyLight = skyLight;
		this.blockLight = blockLight;
	}

	@Override
	public int length() {
		return 10241;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(storageVersion);
		this.writeBytes(blockIds);
		this.writeBytes(blockMetas);
		this.writeBytes(skyLight);
		this.writeBytes(blockLight);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		storageVersion=readBigEndianByte();
		final int bjbnsr=4096; blockIds=this.readBytes(bjbnsr);
		final int bjbntvym=2048; blockMetas=this.readBytes(bjbntvym);
		final int bnexzh=2048; skyLight=this.readBytes(bnexzh);
		final int bjbntlaq=2048; blockLight=this.readBytes(bjbntlaq);
	}

	@Override
	public String toString() {
		return "Section(storageVersion: " + this.storageVersion + ", blockIds: " + Arrays.toString(this.blockIds) + ", blockMetas: " + Arrays.toString(this.blockMetas) + ", skyLight: " + Arrays.toString(this.skyLight) + ", blockLight: " + Arrays.toString(this.blockLight) + ")";
	}


}