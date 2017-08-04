/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft338.xml
 */
package sul.protocol.minecraft.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class AdvancementProgress extends Packet {

	public static final int ID = (int)55;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public boolean notEmpty;
	public String identifier;

	public AdvancementProgress() {}

	public AdvancementProgress(boolean notEmpty, String identifier) {
		this.notEmpty = notEmpty;
		this.identifier = identifier;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(identifier.getBytes(StandardCharsets.UTF_8).length) + identifier.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBool(notEmpty);
		if(notEmpty==true){ byte[] arbrzlc=identifier.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)arbrzlc.length); this.writeBytes(arbrzlc); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		notEmpty=this.readBool();
		if(notEmpty==true){ int bvarbrzl=this.readVaruint(); identifier=new String(this.readBytes(bvarbrzl), StandardCharsets.UTF_8); }
	}

	public static AdvancementProgress fromBuffer(byte[] buffer) {
		AdvancementProgress ret = new AdvancementProgress();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AdvancementProgress(notEmpty: " + this.notEmpty + ", identifier: " + this.identifier + ")";
	}

}