/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/java335.xml
 */
package sul.protocol.java335.types;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

import sul.utils.*;

public class ListAddPlayer extends Stream {

	// gamemode
	public static final int SURVIVAL = (int)0;
	public static final int CREATIVE = (int)1;
	public static final int ADVENTURE = (int)2;
	public static final int SPECTATOR = (int)3;

	public UUID uuid;
	public String name;
	public sul.protocol.java335.types.Property[] properties = new sul.protocol.java335.types.Property[0];
	public int gamemode;
	public int latency;
	public boolean hasDisplayName;
	public String displayName;

	public ListAddPlayer() {}

	public ListAddPlayer(UUID uuid, String name, sul.protocol.java335.types.Property[] properties, int gamemode, int latency, boolean hasDisplayName, String displayName) {
		this.uuid = uuid;
		this.name = name;
		this.properties = properties;
		this.gamemode = gamemode;
		this.latency = latency;
		this.hasDisplayName = hasDisplayName;
		this.displayName = displayName;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(properties.length) + Buffer.varuintLength(gamemode) + Buffer.varuintLength(latency) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + 17; for(sul.protocol.java335.types.Property cjcvdlc:properties){ length+=cjcvdlc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeVaruint((int)properties.length); for(sul.protocol.java335.types.Property cjcvdlc:properties){ this.writeBytes(cjcvdlc.encode()); }
		this.writeVaruint(gamemode);
		this.writeVaruint(latency);
		this.writeBool(hasDisplayName);
		if(hasDisplayName==true){ byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		int bbbbcrzm=this.readVaruint(); properties=new sul.protocol.java335.types.Property[bbbbcrzm]; for(int cjcvdlc=0;cjcvdlc<properties.length;cjcvdlc++){ properties[cjcvdlc]=new sul.protocol.java335.types.Property(); properties[cjcvdlc]._index=this._index; properties[cjcvdlc].decode(this._buffer); this._index=properties[cjcvdlc]._index; }
		gamemode=this.readVaruint();
		latency=this.readVaruint();
		hasDisplayName=this.readBool();
		if(hasDisplayName==true){ int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8); }
	}

	@Override
	public String toString() {
		return "ListAddPlayer(uuid: " + this.uuid.toString() + ", name: " + this.name + ", properties: " + Arrays.deepToString(this.properties) + ", gamemode: " + this.gamemode + ", latency: " + this.latency + ", hasDisplayName: " + this.hasDisplayName + ", displayName: " + this.displayName + ")";
	}


}