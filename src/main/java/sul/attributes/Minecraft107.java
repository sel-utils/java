/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/attributes/minecraft107.xml
 */
package sul.attributes;

public enum Minecraft107 {

	MAX_HEALTH("generic.maxHealth", 0f, 1024f, 20f),

	ABSORPTION("generic.absorption", 0f, 4f, 0f),

	MOVEMENT_SPEED("generic.movementSpeed", 0f, 24791f, 0.1f),

	KNOCKBACK_RESISTANCE("generic.knockbackResistance", 0f, 1f, 0f),

	ATTACK_DAMAGE("generic.attackDamage", 0f, 2048f, 2f),

	ATTACK_SPEED("generic.attackSpeed", 0f, 1024f, 4f);

	public final String name;
	public final float min, max, def;

	Minecraft107(String name, float min, float max, float def) {
		this.name = name;
		this.min = min;
		this.max = max;
		this.def = def;
	}

}
