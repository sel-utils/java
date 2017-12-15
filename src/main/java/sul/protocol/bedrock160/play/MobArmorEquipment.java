/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import java.util.Arrays;

import sul.utils.*;

public class MobArmorEquipment extends Packet {

	public static final int ID = (int)32;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long entityId;
	public sul.protocol.bedrock160.types.Slot[] armor = new sul.protocol.bedrock160.types.Slot[4];

	public MobArmorEquipment() {}

	public MobArmorEquipment(long entityId, sul.protocol.bedrock160.types.Slot[] armor) {
		this.entityId = entityId;
		this.armor = armor;
	}

	@Override
	public int length() {
		int length=Buffer.varlongLength(entityId) + 1; for(sul.protocol.bedrock160.types.Slot yjbi:armor){ length+=yjbi.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarlong(entityId);
		for(sul.protocol.bedrock160.types.Slot yjbi:armor){ this.writeBytes(yjbi.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVarlong();
		final int bfb9=4; armor=new sul.protocol.bedrock160.types.Slot[bfb9]; for(int yjbi=0;yjbi<armor.length;yjbi++){ armor[yjbi]=new sul.protocol.bedrock160.types.Slot(); armor[yjbi]._index=this._index; armor[yjbi].decode(this._buffer); this._index=armor[yjbi]._index; }
	}

	public static MobArmorEquipment fromBuffer(byte[] buffer) {
		MobArmorEquipment ret = new MobArmorEquipment();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MobArmorEquipment(entityId: " + this.entityId + ", armor: " + Arrays.deepToString(this.armor) + ")";
	}

}