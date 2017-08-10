/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket132.xml
 */
package sul.protocol.pocket132.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class PurchaseReceipt extends Packet {

	public static final int ID = (int)92;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public String[] unknown0 = new String[0];

	public PurchaseReceipt() {}

	public PurchaseReceipt(String[] unknown0) {
		this.unknown0 = unknown0;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(unknown0.length) + 2; for(String d5b9ba:unknown0){ length+=Buffer.varuintLength(d5b9ba.getBytes(StandardCharsets.UTF_8).length)+d5b9ba.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)unknown0.length); for(String d5b9ba:unknown0){ byte[] zvoj=d5b9ba.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zvoj.length); this.writeBytes(zvoj); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bva5d4=this.readVaruint(); unknown0=new String[bva5d4]; for(int d5b9ba=0;d5b9ba<unknown0.length;d5b9ba++){ int bvd5b9bb=this.readVaruint(); unknown0[d5b9ba]=new String(this.readBytes(bvd5b9bb), StandardCharsets.UTF_8); }
	}

	public static PurchaseReceipt fromBuffer(byte[] buffer) {
		PurchaseReceipt ret = new PurchaseReceipt();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PurchaseReceipt(unknown0: " + Arrays.deepToString(this.unknown0) + ")";
	}

}