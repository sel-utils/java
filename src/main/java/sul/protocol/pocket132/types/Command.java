/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket132.xml
 */
package sul.protocol.pocket132.types;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class Command extends Stream {

	public String name;
	public String description;
	public byte unknown2;
	public byte permissionLevel;
	public int aliasesEnum = -1;
	public sul.protocol.pocket132.types.Overload[] overloads = new sul.protocol.pocket132.types.Overload[0];

	public Command() {}

	public Command(String name, String description, byte unknown2, byte permissionLevel, int aliasesEnum, sul.protocol.pocket132.types.Overload[] overloads) {
		this.name = name;
		this.description = description;
		this.unknown2 = unknown2;
		this.permissionLevel = permissionLevel;
		this.aliasesEnum = aliasesEnum;
		this.overloads = overloads;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(description.getBytes(StandardCharsets.UTF_8).length) + description.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(overloads.length) + 6; for(sul.protocol.pocket132.types.Overload bzcxyr:overloads){ length+=bzcxyr.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		byte[] zvyjcrb4=description.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zvyjcrb4.length); this.writeBytes(zvyjcrb4);
		this.writeLittleEndianByte(unknown2);
		this.writeLittleEndianByte(permissionLevel);
		this.writeLittleEndianInt(aliasesEnum);
		this.writeVaruint((int)overloads.length); for(sul.protocol.pocket132.types.Overload bzcxyr:overloads){ this.writeBytes(bzcxyr.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		int bvzvyjcr=this.readVaruint(); description=new String(this.readBytes(bvzvyjcr), StandardCharsets.UTF_8);
		unknown2=readLittleEndianByte();
		permissionLevel=readLittleEndianByte();
		aliasesEnum=readLittleEndianInt();
		int b9zjbfc=this.readVaruint(); overloads=new sul.protocol.pocket132.types.Overload[b9zjbfc]; for(int bzcxyr=0;bzcxyr<overloads.length;bzcxyr++){ overloads[bzcxyr]=new sul.protocol.pocket132.types.Overload(); overloads[bzcxyr]._index=this._index; overloads[bzcxyr].decode(this._buffer); this._index=overloads[bzcxyr]._index; }
	}

	@Override
	public String toString() {
		return "Command(name: " + this.name + ", description: " + this.description + ", unknown2: " + this.unknown2 + ", permissionLevel: " + this.permissionLevel + ", aliasesEnum: " + this.aliasesEnum + ", overloads: " + Arrays.deepToString(this.overloads) + ")";
	}


}