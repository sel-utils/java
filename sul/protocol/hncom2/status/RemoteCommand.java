/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.status;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Executes a command on the node.
 */
public class RemoteCommand extends Packet {

	public static final byte ID = (byte)14;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// origin
	public static final byte HUB = 0;
	public static final byte EXTERNAL_CONSOLE = 1;
	public static final byte RCON = 2;

	/**
	 * Origin of the command. It could be the hub itself or an external source.
	 */
	public byte origin;

	/**
	 * Address of the sender if the command has been sent from an external source and not
	 * the hub.
	 */
	public sul.protocol.hncom2.types.Address sender;

	/**
	 * Commands and arguments that should be executed on the node. For example `say hello
	 * world` or `transfer steve lobby12`.
	 */
	public String command;

	/**
	 * Identifier of the command. It's sent in Log.commandId if the command generates an
	 * output.
	 */
	public int commandId;

	public RemoteCommand() {}

	public RemoteCommand(byte origin, sul.protocol.hncom2.types.Address sender, String command, int commandId) {
		this.origin = origin;
		this.sender = sender;
		this.command = command;
		this.commandId = commandId;
	}

	@Override
	public int length() {
		return sender.length() + Buffer.varuintLength(command.getBytes(StandardCharsets.UTF_8).length) + command.getBytes(StandardCharsets.UTF_8).length + Buffer.varintLength(commandId) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(origin);
		if(origin!=0){ this.writeBytes(sender.encode()); }
		byte[] y9bfz=command.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y9bfz.length); this.writeBytes(y9bfz);
		this.writeVarint(commandId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		origin=readBigEndianByte();
		if(origin!=0){ sender=new sul.protocol.hncom2.types.Address(); sender._index=this._index; sender.decode(this._buffer); this._index=sender._index; }
		int bvy9bfz=this.readVaruint(); command=new String(this.readBytes(bvy9bfz), StandardCharsets.UTF_8);
		commandId=this.readVarint();
	}

	public static RemoteCommand fromBuffer(byte[] buffer) {
		RemoteCommand ret = new RemoteCommand();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "RemoteCommand(origin: " + this.origin + ", sender: " + this.sender.toString() + ", command: " + this.command + ", commandId: " + this.commandId + ")";
	}

}