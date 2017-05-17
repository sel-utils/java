/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket112.xml
 */
package sul.protocol.pocket112.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class PlaySound extends Packet {

	public static final byte ID = (byte)87;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String name;
	public sul.protocol.pocket112.types.BlockPosition position;
	public float volume;
	public float pitch;

	public PlaySound() {}

	public PlaySound(String name, sul.protocol.pocket112.types.BlockPosition position, float volume, float pitch) {
		this.name = name;
		this.position = position;
		this.volume = volume;
		this.pitch = pitch;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + position.length() + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeBytes(position.encode());
		this.writeLittleEndianFloat(volume);
		this.writeLittleEndianFloat(pitch);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		position=new sul.protocol.pocket112.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		volume=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
	}

	public static PlaySound fromBuffer(byte[] buffer) {
		PlaySound ret = new PlaySound();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlaySound(name: " + this.name + ", position: " + this.position.toString() + ", volume: " + this.volume + ", pitch: " + this.pitch + ")";
	}

}