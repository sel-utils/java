/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
package sul.utils;

public abstract class Stream extends Buffer {

	public final void reset() {
		this._buffer = new byte[0];
		this._index = 0;
	}
	
	public abstract int length();
	
	public abstract byte[] encode();
	
	public abstract void decode(byte[] buffer);

}
