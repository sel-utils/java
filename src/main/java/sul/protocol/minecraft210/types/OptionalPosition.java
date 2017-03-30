/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.types;

import sul.utils.*;

public class OptionalPosition extends Stream {

	public boolean hasPosition;
	public long position;

	public OptionalPosition() {}

	public OptionalPosition(boolean hasPosition, long position) {
		this.hasPosition = hasPosition;
		this.position = position;
	}

	@Override
	public int length() {
		return 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBool(hasPosition);
		if(hasPosition==true){ this.writeBigEndianLong(position); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		hasPosition=this.readBool();
		if(hasPosition==true){ position=readBigEndianLong(); }
	}

	@Override
	public String toString() {
		return "OptionalPosition(hasPosition: " + this.hasPosition + ", position: " + this.position + ")";
	}


}