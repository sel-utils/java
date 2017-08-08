/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.play;

import sul.utils.*;

/**
 * Updates the world's settings and client's permissions.
 */
public class AdventureSettings extends Packet {

	public static final int ID = (int)55;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// flags
	public static final int IMMUTABLE_WORLD = 1;
	public static final int PVP_DISABLED = 2;
	public static final int PVM_DISABLED = 4;
	public static final int MVP_DISBALED = 8;
	public static final int EVP_DISABLED = 16;
	public static final int AUTO_JUMP = 32;
	public static final int ALLOW_FLIGHT = 64;
	public static final int NO_CLIP = 128;
	public static final int FLYING = 512;
	public static final int MUTED = 1024;

	// permission level
	public static final int USER = 0;
	public static final int OPERATOR = 1;
	public static final int HOST = 2;
	public static final int AUTOMATION = 3;
	public static final int ADMIN = 4;

	// abilities
	public static final int BUILD_AND_MINE = 1;
	public static final int DOORS_AND_SWITCHES = 2;
	public static final int OPEN_CONTAINERS = 4;
	public static final int ATTACK_PLAYERS = 8;
	public static final int ATTACK_MOBS = 16;
	public static final int OP = 32;
	public static final int TELEPORT = 64;

	// player rank
	public static final int VISITOR = 0;
	public static final int MEMBER = 1;
	public static final int OPERATOR = 2;
	public static final int CUSTOM = 3;

	public int flags;
	public int permissionLevel;
	public int abilities;
	public int playerRank;
	public long unknown4;

	public AdventureSettings() {}

	public AdventureSettings(int flags, int permissionLevel, int abilities, int playerRank, long unknown4) {
		this.flags = flags;
		this.permissionLevel = permissionLevel;
		this.abilities = abilities;
		this.playerRank = playerRank;
		this.unknown4 = unknown4;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(flags) + Buffer.varuintLength(permissionLevel) + Buffer.varuintLength(abilities) + Buffer.varuintLength(playerRank) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(flags);
		this.writeVaruint(permissionLevel);
		this.writeVaruint(abilities);
		this.writeVaruint(playerRank);
		this.writeLittleEndianLong(unknown4);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		flags=this.readVaruint();
		permissionLevel=this.readVaruint();
		abilities=this.readVaruint();
		playerRank=this.readVaruint();
		unknown4=readLittleEndianLong();
	}

	public static AdventureSettings fromBuffer(byte[] buffer) {
		AdventureSettings ret = new AdventureSettings();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AdventureSettings(flags: " + this.flags + ", permissionLevel: " + this.permissionLevel + ", abilities: " + this.abilities + ", playerRank: " + this.playerRank + ", unknown4: " + this.unknown4 + ")";
	}

}