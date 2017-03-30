/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.utils.*;

public class EntityLook extends Packet {

	public static final int ID = (int)39;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public byte yaw;
	public byte pitch;
	public boolean onGround;

	public EntityLook() {}

	public EntityLook(int entityId, byte yaw, byte pitch, boolean onGround) {
		this.entityId = entityId;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(entityId) + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianByte(pitch);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		yaw=readBigEndianByte();
		pitch=readBigEndianByte();
		onGround=this.readBool();
	}

	public static EntityLook fromBuffer(byte[] buffer) {
		EntityLook ret = new EntityLook();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityLook(entityId: " + this.entityId + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", onGround: " + this.onGround + ")";
	}

}