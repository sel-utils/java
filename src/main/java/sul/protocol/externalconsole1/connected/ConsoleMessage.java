/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.connected;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Logs a message from the server's console. It may be the output of a command, a debug
 * message or any other message that the server retains able to be seen by the External
 * Console.
 */
public class ConsoleMessage extends Packet {

	public static final byte ID = (byte)4;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Name of the node that created the log or an empty string if the log was created
	 * by the hub or by a server that isn't based on the hub-node layout.
	 */
	public String node;

	/**
	 * Unix timestamp in milliseconds that indicates the exact time when the log was generated
	 * by the server.
	 * The logs may not arrive in order when the server uses the hub-node layout or some
	 * other kind of proxy because the logs created by the nodes have an additional latency
	 * (the one between the hub, or proxy, and the node).
	 */
	public long timestamp;

	/**
	 * Name of the logger. It may be the world name if the log was generated by a world's
	 * message (like a broadcast or a chat message), the name of plugin (for example `plugin\test`)
	 * or the name of the package/module/class that generated the log (like `math.vector`
	 * or `event.world.player`).
	 */
	public String logger;

	/**
	 * The logged message. It may contain Minecraft's formatting codes which should be
	 * translated into appropriate colours and formatting (bold, italic and strikethrough)
	 * by the client implementation of the external console.
	 */
	public String message;

	public ConsoleMessage() {}

	public ConsoleMessage(String node, long timestamp, String logger, String message) {
		this.node = node;
		this.timestamp = timestamp;
		this.logger = logger;
		this.message = message;
	}

	@Override
	public int length() {
		return node.getBytes(StandardCharsets.UTF_8).length + logger.getBytes(StandardCharsets.UTF_8).length + message.getBytes(StandardCharsets.UTF_8).length + 15;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] b9z=node.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)b9z.length); this.writeBytes(b9z);
		this.writeBigEndianLong(timestamp);
		byte[] b9zv=logger.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)b9zv.length); this.writeBytes(b9zv);
		byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)bvcfz.length); this.writeBytes(bvcfz);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		short bvb9z=readBigEndianShort(); node=new String(this.readBytes(bvb9z), StandardCharsets.UTF_8);
		timestamp=readBigEndianLong();
		short bvb9zv=readBigEndianShort(); logger=new String(this.readBytes(bvb9zv), StandardCharsets.UTF_8);
		short bvbvcfz=readBigEndianShort(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
	}

	public static ConsoleMessage fromBuffer(byte[] buffer) {
		ConsoleMessage ret = new ConsoleMessage();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ConsoleMessage(node: " + this.node + ", timestamp: " + this.timestamp + ", logger: " + this.logger + ", message: " + this.message + ")";
	}

}