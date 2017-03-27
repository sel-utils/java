/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.types;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class Attribute extends Stream {

	public String key;
	public double value;
	public sul.protocol.minecraft315.types.Modifier[] modifiers = new sul.protocol.minecraft315.types.Modifier[0];

	public Attribute() {}

	public Attribute(String key, double value, sul.protocol.minecraft315.types.Modifier[] modifiers) {
		this.key = key;
		this.value = value;
		this.modifiers = modifiers;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(key.getBytes(StandardCharsets.UTF_8).length) + key.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(modifiers.length) + 8; for(sul.protocol.minecraft315.types.Modifier b9azzj:modifiers){ length+=b9azzj.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] av=key.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)av.length); this.writeBytes(av);
		this.writeBigEndianDouble(value);
		this.writeVaruint((int)modifiers.length); for(sul.protocol.minecraft315.types.Modifier b9azzj:modifiers){ this.writeBytes(b9azzj.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvav=this.readVaruint(); key=new String(this.readBytes(bvav), StandardCharsets.UTF_8);
		value=readBigEndianDouble();
		int b1zlavc=this.readVaruint(); modifiers=new sul.protocol.minecraft315.types.Modifier[b1zlavc]; for(int b9azzj=0;b9azzj<modifiers.length;b9azzj++){ modifiers[b9azzj]=new sul.protocol.minecraft315.types.Modifier(); modifiers[b9azzj]._index=this._index; modifiers[b9azzj].decode(this._buffer); this._index=modifiers[b9azzj]._index; }
	}

	@Override
	public String toString() {
		return "Attribute(key: " + this.key + ", value: " + this.value + ", modifiers: " + Arrays.deepToString(this.modifiers) + ")";
	}


}
