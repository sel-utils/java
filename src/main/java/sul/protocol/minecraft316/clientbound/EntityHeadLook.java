/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.utils.*;

public class EntityHeadLook extends Packet {

	public static final int ID = (int)52;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public byte headYaw;

	public EntityHeadLook() {}

	public EntityHeadLook(int entityId, byte headYaw) {
		this.entityId = entityId;
		this.headYaw = headYaw;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(headYaw);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		headYaw=readBigEndianByte();
	}

	public static EntityHeadLook fromBuffer(byte[] buffer) {
		EntityHeadLook ret = new EntityHeadLook();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityHeadLook(entityId: " + this.entityId + ", headYaw: " + this.headYaw + ")";
	}

}