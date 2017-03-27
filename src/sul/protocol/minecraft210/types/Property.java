/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Property extends Stream {

	public String name;
	public String value;
	public boolean signed;
	public String signature;

	public Property() {}

	public Property(String name, String value, boolean signed, String signature) {
		this.name = name;
		this.value = value;
		this.signed = signed;
		this.signature = signature;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(value.getBytes(StandardCharsets.UTF_8).length) + value.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(signature.getBytes(StandardCharsets.UTF_8).length) + signature.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		byte[] dfdu=value.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dfdu.length); this.writeBytes(dfdu);
		this.writeBool(signed);
		if(signed==true){ byte[] clbfdj=signature.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)clbfdj.length); this.writeBytes(clbfdj); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		int bvdfdu=this.readVaruint(); value=new String(this.readBytes(bvdfdu), StandardCharsets.UTF_8);
		signed=this.readBool();
		if(signed==true){ int bvclbfdj=this.readVaruint(); signature=new String(this.readBytes(bvclbfdj), StandardCharsets.UTF_8); }
	}

	@Override
	public String toString() {
		return "Property(name: " + this.name + ", value: " + this.value + ", signed: " + this.signed + ", signature: " + this.signature + ")";
	}


}
