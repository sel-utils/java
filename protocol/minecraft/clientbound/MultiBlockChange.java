/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft338.xml
 */
package sul.protocol.minecraft.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class MultiBlockChange extends Packet {

	public static final int ID = (int)16;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.IntXZ chunk = new Tuples.IntXZ();
	public sul.protocol.minecraft.types.BlockChange[] changes = new sul.protocol.minecraft.types.BlockChange[0];

	public MultiBlockChange() {}

	public MultiBlockChange(Tuples.IntXZ chunk, sul.protocol.minecraft.types.BlockChange[] changes) {
		this.chunk = chunk;
		this.changes = changes;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(changes.length) + 9; for(sul.protocol.minecraft.types.BlockChange yhbdc:changes){ length+=yhbdc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(chunk.x); this.writeBigEndianInt(chunk.z);
		this.writeVaruint((int)changes.length); for(sul.protocol.minecraft.types.BlockChange yhbdc:changes){ this.writeBytes(yhbdc.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		chunk=new Tuples.IntXZ(); chunk.x=readBigEndianInt(); chunk.z=readBigEndianInt();
		int bny5zm=this.readVaruint(); changes=new sul.protocol.minecraft.types.BlockChange[bny5zm]; for(int yhbdc=0;yhbdc<changes.length;yhbdc++){ changes[yhbdc]=new sul.protocol.minecraft.types.BlockChange(); changes[yhbdc]._index=this._index; changes[yhbdc].decode(this._buffer); this._index=changes[yhbdc]._index; }
	}

	public static MultiBlockChange fromBuffer(byte[] buffer) {
		MultiBlockChange ret = new MultiBlockChange();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MultiBlockChange(chunk: " + this.chunk.toString() + ", changes: " + Arrays.deepToString(this.changes) + ")";
	}

}