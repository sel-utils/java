/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/metadata/minecraft315.xml
 */
package sul.metadata;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

@SuppressWarnings("unused")
public class Minecraft315 extends Stream {

	@Override
	public int length() {
		return 1;
	}

	@Override
	public byte[] encode() {
		this.writeBigEndianByte((byte)255);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		byte metadata;
		while(!this.eof() && (metadata=readBigEndianByte()) != (byte)255) {
			switch(readBigEndianByte()) {
				case 0:
					byte _0;
					_0=readBigEndianByte();
					break;
				case 1:
					int _1;
					_1=this.readVaruint();
					break;
				case 2:
					float _2;
					_2=readBigEndianFloat();
					break;
				case 3:
					String _3;
					int bvxm=this.readVaruint(); _3=new String(this.readBytes(bvxm), StandardCharsets.UTF_8);
					break;
				case 4:
					String _4;
					int bvxq=this.readVaruint(); _4=new String(this.readBytes(bvxq), StandardCharsets.UTF_8);
					break;
				case 5:
					sul.protocol.minecraft315.types.Slot _5;
					_5=new sul.protocol.minecraft315.types.Slot(); _5._index=this._index; _5.decode(this._buffer); this._index=_5._index;
					break;
				case 6:
					boolean _6;
					_6=this.readBool();
					break;
				case 7:
					Tuples.FloatXYZ _7;
					_7=new Tuples.FloatXYZ(); _7.x=readBigEndianFloat(); _7.y=readBigEndianFloat(); _7.z=readBigEndianFloat();
					break;
				case 8:
					long _8;
					_8=readBigEndianLong();
					break;
				case 9:
					sul.protocol.minecraft315.types.OptionalPosition _9;
					_9=new sul.protocol.minecraft315.types.OptionalPosition(); _9._index=this._index; _9.decode(this._buffer); this._index=_9._index;
					break;
				case 10:
					int _10;
					_10=this.readVaruint();
					break;
				case 11:
					sul.protocol.minecraft315.types.OptionalUuid _11;
					_11=new sul.protocol.minecraft315.types.OptionalUuid(); _11._index=this._index; _11.decode(this._buffer); this._index=_11._index;
					break;
				case 12:
					int _12;
					_12=this.readVaruint();
					break;
				default: break;
			}
		}
	}

}