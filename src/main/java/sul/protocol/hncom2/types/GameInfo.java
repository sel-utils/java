/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Indicates a game and informations about it.
 */
public class GameInfo extends Stream {

	/**
	 * Informations about the the game and the protocols used.
	 */
	public sul.protocol.hncom2.types.Game game;

	/**
	 * "Message of the day" which is displayed in the game's server list. It may contain
	 * Minecraft formatting codes.
	 */
	public String motd;

	/**
	 * Port, or main port if the server allows the connection from multiple ports, where
	 * the socket is listening for connections.
	 */
	public short port;

	public GameInfo() {}

	public GameInfo(sul.protocol.hncom2.types.Game game, String motd, short port) {
		this.game = game;
		this.motd = motd;
		this.port = port;
	}

	@Override
	public int length() {
		return game.length() + Buffer.varuintLength(motd.getBytes(StandardCharsets.UTF_8).length) + motd.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBytes(game.encode());
		byte[] b9z=motd.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)b9z.length); this.writeBytes(b9z);
		this.writeBigEndianShort(port);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		game=new sul.protocol.hncom2.types.Game(); game._index=this._index; game.decode(this._buffer); this._index=game._index;
		int bvb9z=this.readVaruint(); motd=new String(this.readBytes(bvb9z), StandardCharsets.UTF_8);
		port=readBigEndianShort();
	}

	@Override
	public String toString() {
		return "GameInfo(game: " + this.game.toString() + ", motd: " + this.motd + ", port: " + this.port + ")";
	}


}
