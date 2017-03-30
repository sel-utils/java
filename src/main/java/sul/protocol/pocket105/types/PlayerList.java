/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket105.xml
 */
package sul.protocol.pocket105.types;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

/**
 * Informations about a player that will be added to the player's list in the pause
 * menu.
 */
public class PlayerList extends Stream {

	/**
	 * UUID of the player. If it's associated with an XBOX Live account the player's profile
	 * will also be available in pause menu.
	 */
	public UUID uuid;

	/**
	 * Player's id, used to associate the skin with the game's entity spawned with AddPlayer.
	 */
	public long entityId;

	/**
	 * Player's display name, that can contain Minecraft's formatting codes. It shouldn't
	 * contain suffixes nor prefixes.
	 */
	public String displayName;

	/**
	 * Player's skin usually given in the Login's packet body.
	 */
	public sul.protocol.pocket105.types.Skin skin;

	public PlayerList() {}

	public PlayerList(UUID uuid, long entityId, String displayName, sul.protocol.pocket105.types.Skin skin) {
		this.uuid = uuid;
		this.entityId = entityId;
		this.displayName = displayName;
		this.skin = skin;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + skin.length() + 16;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeVarlong(entityId);
		byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
		this.writeBytes(skin.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		entityId=this.readVarlong();
		int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
		skin=new sul.protocol.pocket105.types.Skin(); skin._index=this._index; skin.decode(this._buffer); this._index=skin._index;
	}

	@Override
	public String toString() {
		return "PlayerList(uuid: " + this.uuid.toString() + ", entityId: " + this.entityId + ", displayName: " + this.displayName + ", skin: " + this.skin.toString() + ")";
	}


}