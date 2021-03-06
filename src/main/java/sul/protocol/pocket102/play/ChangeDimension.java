/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import sul.utils.*;

public class ChangeDimension extends Packet {

	public static final byte ID = (byte)61;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// dimension
	public static final int OVERWORLD = (int)0;
	public static final int NETHER = (int)1;
	public static final int END = (int)2;

	public int dimension;
	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public boolean unknown2;

	public ChangeDimension() {}

	public ChangeDimension(int dimension, Tuples.FloatXYZ position, boolean unknown2) {
		this.dimension = dimension;
		this.position = position;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return Buffer.varintLength(dimension) + 14;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(dimension);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeBool(unknown2);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		dimension=this.readVarint();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		unknown2=this.readBool();
	}

	public static ChangeDimension fromBuffer(byte[] buffer) {
		ChangeDimension ret = new ChangeDimension();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChangeDimension(dimension: " + this.dimension + ", position: " + this.position.toString() + ", unknown2: " + this.unknown2 + ")";
	}

}