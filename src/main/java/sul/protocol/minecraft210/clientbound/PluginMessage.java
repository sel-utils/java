/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class PluginMessage extends Packet {

	public static final int ID = (int)24;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String channel;
	public byte[] data = new byte[0];

	public PluginMessage() {}

	public PluginMessage(String channel, byte[] data) {
		this.channel = channel;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(channel.getBytes(StandardCharsets.UTF_8).length) + channel.getBytes(StandardCharsets.UTF_8).length + data.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] yhb5b=channel.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yhb5b.length); this.writeBytes(yhb5b);
		this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvyhb5b=this.readVaruint(); channel=new String(this.readBytes(bvyhb5b), StandardCharsets.UTF_8);
		data=this.readBytes(this._buffer.length-this._index);
	}

	public static PluginMessage fromBuffer(byte[] buffer) {
		PluginMessage ret = new PluginMessage();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PluginMessage(channel: " + this.channel + ", data: " + Arrays.toString(this.data) + ")";
	}

}