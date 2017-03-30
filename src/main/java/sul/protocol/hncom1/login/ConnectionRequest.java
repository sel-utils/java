/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * First real packet sent by the client with its informations.
 */
public class ConnectionRequest extends Packet {

	public static final byte ID = (byte)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Version of the protocol used by the client that must match the hub's one.
	 */
	public int protocol;

	/**
	 * Password, if the hub requires one, or an empty string.
	 */
	public String password;

	/**
	 * Name of the node that will be validated by the hub. It should always be lowercase
	 * and only contain letters, numbers, dashes and underscores.
	 */
	public String name;

	/**
	 * Indicates whether the node accepts clients when they first connect to the hub or
	 * exclusively when they are manually transferred.
	 */
	public boolean main = true;

	public ConnectionRequest() {}

	public ConnectionRequest(int protocol, String password, String name, boolean main) {
		this.protocol = protocol;
		this.password = password;
		this.name = name;
		this.main = main;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(protocol) + Buffer.varuintLength(password.getBytes(StandardCharsets.UTF_8).length) + password.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(protocol);
		byte[] cfcdcq=password.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cfcdcq.length); this.writeBytes(cfcdcq);
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bfz.length); this.writeBytes(bfz);
		this.writeBool(main);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		protocol=this.readVaruint();
		int bvcfcdcq=this.readVaruint(); password=new String(this.readBytes(bvcfcdcq), StandardCharsets.UTF_8);
		int bvbfz=this.readVaruint(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		main=this.readBool();
	}

	public static ConnectionRequest fromBuffer(byte[] buffer) {
		ConnectionRequest ret = new ConnectionRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ConnectionRequest(protocol: " + this.protocol + ", password: " + this.password + ", name: " + this.name + ", main: " + this.main + ")";
	}

}