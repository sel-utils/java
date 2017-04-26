/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket111.xml
 */
package sul.protocol.pocket111.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class CommandBlockUpdate extends Packet {

	public static final byte ID = (byte)80;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public boolean updateBlock;
	public sul.protocol.pocket111.types.BlockPosition position;
	public int mode;
	public boolean redstoneMode;
	public boolean conditional;
	public long minecart;
	public String command;
	public String lastOutput;
	public String hover;
	public boolean trackOutput;

	public CommandBlockUpdate() {}

	public CommandBlockUpdate(boolean updateBlock, sul.protocol.pocket111.types.BlockPosition position, int mode, boolean redstoneMode, boolean conditional, long minecart, String command, String lastOutput, String hover, boolean trackOutput) {
		this.updateBlock = updateBlock;
		this.position = position;
		this.mode = mode;
		this.redstoneMode = redstoneMode;
		this.conditional = conditional;
		this.minecart = minecart;
		this.command = command;
		this.lastOutput = lastOutput;
		this.hover = hover;
		this.trackOutput = trackOutput;
	}

	@Override
	public int length() {
		return position.length() + Buffer.varuintLength(mode) + Buffer.varlongLength(minecart) + Buffer.varuintLength(command.getBytes(StandardCharsets.UTF_8).length) + command.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(lastOutput.getBytes(StandardCharsets.UTF_8).length) + lastOutput.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(hover.getBytes(StandardCharsets.UTF_8).length) + hover.getBytes(StandardCharsets.UTF_8).length + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBool(updateBlock);
		if(updateBlock==true){ this.writeBytes(position.encode()); }
		if(updateBlock==true){ this.writeVaruint(mode); }
		if(updateBlock==true){ this.writeBool(redstoneMode); }
		if(updateBlock==true){ this.writeBool(conditional); }
		if(updateBlock==false){ this.writeVarlong(minecart); }
		byte[] y9bfz=command.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y9bfz.length); this.writeBytes(y9bfz);
		byte[] bfd9dbd=lastOutput.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfd9dbd.length); this.writeBytes(bfd9dbd);
		byte[] a9zi=hover.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)a9zi.length); this.writeBytes(a9zi);
		this.writeBool(trackOutput);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		updateBlock=this.readBool();
		if(updateBlock==true){ position=new sul.protocol.pocket111.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index; }
		if(updateBlock==true){ mode=this.readVaruint(); }
		if(updateBlock==true){ redstoneMode=this.readBool(); }
		if(updateBlock==true){ conditional=this.readBool(); }
		if(updateBlock==false){ minecart=this.readVarlong(); }
		int bvy9bfz=this.readVaruint(); command=new String(this.readBytes(bvy9bfz), StandardCharsets.UTF_8);
		int bvbfd9db=this.readVaruint(); lastOutput=new String(this.readBytes(bvbfd9db), StandardCharsets.UTF_8);
		int bva9zi=this.readVaruint(); hover=new String(this.readBytes(bva9zi), StandardCharsets.UTF_8);
		trackOutput=this.readBool();
	}

	public static CommandBlockUpdate fromBuffer(byte[] buffer) {
		CommandBlockUpdate ret = new CommandBlockUpdate();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "CommandBlockUpdate(updateBlock: " + this.updateBlock + ", position: " + this.position.toString() + ", mode: " + this.mode + ", redstoneMode: " + this.redstoneMode + ", conditional: " + this.conditional + ", minecart: " + this.minecart + ", command: " + this.command + ", lastOutput: " + this.lastOutput + ", hover: " + this.hover + ", trackOutput: " + this.trackOutput + ")";
	}

}