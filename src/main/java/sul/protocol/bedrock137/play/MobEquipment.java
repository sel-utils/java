/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package sul.protocol.bedrock137.play;

import sul.utils.*;

public class MobEquipment extends Packet {

	public static final int ID = (int)31;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public sul.protocol.bedrock137.types.Slot item;
	public byte inventorySlot;
	public byte hotbarSlot;
	public byte unknown4;

	public MobEquipment() {}

	public MobEquipment(long entityId, sul.protocol.bedrock137.types.Slot item, byte inventorySlot, byte hotbarSlot, byte unknown4) {
		this.entityId = entityId;
		this.item = item;
		this.inventorySlot = inventorySlot;
		this.hotbarSlot = hotbarSlot;
		this.unknown4 = unknown4;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + item.length() + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		this.writeBytes(item.encode());
		this.writeLittleEndianByte(inventorySlot);
		this.writeLittleEndianByte(hotbarSlot);
		this.writeLittleEndianByte(unknown4);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		item=new sul.protocol.bedrock137.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
		inventorySlot=readLittleEndianByte();
		hotbarSlot=readLittleEndianByte();
		unknown4=readLittleEndianByte();
	}

	public static MobEquipment fromBuffer(byte[] buffer) {
		MobEquipment ret = new MobEquipment();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MobEquipment(entityId: " + this.entityId + ", item: " + this.item.toString() + ", inventorySlot: " + this.inventorySlot + ", hotbarSlot: " + this.hotbarSlot + ", unknown4: " + this.unknown4 + ")";
	}

}