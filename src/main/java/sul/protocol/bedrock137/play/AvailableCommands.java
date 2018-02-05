/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package sul.protocol.bedrock137.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class AvailableCommands extends Packet {

	public static final int ID = (int)76;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String[] enumValues = new String[0];
	public String[] unknown1 = new String[0];
	public sul.protocol.bedrock137.types.Enum[] enums = new sul.protocol.bedrock137.types.Enum[0];
	public sul.protocol.bedrock137.types.Command[] commands = new sul.protocol.bedrock137.types.Command[0];

	public AvailableCommands() {}

	public AvailableCommands(String[] enumValues, String[] unknown1, sul.protocol.bedrock137.types.Enum[] enums, sul.protocol.bedrock137.types.Command[] commands) {
		this.enumValues = enumValues;
		this.unknown1 = unknown1;
		this.enums = enums;
		this.commands = commands;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(enumValues.length) + Buffer.varuintLength(unknown1.length) + Buffer.varuintLength(enums.length) + Buffer.varuintLength(commands.length) + 2; for(String z5bzbvc:enumValues){ length+=Buffer.varuintLength(z5bzbvc.getBytes(StandardCharsets.UTF_8).length)+z5bzbvc.getBytes(StandardCharsets.UTF_8).length; };for(String d5b9be:unknown1){ length+=Buffer.varuintLength(d5b9be.getBytes(StandardCharsets.UTF_8).length)+d5b9be.getBytes(StandardCharsets.UTF_8).length; };for(sul.protocol.bedrock137.types.Enum z5bm:enums){ length+=z5bm.length(); };for(sul.protocol.bedrock137.types.Command y9bfzm:commands){ length+=y9bfzm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)enumValues.length); for(String z5bzbvc:enumValues){ byte[] evejy=z5bzbvc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)evejy.length); this.writeBytes(evejy); }
		this.writeVaruint((int)unknown1.length); for(String d5b9be:unknown1){ byte[] zvoj=d5b9be.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zvoj.length); this.writeBytes(zvoj); }
		this.writeVaruint((int)enums.length); for(sul.protocol.bedrock137.types.Enum z5bm:enums){ this.writeBytes(z5bm.encode()); }
		this.writeVaruint((int)commands.length); for(sul.protocol.bedrock137.types.Command y9bfzm:commands){ this.writeBytes(y9bfzm.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvd1yxzm=this.readVaruint(); enumValues=new String[bvd1yxzm]; for(int z5bzbvc=0;z5bzbvc<enumValues.length;z5bzbvc++){ int bvz5bzbv=this.readVaruint(); enumValues[z5bzbvc]=new String(this.readBytes(bvz5bzbv), StandardCharsets.UTF_8); }
		int bva5d4=this.readVaruint(); unknown1=new String[bva5d4]; for(int d5b9be=0;d5b9be<unknown1.length;d5b9be++){ int bvd5b9bf=this.readVaruint(); unknown1[d5b9be]=new String(this.readBytes(bvd5b9bf), StandardCharsets.UTF_8); }
		int bvd1=this.readVaruint(); enums=new sul.protocol.bedrock137.types.Enum[bvd1]; for(int z5bm=0;z5bm<enums.length;z5bm++){ enums[z5bm]=new sul.protocol.bedrock137.types.Enum(); enums[z5bm]._index=this._index; enums[z5bm].decode(this._buffer); this._index=enums[z5bm]._index; }
		int bnb1br=this.readVaruint(); commands=new sul.protocol.bedrock137.types.Command[bnb1br]; for(int y9bfzm=0;y9bfzm<commands.length;y9bfzm++){ commands[y9bfzm]=new sul.protocol.bedrock137.types.Command(); commands[y9bfzm]._index=this._index; commands[y9bfzm].decode(this._buffer); this._index=commands[y9bfzm]._index; }
	}

	public static AvailableCommands fromBuffer(byte[] buffer) {
		AvailableCommands ret = new AvailableCommands();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AvailableCommands(enumValues: " + Arrays.deepToString(this.enumValues) + ", unknown1: " + Arrays.deepToString(this.unknown1) + ", enums: " + Arrays.deepToString(this.enums) + ", commands: " + Arrays.deepToString(this.commands) + ")";
	}

}