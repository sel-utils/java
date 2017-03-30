/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.status;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Notifies the node that another node (that is not itself) has connected to the hub.
 */
public class AddNode extends Packet {

	public static final byte ID = (byte)7;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Identifier given by the hub to uniquey identify the node.
	 */
	public int hubId;

	/**
	 * Node's name used for displaying and identification purposes.
	 */
	public String name;

	/**
	 * Whether the node is a main node (see ConnectionRequest.main).
	 */
	public boolean main;

	/**
	 * Indicates the game accepted by the node.
	 */
	public sul.protocol.hncom2.types.Game[] acceptedGames = new sul.protocol.hncom2.types.Game[0];

	public AddNode() {}

	public AddNode(int hubId, String name, boolean main, sul.protocol.hncom2.types.Game[] acceptedGames) {
		this.hubId = hubId;
		this.name = name;
		this.main = main;
		this.acceptedGames = acceptedGames;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(hubId) + Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(acceptedGames.length) + 2; for(sul.protocol.hncom2.types.Game ynzbzry1:acceptedGames){ length+=ynzbzry1.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeBool(main);
		this.writeVaruint((int)acceptedGames.length); for(sul.protocol.hncom2.types.Game ynzbzry1:acceptedGames){ this.writeBytes(ynzbzry1.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		main=this.readBool();
		int bfyvdvrf=this.readVaruint(); acceptedGames=new sul.protocol.hncom2.types.Game[bfyvdvrf]; for(int ynzbzry1=0;ynzbzry1<acceptedGames.length;ynzbzry1++){ acceptedGames[ynzbzry1]=new sul.protocol.hncom2.types.Game(); acceptedGames[ynzbzry1]._index=this._index; acceptedGames[ynzbzry1].decode(this._buffer); this._index=acceptedGames[ynzbzry1]._index; }
	}

	public static AddNode fromBuffer(byte[] buffer) {
		AddNode ret = new AddNode();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddNode(hubId: " + this.hubId + ", name: " + this.name + ", main: " + this.main + ", acceptedGames: " + Arrays.deepToString(this.acceptedGames) + ")";
	}

}