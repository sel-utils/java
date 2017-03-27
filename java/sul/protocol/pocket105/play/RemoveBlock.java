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

/**
 * Instantly removes a block, either because the player is in creative mode or because
 * the target block's hardness is 0 or lower (after all enchantments are applied).
 */
public class RemoveBlock extends Packet {

	public static final byte ID = (byte)22;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public sul.protocol.pocket105.types.BlockPosition position;

	public RemoveBlock() {}

	public RemoveBlock(sul.protocol.pocket105.types.BlockPosition position) {
		this.position = position;
	}

	@Override
	public int length() {
		return position.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(position.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new sul.protocol.pocket105.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
	}

	public static RemoveBlock fromBuffer(byte[] buffer) {
		RemoveBlock ret = new RemoveBlock();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "RemoveBlock(position: " + this.position.toString() + ")";
	}

}
