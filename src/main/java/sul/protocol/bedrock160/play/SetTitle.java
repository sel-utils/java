/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock160.xml
 */
package sul.protocol.bedrock160.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class SetTitle extends Packet {

	public static final int ID = (int)88;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final int HIDE = (int)0;
	public static final int RESET = (int)1;
	public static final int SET_TITLE = (int)2;
	public static final int SET_SUBTITLE = (int)3;
	public static final int SET_ACTION_BAR = (int)4;
	public static final int SET_TIMINGS = (int)5;

	public int action;
	public String text;
	public int fadeIn;
	public int stay;
	public int fadeOut;

	public SetTitle() {}

	public SetTitle(int action, String text, int fadeIn, int stay, int fadeOut) {
		this.action = action;
		this.text = text;
		this.fadeIn = fadeIn;
		this.stay = stay;
		this.fadeOut = fadeOut;
	}

	@Override
	public int length() {
		return Buffer.varintLength(action) + Buffer.varuintLength(text.getBytes(StandardCharsets.UTF_8).length) + text.getBytes(StandardCharsets.UTF_8).length + Buffer.varintLength(fadeIn) + Buffer.varintLength(stay) + Buffer.varintLength(fadeOut) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVarint(action);
		byte[] dvd=text.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvd.length); this.writeBytes(dvd);
		this.writeVarint(fadeIn);
		this.writeVarint(stay);
		this.writeVarint(fadeOut);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		action=this.readVarint();
		int bvdvd=this.readVaruint(); text=new String(this.readBytes(bvdvd), StandardCharsets.UTF_8);
		fadeIn=this.readVarint();
		stay=this.readVarint();
		fadeOut=this.readVarint();
	}

	public static SetTitle fromBuffer(byte[] buffer) {
		SetTitle ret = new SetTitle();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetTitle(action: " + this.action + ", text: " + this.text + ", fadeIn: " + this.fadeIn + ", stay: " + this.stay + ", fadeOut: " + this.fadeOut + ")";
	}

}