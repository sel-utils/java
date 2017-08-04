/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft338.xml
 */
package sul.protocol.minecraft338.clientbound;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

public class BossBar extends Packet {

	public static final int ID = (int)12;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public UUID uuid;
	public int action;

	public BossBar() {}

	public BossBar(UUID uuid, int action) {
		this.uuid = uuid;
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(action) + 17;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeVaruint(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		action=this.readVaruint();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static BossBar fromBuffer(byte[] buffer) {
		BossBar ret = new BossBar();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "BossBar(uuid: " + this.uuid.toString() + ", action: " + this.action + ")";
	}

	public class Add extends Packet {

		public static final int ACTION = (int)0;

		@Override
		public int getId() {
			return ID;
		}

		// color
		public static final int PINK = 0;
		public static final int BLUE = 1;
		public static final int RED = 2;
		public static final int GREEN = 3;
		public static final int YELLOW = 4;
		public static final int PURPLE = 5;
		public static final int WHITE = 6;

		// division
		public static final int NO_DIVISION = 0;
		public static final int SIX_NOTCHES = 1;
		public static final int TEN_NOTCHES = 2;
		public static final int TWELVE_NOTCHES = 3;
		public static final int TWENTY_NOTCHES = 4;

		// flags
		public static final byte DARK_SKY = 1;
		public static final byte IS_DRAGON_BAR = 2;

		public String title;
		public float health;
		public int color;
		public int division;
		public byte flags;

		public Add() {}

		public Add(String title, float health, int color, int division, byte flags) {
			this.title = title;
			this.health = health;
			this.color = color;
			this.division = division;
			this.flags = flags;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(color) + Buffer.varuintLength(division) + 5;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dlbu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dlbu.length); this.writeBytes(dlbu);
			this.writeBigEndianFloat(health);
			this.writeVaruint(color);
			this.writeVaruint(division);
			this.writeBigEndianByte(flags);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvdlbu=this.readVaruint(); title=new String(this.readBytes(bvdlbu), StandardCharsets.UTF_8);
			health=readBigEndianFloat();
			color=this.readVaruint();
			division=this.readVaruint();
			flags=readBigEndianByte();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "BossBar.Add(title: " + this.title + ", health: " + this.health + ", color: " + this.color + ", division: " + this.division + ", flags: " + this.flags + ")";
		}

	}

	public class Remove extends Packet {

		public static final int ACTION = (int)1;

		@Override
		public int getId() {
			return ID;
		}

		@Override
		public int length() {
			return 0;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "BossBar.Remove()";
		}

	}

	public class UpdateHealth extends Packet {

		public static final int ACTION = (int)2;

		@Override
		public int getId() {
			return ID;
		}

		public float health;

		public UpdateHealth() {}

		public UpdateHealth(float health) {
			this.health = health;
		}

		@Override
		public int length() {
			return 4;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianFloat(health);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			health=readBigEndianFloat();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "BossBar.UpdateHealth(health: " + this.health + ")";
		}

	}

	public class UpdateTitle extends Packet {

		public static final int ACTION = (int)3;

		@Override
		public int getId() {
			return ID;
		}

		public String title;

		public UpdateTitle() {}

		public UpdateTitle(String title) {
			this.title = title;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dlbu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dlbu.length); this.writeBytes(dlbu);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvdlbu=this.readVaruint(); title=new String(this.readBytes(bvdlbu), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "BossBar.UpdateTitle(title: " + this.title + ")";
		}

	}

	public class UpdateStyle extends Packet {

		public static final int ACTION = (int)4;

		@Override
		public int getId() {
			return ID;
		}

		// color
		public static final int PINK = 0;
		public static final int BLUE = 1;
		public static final int RED = 2;
		public static final int GREEN = 3;
		public static final int YELLOW = 4;
		public static final int PURPLE = 5;
		public static final int WHITE = 6;

		// division
		public static final int NO_DIVISION = 0;
		public static final int SIX_NOTCHES = 1;
		public static final int TEN_NOTCHES = 2;
		public static final int TWELVE_NOTCHES = 3;
		public static final int TWENTY_NOTCHES = 4;

		public int color;
		public int division;

		public UpdateStyle() {}

		public UpdateStyle(int color, int division) {
			this.color = color;
			this.division = division;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(color) + Buffer.varuintLength(division);
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint(color);
			this.writeVaruint(division);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			color=this.readVaruint();
			division=this.readVaruint();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "BossBar.UpdateStyle(color: " + this.color + ", division: " + this.division + ")";
		}

	}

	public class UpdateFlags extends Packet {

		public static final int ACTION = (int)5;

		@Override
		public int getId() {
			return ID;
		}

		// flags
		public static final byte DARK_SKY = 1;
		public static final byte IS_DRAGON_BAR = 2;

		public byte flags;

		public UpdateFlags() {}

		public UpdateFlags(byte flags) {
			this.flags = flags;
		}

		@Override
		public int length() {
			return 1;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianByte(flags);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			flags=readBigEndianByte();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "BossBar.UpdateFlags(flags: " + this.flags + ")";
		}

	}

}