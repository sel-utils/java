/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/entities.xml
 */
package sul;

import java.util.*;

public final class Entities {

	public final String name;
	public final boolean object;
	public final int minecraft, pocket;
	public final double width, height;

	private Entities(String name, boolean object, int minecraft, int pocket, double width, double height) {
		this.name = name;
		this.object = object;
		this.minecraft = minecraft;
		this.pocket = pocket;
		this.width = width;
		this.height = height;
	}

	public static final Entities BOAT = new Entities("boat", true, 1, 90, 1.5, 0.6);
	public static final Entities DROPPED_ITEM = new Entities("dropped item", true, 2, 64, 0.25, 0.25);
	public static final Entities AREA_EFFECT_CLOUD = new Entities("area effect cloud", true, 3, 95, 2, 0.5);
	public static final Entities MINECART = new Entities("minecart", true, 10, 84, 0.98, 0.7);
	public static final Entities MINECART_WITH_HOPPER = new Entities("minecart with hopper", true, -1, 96, 0.98, 0.7);
	public static final Entities MINECART_WITH_TNT = new Entities("minecart with tnt", true, -1, 97, 0.98, 0.7);
	public static final Entities MINECART_WITH_CHEST = new Entities("minecart with chest", true, -1, 98, 0.98, 0.7);
	public static final Entities ACTIVATED_TNT = new Entities("activated tnt", true, 50, 65, 0.98, 0.98);
	public static final Entities ENDER_CRYSTAL = new Entities("ender crystal", true, 51, 71, 2, 2);
	public static final Entities ARROW = new Entities("arrow", true, 60, 80, 0.5, 0.5);
	public static final Entities SNOWBALL = new Entities("snowball", true, 61, 81, 0.25, 0.25);
	public static final Entities EGG = new Entities("egg", true, 62, 82, 0.25, 0.25);
	public static final Entities GHAST_FIREBALL = new Entities("ghast fireball", true, 63, 85, 1, 1);
	public static final Entities BLAZE_FIREBALL = new Entities("blaze fireball", true, 64, 94, 0.3125, 0.3125);
	public static final Entities ENDERPEARL = new Entities("enderpearl", true, 65, 87, 0.25, 0.25);
	public static final Entities WITHER_SKULL = new Entities("wither skull", true, 66, 89, 0.3125, 0.3125);
	public static final Entities SHULKER_BULLET = new Entities("shulker bullet", true, 67, 76, 0.3125, 0.3125);
	public static final Entities LLAMA_SPIT = new Entities("llama spit", true, 68, -1, 0.25, 0.25);
	public static final Entities FALLING_BLOCK = new Entities("falling block", true, 70, 66, 0.98, 0.98);
	public static final Entities ITEM_FRAME = new Entities("item frame", true, 71, -1, Double.NaN, Double.NaN);
	public static final Entities EYE_OF_ENDER = new Entities("eye of ender", true, 72, 70, 0.25, 0.25);
	public static final Entities SPLASH_POTION = new Entities("splash potion", true, 73, 86, 0.25, 0.25);
	public static final Entities EXP_BOTTLE = new Entities("exp bottle", true, 75, 68, 0.25, 0.25);
	public static final Entities FIREWORK_ROCKET = new Entities("firework rocket", true, 76, -1, 0.25, 0.25);
	public static final Entities LEASH_KNOT = new Entities("leash knot", true, 77, 88, 0.375, 0.25);
	public static final Entities ARMOR_STAND = new Entities("armor stand", true, 78, -1, 0.5, 1.975);
	public static final Entities EVOCATION_FANGS = new Entities("evocation fangs", true, 79, -1, 0.5, 0.8);
	public static final Entities FISHING_HOOK = new Entities("fishing hook", true, -1, 77, 0.25, 0.25);
	public static final Entities SPECTRAL_ARROW = new Entities("spectral arrow", true, 91, -1, 0.5, 0.5);
	public static final Entities DRAGON_FIREBALL = new Entities("dragon fireball", true, 93, 79, 1, 1);
	public static final Entities CAMERA = new Entities("camera", true, -1, 62, Double.NaN, Double.NaN);
	public static final Entities ELDER_GUARDIAN = new Entities("elder guardian", false, 4, 50, 1.9975, 1.9975);
	public static final Entities WITHER_SKELETON = new Entities("wither skeleton", false, 5, 48, 0.7, 2.4);
	public static final Entities STRAY = new Entities("stray", false, 6, 46, 0.6, 1.99);
	public static final Entities HUSK = new Entities("husk", false, 23, 47, 0.6, 1.99);
	public static final Entities ZOMBIE_VILLAGER = new Entities("zombie villager", false, 27, 44, 0.6, 1.95);
	public static final Entities SKELETON_HORSE = new Entities("skeleton horse", false, 28, 26, 1.39648, 1.6);
	public static final Entities ZOMBIE_HORSE = new Entities("zombie horse", false, 29, 27, 1.39648, 1.6);
	public static final Entities DONKEY = new Entities("donkey", false, 31, 24, 1.39648, 1.6);
	public static final Entities MULE = new Entities("mule", false, 32, 25, 1.39648, 1.6);
	public static final Entities EVOCATION_ILLAGER = new Entities("evocation illager", false, 34, -1, 0.6, 1.95);
	public static final Entities VEX = new Entities("vex", false, 35, -1, 0.4, 0.8);
	public static final Entities VINDICATION_ILLAGER = new Entities("vindication illager", false, 36, -1, 0.6, 1.95);
	public static final Entities CREEPER = new Entities("creeper", false, 50, 33, 0.6, 1.7);
	public static final Entities SKELETON = new Entities("skeleton", false, -1, 34, 0.6, 1.99);
	public static final Entities SPIDER = new Entities("spider", false, 52, 35, 1.4, 0.9);
	public static final Entities GIANT = new Entities("giant", false, 53, -1, 3.6, 10.8);
	public static final Entities ZOMBIE = new Entities("zombie", false, 54, 32, 0.6, 1.95);
	public static final Entities SLIME = new Entities("slime", false, 55, 37, 0.51, 0.51);
	public static final Entities GHAST = new Entities("ghast", false, 56, 41, 4, 4);
	public static final Entities ENDERMAN = new Entities("enderman", false, 58, 38, 0.6, 2.9);
	public static final Entities CAVE_SPIDER = new Entities("cave spider", false, 59, 40, 0.7, 0.5);
	public static final Entities SILVERFISH = new Entities("silverfish", false, 60, 39, 0.4, 0.3);
	public static final Entities BLAZE = new Entities("blaze", false, 61, 43, 0.6, 1.8);
	public static final Entities MAGMA_CUBE = new Entities("magma cube", false, 62, 42, 0.51, 0.51);
	public static final Entities ENDER_DRAGON = new Entities("ender dragon", false, 63, 53, 16, 8);
	public static final Entities WITHER_BOSS = new Entities("wither boss", false, 64, 52, 0.9, 3.5);
	public static final Entities BAT = new Entities("bat", false, 65, 19, 0.5, 0.9);
	public static final Entities WITCH = new Entities("witch", false, 66, 45, 0.6, 1.95);
	public static final Entities ENDERMITE = new Entities("endermite", false, 67, 55, 0.4, 0.3);
	public static final Entities GUARDIAN = new Entities("guardian", false, 68, 49, 0.85, 0.85);
	public static final Entities SHULKER = new Entities("shulker", false, 69, 54, 1, 1);
	public static final Entities PIG = new Entities("pig", false, 90, 12, 0.9, 0.9);
	public static final Entities SHEEP = new Entities("sheep", false, 91, 13, 0.9, 1.3);
	public static final Entities COW = new Entities("cow", false, 92, 11, 0.9, 1.4);
	public static final Entities CHICKEN = new Entities("chicken", false, 93, 10, 0.4, 0.7);
	public static final Entities SQUID = new Entities("squid", false, 94, 17, 0.8, 0.8);
	public static final Entities WOLF = new Entities("wolf", false, 95, 14, 0.6, 0.85);
	public static final Entities MOOSHROOM = new Entities("mooshroom", false, 96, 16, 0.9, 1.4);
	public static final Entities SNOW_GOLEM = new Entities("snow golem", false, 97, 21, 0.7, 1.9);
	public static final Entities OCELOT = new Entities("ocelot", false, 98, 22, 0.6, 0.7);
	public static final Entities IRON_GOLEM = new Entities("iron golem", false, 99, 20, 1.4, 2.7);
	public static final Entities HORSE = new Entities("horse", false, 100, 23, 1.39648, 1.6);
	public static final Entities RABBIT = new Entities("rabbit", false, 101, 18, 0.4, 0.5);
	public static final Entities POLAR_BEAR = new Entities("polar bear", false, 102, 28, 1.3, 1.4);
	public static final Entities LLAMA = new Entities("llama", false, 103, -1, 0.9, 1.87);
	public static final Entities VILLAGER = new Entities("villager", false, 120, 15, 0.6, 1.95);
	public static final Entities NPC = new Entities("npc", false, -1, 51, 0.6, 1.95);

