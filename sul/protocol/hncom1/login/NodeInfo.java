/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Informations about the node.
 */
public class NodeInfo extends Packet {

	public static final byte ID = (byte)4;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// max
	public static final int UNLIMITED = 0;

	/**
	 * Unix time with microseconds precision that indicates the exact moment when this
	 * packet was created. It's used by the hub to calculate the latency.
	 */
	public long time;

	/**
	 * Maximum number of players accepted by node.
	 */
	public int max;

	/**
	 * Informations about the games accepted by the node. There should be at least one
	 * combination of game/protocol that is also accepted by hub as indicated in HubInfo.gamesInfo,
	 * otherwise the node will never receive any player.
	 */
	public sul.protocol.hncom1.types.Game[] acceptedGames = new sul.protocol.hncom1.types.Game[0];

	/**
	 * List of plugins loaded on the node for creating queries on the hub.
	 */
	public sul.protocol.hncom1.types.Plugin[] plugins = new sul.protocol.hncom1.types.Plugin[0];

	/**
	 * Optional informations about the server's software and system, similar to HubInfo.additionalJson.
	 * <code>
	 * {
	 *    "software": {
	 *       "name": "SEL",
	 *       "version": "1.0.4",
	 *       "stable": true
	 *    },
	 *    "system": {
	 *       "os": "Windows 10",
	 *       "cpu": "Intel(R) Core(TM) i7-5700U CPU @ 3.40GHz",
	 *       "cores": 4,
	 *       "ram": 8589934592
	 *    }
	 * }
	 * </code>
	 */
	public String additionalJson;

	public NodeInfo() {}

	public NodeInfo(long time, int max, sul.protocol.hncom1.types.Game[] acceptedGames, sul.protocol.hncom1.types.Plugin[] plugins, String additionalJson) {
		this.time = time;
		this.max = max;
		this.acceptedGames = acceptedGames;
		this.plugins = plugins;
		this.additionalJson = additionalJson;
	}

	@Override
	public int length() {
		int length=Buffer.varulongLength(time) + Buffer.varuintLength(max) + Buffer.varuintLength(acceptedGames.length) + Buffer.varuintLength(plugins.length) + Buffer.varuintLength(additionalJson.getBytes(StandardCharsets.UTF_8).length) + additionalJson.getBytes(StandardCharsets.UTF_8).length + 1; for(sul.protocol.hncom1.types.Game ynzbzry1:acceptedGames){ length+=ynzbzry1.length(); };for(sul.protocol.hncom1.types.Plugin cxzlc:plugins){ length+=cxzlc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarulong(time);
		this.writeVaruint(max);
		this.writeVaruint((int)acceptedGames.length); for(sul.protocol.hncom1.types.Game ynzbzry1:acceptedGames){ this.writeBytes(ynzbzry1.encode()); }
		this.writeVaruint((int)plugins.length); for(sul.protocol.hncom1.types.Plugin cxzlc:plugins){ this.writeBytes(cxzlc.encode()); }
		byte[] yrarb5bp=additionalJson.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yrarb5bp.length); this.writeBytes(yrarb5bp);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		time=this.readVarulong();
		max=this.readVaruint();
		int bfyvdvrf=this.readVaruint(); acceptedGames=new sul.protocol.hncom1.types.Game[bfyvdvrf]; for(int ynzbzry1=0;ynzbzry1<acceptedGames.length;ynzbzry1++){ acceptedGames[ynzbzry1]=new sul.protocol.hncom1.types.Game(); acceptedGames[ynzbzry1]._index=this._index; acceptedGames[ynzbzry1].decode(this._buffer); this._index=acceptedGames[ynzbzry1]._index; }
		int bbddbm=this.readVaruint(); plugins=new sul.protocol.hncom1.types.Plugin[bbddbm]; for(int cxzlc=0;cxzlc<plugins.length;cxzlc++){ plugins[cxzlc]=new sul.protocol.hncom1.types.Plugin(); plugins[cxzlc]._index=this._index; plugins[cxzlc].decode(this._buffer); this._index=plugins[cxzlc]._index; }
		int bvyrarb5=this.readVaruint(); additionalJson=new String(this.readBytes(bvyrarb5), StandardCharsets.UTF_8);
	}

	public static NodeInfo fromBuffer(byte[] buffer) {
		NodeInfo ret = new NodeInfo();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "NodeInfo(time: " + this.time + ", max: " + this.max + ", acceptedGames: " + Arrays.deepToString(this.acceptedGames) + ", plugins: " + Arrays.deepToString(this.plugins) + ", additionalJson: " + this.additionalJson + ")";
	}

}