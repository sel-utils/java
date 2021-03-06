/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/metadata/pocket102.xml
 */
package sul.metadata;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

@SuppressWarnings("unused")
public class Pocket102 extends Stream {

	@Override
	public int length() {
		return 1;
	}

	@Override
	public byte[] encode() {
		this.writeVaruint(0);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		byte metadata;
		int length=this.readVaruint();
		while(length-- > 0) {
			metadata=readBigEndianByte();
			switch(readBigEndianByte()) {
				case 0:
					byte _0;
					_0=readBigEndianByte();
					break;
				case 1:
					short _1;
					_1=readLittleEndianShort();
					break;
				case 2:
					int _2;
					_2=this.readVarint();
					break;
				case 3:
					float _3;
					_3=readLittleEndianFloat();
					break;
				case 4:
					String _4;
					int bvxq=this.readVaruint(); _4=new String(this.readBytes(bvxq), StandardCharsets.UTF_8);
					break;
				case 5:
					sul.protocol.pocket102.types.Slot _5;
					_5=new sul.protocol.pocket102.types.Slot(); _5._index=this._index; _5.decode(this._buffer); this._index=_5._index;
					break;
				case 6:
					Tuples.IntXYZ _6;
					_6=new Tuples.IntXYZ(); _6.x=this.readVarint(); _6.y=this.readVarint(); _6.z=this.readVarint();
					break;
				case 7:
					long _7;
					_7=this.readVarlong();
					break;
				case 8:
					Tuples.FloatXYZ _8;
					_8=new Tuples.FloatXYZ(); _8.x=readLittleEndianFloat(); _8.y=readLittleEndianFloat(); _8.z=readLittleEndianFloat();
					break;
				default: break;
			}
		}
	}

}