/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/biomes.xml
 */
package sul;

import java.util.*;

public enum Biomes
{

    OCEAN("ocean", (byte)0, 0.5f),
    PLAINS("plains", (byte)1, 0.8f),
    DESERT("desert", (byte)2, 2f),
    EXTREME_HILLS("extreme hills", (byte)3, 0.2f),
    FOREST("forest", (byte)4, 0.7f),
    TAIGA("taiga", (byte)5, 0.05f),
    SWAMPLAND("swampland", (byte)6, 0.8f),
    RIVER("river", (byte)7, 0.5f),
    HELL("hell", (byte)8, 2f),
    THE_END("the end", (byte)9, 0.5f),
    FROZEN_OCEAN("frozen ocean", (byte)10, 0f),
    FROZEN_RIVER("frozen river", (byte)11, 0f),
    ICE_PLAINS("ice plains", (byte)12, 0f),
    ICE_MOUNTAINS("ice mountains", (byte)13, 0f),
    MUSHROOM_ISLAND("mushroom island", (byte)14, 0.9f),
    MUSHROOM_ISLAND_SHORE("mushroom island shore", (byte)15, 0.9f),
    BEACH("beach", (byte)16, 0.8f),
    DESERT_HILLS("desert hills", (byte)17, 2f),
    FOREST_HILLS("forest hills", (byte)18, 0.7f),
    TAIGA_HILLS("taiga hills", (byte)19, 0.2f),
    EXTREME_HILLS_EDGE("extreme hills edge", (byte)20, 0.2f),
    JUNGLE("jungle", (byte)21, 1.2f),
    JUNGLE_HILLS("jungle hills", (byte)22, 1.2f),
    JUNGLE_EDGE("jungle edge", (byte)23, 0.95f),
    DEEP_OCEAN("deep ocean", (byte)24, 0.5f),
    STONE_BEACH("stone beach", (byte)25, 0.2f),
    COLD_BEACH("cold beach", (byte)26, 0.05f),
    BIRCH_FOREST("birch forest", (byte)27, 0.6f),
    BIRCH_FOREST_HILLS("birch forest hills", (byte)28, 0.6f),
    ROOFED_FOREST("roofed forest", (byte)29, 0.7f),
    COLD_TAIGA("cold taiga", (byte)30, -0.5f),
    COLD_TAIGA_HILLS("cold taiga hills", (byte)31, -0.5f),
    MEGA_TAIGA("mega taiga", (byte)32, 0.3f),
    MEGA_TAIGA_HILLS("mega taiga hills", (byte)33, 0.3f),
    EXTREME_HILLS_PLUS("extreme hills plus", (byte)34, 0.2f),
    SAVANNA("savanna", (byte)35, 1.2f),
    SAVANNA_PLATEAU("savanna plateau", (byte)36, 1f),
    MESA("mesa", (byte)37, 2f),
    MESA_PLATEAU_F("mesa plateau f", (byte)38, 2f),
    MESA_PLATEAU("mesa plateau", (byte)39, 2f),
    THE_VOID("the void", (byte)127, 0f),
    PLAINS_M("plains m", (byte)128, 0.5f),
    SUNFLOWER_PLAINS("sunflower plains", (byte)129, 0.8f),
    DESERT_M("desert m", (byte)130, 2f),
    EXTREME_HILLS_M("extreme hills m", (byte)131, 0.2f),
    FLOWER_FOREST("flower forest", (byte)132, 0.7f),
    TAIGA_M("taiga m", (byte)133, 0.05f),
    SWAMPLAND_M("swampland m", (byte)134, 0.8f),
    ICE_PLAINS_SPIKES("ice plains spikes", (byte)140, 0f),
    JUNGLE_M("jungle m", (byte)149, 1.2f),
    JUNGLE_EDGE_M("jungle edge m", (byte)151, 0.95f),
    BIRCH_FOREST_M("birch forest m", (byte)155, 0.6f),
    BIRCH_FOREST_HILLS_M("birch forest hills m", (byte)156, 0.6f),
    ROOFED_FOREST_M("roofed forest m", (byte)157, 0.7f),
    COLD_TAIGA_M("cold taiga m", (byte)158, -0.5f),
    MEGA_SPRUCE_TAIGA("mega spruce taiga", (byte)160, 0.3f),
    REDWOOD_TAIGA_HILLS_M("redwood taiga hills m", (byte)161, 0.3f),
    EXTREME_HILLS_PLUS_M("extreme hills plus m", (byte)162, 0.2f),
    SAVANNA_M("savanna m", (byte)163, 1.2f),
    SAVANNA_PLATEAU_M("savanna plateau m", (byte)164, 1f),
    MESA_BRYCE("mesa bryce", (byte)165, 2f),
    MESA_PLATEAU_F_M("mesa plateau f m", (byte)166, 2f),
    MESA_PLATEAU_M("mesa plateau m", (byte)167, 2f);

