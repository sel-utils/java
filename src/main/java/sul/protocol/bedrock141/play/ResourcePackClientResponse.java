/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class ResourcePackClientResponse extends Packet {

	public static final int ID = (int)8;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// status
	public static final byte REFUSED = (byte)1;
	public static final byte SEND_PACKS = (byte)2;
	public static final byte HAVE_ALL_PACKS = (byte)3;
	public static final byte COMPLETED = (byte)4;

	public byte status;
	public String[] packIds = new String[0];

	public ResourcePackClientResponse() {}

	public ResourcePackClientResponse(byte status, String[] packIds) {
		this.status = status;
		this.packIds = packIds;
	}

	@Override
	public int length() {
		int length=4; for(String cfalc:packIds){ length+=Buffer.varuintLength(cfalc.getBytes(StandardCharsets.UTF_8).length)+cfalc.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeLittleEndianByte(status);
		this.writeLittleEndianShort((short)packIds.length); for(String cfalc:packIds){ byte[] yzbm=cfalc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yzbm.length); this.writeBytes(yzbm); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		status=readLittleEndianByte();
		int bbytzm=readLittleEndianShort(); packIds=new String[bbytzm]; for(int cfalc=0;cfalc<packIds.length;cfalc++){ int bvcfalct=this.readVaruint(); packIds[cfalc]=new String(this.readBytes(bvcfalct), StandardCharsets.UTF_8); }
	}

	public static ResourcePackClientResponse fromBuffer(byte[] buffer) {
		ResourcePackClientResponse ret = new ResourcePackClientResponse();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackClientResponse(status: " + this.status + ", packIds: " + Arrays.deepToString(this.packIds) + ")";
	}

}