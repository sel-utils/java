/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom.login;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Informations about the hub.
 */
public class HubInfo extends Packet {

	public static final byte ID = (byte)5;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// max
	public static final int UNLIMITED = (int)-1;

	/**
	 * Unix time with microseconds precision that indicates the exact moment when this
	 * packet was created. It's used by the node to calculate the latency.
	 */
	public long time;

	/**
	 * Server's id, either given by a snoop system or randomly generated at runtime.
	 */
	public long serverId;

	/**
	 * First number of the 4,294,967,296 (2³²) reserved by the hub to create the node's
	 * UUIDs. Every UUID generated by the node is formed by the server's id (most signicant)
	 * and the next reserved uuid (least significant). This way every UUID in the hub and
	 * in the connected nodes is always different.
	 */
	public long reservedUuids;

	/**
	 * Unformatted name of the server as indicated in the hub's configuration file.
	 */
	public String displayName;

	/**
	 * Informations about the games supported by the hub.
	 */
	public sul.protocol.hncom.types.GameInfo[] gamesInfo = new sul.protocol.hncom.types.GameInfo[0];

	/**
	 * Number of players currently online and connected to other nodes.
	 */
	public int online;

	/**
	 * Number of maximum players that can connect to the server (that is the sum of the
	 * max players of the nodes already connected). The number may change after this node
	 * connects.
	 */
	public int max;

	/**
	 * Default server's language in format (language_COUNTRY, e.g. en_GB) and also the
	 * default language for players that don't specify their language or for the ones which
	 * language is not supported by the server.
	 */
	public String language;

	/**
	 * Languages accepted by the server in the same format as language. The list should
	 * always contain at least one element (the default language).
	 */
	public String[] acceptedLanguages = new String[0];

	/**
	 * Optional informations about the server's software, social accounts, system and options
	 * in the format indicated below.
	 * <code>
	 * {
	 *    "software": {
	 *       "name": "SEL",
	 *       "version": "1.0.4",
	 *       "stable": true
	 *    },
	 *    "minecraft": {
	 *       "edu": false,
	 *       "realm": true
	 *    },
	 *    "social": {
	 *       "website": "example.com",
	 *       "facebook": "example-official",
	 *       "twitter": "example_tweets",
	 *       "youtube": "examplechannel",
	 *       "instagram": "example",
	 *       "google-plus": "example-plus"
	 *    },
	 *    "system": {
	 *       "os": "Ubuntu 16.04",
	 *       "cpu": "Intel(R) Core(TM) i5-5200U CPU @ 2.20GHz",
	 *       "cores": 2,
	 *       "ram": 2147483648
	 *    }
	 * }
	 * </code>
	 */
	public String additionalJson;

	public HubInfo() {}

	public HubInfo(long time, long serverId, long reservedUuids, String displayName, sul.protocol.hncom.types.GameInfo[] gamesInfo, int online, int max, String language, String[] acceptedLanguages, String additionalJson) {
		this.time = time;
		this.serverId = serverId;
		this.reservedUuids = reservedUuids;
		this.displayName = displayName;
		this.gamesInfo = gamesInfo;
		this.online = online;
		this.max = max;
		this.language = language;
		this.acceptedLanguages = acceptedLanguages;
		this.additionalJson = additionalJson;
	}

	@Override
	public int length() {
		int length=Buffer.varulongLength(time) + Buffer.varulongLength(serverId) + Buffer.varulongLength(reservedUuids) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(gamesInfo.length) + Buffer.varuintLength(online) + Buffer.varintLength(max) + Buffer.varuintLength(language.getBytes(StandardCharsets.UTF_8).length) + language.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(acceptedLanguages.length) + Buffer.varuintLength(additionalJson.getBytes(StandardCharsets.UTF_8).length) + additionalJson.getBytes(StandardCharsets.UTF_8).length + 1; for(sul.protocol.hncom.types.GameInfo zfznbz:gamesInfo){ length+=zfznbz.length(); };for(String ynzbzry5:acceptedLanguages){ length+=Buffer.varuintLength(ynzbzry5.getBytes(StandardCharsets.UTF_8).length)+ynzbzry5.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarulong(time);
		this.writeVarulong(serverId);
		this.writeVarulong(reservedUuids);
		byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
		this.writeVaruint((int)gamesInfo.length); for(sul.protocol.hncom.types.GameInfo zfznbz:gamesInfo){ this.writeBytes(zfznbz.encode()); }
		this.writeVaruint(online);
		this.writeVarint(max);
		byte[] bfzvzu=language.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfzvzu.length); this.writeBytes(bfzvzu);
		this.writeVaruint((int)acceptedLanguages.length); for(String ynzbzry5:acceptedLanguages){ byte[] e5ypeu=ynzbzry5.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)e5ypeu.length); this.writeBytes(e5ypeu); }
		byte[] yrarb5bp=additionalJson.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yrarb5bp.length); this.writeBytes(yrarb5bp);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		time=this.readVarulong();
		serverId=this.readVarulong();
		reservedUuids=this.readVarulong();
		int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
		int bdbvs5b=this.readVaruint(); gamesInfo=new sul.protocol.hncom.types.GameInfo[bdbvs5b]; for(int zfznbz=0;zfznbz<gamesInfo.length;zfznbz++){ gamesInfo[zfznbz]=new sul.protocol.hncom.types.GameInfo(); gamesInfo[zfznbz]._index=this._index; gamesInfo[zfznbz].decode(this._buffer); this._index=gamesInfo[zfznbz]._index; }
		online=this.readVaruint();
		max=this.readVarint();
		int bvbfzvzu=this.readVaruint(); language=new String(this.readBytes(bvbfzvzu), StandardCharsets.UTF_8);
		int bfyvdvtf=this.readVaruint(); acceptedLanguages=new String[bfyvdvtf]; for(int ynzbzry5=0;ynzbzry5<acceptedLanguages.length;ynzbzry5++){ int bvynzbzr=this.readVaruint(); acceptedLanguages[ynzbzry5]=new String(this.readBytes(bvynzbzr), StandardCharsets.UTF_8); }
		int bvyrarb5=this.readVaruint(); additionalJson=new String(this.readBytes(bvyrarb5), StandardCharsets.UTF_8);
	}

	public static HubInfo fromBuffer(byte[] buffer) {
		HubInfo ret = new HubInfo();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "HubInfo(time: " + this.time + ", serverId: " + this.serverId + ", reservedUuids: " + this.reservedUuids + ", displayName: " + this.displayName + ", gamesInfo: " + Arrays.deepToString(this.gamesInfo) + ", online: " + this.online + ", max: " + this.max + ", language: " + this.language + ", acceptedLanguages: " + Arrays.deepToString(this.acceptedLanguages) + ", additionalJson: " + this.additionalJson + ")";
	}

}