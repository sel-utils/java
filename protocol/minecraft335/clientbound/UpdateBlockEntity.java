/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft335.xml
 */
package sul.protocol.minecraft335.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class UpdateBlockEntity extends Packet {

	public static final int ID = (int)9;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte MOB_SPAWNER_DATA = (byte)1;
	public static final byte COMMAND_BLOCK_TEXT = (byte)2;
	public static final byte BEACON_POWERS = (byte)3;
	public static final byte MOB_HEAD_DATA = (byte)4;
	public static final byte FLOWER_POT_FLOWER = (byte)5;
	public static final byte BANNER_DATA = (byte)6;
	public static final byte STRUCTURE_DATA = (byte)7;
	public static final byte END_GATEWAY_DESTINATION = (byte)8;
	public static final byte SIGN_TEXT = (byte)9;
	public static final byte SHULKER_BOX_DECLARATION = (byte)10;
	public static final byte BED_COLOR = (byte)11;

	public long position;
	public byte action;
	public byte[] nbt = new byte[0];

	public UpdateBlockEntity() {}

	public UpdateBlockEntity(long position, byte action, byte[] nbt) {
		this.position = position;
		this.action = action;
		this.nbt = nbt;
	}

	@Override
	public int length() {
		return nbt.length + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(action);
		this.writeBytes(nbt);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		action=readBigEndianByte();
		nbt=this.readBytes(this._buffer.length-this._index);
	}

	public static UpdateBlockEntity fromBuffer(byte[] buffer) {
		UpdateBlockEntity ret = new UpdateBlockEntity();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateBlockEntity(position: " + this.position + ", action: " + this.action + ", nbt: " + Arrays.toString(this.nbt) + ")";
	}

}