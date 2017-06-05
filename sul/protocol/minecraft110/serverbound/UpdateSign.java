/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.serverbound;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class UpdateSign extends Packet {

	public static final int ID = (int)25;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long position;
	public String[] lines = new String[4];

	public UpdateSign() {}

	public UpdateSign(long position, String[] lines) {
		this.position = position;
		this.lines = lines;
	}

	@Override
	public int length() {
		int length=9; for(String blzm:lines){ length+=Buffer.varuintLength(blzm.getBytes(StandardCharsets.UTF_8).length)+blzm.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		for(String blzm:lines){ byte[] yxb=blzm.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yxb.length); this.writeBytes(yxb); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		final int bxbv=4; lines=new String[bxbv]; for(int blzm=0;blzm<lines.length;blzm++){ int bvblznyx=this.readVaruint(); lines[blzm]=new String(this.readBytes(bvblznyx), StandardCharsets.UTF_8); }
	}

	public static UpdateSign fromBuffer(byte[] buffer) {
		UpdateSign ret = new UpdateSign();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateSign(position: " + this.position + ", lines: " + Arrays.deepToString(this.lines) + ")";
	}

}