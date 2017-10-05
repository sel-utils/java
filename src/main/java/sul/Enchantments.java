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

public enum Enchantments
{

PROTECTION("protection", (byte)0, (byte)0, (byte)4),
FIRE_PROTECTION("fire protection", (byte)1, (byte)1, (byte)4),
FEATHER_FALLING("feather falling", (byte)2, (byte)2, (byte)4),
BLAST_PROTECTION("blast protection", (byte)3, (byte)3, (byte)4),
PROJECTILE_PROTECTION("projectile protection", (byte)4, (byte)4, (byte)4),
RESPIRATION("respiration", (byte)5, (byte)6, (byte)3),
AQUA_AFFINITY("aqua affinity", (byte)6, (byte)8, (byte)1),
THORNS("thorns", (byte)7, (byte)5, (byte)3),
DEPTH_STRIDER("depth strider", (byte)8, (byte)7, (byte)3),
FROST_WALKER("frost walker", (byte)9, (byte)25, (byte)2),
CURSE_OF_BINDING("curse of binding", (byte)10, (byte)0, (byte)1),
SHARPNESS("sharpness", (byte)16, (byte)9, (byte)5),
SMITE("smite", (byte)17, (byte)10, (byte)5),
BANE_OF_ARTHROPODS("bane of arthropods", (byte)18, (byte)11, (byte)5),
KNOCKBACK("knockback", (byte)19, (byte)12, (byte)2),
FIRE_ASPECT("fire aspect", (byte)20, (byte)13, (byte)2),
LOOTING("looting", (byte)21, (byte)14, (byte)3),
SWEEPING_EDGE("sweeping edge", (byte)22, (byte)0, (byte)3),
EFFICIENCY("efficiency", (byte)32, (byte)15, (byte)5),
SILK_TOUCH("silk touch", (byte)33, (byte)16, (byte)1),
UNBREAKING("unbreaking", (byte)34, (byte)17, (byte)3),
FORTUNE("fortune", (byte)35, (byte)18, (byte)3),
POWER("power", (byte)48, (byte)19, (byte)5),
PUNCH("punch", (byte)49, (byte)20, (byte)2),
FLAME("flame", (byte)50, (byte)21, (byte)1),
INFINITY("infinity", (byte)51, (byte)22, (byte)1),
LUCK_OF_THE_SEA("luck of the sea", (byte)61, (byte)23, (byte)3),
LURE("lure", (byte)62, (byte)24, (byte)3),
MENDING("mending", (byte)70, (byte)26, (byte)1),
CURSE_OF_VANISHING("curse of vanishing", (byte)71, (byte)0, (byte)1);

    public final String name;
    public final byte java, bedrock;
    public final byte max;

    private Enchantments(String name, byte java, byte bedrock, byte max)
    {
        this.name = name;
        this.java = java;
        this.bedrock = bedrock;
        this.max = max;
    }

    private static Map<Integer, Enchantments> javaEnchantments, bedrockEnchantments;

    static
    {

        javaEnchantments = new HashMap<Integer, Enchantments>();
        bedrockEnchantments = new HashMap<Integer, Enchantments>();

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

    private static void add(Enchantments e)
    {
        if(e.java != -1) javaEnchantments.put((int)e.java, e);
        if(e.bedrock != -1) bedrockEnchantments.put((int)e.bedrock, e);
    }

    public static Enchantments getJavaEnchantment(int id)
    {
        return javaEnchantments.get(id);
    }

    public static Enchantments getPocketEnchantment(int id)
    {
        return bedrockEnchantments.get(id);
    }

}
