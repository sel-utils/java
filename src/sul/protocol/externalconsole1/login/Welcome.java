/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.login;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Indicates the status of the authentication process.
 */
public class Welcome extends Packet {

	public static final byte ID = (byte)2;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte status;

	public Welcome() {}

	public Welcome(byte status) {
		this.status = status;
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(status);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		status=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Welcome fromBuffer(byte[] buffer) {
		Welcome ret = new Welcome();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Welcome(status: " + this.status + ")";
	}

	/**
	 * Sent when the hash sent in Auth matches the server's.
	 */
	public class Accepted extends Packet {

		public static final byte STATUS = (byte)0;

		@Override
		public int getId() {
			return ID;
		}

		/**
		 * Indicates whether the external console can execute command remotely through the
		 * Command packet.
		 */
		public boolean remoteCommands;

		/**
		 * The server's software as a formatted string (without the version).
		 */
		public String software;

		/**
		 * Versions of the server in a 3-btyes array readed as `[major, minor, release]`.
		 */
		public byte[] versions = new byte[3];

		/**
		 * Name of the server (not the game's MOTD!). It shouldn't contain Minecraft formatting
		 * codes.
		 */
		public String displayName;

		/**
		 * Informations about the games and their protocols supported by the server.
		 */
		public sul.protocol.externalconsole1.types.Game[] games = new sul.protocol.externalconsole1.types.Game[0];

		/**
		 * List of names of the nodes connected to the server, if it uses the hub-node layout,
		 * or an empty list.
		 */
		public String[] connectedNodes = new String[0];

		public Accepted() {}

		public Accepted(boolean remoteCommands, String software, byte[] versions, String displayName, sul.protocol.externalconsole1.types.Game[] games, String[] connectedNodes) {
			this.remoteCommands = remoteCommands;
			this.software = software;
			this.versions = versions;
			this.displayName = displayName;
			this.games = games;
			this.connectedNodes = connectedNodes;
		}

		@Override
		public int length() {
			int length=software.getBytes(StandardCharsets.UTF_8).length + displayName.getBytes(StandardCharsets.UTF_8).length + connectedNodes.length*2 + 12; for(sul.protocol.externalconsole1.types.Game zfzm:games){ length+=zfzm.length(); };for(String y9bvdvt9:connectedNodes){ length+=y9bvdvt9.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBool(remoteCommands);
			byte[] c9ddcu=software.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)c9ddcu.length); this.writeBytes(c9ddcu);
			this.writeBytes(versions);
			byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
			this.writeBigEndianShort((short)games.length); for(sul.protocol.externalconsole1.types.Game zfzm:games){ this.writeBytes(zfzm.encode()); }
			this.writeBigEndianShort((short)connectedNodes.length); for(String y9bvdvt9:connectedNodes){ byte[] eldrdk=y9bvdvt9.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)eldrdk.length); this.writeBytes(eldrdk); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			remoteCommands=this.readBool();
			short bvc9ddcu=readBigEndianShort(); software=new String(this.readBytes(bvc9ddcu), StandardCharsets.UTF_8);
			final int bzcnb5=3; versions=this.readBytes(bzcnb5);
			short bvzlcxe5=readBigEndianShort(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
			int bdbv=readBigEndianShort(); games=new sul.protocol.externalconsole1.types.Game[bdbv]; for(int zfzm=0;zfzm<games.length;zfzm++){ games[zfzm]=new sul.protocol.externalconsole1.types.Game(); games[zfzm]._index=this._index; games[zfzm].decode(this._buffer); this._index=games[zfzm]._index; }
			int bnb5yrz5=readBigEndianShort(); connectedNodes=new String[bnb5yrz5]; for(int y9bvdvt9=0;y9bvdvt9<connectedNodes.length;y9bvdvt9++){ short bvy9bvdv=readBigEndianShort(); connectedNodes[y9bvdvt9]=new String(this.readBytes(bvy9bvdv), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Welcome.Accepted(remoteCommands: " + this.remoteCommands + ", software: " + this.software + ", versions: " + Arrays.toString(this.versions) + ", displayName: " + this.displayName + ", games: " + Arrays.deepToString(this.games) + ", connectedNodes: " + Arrays.deepToString(this.connectedNodes) + ")";
		}

	}

	/**
	 * Sent when Auth is received but the given password or hash doesn't match the server's
	 * one.
	 */
	public class WrongHash extends Packet {

		public static final byte STATUS = (byte)1;

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
			return "Welcome.WrongHash()";
		}

	}

	/**
	 * Sent when Auth is not received and the server decides to close the connection because
	 * too much time has elapsed since the creation of the socket.
	 */
	public class TimedOut extends Packet {

		public static final byte STATUS = (byte)2;

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
			return "Welcome.TimedOut()";
		}

	}

}
