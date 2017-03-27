/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import sul.utils.*;

public class Respawn extends Packet {

	public static final byte ID = (byte)46;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();

	public Respawn() {}

	public Respawn(Tuples.FloatXYZ position) {
		this.position = position;
	}

	@Override
	public int length() {
		return 13;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
	}

	public static Respawn fromBuffer(byte[] buffer) {
		Respawn ret = new Respawn();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Respawn(position: " + this.position.toString() + ")";
	}

}
