/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java340.xml
 */
package sul.protocol.java340.serverbound;

import sul.utils.*;

public class CraftingBookData extends Packet {

	public static final int ID = (int)23;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int type;

	public CraftingBookData() {}

	public CraftingBookData(int type) {
		this.type = type;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(type) + 1;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(type);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		type=this.readVaruint();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static CraftingBookData fromBuffer(byte[] buffer) {
		CraftingBookData ret = new CraftingBookData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CraftingBookData(type: " + this.type + ")";
	}

	public class DisplayedRecipe extends Packet {

		public static final int TYPE = (int)1;

		@Override
		public int getId() {
			return ID;
		}

		public int id;

		public DisplayedRecipe() {}

		public DisplayedRecipe(int id) {
			this.id = id;
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
			this.writeBigEndianInt(id);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			id=readBigEndianInt();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "CraftingBookData.DisplayedRecipe(id: " + this.id + ")";
		}

	}

	public class CraftingBookStatus extends Packet {

		public static final int TYPE = (int)2;

		@Override
		public int getId() {
			return ID;
		}

		public boolean bookOpened;
		public boolean filtering;

		public CraftingBookStatus() {}

		public CraftingBookStatus(boolean bookOpened, boolean filtering) {
			this.bookOpened = bookOpened;
			this.filtering = filtering;
		}

		@Override
		public int length() {
			return 2;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBool(bookOpened);
			this.writeBool(filtering);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			bookOpened=this.readBool();
			filtering=this.readBool();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "CraftingBookData.CraftingBookStatus(bookOpened: " + this.bookOpened + ", filtering: " + this.filtering + ")";
		}

	}

}