	private static Map<Integer, Entities> minecraftEntities, minecraftObjects, pocketEntities, pocketObjects;

	static {

		minecraftEntities = new HashMap<Integer, Entities>();
		minecraftObjects = new HashMap<Integer, Entities>();
		pocketEntities = new HashMap<Integer, Entities>();
		pocketObjects = new HashMap<Integer, Entities>();

		add(BOAT);
		add(DROPPED_ITEM);
		add(AREA_EFFECT_CLOUD);
		add(MINECART);
		add(MINECART_WITH_HOPPER);
		add(MINECART_WITH_TNT);
		add(MINECART_WITH_CHEST);
		add(ACTIVATED_TNT);
		add(ENDER_CRYSTAL);
		add(ARROW);
		add(SNOWBALL);
		add(EGG);
		add(GHAST_FIREBALL);
		add(BLAZE_FIREBALL);
		add(ENDERPEARL);
		add(WITHER_SKULL);
		add(SHULKER_BULLET);
		add(LLAMA_SPIT);
		add(FALLING_BLOCK);
		add(ITEM_FRAME);
		add(EYE_OF_ENDER);
		add(SPLASH_POTION);
		add(EXP_BOTTLE);
		add(FIREWORK_ROCKET);
		add(LEASH_KNOT);
		add(ARMOR_STAND);
		add(EVOCATION_FANGS);
		add(FISHING_HOOK);
		add(SPECTRAL_ARROW);
		add(DRAGON_FIREBALL);
		add(CAMERA);
		add(ELDER_GUARDIAN);
		add(WITHER_SKELETON);
		add(STRAY);
		add(HUSK);
		add(ZOMBIE_VILLAGER);
		add(SKELETON_HORSE);
		add(ZOMBIE_HORSE);
		add(DONKEY);
		add(MULE);
		add(EVOCATION_ILLAGER);
		add(VEX);
		add(VINDICATION_ILLAGER);
		add(CREEPER);
		add(SKELETON);
		add(SPIDER);
		add(GIANT);
		add(ZOMBIE);
		add(SLIME);
		add(GHAST);
		add(ENDERMAN);
		add(CAVE_SPIDER);
		add(SILVERFISH);
		add(BLAZE);
		add(MAGMA_CUBE);
		add(ENDER_DRAGON);
		add(WITHER_BOSS);
		add(BAT);
		add(WITCH);
		add(ENDERMITE);
		add(GUARDIAN);
		add(SHULKER);
		add(PIG);
		add(SHEEP);
		add(COW);
		add(CHICKEN);
		add(SQUID);
		add(WOLF);
		add(MOOSHROOM);
		add(SNOW_GOLEM);
		add(OCELOT);
		add(IRON_GOLEM);
		add(HORSE);
		add(RABBIT);
		add(POLAR_BEAR);
		add(LLAMA);
		add(VILLAGER);
		add(NPC);

	}

