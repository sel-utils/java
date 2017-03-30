/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
package sul.protocol.raknet8;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import sul.utils.Packet;

/**
 * Minecraft: Pocket Edition's networking protocol.
 */
public final class Packets {

	private Packets() {}

	public static final Map<Integer, Class<? extends Packet>> CONTROL;

	public static final Map<Integer, Class<? extends Packet>> UNCONNECTED;

	public static final Map<Integer, Class<? extends Packet>> ENCAPSULATED;

	static {

		HashMap<Integer, Class<? extends Packet>> control = new HashMap<Integer, Class<? extends Packet>>();
		control.put(192, sul.protocol.raknet8.control.Ack.class);
		control.put(160, sul.protocol.raknet8.control.Nack.class);
		control.put(132, sul.protocol.raknet8.control.Encapsulated.class);
		CONTROL = Collections.unmodifiableMap(control);

		HashMap<Integer, Class<? extends Packet>> unconnected = new HashMap<Integer, Class<? extends Packet>>();
		unconnected.put(1, sul.protocol.raknet8.unconnected.Ping.class);
		unconnected.put(28, sul.protocol.raknet8.unconnected.Pong.class);
		unconnected.put(5, sul.protocol.raknet8.unconnected.OpenConnectionRequest1.class);
		unconnected.put(6, sul.protocol.raknet8.unconnected.OpenConnectionReply1.class);
		unconnected.put(7, sul.protocol.raknet8.unconnected.OpenConnectionRequest2.class);
		unconnected.put(8, sul.protocol.raknet8.unconnected.OpenConnectionReply2.class);
		UNCONNECTED = Collections.unmodifiableMap(unconnected);

		HashMap<Integer, Class<? extends Packet>> encapsulated = new HashMap<Integer, Class<? extends Packet>>();
		encapsulated.put(9, sul.protocol.raknet8.encapsulated.ClientConnect.class);
		encapsulated.put(16, sul.protocol.raknet8.encapsulated.ServerHandshake.class);
		encapsulated.put(19, sul.protocol.raknet8.encapsulated.ClientHandshake.class);
		encapsulated.put(21, sul.protocol.raknet8.encapsulated.ClientCancelConnection.class);
		encapsulated.put(0, sul.protocol.raknet8.encapsulated.Ping.class);
		encapsulated.put(3, sul.protocol.raknet8.encapsulated.Pong.class);
		encapsulated.put(254, sul.protocol.raknet8.encapsulated.Mcpe.class);
		ENCAPSULATED = Collections.unmodifiableMap(encapsulated);

	}

}