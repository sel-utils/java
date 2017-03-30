/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.types;

import sul.utils.*;

public class Acknowledge extends Stream {

	public boolean unique;
	public int first;
	public int last;

	public Acknowledge() {}

	public Acknowledge(boolean unique, int first, int last) {
		this.unique = unique;
		this.first = first;
		this.last = last;
	}

	@Override
	public int length() {
		return 7;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBool(unique);
		this.writeLittleEndianTriad(first);
		if(unique==false){ this.writeLittleEndianTriad(last); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		unique=this.readBool();
		first=readLittleEndianTriad();
		if(unique==false){ last=readLittleEndianTriad(); }
	}

	@Override
	public String toString() {
		return "Acknowledge(unique: " + this.unique + ", first: " + this.first + ", last: " + this.last + ")";
	}


}