	private static void add(Entities entity) {
		if(entity.minecraft != -1) {
			if(entity.object) minecraftObjects.put(entity.minecraft, entity);
			if(!entity.object || !minecraftEntities.containsKey(entity.minecraft)) minecraftEntities.put(entity.minecraft, entity);
		}
		if(entity.pocket != -1) {
			if(entity.object) pocketObjects.put(entity.pocket, entity);
			if(!entity.object || !pocketEntities.containsKey(entity.pocket)) pocketEntities.put(entity.pocket, entity);
		}
	}

	public static Entities getMinecraftEntity(int id, boolean object) {
		if(object && minecraftObjects.containsKey(id)) return minecraftObjects.get(id);
		else return minecraftEntities.get(id);
	}

	public static Entities getMinecraftEntity(int id) {
		return getMinecraftEntity(id, false);
	}

	public static Entities getMinecraftObject(int id) {
		return getMinecraftEntity(id, true);
	}

	public static Entities getPocketEntity(int id, boolean object) {
		if(object && pocketObjects.containsKey(id)) return pocketObjects.get(id);
		else return pocketEntities.get(id);
	}

	public static Entities getPocketEntity(int id) {
		return getPocketEntity(id, false);
	}

	public static Entities getPocketObject(int id) {
		return getPocketEntity(id, true);
	}

}
