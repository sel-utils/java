/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket102.xml
 */
package sul.protocol.pocket102.play;

import java.util.Arrays;

import sul.utils.*;

public class ResourcePacksStackPacket extends Packet {

	public static final byte ID = (byte)8;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public boolean mustAccept;
	public sul.protocol.pocket102.types.Pack[] behaviourPacks = new sul.protocol.pocket102.types.Pack[0];
	public sul.protocol.pocket102.types.Pack[] resourcePacks = new sul.protocol.pocket102.types.Pack[0];

	public ResourcePacksStackPacket() {}

	public ResourcePacksStackPacket(boolean mustAccept, sul.protocol.pocket102.types.Pack[] behaviourPacks, sul.protocol.pocket102.types.Pack[] resourcePacks) {
		this.mustAccept = mustAccept;
		this.behaviourPacks = behaviourPacks;
		this.resourcePacks = resourcePacks;
	}

	@Override
	public int length() {
		int length=6; for(sul.protocol.pocket102.types.Pack yvyzbvuf:behaviourPacks){ length+=yvyzbvuf.length(); };for(sul.protocol.pocket102.types.Pack cvbvyvyn:resourcePacks){ length+=cvbvyvyn.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBool(mustAccept);
		this.writeLittleEndianShort((short)behaviourPacks.length); for(sul.protocol.pocket102.types.Pack yvyzbvuf:behaviourPacks){ this.writeBytes(yvyzbvuf.encode()); }
		this.writeLittleEndianShort((short)resourcePacks.length); for(sul.protocol.pocket102.types.Pack cvbvyvyn:resourcePacks){ this.writeBytes(cvbvyvyn.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		mustAccept=this.readBool();
		int bjafa9cb=readLittleEndianShort(); behaviourPacks=new sul.protocol.pocket102.types.Pack[bjafa9cb]; for(int yvyzbvuf=0;yvyzbvuf<behaviourPacks.length;yvyzbvuf++){ behaviourPacks[yvyzbvuf]=new sul.protocol.pocket102.types.Pack(); behaviourPacks[yvyzbvuf]._index=this._index; behaviourPacks[yvyzbvuf].decode(this._buffer); this._index=behaviourPacks[yvyzbvuf]._index; }
		int bjc9cnuf=readLittleEndianShort(); resourcePacks=new sul.protocol.pocket102.types.Pack[bjc9cnuf]; for(int cvbvyvyn=0;cvbvyvyn<resourcePacks.length;cvbvyvyn++){ resourcePacks[cvbvyvyn]=new sul.protocol.pocket102.types.Pack(); resourcePacks[cvbvyvyn]._index=this._index; resourcePacks[cvbvyvyn].decode(this._buffer); this._index=resourcePacks[cvbvyvyn]._index; }
	}

	public static ResourcePacksStackPacket fromBuffer(byte[] buffer) {
		ResourcePacksStackPacket ret = new ResourcePacksStackPacket();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePacksStackPacket(mustAccept: " + this.mustAccept + ", behaviourPacks: " + Arrays.deepToString(this.behaviourPacks) + ", resourcePacks: " + Arrays.deepToString(this.resourcePacks) + ")";
	}

}
