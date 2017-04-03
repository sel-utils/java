/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket110.xml
 */
package sul.protocol.pocket110.play;

import java.util.Arrays;

import sul.utils.*;

public class CraftingData extends Packet {

	public static final byte ID = (byte)53;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public sul.protocol.pocket110.types.Recipe[] recipes = new sul.protocol.pocket110.types.Recipe[0];

	public CraftingData() {}

	public CraftingData(sul.protocol.pocket110.types.Recipe[] recipes) {
		this.recipes = recipes;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(recipes.length) + 1; for(sul.protocol.pocket110.types.Recipe cvabc:recipes){ length+=cvabc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint((int)recipes.length); for(sul.protocol.pocket110.types.Recipe cvabc:recipes){ this.writeBytes(cvabc.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bjylzm=this.readVaruint(); recipes=new sul.protocol.pocket110.types.Recipe[bjylzm]; for(int cvabc=0;cvabc<recipes.length;cvabc++){ recipes[cvabc]=new sul.protocol.pocket110.types.Recipe(); recipes[cvabc]._index=this._index; recipes[cvabc].decode(this._buffer); this._index=recipes[cvabc]._index; }
	}

	public static CraftingData fromBuffer(byte[] buffer) {
		CraftingData ret = new CraftingData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CraftingData(recipes: " + Arrays.deepToString(this.recipes) + ")";
	}

}