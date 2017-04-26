/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import sul.utils.*;

public class PlayerInput extends Packet {

	public static final byte ID = (byte)58;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.FloatXYZ motion = new Tuples.FloatXYZ();
	public byte flags;
	public boolean unknown2;

	public PlayerInput() {}

	public PlayerInput(Tuples.FloatXYZ motion, byte flags, boolean unknown2) {
		this.motion = motion;
		this.flags = flags;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return 15;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		this.writeBigEndianByte(flags);
		this.writeBool(unknown2);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		motion=new Tuples.FloatXYZ(); motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
		flags=readBigEndianByte();
		unknown2=this.readBool();
	}

	public static PlayerInput fromBuffer(byte[] buffer) {
		PlayerInput ret = new PlayerInput();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerInput(motion: " + this.motion.toString() + ", flags: " + this.flags + ", unknown2: " + this.unknown2 + ")";
	}

}