/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.util.Arrays;
import java.util.UUID;

import sul.utils.*;

public class PlayerListItem extends Packet {

	public static final int ID = (int)45;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int action;

	public PlayerListItem() {}

	public PlayerListItem(int action) {
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(action) + 1;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		action=this.readVaruint();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static PlayerListItem fromBuffer(byte[] buffer) {
		PlayerListItem ret = new PlayerListItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerListItem(action: " + this.action + ")";
	}

	public class AddPlayer extends Packet {

		public static final int ACTION = (int)0;

		@Override
		public int getId() {
			return ID;
		}

		public sul.protocol.minecraft108.types.ListAddPlayer[] players = new sul.protocol.minecraft108.types.ListAddPlayer[0];

		public AddPlayer() {}

		public AddPlayer(sul.protocol.minecraft108.types.ListAddPlayer[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length); for(sul.protocol.minecraft108.types.ListAddPlayer cxevc:players){ length+=cxevc.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListAddPlayer cxevc:players){ this.writeBytes(cxevc.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListAddPlayer[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ players[cxevc]=new sul.protocol.minecraft108.types.ListAddPlayer(); players[cxevc]._index=this._index; players[cxevc].decode(this._buffer); this._index=players[cxevc]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.AddPlayer(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class UpdateGamemode extends Packet {

		public static final int ACTION = (int)1;

		@Override
		public int getId() {
			return ID;
		}

		public sul.protocol.minecraft108.types.ListUpdateGamemode[] players = new sul.protocol.minecraft108.types.ListUpdateGamemode[0];

		public UpdateGamemode() {}

		public UpdateGamemode(sul.protocol.minecraft108.types.ListUpdateGamemode[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length); for(sul.protocol.minecraft108.types.ListUpdateGamemode cxevc:players){ length+=cxevc.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListUpdateGamemode cxevc:players){ this.writeBytes(cxevc.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListUpdateGamemode[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ players[cxevc]=new sul.protocol.minecraft108.types.ListUpdateGamemode(); players[cxevc]._index=this._index; players[cxevc].decode(this._buffer); this._index=players[cxevc]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.UpdateGamemode(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class UpdateLatency extends Packet {

		public static final int ACTION = (int)2;

		@Override
		public int getId() {
			return ID;
		}

		public sul.protocol.minecraft108.types.ListUpdateLatency[] players = new sul.protocol.minecraft108.types.ListUpdateLatency[0];

		public UpdateLatency() {}

		public UpdateLatency(sul.protocol.minecraft108.types.ListUpdateLatency[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length); for(sul.protocol.minecraft108.types.ListUpdateLatency cxevc:players){ length+=cxevc.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListUpdateLatency cxevc:players){ this.writeBytes(cxevc.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListUpdateLatency[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ players[cxevc]=new sul.protocol.minecraft108.types.ListUpdateLatency(); players[cxevc]._index=this._index; players[cxevc].decode(this._buffer); this._index=players[cxevc]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.UpdateLatency(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class UpdateDisplayName extends Packet {

		public static final int ACTION = (int)3;

		@Override
		public int getId() {
			return ID;
		}

		public sul.protocol.minecraft108.types.ListUpdateDisplayName[] players = new sul.protocol.minecraft108.types.ListUpdateDisplayName[0];

		public UpdateDisplayName() {}

		public UpdateDisplayName(sul.protocol.minecraft108.types.ListUpdateDisplayName[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length); for(sul.protocol.minecraft108.types.ListUpdateDisplayName cxevc:players){ length+=cxevc.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft108.types.ListUpdateDisplayName cxevc:players){ this.writeBytes(cxevc.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new sul.protocol.minecraft108.types.ListUpdateDisplayName[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ players[cxevc]=new sul.protocol.minecraft108.types.ListUpdateDisplayName(); players[cxevc]._index=this._index; players[cxevc].decode(this._buffer); this._index=players[cxevc]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.UpdateDisplayName(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class RemovePlayer extends Packet {

		public static final int ACTION = (int)4;

		@Override
		public int getId() {
			return ID;
		}

		public UUID[] players = new UUID[0];

		public RemovePlayer() {}

		public RemovePlayer(UUID[] players) {
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
			return "PlayerListItem.RemovePlayer(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

}
