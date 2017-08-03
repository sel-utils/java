/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket130.xml
 */
package sul.protocol.pocket130.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Sends a list of the commands that the player can use through the CommandStep packet.
 */
public class AvailableCommands extends Packet {

	public static final byte ID = (byte)76;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String[] enumValues = new String[0];
	public int unknown1;
	public sul.protocol.pocket130.types.Command[] commands = new sul.protocol.pocket130.types.Command[0];

	public AvailableCommands() {}

	public AvailableCommands(String[] enumValues, int unknown1, sul.protocol.pocket130.types.Command[] commands) {
		this.enumValues = enumValues;
		this.unknown1 = unknown1;
		this.commands = commands;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(enumValues.length) + Buffer.varuintLength(unknown1) + Buffer.varuintLength(commands.length) + 1; for(String z5bzbvc:enumValues){ length+=Buffer.varuintLength(z5bzbvc.getBytes(StandardCharsets.UTF_8).length)+z5bzbvc.getBytes(StandardCharsets.UTF_8).length; };for(sul.protocol.pocket130.types.Command y9bfzm:commands){ length+=y9bfzm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint((int)enumValues.length); for(String z5bzbvc:enumValues){ byte[] evejy=z5bzbvc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)evejy.length); this.writeBytes(evejy); }
		this.writeVaruint(unknown1);
		this.writeVaruint((int)commands.length); for(sul.protocol.pocket130.types.Command y9bfzm:commands){ this.writeBytes(y9bfzm.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvd1yxzm=this.readVaruint(); enumValues=new String[bvd1yxzm]; for(int z5bzbvc=0;z5bzbvc<enumValues.length;z5bzbvc++){ int bvz5bzbv=this.readVaruint(); enumValues[z5bzbvc]=new String(this.readBytes(bvz5bzbv), StandardCharsets.UTF_8); }
		unknown1=this.readVaruint();
		int bnb1br=this.readVaruint(); commands=new sul.protocol.pocket130.types.Command[bnb1br]; for(int y9bfzm=0;y9bfzm<commands.length;y9bfzm++){ commands[y9bfzm]=new sul.protocol.pocket130.types.Command(); commands[y9bfzm]._index=this._index; commands[y9bfzm].decode(this._buffer); this._index=commands[y9bfzm]._index; }
	}

	public static AvailableCommands fromBuffer(byte[] buffer) {
		AvailableCommands ret = new AvailableCommands();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AvailableCommands(enumValues: " + Arrays.deepToString(this.enumValues) + ", unknown1: " + this.unknown1 + ", commands: " + Arrays.deepToString(this.commands) + ")";
	}

}