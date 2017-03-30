/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.status;

import java.util.Arrays;

import sul.utils.*;

/**
 * Updates the statistics about the usage of the server and, eventually, the connected
 * nodes.
 * This packet is sent in response to RequestStats and every time the server retains
 * that the stats should be updated (usually in a range of 5 to 30 seconds).
 */
public class UpdateStats extends Packet {

	public static final byte ID = (byte)3;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Number of players currently online on the server. Players that are performing authentication
	 * are not included in the count.
	 */
	public int onlinePlayers;

	/**
	 * Highest number of players that can join the server simultaneously. If 0, there is
	 * not maximum number of players.
	 */
	public int maxPlayers;

	/**
	 * Milliseconds since the server has started.
	 */
	public int uptime;

	/**
	 * Average amount of bytes sent every second.
	 */
	public int upload;

	/**
	 * Average amount of bytes sent every second.
	 */
	public int download;

	/**
	 * Resources usage of the connected nodes, if the server uses the hub-node layout,
	 * or an empty list.
	 */
	public sul.protocol.externalconsole1.types.NodeStats[] nodes = new sul.protocol.externalconsole1.types.NodeStats[0];

	public UpdateStats() {}

	public UpdateStats(int onlinePlayers, int maxPlayers, int uptime, int upload, int download, sul.protocol.externalconsole1.types.NodeStats[] nodes) {
		this.onlinePlayers = onlinePlayers;
		this.maxPlayers = maxPlayers;
		this.uptime = uptime;
		this.upload = upload;
		this.download = download;
		this.nodes = nodes;
	}

	@Override
	public int length() {
		int length=23; for(sul.protocol.externalconsole1.types.NodeStats b9zm:nodes){ length+=b9zm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianInt(onlinePlayers);
		this.writeBigEndianInt(maxPlayers);
		this.writeBigEndianInt(uptime);
		this.writeBigEndianInt(upload);
		this.writeBigEndianInt(download);
		this.writeBigEndianShort((short)nodes.length); for(sul.protocol.externalconsole1.types.NodeStats b9zm:nodes){ this.writeBytes(b9zm.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		onlinePlayers=readBigEndianInt();
		maxPlayers=readBigEndianInt();
		uptime=readBigEndianInt();
		upload=readBigEndianInt();
		download=readBigEndianInt();
		int b5zv=readBigEndianShort(); nodes=new sul.protocol.externalconsole1.types.NodeStats[b5zv]; for(int b9zm=0;b9zm<nodes.length;b9zm++){ nodes[b9zm]=new sul.protocol.externalconsole1.types.NodeStats(); nodes[b9zm]._index=this._index; nodes[b9zm].decode(this._buffer); this._index=nodes[b9zm]._index; }
	}

	public static UpdateStats fromBuffer(byte[] buffer) {
		UpdateStats ret = new UpdateStats();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateStats(onlinePlayers: " + this.onlinePlayers + ", maxPlayers: " + this.maxPlayers + ", uptime: " + this.uptime + ", upload: " + this.upload + ", download: " + this.download + ", nodes: " + Arrays.deepToString(this.nodes) + ")";
	}

}