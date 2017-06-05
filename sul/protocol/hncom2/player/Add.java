/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.player;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

import sul.utils.*;

/**
 * Adds a player to the node.
 */
public class Add extends Packet {

	public static final byte ID = (byte)17;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// reason
	public static final byte FIRST_JOIN = 0;
	public static final byte TRANSFERRED = 1;
	public static final byte FORCIBLY_TRANSFERRED = 2;

	// dimension
	public static final byte OVERWORLD = 0;
	public static final byte NETHER = 1;
	public static final byte END = 2;

	// input mode
	public static final byte KEYBOARD = 0;
	public static final byte TOUCH = 1;
	public static final byte CONTROLLER = 2;

	public int hubId;

	/**
	 * Reason for which the player has been added to the node.
	 */
	public byte reason;

	/**
	 * Game of the client, which could either be Minecraft or Minecraft: Pocket Edition.
	 */
	public byte type;

	/**
	 * Version of the protocol used by the client.
	 */
	public int protocol;

	/**
	 * Version of the game used by the client, usually in the format major.minor[.patch],
	 * calculated by the server or passed by the client during the authentication process.
	 * The node should verify that the version exists and matches the protocol in the previous
	 * field.
	 */
	public String version;

	/**
	 * Username of the player.
	 */
	public String username;

	/**
	 * Display name of the player, which can contain formatting codes. By default it's
	 * equals to the username but it can be updated by the node using UpdateDisplayName.
	 */
	public String displayName;

	/**
	 * Dimension in which the player was playing before being transferred.
	 * It's used to send the game's change dimension packet to despawn old entities and
	 * delete old chunks.
	 */
	public byte dimension;

	/**
	 * Client's view distance (or chunk radius). See [UpdateViewDistance.viewDistance](#player_update-view-distance_view-distance)
	 * for more informations.
	 */
	public int viewDistance;

	/**
	 * Remote address of the client.
	 */
	public sul.protocol.hncom2.types.Address clientAddress;

	/**
	 * Ip used by the client to connect to the server. The value of this field is the address
	 * the client has saved in its servers list. For example a client that joins through
	 * `localhost` and a client that joins through `127.0.0.1` will connect to the same
	 * server but the field of this value will be different (`localhost` for the first
	 * client and `127.0.0.1` for the second).
	 */
	public String serverAddress;

	/**
	 * Port used by the client to connect to the server.
	 */
	public short serverPort;

	/**
	 * Client's UUID, given by Mojang's or Microsoft's services if the server is in online
	 * mode or given by the client (and not verified) if the server is in offline mode.
	 */
	public UUID uuid;

	/**
	 * Client's skin, given by the client or downloaded from Mojang's services in online
	 * mode.
	 */
	public sul.protocol.hncom2.types.Skin skin;

	/**
	 * Client's language, in the same format as HubInfo.language, which should be updated
	 * from the node when the client changes it. See also UpdateLanguage.language.
	 */
	public String language;

	/**
	 * Client's input mode. See UpdateInputMode.inputMode for more informations.
	 */
	public byte inputMode;

	/**
	 * Client's latency (ping time). See UpdateLatency.latency for more informations.
	 */
	public int latency;

	public Add() {}

