/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/enchantments.xml
 */
package sul;

import java.util.*;

public final class Enchantments {

	public final String name;
	public final byte minecraft, pocket;
	public final byte max;

	private Enchantments(String name, byte minecraft, byte pocket, byte max) {
		this.name = name;
		this.minecraft = minecraft;
		this.pocket = pocket;
		this.max = max;
	}

	public static final Enchantments PROTECTION = new Enchantments("protection", (byte)0, (byte)0, (byte)4);
	public static final Enchantments FIRE_PROTECTION = new Enchantments("fire protection", (byte)1, (byte)1, (byte)4);
	public static final Enchantments FEATHER_FALLING = new Enchantments("feather falling", (byte)2, (byte)2, (byte)4);
	public static final Enchantments BLAST_PROTECTION = new Enchantments("blast protection", (byte)3, (byte)3, (byte)4);
	public static final Enchantments PROJECTILE_PROTECTION = new Enchantments("projectile protection", (byte)4, (byte)4, (byte)4);
	public static final Enchantments RESPIRATION = new Enchantments("respiration", (byte)5, (byte)6, (byte)3);
	public static final Enchantments AQUA_AFFINITY = new Enchantments("aqua affinity", (byte)6, (byte)8, (byte)1);
	public static final Enchantments THORNS = new Enchantments("thorns", (byte)7, (byte)5, (byte)3);
	public static final Enchantments DEPTH_STRIDER = new Enchantments("depth strider", (byte)8, (byte)7, (byte)3);
	public static final Enchantments FROST_WALKER = new Enchantments("frost walker", (byte)9, (byte)25, (byte)2);
	public static final Enchantments CURSE_OF_BINDING = new Enchantments("curse of binding", (byte)10, (byte)-1, (byte)1);
	public static final Enchantments SHARPNESS = new Enchantments("sharpness", (byte)16, (byte)9, (byte)5);
	public static final Enchantments SMITE = new Enchantments("smite", (byte)17, (byte)10, (byte)5);
	public static final Enchantments BANE_OF_ARTHROPODS = new Enchantments("bane of arthropods", (byte)18, (byte)11, (byte)5);
	public static final Enchantments KNOCKBACK = new Enchantments("knockback", (byte)19, (byte)12, (byte)2);
	public static final Enchantments FIRE_ASPECT = new Enchantments("fire aspect", (byte)20, (byte)13, (byte)2);
	public static final Enchantments LOOTING = new Enchantments("looting", (byte)21, (byte)14, (byte)3);
	public static final Enchantments SWEEPING_EDGE = new Enchantments("sweeping edge", (byte)22, (byte)-1, (byte)3);
	public static final Enchantments EFFICIENCY = new Enchantments("efficiency", (byte)32, (byte)15, (byte)5);
	public static final Enchantments SILK_TOUCH = new Enchantments("silk touch", (byte)33, (byte)16, (byte)1);
	public static final Enchantments UNBREAKING = new Enchantments("unbreaking", (byte)34, (byte)17, (byte)3);
	public static final Enchantments FORTUNE = new Enchantments("fortune", (byte)35, (byte)18, (byte)3);
	public static final Enchantments POWER = new Enchantments("power", (byte)48, (byte)19, (byte)5);
	public static final Enchantments PUNCH = new Enchantments("punch", (byte)49, (byte)20, (byte)2);
	public static final Enchantments FLAME = new Enchantments("flame", (byte)50, (byte)21, (byte)1);
	public static final Enchantments INFINITY = new Enchantments("infinity", (byte)51, (byte)22, (byte)1);
	public static final Enchantments LUCK_OF_THE_SEA = new Enchantments("luck of the sea", (byte)61, (byte)23, (byte)3);
	public static final Enchantments LURE = new Enchantments("lure", (byte)62, (byte)24, (byte)3);
	public static final Enchantments MENDING = new Enchantments("mending", (byte)70, (byte)26, (byte)1);
	public static final Enchantments CURSE_OF_VANISHING = new Enchantments("curse of vanishing", (byte)71, (byte)-1, (byte)1);

	private static Map<Integer, Enchantments> minecraftEnchantments, pocketEnchantments;

	static {

		minecraftEnchantments = new HashMap<Integer, Enchantments>();
		pocketEnchantments = new HashMap<Integer, Enchantments>();

		add(PROTECTION);
		add(FIRE_PROTECTION);
		add(FEATHER_FALLING);
		add(BLAST_PROTECTION);
		add(PROJECTILE_PROTECTION);
		add(RESPIRATION);
		add(AQUA_AFFINITY);
		add(THORNS);
		add(DEPTH_STRIDER);
		add(FROST_WALKER);
		add(CURSE_OF_BINDING);
		add(SHARPNESS);
		add(SMITE);
		add(BANE_OF_ARTHROPODS);
		add(KNOCKBACK);
		add(FIRE_ASPECT);
		add(LOOTING);
		add(SWEEPING_EDGE);
		add(EFFICIENCY);
		add(SILK_TOUCH);
		add(UNBREAKING);
		add(FORTUNE);
		add(POWER);
		add(PUNCH);
		add(FLAME);
		add(INFINITY);
		add(LUCK_OF_THE_SEA);
		add(LURE);
		add(MENDING);
		add(CURSE_OF_VANISHING);

	}

	private static void add(Enchantments e) {
		if(e.minecraft != -1) minecraftEnchantments.put((int)e.minecraft, e);
		if(e.pocket != -1) pocketEnchantments.put((int)e.pocket, e);
	}

	public static Enchantments getMinecraftEnchantment(int id) {
		return minecraftEnchantments.get(id);
	}

	public static Enchantments getPocketEnchantment(int id) {
		return pocketEnchantments.get(id);
	}

}