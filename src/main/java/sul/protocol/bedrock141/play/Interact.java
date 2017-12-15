/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock141.xml
 */
package sul.protocol.bedrock141.play;

import sul.utils.*;

public class Interact extends Packet {

	public static final int ID = (int)33;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte LEAVE_VEHICLE = (byte)3;
	public static final byte HOVER = (byte)4;
	public static final byte OPEN_INVENTORY = (byte)6;

	public byte action;
	public long target;
	public Tuples.FloatXYZ targetPosition = new Tuples.FloatXYZ();

	public Interact() {}

	public Interact(byte action, long target, Tuples.FloatXYZ targetPosition) {
		this.action = action;
		this.target = target;
		this.targetPosition = targetPosition;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(target) + 14;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeLittleEndianByte(action);
		this.writeVarlong(target);
		if(action==4){ this.writeLittleEndianFloat(targetPosition.x); this.writeLittleEndianFloat(targetPosition.y); this.writeLittleEndianFloat(targetPosition.z); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		action=readLittleEndianByte();
		target=this.readVarlong();
		if(action==4){ targetPosition=new Tuples.FloatXYZ(); targetPosition.x=readLittleEndianFloat(); targetPosition.y=readLittleEndianFloat(); targetPosition.z=readLittleEndianFloat(); }
	}

	public static Interact fromBuffer(byte[] buffer) {
		Interact ret = new Interact();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Interact(action: " + this.action + ", target: " + this.target + ", targetPosition: " + this.targetPosition.toString() + ")";
	}

}