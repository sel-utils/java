/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import sul.utils.*;

public class BlockBreakAnimation extends Packet {

	public static final int ID = (int)8;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public long position;
	public byte stage;

	public BlockBreakAnimation() {}

	public BlockBreakAnimation(int entityId, long position, byte stage) {
		this.entityId = entityId;
		this.position = position;
		this.stage = stage;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(stage);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		position=readBigEndianLong();
		stage=readBigEndianByte();
	}

	public static BlockBreakAnimation fromBuffer(byte[] buffer) {
		BlockBreakAnimation ret = new BlockBreakAnimation();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "BlockBreakAnimation(entityId: " + this.entityId + ", position: " + this.position + ", stage: " + this.stage + ")";
	}

}