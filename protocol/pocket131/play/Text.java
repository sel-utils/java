/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket131.xml
 */
package sul.protocol.pocket131.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * Sends or receives a message from the player. Every variant's field can contain Minecraft's
 * formatting codes.
 */
public class Text extends Packet {

	public static final byte ID = (byte)9;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte type;
	public byte unknown1;

	public Text() {}

	public Text(byte type, byte unknown1) {
		this.type = type;
		this.unknown1 = unknown1;
	}

	@Override
	public int length() {
		return 3;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(type);
		this.writeBigEndianByte(unknown1);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		type=readBigEndianByte();
		unknown1=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static Text fromBuffer(byte[] buffer) {
		Text ret = new Text();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Text(type: " + this.type + ", unknown1: " + this.unknown1 + ")";
	}

	/**
	 * Raw message that will be printed in the chat as it is.
	 */
	public class Raw extends Packet {

		public static final byte TYPE = (byte)0;

		@Override
		public int getId() {
			return ID;
		}

		public String message;

		public Raw() {}

		public Raw(String message) {
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.Raw(message: " + this.message + ")";
		}

	}

	/**
	 * Chat message sent by the player to the server. If sent from the server it will display
	 * as `&lt;sender&gt; message`.
	 */
	public class Chat extends Packet {

		public static final byte TYPE = (byte)1;

		@Override
		public int getId() {
			return ID;
		}

		/**
		 * Case sensitive name of the player that has sent the message.
		 */
		public String sender;

		/**
		 * Message sent by the player. It should be unformatted (regular expression: `§[a-fA-F0-9k-or]`)
		 * before being processed as chat message by the server.
		 */
		public String message;

		public Chat() {}

		public Chat(String sender, String message) {
			this.sender = sender;
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(sender.getBytes(StandardCharsets.UTF_8).length) + sender.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] cvzv=sender.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvzv.length); this.writeBytes(cvzv);
			byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvcvzv=this.readVaruint(); sender=new String(this.readBytes(bvcvzv), StandardCharsets.UTF_8);
			int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.Chat(sender: " + this.sender + ", message: " + this.message + ")";
		}

	}

	/**
	 * Sends a message that will be translated client-side using the player's language.
	 */
	public class Translation extends Packet {

		public static final byte TYPE = (byte)2;

		@Override
		public int getId() {
			return ID;
		}

		/**
		 * A message in the game's language file.
		 */
		public String message;

		/**
		 * Parameters that will be placed instead of the replacement symbols (%1, %2, etc...).
		 */
		public String[] parameters = new String[0];

		public Translation() {}

		public Translation(String message, String[] parameters) {
			this.message = message;
			this.parameters = parameters;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(parameters.length); for(String cfy1dvc:parameters){ length+=Buffer.varuintLength(cfy1dvc.getBytes(StandardCharsets.UTF_8).length)+cfy1dvc.getBytes(StandardCharsets.UTF_8).length; } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
			this.writeVaruint((int)parameters.length); for(String cfy1dvc:parameters){ byte[] yzmry=cfy1dvc.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yzmry.length); this.writeBytes(yzmry); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
			int bbcfzrcm=this.readVaruint(); parameters=new String[bbcfzrcm]; for(int cfy1dvc=0;cfy1dvc<parameters.length;cfy1dvc++){ int bvcfy1dv=this.readVaruint(); parameters[cfy1dvc]=new String(this.readBytes(bvcfy1dv), StandardCharsets.UTF_8); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.Translation(message: " + this.message + ", parameters: " + Arrays.deepToString(this.parameters) + ")";
		}

	}

	/**
	 * Displays popups messages for one tick before fading out. The popup messages are
	 * displayed at the centre of the screen and are not automatically aligned horizontally.
	 */
	public class Popup extends Packet {

		public static final byte TYPE = (byte)3;

		@Override
		public int getId() {
			return ID;
		}

		public String title;
		public String subtitle;

		public Popup() {}

		public Popup(String title, String subtitle) {
			this.title = title;
			this.subtitle = subtitle;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(title.getBytes(StandardCharsets.UTF_8).length) + title.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(subtitle.getBytes(StandardCharsets.UTF_8).length) + subtitle.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dlbu=title.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dlbu.length); this.writeBytes(dlbu);
			byte[] cvdlbu=subtitle.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvdlbu.length); this.writeBytes(cvdlbu);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvdlbu=this.readVaruint(); title=new String(this.readBytes(bvdlbu), StandardCharsets.UTF_8);
			int bvcvdlbu=this.readVaruint(); subtitle=new String(this.readBytes(bvcvdlbu), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.Popup(title: " + this.title + ", subtitle: " + this.subtitle + ")";
		}

	}

	/**
	 * Displays a tip message for one tick before fading out. The tip message is displayed
	 * on top of the inventory bar and can contain multiple lines separated with `\n`.
	 */
	public class Tip extends Packet {

		public static final byte TYPE = (byte)4;

		@Override
		public int getId() {
			return ID;
		}

		public String message;

		public Tip() {}

		public Tip(String message) {
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.Tip(message: " + this.message + ")";
		}

	}

	public class System extends Packet {

		public static final byte TYPE = (byte)5;

		@Override
		public int getId() {
			return ID;
		}

		public String message;

		public System() {}

		public System(String message) {
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.System(message: " + this.message + ")";
		}

	}

	/**
	 * Sends a whisper message to the client that will be displayed in the format `<i>sender
	 * has whispered to you:</i> message`.
	 */
	public class Whisper extends Packet {

		public static final byte TYPE = (byte)6;

		@Override
		public int getId() {
			return ID;
		}

		public String sender;
		public String message;

		public Whisper() {}

		public Whisper(String sender, String message) {
			this.sender = sender;
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(sender.getBytes(StandardCharsets.UTF_8).length) + sender.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] cvzv=sender.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cvzv.length); this.writeBytes(cvzv);
			byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvcvzv=this.readVaruint(); sender=new String(this.readBytes(bvcvzv), StandardCharsets.UTF_8);
			int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.Whisper(sender: " + this.sender + ", message: " + this.message + ")";
		}

	}

	public class Announcement extends Packet {

		public static final byte TYPE = (byte)7;

		@Override
		public int getId() {
			return ID;
		}

		public String announcer;
		public String message;

		public Announcement() {}

		public Announcement(String announcer, String message) {
			this.announcer = announcer;
			this.message = message;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(announcer.getBytes(StandardCharsets.UTF_8).length) + announcer.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] y5bvyv=announcer.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y5bvyv.length); this.writeBytes(y5bvyv);
			byte[] bvcfz=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bvcfz.length); this.writeBytes(bvcfz);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bvy5bvyv=this.readVaruint(); announcer=new String(this.readBytes(bvy5bvyv), StandardCharsets.UTF_8);
			int bvbvcfz=this.readVaruint(); message=new String(this.readBytes(bvbvcfz), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "Text.Announcement(announcer: " + this.announcer + ", message: " + this.message + ")";
		}

	}

}