/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.types;

import java.util.Arrays;

import sul.utils.*;

public class Overload extends Stream {

	public sul.protocol.bedrock160.types.Parameter[] parameters = new sul.protocol.bedrock160.types.Parameter[0];

	public Overload() {}

	public Overload(sul.protocol.bedrock160.types.Parameter[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(parameters.length); for(sul.protocol.bedrock160.types.Parameter cfy1dvc:parameters){ length+=cfy1dvc.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint((int)parameters.length); for(sul.protocol.bedrock160.types.Parameter cfy1dvc:parameters){ this.writeBytes(cfy1dvc.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bbcfzrcm=this.readVaruint(); parameters=new sul.protocol.bedrock160.types.Parameter[bbcfzrcm]; for(int cfy1dvc=0;cfy1dvc<parameters.length;cfy1dvc++){ parameters[cfy1dvc]=new sul.protocol.bedrock160.types.Parameter(); parameters[cfy1dvc]._index=this._index; parameters[cfy1dvc].decode(this._buffer); this._index=parameters[cfy1dvc]._index; }
	}

	@Override
	public String toString() {
		return "Overload(parameters: " + Arrays.deepToString(this.parameters) + ")";
	}


}