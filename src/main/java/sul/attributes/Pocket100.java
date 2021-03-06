/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/attributes/pocket100.xml
 */
package sul.attributes;

public enum Pocket100
{

    HEALTH("minecraft:health", 0f, 20f, 20f),

    ABSORPTION("minecraft:absorption", 0f, 4f, 0f),

    HUNGER("minecraft:player.hunger", 0f, 20f, 20f),

    SATURATION("minecraft:player.saturation", 0f, 20f, 5f),

    EXPERIENCE("minecraft:player.experience", 0f, 1f, 0f),

    LEVEL("minecraft:player.level", 0f, 24791f, 0f),

    SPEED("minecraft:movement", 0f, 24791f, 0.1f),

    KNOCKBACK_RESISTANCE("minecraft:generic.knockback_resistance", 0f, 1f, 0f);

    public final String id;
    public final float min, max, def;

    Pocket100(String id, float min, float max, float def)
    {
        this.id = id;
        this.min = min;
        this.max = max;
        this.def = def;
    }

}
