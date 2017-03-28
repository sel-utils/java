/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Sends a list of the commands that the player can use through the CommandStep packet.
 */
public class AvailableCommands extends Packet {

	public static final byte ID = (byte)78;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * JSON object with the commands.
	 */
	public String commands;
	public String unknown1;

	public AvailableCommands() {}

	public AvailableCommands(String commands, String unknown1) {
		this.commands = commands;
		this.unknown1 = unknown1;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(commands.getBytes(StandardCharsets.UTF_8).length) + commands.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(unknown1.getBytes(StandardCharsets.UTF_8).length) + unknown1.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] y9bfzm=commands.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y9bfzm.length); this.writeBytes(y9bfzm);
		byte[] d5b9be=unknown1.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d5b9be.length); this.writeBytes(d5b9be);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvy9bfzm=this.readVaruint(); commands=new String(this.readBytes(bvy9bfzm), StandardCharsets.UTF_8);
		int bvd5b9be=this.readVaruint(); unknown1=new String(this.readBytes(bvd5b9be), StandardCharsets.UTF_8);
	}

	public static AvailableCommands fromBuffer(byte[] buffer) {
		AvailableCommands ret = new AvailableCommands();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AvailableCommands(commands: " + this.commands + ", unknown1: " + this.unknown1 + ")";
	}

}
