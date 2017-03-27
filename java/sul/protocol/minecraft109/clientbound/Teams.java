/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class Teams extends Packet {

	public static final int ID = (int)65;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String name;
	public byte mode;

	public Teams() {}

	public Teams(String name, byte mode) {
		this.name = name;
		this.mode = mode;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 3;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeBigEndianByte(mode);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		mode=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Teams fromBuffer(byte[] buffer) {
		Teams ret = new Teams();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Teams(name: " + this.name + ", mode: " + this.mode + ")";
	}

	public class CreateTeam extends Packet {

		public static final byte MODE = (byte)0;

		@Override
		public int getId() {
			return ID;
		}

		// friendly flags
		public static final byte FRIENDLY_FIRE = 1;
		public static final byte SEE_TEAM_INVISIBLE_PLAYERS = 2;

		// nametag visibility
		public static final String ALWAYS_HIDE = "always";
		public static final String HIDE_OTHER_TEAMS = "hideOtherTeams";
		public static final String HIDE_OWN_TEAM = "hideOwnTeam";
		public static final String NEVER_HIDE = "never";

		// collision rule
		public static final String ALWAYS_PUSH = "always";
		public static final String PUSH_OTHER_TEAMS = "pushOtherTeams";
		public static final String PUSH_OWN_TEAM = "pushOwnTeam";
		public static final String NEVER_PUSH = "never";

		public String displayName;
		public String prefix;
		public String suffix;
		public byte friendlyFlags;
		public String nametagVisibility;
		public String collisionRule;
		public byte color;
		public String[] players = new String[0];

		public CreateTeam() {}

		public CreateTeam(String displayName, String prefix, String suffix, byte friendlyFlags, String nametagVisibility, String collisionRule, byte color, String[] players) {
			this.displayName = displayName;
			this.prefix = prefix;
			this.suffix = suffix;
			this.friendlyFlags = friendlyFlags;
			this.nametagVisibility = nametagVisibility;
			this.collisionRule = collisionRule;
			this.color = color;
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(prefix.getBytes(StandardCharsets.UTF_8).length) + prefix.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(suffix.getBytes(StandardCharsets.UTF_8).length) + suffix.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(nametagVisibility.getBytes(StandardCharsets.UTF_8).length) + nametagVisibility.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(collisionRule.getBytes(StandardCharsets.UTF_8).length) + collisionRule.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(players.length) + 2; for(String cxevc:players){ length+=Buffer.varuintLength(cxevc.getBytes(StandardCharsets.UTF_8).length)+cxevc.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
			byte[] cjzl=prefix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cjzl.length); this.writeBytes(cjzl);
			byte[] cvzl=suffix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvzl.length); this.writeBytes(cvzl);
			this.writeBigEndianByte(friendlyFlags);
			byte[] bfzrzzcl=nametagVisibility.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfzrzzcl.length); this.writeBytes(bfzrzzcl);
			byte[] y9bla9uv=collisionRule.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y9bla9uv.length); this.writeBytes(y9bla9uv);
			this.writeBigEndianByte(color);
			this.writeVaruint((int)players.length); for(String cxevc:players){ byte[] yhdm=cxevc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yhdm.length); this.writeBytes(yhdm); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
			int bvcjzl=this.readVaruint(); prefix=new String(this.readBytes(bvcjzl), StandardCharsets.UTF_8);
			int bvcvzl=this.readVaruint(); suffix=new String(this.readBytes(bvcvzl), StandardCharsets.UTF_8);
			friendlyFlags=readBigEndianByte();
			int bvbfzrzz=this.readVaruint(); nametagVisibility=new String(this.readBytes(bvbfzrzz), StandardCharsets.UTF_8);
			int bvy9bla9=this.readVaruint(); collisionRule=new String(this.readBytes(bvy9bla9), StandardCharsets.UTF_8);
			color=readBigEndianByte();
			int bbylcm=this.readVaruint(); players=new String[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ int bvcxevct=this.readVaruint(); players[cxevc]=new String(this.readBytes(bvcxevct), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Teams.CreateTeam(displayName: " + this.displayName + ", prefix: " + this.prefix + ", suffix: " + this.suffix + ", friendlyFlags: " + this.friendlyFlags + ", nametagVisibility: " + this.nametagVisibility + ", collisionRule: " + this.collisionRule + ", color: " + this.color + ", players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class RemoveTeam extends Packet {

		public static final byte MODE = (byte)1;

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
			return "Teams.RemoveTeam()";
		}

	}

	public class UpdateTeamInfo extends Packet {

		public static final byte MODE = (byte)2;

		@Override
		public int getId() {
			return ID;
		}

		// friendly flags
		public static final byte FRIENDLY_FIRE = 1;
		public static final byte SEE_TEAM_INVISIBLE_PLAYERS = 2;

		// nametag visibility
		public static final String ALWAYS_HIDE = "always";
		public static final String HIDE_OTHER_TEAMS = "hideOtherTeams";
		public static final String HIDE_OWN_TEAM = "hideOwnTeam";
		public static final String NEVER_HIDE = "never";

		// collision rule
		public static final String ALWAYS_PUSH = "always";
		public static final String PUSH_OTHER_TEAMS = "pushOtherTeams";
		public static final String PUSH_OWN_TEAM = "pushOwnTeam";
		public static final String NEVER_PUSH = "never";

		public String displayName;
		public String prefix;
		public String suffix;
		public byte friendlyFlags;
		public String nametagVisibility;
		public String collisionRule;
		public byte color;

		public UpdateTeamInfo() {}

		public UpdateTeamInfo(String displayName, String prefix, String suffix, byte friendlyFlags, String nametagVisibility, String collisionRule, byte color) {
			this.displayName = displayName;
			this.prefix = prefix;
			this.suffix = suffix;
			this.friendlyFlags = friendlyFlags;
			this.nametagVisibility = nametagVisibility;
			this.collisionRule = collisionRule;
			this.color = color;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(prefix.getBytes(StandardCharsets.UTF_8).length) + prefix.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(suffix.getBytes(StandardCharsets.UTF_8).length) + suffix.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(nametagVisibility.getBytes(StandardCharsets.UTF_8).length) + nametagVisibility.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(collisionRule.getBytes(StandardCharsets.UTF_8).length) + collisionRule.getBytes(StandardCharsets.UTF_8).length + 2;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
			byte[] cjzl=prefix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cjzl.length); this.writeBytes(cjzl);
			byte[] cvzl=suffix.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvzl.length); this.writeBytes(cvzl);
			this.writeBigEndianByte(friendlyFlags);
			byte[] bfzrzzcl=nametagVisibility.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfzrzzcl.length); this.writeBytes(bfzrzzcl);
			byte[] y9bla9uv=collisionRule.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y9bla9uv.length); this.writeBytes(y9bla9uv);
			this.writeBigEndianByte(color);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
			int bvcjzl=this.readVaruint(); prefix=new String(this.readBytes(bvcjzl), StandardCharsets.UTF_8);
			int bvcvzl=this.readVaruint(); suffix=new String(this.readBytes(bvcvzl), StandardCharsets.UTF_8);
			friendlyFlags=readBigEndianByte();
			int bvbfzrzz=this.readVaruint(); nametagVisibility=new String(this.readBytes(bvbfzrzz), StandardCharsets.UTF_8);
			int bvy9bla9=this.readVaruint(); collisionRule=new String(this.readBytes(bvy9bla9), StandardCharsets.UTF_8);
			color=readBigEndianByte();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Teams.UpdateTeamInfo(displayName: " + this.displayName + ", prefix: " + this.prefix + ", suffix: " + this.suffix + ", friendlyFlags: " + this.friendlyFlags + ", nametagVisibility: " + this.nametagVisibility + ", collisionRule: " + this.collisionRule + ", color: " + this.color + ")";
		}

	}

	public class AddPlayers extends Packet {

		public static final byte MODE = (byte)3;

		@Override
		public int getId() {
			return ID;
		}

		public String[] players = new String[0];

		public AddPlayers() {}

		public AddPlayers(String[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length); for(String cxevc:players){ length+=Buffer.varuintLength(cxevc.getBytes(StandardCharsets.UTF_8).length)+cxevc.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(String cxevc:players){ byte[] yhdm=cxevc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yhdm.length); this.writeBytes(yhdm); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new String[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ int bvcxevct=this.readVaruint(); players[cxevc]=new String(this.readBytes(bvcxevct), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Teams.AddPlayers(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class RemovePlayers extends Packet {

		public static final byte MODE = (byte)4;

		@Override
		public int getId() {
			return ID;
		}

		public String[] players = new String[0];

		public RemovePlayers() {}

		public RemovePlayers(String[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length); for(String cxevc:players){ length+=Buffer.varuintLength(cxevc.getBytes(StandardCharsets.UTF_8).length)+cxevc.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(String cxevc:players){ byte[] yhdm=cxevc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yhdm.length); this.writeBytes(yhdm); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bbylcm=this.readVaruint(); players=new String[bbylcm]; for(int cxevc=0;cxevc<players.length;cxevc++){ int bvcxevct=this.readVaruint(); players[cxevc]=new String(this.readBytes(bvcxevct), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Teams.RemovePlayers(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

}
