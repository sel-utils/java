/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.util.Arrays;
import java.util.UUID;

import sul.utils.*;

/**
 * Adds or removes a player from the player's list displayed in the pause menu. This
 * packet should be sent before spawning a player with AddPlayer, otherwise the skin
 * is not applied.
 */
public class PlayerList extends Packet {

	public static final byte ID = (byte)63;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte action;

	public PlayerList() {}

	public PlayerList(byte action) {
		this.action = action;
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
		this.writeBigEndianByte(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		action=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static PlayerList fromBuffer(byte[] buffer) {
		PlayerList ret = new PlayerList();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerList(action: " + this.action + ")";
	}

	public class Add extends Packet {

		public static final byte ACTION = (byte)0;

		@Override
		public int getId() {
			return ID;
		}

		public sul.protocol.pocket101.types.PlayerList[] players = new sul.protocol.pocket101.types.PlayerList[0];

		public Add() {}

		public Add(sul.protocol.pocket101.types.PlayerList[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length); for(sul.protocol.pocket101.types.PlayerList cxevc:players){ length+=cxevc.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.pocket101.types.PlayerList cxevc:players){ this.writeBytes(cxevc.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new sul.protocol.pocket101.types.PlayerList[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ players[cxevc]=new sul.protocol.pocket101.types.PlayerList(); players[cxevc]._index=this._index; players[cxevc].decode(this._buffer); this._index=players[cxevc]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerList.Add(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class Remove extends Packet {

		public static final byte ACTION = (byte)1;

		@Override
		public int getId() {
			return ID;
		}

		public UUID[] players = new UUID[0];

		public Remove() {}

		public Remove(UUID[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(players.length) + players.length*16;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(UUID cxevc:players){ this.writeBigEndianLong(cxevc.getLeastSignificantBits()); this.writeBigEndianLong(cxevc.getMostSignificantBits()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new UUID[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ long abylcnyh=readBigEndianLong(); long bylcnyhd=readBigEndianLong(); players[cxevc]=new UUID(abylcnyh,bylcnyhd); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerList.Remove(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

}
