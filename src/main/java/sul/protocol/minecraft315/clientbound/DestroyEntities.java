/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class DestroyEntities extends Packet {

	public static final int ID = (int)48;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int[] entityIds = new int[0];

	public DestroyEntities() {}

	public DestroyEntities(int[] entityIds) {
		this.entityIds = entityIds;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(entityIds.length) + 1; for(int z5arsr:entityIds){ length+=Buffer.varuintLength(z5arsr); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)entityIds.length); for(int z5arsr:entityIds){ this.writeVaruint(z5arsr); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvdlelc=this.readVaruint(); entityIds=new int[bvdlelc]; for(int z5arsr=0;z5arsr<entityIds.length;z5arsr++){ entityIds[z5arsr]=this.readVaruint(); }
	}

	public static DestroyEntities fromBuffer(byte[] buffer) {
		DestroyEntities ret = new DestroyEntities();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "DestroyEntities(entityIds: " + Arrays.toString(this.entityIds) + ")";
	}

}