	public Add(int hubId, byte reason, byte type, int protocol, String version, String username, String displayName, byte dimension, int viewDistance, sul.protocol.hncom2.types.Address clientAddress, String serverAddress, short serverPort, UUID uuid, sul.protocol.hncom2.types.Skin skin, String language, byte inputMode, int latency) {
		this.hubId = hubId;
		this.reason = reason;
		this.type = type;
		this.protocol = protocol;
		this.version = version;
		this.username = username;
		this.displayName = displayName;
		this.dimension = dimension;
		this.viewDistance = viewDistance;
		this.clientAddress = clientAddress;
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		this.uuid = uuid;
		this.skin = skin;
		this.language = language;
		this.inputMode = inputMode;
		this.latency = latency;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + Buffer.varuintLength(protocol) + Buffer.varuintLength(version.getBytes(StandardCharsets.UTF_8).length) + version.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(viewDistance) + clientAddress.length() + Buffer.varuintLength(serverAddress.getBytes(StandardCharsets.UTF_8).length) + serverAddress.getBytes(StandardCharsets.UTF_8).length + skin.length() + Buffer.varuintLength(language.getBytes(StandardCharsets.UTF_8).length) + language.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(latency) + 23;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		this.writeBigEndianByte(reason);
		this.writeBigEndianByte(type);
		this.writeVaruint(protocol);
		byte[] dvclb=version.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvclb.length); this.writeBytes(dvclb);
		byte[] dnc5bu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dnc5bu.length); this.writeBytes(dnc5bu);
		byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
		if(reason!=0){ this.writeBigEndianByte(dimension); }
		if(reason!=0){ this.writeVaruint(viewDistance); }
		this.writeBytes(clientAddress.encode());
		byte[] cvdvqrcv=serverAddress.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvdvqrcv.length); this.writeBytes(cvdvqrcv);
		this.writeBigEndianShort(serverPort);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeBytes(skin.encode());
		byte[] bfzvzu=language.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfzvzu.length); this.writeBytes(bfzvzu);
		this.writeBigEndianByte(inputMode);
		this.writeVaruint(latency);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		reason=readBigEndianByte();
		type=readBigEndianByte();
		protocol=this.readVaruint();
		int bvdvclb=this.readVaruint(); version=new String(this.readBytes(bvdvclb), StandardCharsets.UTF_8);
		int bvdnc5bu=this.readVaruint(); username=new String(this.readBytes(bvdnc5bu), StandardCharsets.UTF_8);
		int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
		if(reason!=0){ dimension=readBigEndianByte(); }
		if(reason!=0){ viewDistance=this.readVaruint(); }
		clientAddress=new sul.protocol.hncom2.types.Address(); clientAddress._index=this._index; clientAddress.decode(this._buffer); this._index=clientAddress._index;
		int bvcvdvqr=this.readVaruint(); serverAddress=new String(this.readBytes(bvcvdvqr), StandardCharsets.UTF_8);
		serverPort=readBigEndianShort();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		skin=new sul.protocol.hncom2.types.Skin(); skin._index=this._index; skin.decode(this._buffer); this._index=skin._index;
		int bvbfzvzu=this.readVaruint(); language=new String(this.readBytes(bvbfzvzu), StandardCharsets.UTF_8);
		inputMode=readBigEndianByte();
		latency=this.readVaruint();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Add fromBuffer(byte[] buffer) {
		Add ret = new Add();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Add(hubId: " + this.hubId + ", reason: " + this.reason + ", type: " + this.type + ", protocol: " + this.protocol + ", version: " + this.version + ", username: " + this.username + ", displayName: " + this.displayName + ", dimension: " + this.dimension + ", viewDistance: " + this.viewDistance + ", clientAddress: " + this.clientAddress.toString() + ", serverAddress: " + this.serverAddress + ", serverPort: " + this.serverPort + ", uuid: " + this.uuid.toString() + ", skin: " + this.skin.toString() + ", language: " + this.language + ", inputMode: " + this.inputMode + ", latency: " + this.latency + ")";
	}

	/**
	 * A Minecraft: Pocket Edition client.
	 */
	public class Pocket extends Packet {

		public static final byte TYPE = (byte)1;

		@Override
		public int getId() {
			return ID;
		}

		// device os
		public static final byte UNKNOWN = 0;
		public static final byte ANDROID = 1;
		public static final byte IOS = 2;
		public static final byte OSX = 3;
		public static final byte FIRE_OS = 4;
		public static final byte GEAR_VR = 5;
		public static final byte HOLOLENS = 6;
		public static final byte WINDOWS10 = 7;
		public static final byte WINDOWS32 = 8;
		public static final byte DEDICATED = 9;

		/**
		 * XBOX Live id, which is a unique identifier for authenticated players or 0 if the
		 * server is in offline mode.
		 */
		public long xuid;

		/**
		 * Indicates whether the client is using the Education Edition variant of the game.
		 */
		public boolean edu;

		/**
		 * Client's packet loss calculated from the hub. See UpdatePacketLoss.packetLoss for
		 * more informations.
		 */
		public float packetLoss;

		/**
		 * Client's operative system, if supplied by the client. This field's value may be
		 * used to divide players that play from a phone from players that play on a computer.
		 */
		public byte deviceOs;

		/**
		 * Client's device model, if supplied by the client. This field is usually a string
		 * in the format `MANUFACTURER MODEL`: for example, the Oneplus one is `ONEPLUS A0001`.
		 * This field's value may be used to ban low-end devices.
		 */
		public String deviceModel;

		public Pocket() {}

		public Pocket(long xuid, boolean edu, float packetLoss, byte deviceOs, String deviceModel) {
			this.xuid = xuid;
			this.edu = edu;
			this.packetLoss = packetLoss;
			this.deviceOs = deviceOs;
			this.deviceModel = deviceModel;
		}

		@Override
		public int length() {
			return Buffer.varlongLength(xuid) + Buffer.varuintLength(deviceModel.getBytes(StandardCharsets.UTF_8).length) + deviceModel.getBytes(StandardCharsets.UTF_8).length + 6;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVarlong(xuid);
			this.writeBool(edu);
			this.writeBigEndianFloat(packetLoss);
			this.writeBigEndianByte(deviceOs);
			byte[] zvant9zw=deviceModel.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zvant9zw.length); this.writeBytes(zvant9zw);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			xuid=this.readVarlong();
			edu=this.readBool();
			packetLoss=readBigEndianFloat();
			deviceOs=readBigEndianByte();
			int bvzvant9=this.readVaruint(); deviceModel=new String(this.readBytes(bvzvant9), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Add.Pocket(xuid: " + this.xuid + ", edu: " + this.edu + ", packetLoss: " + this.packetLoss + ", deviceOs: " + this.deviceOs + ", deviceModel: " + this.deviceModel + ")";
		}

	}

	/**
	 * A Minecraft client.
	 */
	public class Minecraft extends Packet {

		public static final byte TYPE = (byte)2;

		@Override
		public int getId() {
			return ID;
		}

		/**
		 * Additional properties like textures when the server is on online mode.
		 */
		public sul.protocol.hncom2.types.Property[] properties = new sul.protocol.hncom2.types.Property[0];

		public Minecraft() {}

		public Minecraft(sul.protocol.hncom2.types.Property[] properties) {
			this.properties = properties;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(properties.length); for(sul.protocol.hncom2.types.Property cjcvdlc:properties){ length+=cjcvdlc.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)properties.length); for(sul.protocol.hncom2.types.Property cjcvdlc:properties){ this.writeBytes(cjcvdlc.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbbbcrzm=this.readVaruint(); properties=new sul.protocol.hncom2.types.Property[bbbbcrzm]; for(int cjcvdlc=0;cjcvdlc<properties.length;cjcvdlc++){ properties[cjcvdlc]=new sul.protocol.hncom2.types.Property(); properties[cjcvdlc]._index=this._index; properties[cjcvdlc].decode(this._buffer); this._index=properties[cjcvdlc]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Add.Minecraft(properties: " + Arrays.deepToString(this.properties) + ")";
		}

	}

	public class Console extends Packet {

		public static final byte TYPE = (byte)3;

		@Override
		public int getId() {
			return ID;
		}

		@Override
		public int length() {
			return 0;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Add.Console()";
		}

	}

}