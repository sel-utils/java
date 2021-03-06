/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.util.Arrays;
import java.util.UUID;

import sul.utils.*;

public class CraftingEvent extends Packet {

	public static final byte ID = (byte)54;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte window;
	public int type;
	public UUID uuid;
	public sul.protocol.pocket101.types.Slot[] input = new sul.protocol.pocket101.types.Slot[0];
	public sul.protocol.pocket101.types.Slot[] output = new sul.protocol.pocket101.types.Slot[0];

	public CraftingEvent() {}

	public CraftingEvent(byte window, int type, UUID uuid, sul.protocol.pocket101.types.Slot[] input, sul.protocol.pocket101.types.Slot[] output) {
		this.window = window;
		this.type = type;
		this.uuid = uuid;
		this.input = input;
		this.output = output;
	}

	@Override
	public int length() {
		int length=Buffer.varintLength(type) + Buffer.varuintLength(input.length) + Buffer.varuintLength(output.length) + 18; for(sul.protocol.pocket101.types.Slot a5dq:input){ length+=a5dq.length(); };for(sul.protocol.pocket101.types.Slot bvcv:output){ length+=bvcv.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(window);
		this.writeVarint(type);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeVaruint((int)input.length); for(sul.protocol.pocket101.types.Slot a5dq:input){ this.writeBytes(a5dq.encode()); }
		this.writeVaruint((int)output.length); for(sul.protocol.pocket101.types.Slot bvcv:output){ this.writeBytes(bvcv.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		window=readBigEndianByte();
		type=this.readVarint();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		int blcv=this.readVaruint(); input=new sul.protocol.pocket101.types.Slot[blcv]; for(int a5dq=0;a5dq<input.length;a5dq++){ input[a5dq]=new sul.protocol.pocket101.types.Slot(); input[a5dq]._index=this._index; input[a5dq].decode(this._buffer); this._index=input[a5dq]._index; }
		int b9dbd=this.readVaruint(); output=new sul.protocol.pocket101.types.Slot[b9dbd]; for(int bvcv=0;bvcv<output.length;bvcv++){ output[bvcv]=new sul.protocol.pocket101.types.Slot(); output[bvcv]._index=this._index; output[bvcv].decode(this._buffer); this._index=output[bvcv]._index; }
	}

	public static CraftingEvent fromBuffer(byte[] buffer) {
		CraftingEvent ret = new CraftingEvent();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CraftingEvent(window: " + this.window + ", type: " + this.type + ", uuid: " + this.uuid.toString() + ", input: " + Arrays.deepToString(this.input) + ", output: " + Arrays.deepToString(this.output) + ")";
	}

}