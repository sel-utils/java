/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket110.xml
 */
package sul.protocol.pocket110.play;

import sul.utils.*;

public class SetSpawnPosition extends Packet {

	public static final byte ID = (byte)43;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int unknown0;
	public sul.protocol.pocket110.types.BlockPosition position;
	public boolean unknown2;

	public SetSpawnPosition() {}

	public SetSpawnPosition(int unknown0, sul.protocol.pocket110.types.BlockPosition position, boolean unknown2) {
		this.unknown0 = unknown0;
		this.position = position;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return Buffer.varintLength(unknown0) + position.length() + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(unknown0);
		this.writeBytes(position.encode());
		this.writeBool(unknown2);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		unknown0=this.readVarint();
		position=new sul.protocol.pocket110.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		unknown2=this.readBool();
	}

	public static SetSpawnPosition fromBuffer(byte[] buffer) {
		SetSpawnPosition ret = new SetSpawnPosition();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetSpawnPosition(unknown0: " + this.unknown0 + ", position: " + this.position.toString() + ", unknown2: " + this.unknown2 + ")";
	}

}