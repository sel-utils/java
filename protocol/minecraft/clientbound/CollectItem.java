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

public class CollectItem extends Packet {

	public static final int ID = (int)75;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int collected;
	public int collector;
	public int count;

	public CollectItem() {}

	public CollectItem(int collected, int collector, int count) {
		this.collected = collected;
		this.collector = collector;
		this.count = count;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(collected) + Buffer.varuintLength(collector) + Buffer.varuintLength(count) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(collected);
		this.writeVaruint(collector);
		this.writeVaruint(count);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		collected=this.readVaruint();
		collector=this.readVaruint();
		count=this.readVaruint();
	}

	public static CollectItem fromBuffer(byte[] buffer) {
		CollectItem ret = new CollectItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CollectItem(collected: " + this.collected + ", collector: " + this.collector + ", count: " + this.count + ")";
	}

}