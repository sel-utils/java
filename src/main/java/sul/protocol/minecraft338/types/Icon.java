/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft338.xml
 */
package sul.protocol.minecraft338.types;

import sul.utils.*;

public class Icon extends Stream {

	// direction and type
	public static final byte WHITE_ARROW = (byte)0;
	public static final byte GREEN_ARROW = (byte)1;
	public static final byte RED_ARROW = (byte)2;
	public static final byte BLUE_ARROW = (byte)3;
	public static final byte WHITE_CROSS = (byte)4;
	public static final byte RED_POINTER = (byte)5;
	public static final byte WHITE_CIRCLE = (byte)6;
	public static final byte SMALL_WHITE_CIRCLE = (byte)7;
	public static final byte MANSION = (byte)8;
	public static final byte TEMPLE = (byte)9;

	public byte directionAndType;
	public Tuples.ByteXZ position = new Tuples.ByteXZ();

	public Icon() {}

	public Icon(byte directionAndType, Tuples.ByteXZ position) {
		this.directionAndType = directionAndType;
		this.position = position;
	}

	@Override
	public int length() {
		return 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(directionAndType);
		this.writeBigEndianByte(position.x); this.writeBigEndianByte(position.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		directionAndType=readBigEndianByte();
		position=new Tuples.ByteXZ(); position.x=readBigEndianByte(); position.z=readBigEndianByte();
	}

	@Override
	public String toString() {
		return "Icon(directionAndType: " + this.directionAndType + ", position: " + this.position.toString() + ")";
	}


}