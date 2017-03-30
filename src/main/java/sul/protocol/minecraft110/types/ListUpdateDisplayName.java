/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.types;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

public class ListUpdateDisplayName extends Stream {

	public UUID uuid;
	public boolean hasDisplayName;
	public String displayName;

	public ListUpdateDisplayName() {}

	public ListUpdateDisplayName(UUID uuid, boolean hasDisplayName, String displayName) {
		this.uuid = uuid;
		this.hasDisplayName = hasDisplayName;
		this.displayName = displayName;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeBool(hasDisplayName);
		if(hasDisplayName==true){ byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		hasDisplayName=this.readBool();
		if(hasDisplayName==true){ int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8); }
	}

	@Override
	public String toString() {
		return "ListUpdateDisplayName(uuid: " + this.uuid.toString() + ", hasDisplayName: " + this.hasDisplayName + ", displayName: " + this.displayName + ")";
	}


}