    public final String name;
    public final byte id;
    public final float temperature;

    private Biomes(String name, byte id, float temperature)
    {
        this.name = name;
        this.id = id;
        this.temperature = temperature;
    }

    private static Map<Byte, Biomes> biomes;

    static
    {

        biomes = new HashMap<Byte, Biomes>();

        add(OCEAN);
        add(PLAINS);
        add(DESERT);
        add(EXTREME_HILLS);
        add(FOREST);
        add(TAIGA);
        add(SWAMPLAND);
        add(RIVER);
        add(HELL);
        add(THE_END);
        add(FROZEN_OCEAN);
        add(FROZEN_RIVER);
        add(ICE_PLAINS);
        add(ICE_MOUNTAINS);
        add(MUSHROOM_ISLAND);
        add(MUSHROOM_ISLAND_SHORE);
        add(BEACH);
        add(DESERT_HILLS);
        add(FOREST_HILLS);
        add(TAIGA_HILLS);
        add(EXTREME_HILLS_EDGE);
        add(JUNGLE);
        add(JUNGLE_HILLS);
        add(JUNGLE_EDGE);
        add(DEEP_OCEAN);
        add(STONE_BEACH);
        add(COLD_BEACH);
        add(BIRCH_FOREST);
        add(BIRCH_FOREST_HILLS);
        add(ROOFED_FOREST);
        add(COLD_TAIGA);
        add(COLD_TAIGA_HILLS);
        add(MEGA_TAIGA);
        add(MEGA_TAIGA_HILLS);
        add(EXTREME_HILLS_PLUS);
        add(SAVANNA);
        add(SAVANNA_PLATEAU);
        add(MESA);
        add(MESA_PLATEAU_F);
        add(MESA_PLATEAU);
        add(THE_VOID);
        add(PLAINS_M);
        add(SUNFLOWER_PLAINS);
        add(DESERT_M);
        add(EXTREME_HILLS_M);
        add(FLOWER_FOREST);
        add(TAIGA_M);
        add(SWAMPLAND_M);
        add(ICE_PLAINS_SPIKES);
        add(JUNGLE_M);
        add(JUNGLE_EDGE_M);
        add(BIRCH_FOREST_M);
        add(BIRCH_FOREST_HILLS_M);
        add(ROOFED_FOREST_M);
        add(COLD_TAIGA_M);
        add(MEGA_SPRUCE_TAIGA);
        add(REDWOOD_TAIGA_HILLS_M);
        add(EXTREME_HILLS_PLUS_M);
        add(SAVANNA_M);
        add(SAVANNA_PLATEAU_M);
        add(MESA_BRYCE);
        add(MESA_PLATEAU_F_M);
        add(MESA_PLATEAU_M);

    }

    private static void add(Biomes biome)
    {
        biomes.put(biome.id, biome);
    }

    public static Biomes getBiome(int id)
    {
        return biomes.get(id);
    }

}
