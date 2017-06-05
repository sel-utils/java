/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class Explosion extends Packet {

	public static final int ID = (int)28;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.FloatXYZ position = new Tuples.FloatXYZ();
	public float radius;
	public Tuples.ByteXYZ[] records = new Tuples.ByteXYZ[0];
	public Tuples.FloatXYZ motion = new Tuples.FloatXYZ();

	public Explosion() {}

	public Explosion(Tuples.FloatXYZ position, float radius, Tuples.ByteXYZ[] records, Tuples.FloatXYZ motion) {
		this.position = position;
		this.radius = radius;
		this.records = records;
		this.motion = motion;
	}

	@Override
	public int length() {
		return records.length*3 + 33;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianFloat(position.x); this.writeBigEndianFloat(position.y); this.writeBigEndianFloat(position.z);
		this.writeBigEndianFloat(radius);
		this.writeBigEndianInt((int)records.length); for(Tuples.ByteXYZ cvbjc:records){ this.writeBigEndianByte(cvbjc.x); this.writeBigEndianByte(cvbjc.y); this.writeBigEndianByte(cvbjc.z); }
		this.writeBigEndianFloat(motion.x); this.writeBigEndianFloat(motion.y); this.writeBigEndianFloat(motion.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=new Tuples.FloatXYZ(); position.x=readBigEndianFloat(); position.y=readBigEndianFloat(); position.z=readBigEndianFloat();
		radius=readBigEndianFloat();
		int bjy9zm=readBigEndianInt(); records=new Tuples.ByteXYZ[bjy9zm]; for(int cvbjc=0;cvbjc<records.length;cvbjc++){ records[cvbjc]=new Tuples.ByteXYZ(); records[cvbjc].x=readBigEndianByte(); records[cvbjc].y=readBigEndianByte(); records[cvbjc].z=readBigEndianByte(); }
		motion=new Tuples.FloatXYZ(); motion.x=readBigEndianFloat(); motion.y=readBigEndianFloat(); motion.z=readBigEndianFloat();
	}

	public static Explosion fromBuffer(byte[] buffer) {
		Explosion ret = new Explosion();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Explosion(position: " + this.position.toString() + ", radius: " + this.radius + ", records: " + Arrays.deepToString(this.records) + ", motion: " + this.motion.toString() + ")";
	}

}