/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft338.xml
 */
package sul.protocol.minecraft.clientbound;

import sul.utils.*;

public class ChangeGameState extends Packet {

	public static final int ID = (int)30;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// reason
	public static final byte INVALID_BED = (byte)0;
	public static final byte END_RAINING = (byte)1;
	public static final byte BEGIN_RAINING = (byte)2;
	public static final byte CHANGE_GAMEMODE = (byte)3;
	public static final byte EXIT_END = (byte)4;
	public static final byte DEMO_MESSAGE = (byte)5;
	public static final byte ARROW_HITTING_PLAYER = (byte)6;
	public static final byte FADE_VALUE = (byte)7;
	public static final byte FADE_TIME = (byte)8;
	public static final byte PLAY_ELDER_GUARDIAN_MOB_APPEARANCE = (byte)10;

	// value
	public static final float SURVIVAL = (float)0;
	public static final float CREATIVE = (float)1;
	public static final float ADVENTURE = (float)2;
	public static final float SPECTATOR = (float)3;
	public static final float RESPAWN_IMMEDIATELY = (float)0;
	public static final float RESPAWN_AFTER_CREDITS = (float)1;
	public static final float SHOW_DEMO_SCREEN = (float)0;
	public static final float TELL_MOVEMENT_CONTROLS = (float)101;
	public static final float TELL_JUMP_CONTROLS = (float)102;
	public static final float TELL_INVENTORY_CONTROLS = (float)103;
	public static final float BRIGHT = (float)0;
	public static final float DARK = (float)1;

	public byte reason;
	public float value;

	public ChangeGameState() {}

	public ChangeGameState(byte reason, float value) {
		this.reason = reason;
		this.value = value;
	}

	@Override
	public int length() {
		return 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(reason);
		this.writeBigEndianFloat(value);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		reason=readBigEndianByte();
		value=readBigEndianFloat();
	}

	public static ChangeGameState fromBuffer(byte[] buffer) {
		ChangeGameState ret = new ChangeGameState();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChangeGameState(reason: " + this.reason + ", value: " + this.value + ")";
	}

}