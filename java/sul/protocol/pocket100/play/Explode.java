/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.Arrays;

import sul.utils.*;

public class Explode extends Packet {

	public static final byte ID = (byte)25;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public float radius;
	public sul.protocol.pocket100.types.BlockPosition[] destroyedBlocks = new sul.protocol.pocket100.types.BlockPosition[0];

	public Explode() {}

	public Explode(Tuples.FloatXYZ position, float radius, sul.protocol.pocket100.types.BlockPosition[] destroyedBlocks) {
		this.position = position;
		this.radius = radius;
		this.destroyedBlocks = destroyedBlocks;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(destroyedBlocks.length) + 17; for(sul.protocol.pocket100.types.BlockPosition zvdjevqx:destroyedBlocks){ length+=zvdjevqx.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(radius);
		this.writeVaruint((int)destroyedBlocks.length); for(sul.protocol.pocket100.types.BlockPosition zvdjevqx:destroyedBlocks){ this.writeBytes(zvdjevqx.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new Tuples.FloatXYZ(); position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		radius=readLittleEndianFloat();
		int brcrblzj=this.readVaruint(); destroyedBlocks=new sul.protocol.pocket100.types.BlockPosition[brcrblzj]; for(int zvdjevqx=0;zvdjevqx<destroyedBlocks.length;zvdjevqx++){ destroyedBlocks[zvdjevqx]=new sul.protocol.pocket100.types.BlockPosition(); destroyedBlocks[zvdjevqx]._index=this._index; destroyedBlocks[zvdjevqx].decode(this._buffer); this._index=destroyedBlocks[zvdjevqx]._index; }
	}

	public static Explode fromBuffer(byte[] buffer) {
		Explode ret = new Explode();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Explode(position: " + this.position.toString() + ", radius: " + this.radius + ", destroyedBlocks: " + Arrays.deepToString(this.destroyedBlocks) + ")";
	}

}
