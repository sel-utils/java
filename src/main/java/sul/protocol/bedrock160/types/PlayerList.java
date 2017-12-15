/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.types;

import java.nio.charset.StandardCharsets;

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
	public sul.protocol.bedrock160.types.McpeUuid uuid;

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
	public sul.protocol.bedrock160.types.Skin skin;
	public String unknown4;

	public PlayerList() {}

	public PlayerList(sul.protocol.bedrock160.types.McpeUuid uuid, long entityId, String displayName, sul.protocol.bedrock160.types.Skin skin, String unknown4) {
		this.uuid = uuid;
		this.entityId = entityId;
		this.displayName = displayName;
		this.skin = skin;
		this.unknown4 = unknown4;
	}

	@Override
	public int length() {
		return uuid.length() + Buffer.varlongLength(entityId) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + skin.length() + Buffer.varuintLength(unknown4.getBytes(StandardCharsets.UTF_8).length) + unknown4.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBytes(uuid.encode());
		this.writeVarlong(entityId);
		byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
		this.writeBytes(skin.encode());
		byte[] d5b9bq=unknown4.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d5b9bq.length); this.writeBytes(d5b9bq);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		uuid=new sul.protocol.bedrock160.types.McpeUuid(); uuid._index=this._index; uuid.decode(this._buffer); this._index=uuid._index;
		entityId=this.readVarlong();
		int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
		skin=new sul.protocol.bedrock160.types.Skin(); skin._index=this._index; skin.decode(this._buffer); this._index=skin._index;
		int bvd5b9bq=this.readVaruint(); unknown4=new String(this.readBytes(bvd5b9bq), StandardCharsets.UTF_8);
	}

	@Override
	public String toString() {
		return "PlayerList(uuid: " + this.uuid.toString() + ", entityId: " + this.entityId + ", displayName: " + this.displayName + ", skin: " + this.skin.toString() + ", unknown4: " + this.unknown4 + ")";
	}


}