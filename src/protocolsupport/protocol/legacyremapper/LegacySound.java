package protocolsupport.protocol.legacyremapper;

import java.util.HashMap;

import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_9_R2.Block;
import net.minecraft.server.v1_9_R2.PacketPlayOutNamedSoundEffect;
import net.minecraft.server.v1_9_R2.SoundCategory;
import net.minecraft.server.v1_9_R2.SoundEffect;
import net.minecraft.server.v1_9_R2.SoundEffectType;

public class LegacySound {

	@SuppressWarnings("deprecation")
	public static void sendBlockBreakPlace(Player player, org.bukkit.block.Block block) {
		SoundEffectType blocksound = Block.getById(block.getType().getId()).w();
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutNamedSoundEffect(
			blocksound.e(), SoundCategory.BLOCKS,
			block.getX(), block.getY(), block.getZ(),
			(blocksound.a() + 1.0F) / 2.0F,
			blocksound.b() * 0.8F
		));
	}

	private static final HashMap<String, String> legacySounds = new HashMap<>();

	//return new sound if legacy not found, so launcher will print a warning with that new sound name
	public static String getSoundName(int soundType) {
		String newSound = SoundEffect.a.b(SoundEffect.a.getId(soundType)).a();
		String legacySound = legacySounds.get(newSound);
		return legacySound != null ? legacySound : newSound;
	}

	public static String getLegacySoundName(String soundName) {
		switch (soundName) {
			case "game.player.hurt.fall.big":
			case "game.neutral.hurt.fall.big":
			case "game.hostile.hurt.fall.big": {
				return "damage.fallbig";
			}
			case "game.player.hurt.fall.small":
			case "game.neutral.hurt.fall.small":
			case "game.hostile.hurt.fall.small": {
				return "damage.fallsmall";
			}
			case "game.player.hurt":
			case "game.player.die":
			case "game.neutral.hurt":
			case "game.neutral.die":
			case "game.hostile.hurt":
			case "game.hostile.die": {
				return "damage.hit";
			}
			case "game.player.swim":
			case "game.neutral.swim":
			case "game.hostile.swim": {
				return "liquid.swim";
			}
			case "game.player.swim.splash":
			case "game.neutral.swim.splash":
			case "game.hostile.swim.splash": {
				return "liquid.splash";
			}
			default: {
				return soundName;
			}
		}
	}

	private static void register(String newSound, String legacySound) {
		legacySounds.put(newSound, legacySound);
	}

	static {
		//sounds were autogenerated by comparing json files and weren't checked for correctness
		register("entity.zombie_horse.ambient", "mob.horse.zombie.idle");
		register("block.note.snare", "note.snare");
		register("block.wood_button.click_off", "random.wood_click");
		register("block.wood_button.click_on", "random.wood_click");
		register("block.gravel.break", "dig.gravel");
		register("block.gravel.place", "dig.gravel");
		register("entity.arrow.hit", "random.bowhit");
		register("block.tripwire.detach", "random.bowhit");
		register("entity.splash_potion.break", "dig.glass");
		register("block.glass.break", "dig.glass");
		register("entity.zombie.ambient", "mob.zombie.say");
		register("entity.zombie_villager.ambient", "mob.zombie.say");
		register("entity.pig.death", "mob.pig.death");
		register("entity.mule.hurt", "mob.horse.donkey.hit");
		register("entity.donkey.hurt", "mob.horse.donkey.hit");
		register("entity.generic.swim", "game.neutral.swim");
		register("entity.hostile.swim", "game.neutral.swim");
		register("entity.player.swim", "game.neutral.swim");
		register("entity.generic.swim", "game.player.swim");
		register("entity.hostile.swim", "game.player.swim");
		register("entity.player.swim", "game.player.swim");
		register("entity.endermen.ambient", "mob.endermen.idle");
		register("block.portal.ambient", "portal.portal");
		register("entity.generic.burn", "random.fizz");
		register("block.fire.extinguish", "random.fizz");
		register("block.redstone_torch.burnout", "random.fizz");
		register("block.lava.extinguish", "random.fizz");
		register("entity.generic.extinguish_fire", "random.fizz");
		register("block.note.harp", "note.harp");
		register("block.snow.hit", "step.snow");
		register("block.snow.fall", "step.snow");
		register("block.snow.step", "step.snow");
		register("entity.arrow.hit_player", "random.successful_hit");
		register("entity.zombie_pig.hurt", "mob.zombiepig.zpighurt");
		register("entity.wolf.howl", "mob.wolf.howl");
		register("entity.firework.launch", "fireworks.launch");
		register("entity.cow.hurt", "mob.cow.hurt");
		register("entity.cow.death", "mob.cow.hurt");
		register("entity.firework.large_blast", "fireworks.largeBlast");
		register("entity.blaze.hurt", "mob.blaze.hit");
		register("entity.villager.death", "mob.villager.death");
		register("entity.blaze.death", "mob.blaze.death");
		register("entity.zombie_horse.death", "mob.horse.zombie.death");
		register("entity.silverfish.death", "mob.silverfish.kill");
		register("entity.endermite.death", "mob.silverfish.kill");
		register("record.ward", "records.ward");
		register("entity.wolf.pant", "mob.wolf.panting");
		register("block.metal.break", "dig.stone");
		register("block.metal.place", "dig.stone");
		register("entity.armorstand.place", "dig.stone");
		register("block.stone.break", "dig.stone");
		register("block.stone.place", "dig.stone");
		register("block.anvil.break", "dig.stone");
		register("block.glass.place", "dig.stone");
		register("entity.endermen.stare", "mob.endermen.stare");
		register("entity.player.splash", "game.player.swim.splash");
		register("entity.hostile.splash", "game.player.swim.splash");
		register("entity.generic.splash", "game.player.swim.splash");
		register("entity.small_magmacube.hurt", "mob.slime.small");
		register("block.slime.fall", "mob.slime.small");
		register("entity.small_slime.death", "mob.slime.small");
		register("block.slime.step", "mob.slime.small");
		register("entity.small_magmacube.death", "mob.slime.small");
		register("entity.small_slime.hurt", "mob.slime.small");
		register("block.slime.hit", "mob.slime.small");
		register("music.nether", "music.game.nether");
		register("entity.ghast.death", "mob.ghast.death");
		register("entity.guardian.attack", "mob.guardian.attack");
		register("block.dispenser.fail", "random.click");
		register("block.comparator.click", "random.click");
		register("block.stone_button.click_on", "random.click");
		register("block.stone_button.click_off", "random.click");
		register("block.tripwire.click_on", "random.click");
		register("block.dispenser.dispense", "random.click");
		register("ui.button.click", "random.click");
		register("block.lever.click", "random.click");
		register("block.tripwire.attach", "random.click");
		register("block.stone_pressureplate.click_on", "random.click");
		register("block.wood_pressureplate.click_off", "random.click");
		register("block.stone_pressureplate.click_off", "random.click");
		register("block.metal_pressureplate.click_off", "random.click");
		register("block.tripwire.click_off", "random.click");
		register("block.metal_pressureplate.click_on", "random.click");
		register("block.wood_pressureplate.click_on", "random.click");
		register("entity.zombie_pig.ambient", "mob.zombiepig.zpig");
		register("entity.generic.death", "game.player.die");
		register("entity.hostile.hurt", "game.player.die");
		register("entity.player.hurt", "game.player.die");
		register("entity.hostile.death", "game.player.die");
		register("entity.generic.hurt", "game.player.die");
		register("entity.player.death", "game.player.die");
		register("music.dragon", "music.game.end.dragon");
		register("entity.firework.twinkle_far", "fireworks.twinkle_far");
		register("entity.elder_guardian.ambient_land", "mob.guardian.land.idle");
		register("entity.guardian.ambient_land", "mob.guardian.land.idle");
		register("block.grass.break", "dig.grass");
		register("block.grass.place", "dig.grass");
		register("entity.skeleton.step", "mob.skeleton.step");
		register("entity.wither.death", "mob.wither.death");
		register("entity.wolf.hurt", "mob.wolf.hurt");
		register("entity.pig.saddle", "mob.horse.leather");
		register("entity.horse.saddle", "mob.horse.leather");
		register("entity.bat.loop", "mob.bat.loop");
		register("entity.ghast.hurt", "mob.ghast.scream");
		register("entity.generic.death", "game.player.hurt");
		register("entity.hostile.hurt", "game.player.hurt");
		register("entity.player.hurt", "game.player.hurt");
		register("entity.hostile.death", "game.player.hurt");
		register("entity.generic.hurt", "game.player.hurt");
		register("entity.player.death", "game.player.hurt");
		register("entity.generic.death", "game.neutral.die");
		register("entity.hostile.hurt", "game.neutral.die");
		register("entity.player.hurt", "game.neutral.die");
		register("entity.hostile.death", "game.neutral.die");
		register("entity.generic.hurt", "game.neutral.die");
		register("entity.player.death", "game.neutral.die");
		register("entity.creeper.death", "mob.creeper.death");
		register("entity.horse.gallop", "mob.horse.gallop");
		register("entity.wither.spawn", "mob.wither.spawn");
		register("entity.endermen.hurt", "mob.endermen.hit");
		register("entity.creeper.hurt", "mob.creeper.say");
		register("entity.horse.step_wood", "mob.horse.wood");
		register("entity.rabbit.death", "mob.rabbit.death");
		register("entity.zombie_villager.converted", "mob.zombie.unfect");
		register("block.anvil.use", "random.anvil_use");
		register("block.enderchest.close", "random.chestclosed");
		register("entity.mooshroom.shear", "mob.sheep.shear");
		register("entity.sheep.shear", "mob.sheep.shear");
		register("entity.item.pickup", "random.pop");
		register("entity.bat.death", "mob.bat.death");
		register("block.wood.place", "dig.wood");
		register("block.wood.break", "dig.wood");
		register("block.ladder.place", "dig.wood");
		register("entity.armorstand.fall", "dig.wood");
		register("block.ladder.break", "dig.wood");
		register("record.chirp", "records.chirp");
		register("entity.mule.death", "mob.horse.donkey.death");
		register("entity.donkey.death", "mob.horse.donkey.death");
		register("entity.firework.blast", "fireworks.blast");
		register("entity.zombie_pig.angry", "mob.zombiepig.zpigangry");
		register("entity.generic.swim", "game.hostile.swim");
		register("entity.hostile.swim", "game.hostile.swim");
		register("entity.player.swim", "game.hostile.swim");
		register("entity.guardian.flop", "mob.guardian.flop");
		register("entity.villager.yes", "mob.villager.yes");
		register("entity.ghast.warn", "mob.ghast.charge");
		register("entity.tnt.primed", "creeper.primed");
		register("entity.creeper.primed", "creeper.primed");
		register("block.sand.place", "dig.sand");
		register("block.sand.break", "dig.sand");
		register("entity.chicken.ambient", "mob.chicken.say");
		register("record.13", "records.13");
		register("record.11", "records.11");
		register("entity.elder_guardian.death", "mob.guardian.elder.death");
		register("entity.firework.twinkle", "fireworks.twinkle");
		register("entity.skeleton_horse.death", "mob.horse.skeleton.death");
		register("weather.rain", "ambient.weather.rain");
		register("weather.rain.above", "ambient.weather.rain");
		register("block.portal.trigger", "portal.trigger");
		register("block.enderchest.open", "random.chestopen");
		register("entity.horse.land", "mob.horse.land");
		register("entity.endermite.step", "mob.silverfish.step");
		register("entity.silverfish.step", "mob.silverfish.step");
		register("entity.bat.takeoff", "mob.bat.takeoff");
		register("entity.villager.no", "mob.villager.no");
		register("entity.player.big_fall", "game.hostile.hurt.fall.big");
		register("entity.generic.big_fall", "game.hostile.hurt.fall.big");
		register("entity.hostile.big_fall", "game.hostile.hurt.fall.big");
		register("entity.irongolem.step", "mob.irongolem.walk");
		register("block.note.hat", "note.hat");
		register("entity.zombie.attack_iron_door", "mob.zombie.metal");
		register("entity.villager.trading", "mob.villager.haggle");
		register("item.firecharge.use", "mob.ghast.fireball");
		register("entity.ghast.shoot", "mob.ghast.fireball");
		register("entity.enderdragon.shoot", "mob.ghast.fireball");
		register("entity.blaze.shoot", "mob.ghast.fireball");
		register("music.credits", "music.game.end.credits");
		register("entity.irongolem.death", "mob.irongolem.death");
		register("entity.item.break", "random.break");
		register("item.shield.break", "random.break");
		register("record.mellohi", "records.mellohi");
		register("entity.zombie_villager.cure", "mob.zombie.remedy");
		register("entity.enderpearl.throw", "random.bow");
		register("block.dispenser.launch", "random.bow");
		register("entity.skeleton.shoot", "random.bow");
		register("entity.endereye.launch", "random.bow");
		register("entity.firework.shoot", "random.bow");
		register("entity.experience_bottle.throw", "random.bow");
		register("entity.snowman.shoot", "random.bow");
		register("entity.arrow.shoot", "random.bow");
		register("entity.egg.throw", "random.bow");
		register("entity.snowball.throw", "random.bow");
		register("entity.bobber.throw", "random.bow");
		register("entity.lingeringpotion.throw", "random.bow");
		register("entity.splash_potion.throw", "random.bow");
		register("entity.villager.ambient", "mob.villager.idle");
		register("block.cloth.hit", "step.cloth");
		register("block.cloth.step", "step.cloth");
		register("block.cloth.fall", "step.cloth");
		register("entity.silverfish.hurt", "mob.silverfish.hit");
		register("entity.endermite.hurt", "mob.silverfish.hit");
		register("music.game", "music.game");
		register("block.lava.ambient", "liquid.lava");
		register("entity.player.big_fall", "game.neutral.hurt.fall.big");
		register("entity.generic.big_fall", "game.neutral.hurt.fall.big");
		register("entity.hostile.big_fall", "game.neutral.hurt.fall.big");
		register("record.mall", "records.mall");
		register("entity.blaze.burn", "fire.fire");
		register("block.fire.ambient", "fire.fire");
		register("entity.zombie.attack_door_wood", "mob.zombie.wood");
		register("entity.chicken.step", "mob.chicken.step");
		register("record.stal", "records.stal");
		register("entity.elder_guardian.hurt_land", "mob.guardian.land.hit");
		register("entity.guardian.hurt_land", "mob.guardian.land.hit");
		register("entity.chicken.egg", "mob.chicken.plop");
		register("entity.donkey.chest", "mob.chicken.plop");
		register("entity.enderdragon.flap", "mob.enderdragon.wings");
		register("block.grass.step", "step.grass");
		register("block.grass.fall", "step.grass");
		register("block.grass.hit", "step.grass");
		register("entity.horse.breathe", "mob.horse.breathe");
		register("entity.player.big_fall", "game.player.hurt.fall.big");
		register("entity.generic.big_fall", "game.player.hurt.fall.big");
		register("entity.hostile.big_fall", "game.player.hurt.fall.big");
		register("entity.mule.ambient", "mob.horse.donkey.idle");
		register("entity.donkey.ambient", "mob.horse.donkey.idle");
		register("record.far", "records.far");
		register("entity.spider.step", "mob.spider.step");
		register("entity.generic.death", "game.neutral.hurt");
		register("entity.hostile.hurt", "game.neutral.hurt");
		register("entity.player.hurt", "game.neutral.hurt");
		register("entity.hostile.death", "game.neutral.hurt");
		register("entity.generic.hurt", "game.neutral.hurt");
		register("entity.player.death", "game.neutral.hurt");
		register("entity.cow.ambient", "mob.cow.say");
		register("entity.horse.jump", "mob.horse.jump");
		register("entity.horse.step", "mob.horse.soft");
		register("entity.player.splash", "game.neutral.swim.splash");
		register("entity.hostile.splash", "game.neutral.swim.splash");
		register("entity.generic.splash", "game.neutral.swim.splash");
		register("entity.guardian.hurt", "mob.guardian.hit");
		register("entity.enderdragon.death", "mob.enderdragon.end");
		register("entity.zombie_villager.step", "mob.zombie.step");
		register("entity.zombie.step", "mob.zombie.step");
		register("entity.enderdragon.ambient", "mob.enderdragon.growl");
		register("entity.enderdragon.growl", "mob.enderdragon.growl");
		register("entity.wolf.shake", "mob.wolf.shake");
		register("entity.endermen.death", "mob.endermen.death");
		register("block.anvil.place", "random.anvil_land");
		register("block.anvil.land", "random.anvil_land");
		register("entity.generic.death", "game.hostile.hurt");
		register("entity.hostile.hurt", "game.hostile.hurt");
		register("entity.player.hurt", "game.hostile.hurt");
		register("entity.hostile.death", "game.hostile.hurt");
		register("entity.generic.hurt", "game.hostile.hurt");
		register("entity.player.death", "game.hostile.hurt");
		register("entity.minecart.inside", "minecart.inside");
		register("entity.slime.squish", "mob.slime.big");
		register("entity.magmacube.hurt", "mob.slime.big");
		register("entity.magmacube.death", "mob.slime.big");
		register("block.slime.break", "mob.slime.big");
		register("block.slime.place", "mob.slime.big");
		register("entity.slime.jump", "mob.slime.big");
		register("entity.slime.hurt", "mob.slime.big");
		register("entity.slime.death", "mob.slime.big");
		register("block.water.ambient", "liquid.water");
		register("entity.pig.hurt", "mob.pig.say");
		register("entity.pig.ambient", "mob.pig.say");
		register("entity.wither.shoot", "mob.wither.shoot");
		register("record.blocks", "records.blocks");
		register("item.firecharge.use", "item.fireCharge.use");
		register("entity.ghast.shoot", "item.fireCharge.use");
		register("entity.enderdragon.shoot", "item.fireCharge.use");
		register("entity.blaze.shoot", "item.fireCharge.use");
		register("block.sand.hit", "step.sand");
		register("block.sand.step", "step.sand");
		register("block.sand.fall", "step.sand");
		register("music.creative", "music.game.creative");
		register("entity.irongolem.hurt", "mob.irongolem.hit");
		register("entity.horse.death", "mob.horse.death");
		register("entity.bat.hurt", "mob.bat.hurt");
		register("entity.ghast.scream", "mob.ghast.affectionate_scream");
		register("entity.elder_guardian.ambient", "mob.guardian.elder.idle");
		register("entity.zombie_pig.death", "mob.zombiepig.zpigdeath");
		register("entity.lightning.thunder", "ambient.weather.thunder");
		register("entity.minecart.riding", "minecart.base");
		register("block.ladder.step", "step.ladder");
		register("block.ladder.fall", "step.ladder");
		register("block.ladder.hit", "step.ladder");
		register("entity.donkey.angry", "mob.horse.donkey.angry");
		register("ambient.cave", "ambient.cave.cave");
		register("record.wait", "records.wait");
		register("entity.firework.blast_far", "fireworks.blast_far");
		register("entity.hostile.small_fall", "game.neutral.hurt.fall.small");
		register("entity.player.small_fall", "game.neutral.hurt.fall.small");
		register("entity.generic.small_fall", "game.neutral.hurt.fall.small");
		register("entity.player.splash", "game.hostile.swim.splash");
		register("entity.hostile.splash", "game.hostile.swim.splash");
		register("entity.generic.splash", "game.hostile.swim.splash");
		register("entity.generic.drink", "random.drink");
		register("music.menu", "music.menu");
		register("entity.generic.death", "game.hostile.die");
		register("entity.hostile.hurt", "game.hostile.die");
		register("entity.player.hurt", "game.hostile.die");
		register("entity.hostile.death", "game.hostile.die");
		register("entity.generic.hurt", "game.hostile.die");
		register("entity.player.death", "game.hostile.die");
		register("entity.cat.hiss", "mob.cat.hiss");
		register("block.note.basedrum", "note.bd");
		register("entity.spider.ambient", "mob.spider.say");
		register("entity.spider.hurt", "mob.spider.say");
		register("block.stone.fall", "step.stone");
		register("block.anvil.fall", "step.stone");
		register("block.metal.step", "step.stone");
		register("block.stone.hit", "step.stone");
		register("block.glass.fall", "step.stone");
		register("block.stone.step", "step.stone");
		register("block.anvil.step", "step.stone");
		register("block.metal.hit", "step.stone");
		register("block.glass.step", "step.stone");
		register("block.metal.fall", "step.stone");
		register("block.glass.hit", "step.stone");
		register("block.anvil.hit", "step.stone");
		register("entity.player.levelup", "random.levelup");
		register("block.lava.pop", "liquid.lavapop");
		register("entity.sheep.hurt", "mob.sheep.say");
		register("entity.sheep.death", "mob.sheep.say");
		register("entity.sheep.ambient", "mob.sheep.say");
		register("entity.skeleton.ambient", "mob.skeleton.say");
		register("entity.blaze.ambient", "mob.blaze.breathe");
		register("entity.bat.ambient", "mob.bat.idle");
		register("entity.magmacube.squish", "mob.magmacube.big");
		register("entity.horse.ambient", "mob.horse.idle");
		register("entity.hostile.small_fall", "game.hostile.hurt.fall.small");
		register("entity.player.small_fall", "game.hostile.hurt.fall.small");
		register("entity.generic.small_fall", "game.hostile.hurt.fall.small");
		register("entity.zombie_horse.hurt", "mob.horse.zombie.hit");
		register("entity.irongolem.attack", "mob.irongolem.throw");
		register("block.cloth.break", "dig.cloth");
		register("block.cloth.place", "dig.cloth");
		register("block.gravel.fall", "step.gravel");
		register("block.gravel.step", "step.gravel");
		register("block.gravel.hit", "step.gravel");
		register("entity.endermite.ambient", "mob.silverfish.say");
		register("entity.silverfish.ambient", "mob.silverfish.say");
		register("entity.cat.purr", "mob.cat.purr");
		register("entity.zombie.infect", "mob.zombie.infect");
		register("entity.generic.eat", "random.eat");
		register("entity.wolf.ambient", "mob.wolf.bark");
		register("entity.tnt.primed", "game.tnt.primed");
		register("entity.creeper.primed", "game.tnt.primed");
		register("entity.sheep.step", "mob.sheep.step");
		register("entity.zombie_villager.death", "mob.zombie.death");
		register("entity.zombie.death", "mob.zombie.death");
		register("entity.shulker.teleport", "mob.endermen.portal");
		register("item.chorus_fruit.teleport", "mob.endermen.portal");
		register("entity.endermen.teleport", "mob.endermen.portal");
		register("entity.horse.angry", "mob.horse.angry");
		register("entity.wolf.growl", "mob.wolf.growl");
		register("block.snow.break", "dig.snow");
		register("block.snow.place", "dig.snow");
		register("block.piston.extend", "tile.piston.out");
		register("entity.player.burp", "random.burp");
		register("entity.cow.step", "mob.cow.step");
		register("entity.wither.hurt", "mob.wither.hurt");
		register("entity.guardian.death_land", "mob.guardian.land.death");
		register("entity.elder_guardian.death_land", "mob.guardian.land.death");
		register("music.end", "music.game.end");
		register("entity.chicken.hurt", "mob.chicken.hurt");
		register("entity.chicken.death", "mob.chicken.hurt");
		register("entity.wolf.step", "mob.wolf.step");
		register("entity.wolf.death", "mob.wolf.death");
		register("entity.wolf.whine", "mob.wolf.whine");
		register("block.note.pling", "note.pling");
		register("entity.hostile.small_fall", "game.player.hurt.fall.small");
		register("entity.player.small_fall", "game.player.hurt.fall.small");
		register("entity.generic.small_fall", "game.player.hurt.fall.small");
		register("entity.rabbit.hurt", "mob.rabbit.hurt");
		register("entity.cat.purreow", "mob.cat.purreow");
		register("entity.firework.large_blast_far", "fireworks.largeBlast_far");
		register("entity.skeleton.hurt", "mob.skeleton.hurt");
		register("entity.spider.death", "mob.spider.death");
		register("block.anvil.destroy", "random.anvil_break");
		register("record.cat", "records.cat");
		register("entity.wither.ambient", "mob.wither.idle");
		register("entity.elder_guardian.hurt", "mob.guardian.elder.hit");
		register("entity.endermen.scream", "mob.endermen.scream");
		register("entity.cat.death", "mob.cat.hitt");
		register("entity.cat.hurt", "mob.cat.hitt");
		register("entity.small_magmacube.squish", "mob.magmacube.small");
		register("item.flintandsteel.use", "fire.ignite");
		register("entity.enderdragon.hurt", "mob.enderdragon.hit");
		register("entity.zombie.hurt", "mob.zombie.hurt");
		register("entity.zombie_villager.hurt", "mob.zombie.hurt");
		register("entity.enderdragon_fireball.explode", "random.explode");
		register("entity.generic.explode", "random.explode");
		register("entity.lightning.impact", "random.explode");
		register("block.end_gateway.spawn", "random.explode");
		register("entity.slime.attack", "mob.slime.attack");
		register("entity.magmacube.jump", "mob.magmacube.jump");
		register("entity.bobber.splash", "random.splash");
		register("entity.skeleton_horse.hurt", "mob.horse.skeleton.hit");
		register("entity.rabbit.jump", "mob.rabbit.hop");
		register("entity.ghast.ambient", "mob.ghast.moan");
		register("entity.elder_guardian.curse", "mob.guardian.curse");
		register("entity.splash_potion.break", "game.potion.smash");
		register("block.glass.break", "game.potion.smash");
		register("block.note.bass", "note.bassattack");
		register("block.dispenser.fail", "gui.button.press");
		register("block.comparator.click", "gui.button.press");
		register("block.stone_button.click_on", "gui.button.press");
		register("block.stone_button.click_off", "gui.button.press");
		register("block.tripwire.click_on", "gui.button.press");
		register("block.dispenser.dispense", "gui.button.press");
		register("ui.button.click", "gui.button.press");
		register("block.lever.click", "gui.button.press");
		register("block.tripwire.attach", "gui.button.press");
		register("block.stone_pressureplate.click_on", "gui.button.press");
		register("block.wood_pressureplate.click_off", "gui.button.press");
		register("block.stone_pressureplate.click_off", "gui.button.press");
		register("block.metal_pressureplate.click_off", "gui.button.press");
		register("block.tripwire.click_off", "gui.button.press");
		register("block.metal_pressureplate.click_on", "gui.button.press");
		register("block.wood_pressureplate.click_on", "gui.button.press");
		register("entity.experience_orb.touch", "random.orb");
		register("entity.experience_orb.pickup", "random.orb");
		register("entity.wither.break_block", "mob.zombie.woodbreak");
		register("entity.zombie.break_door_wood", "mob.zombie.woodbreak");
		register("entity.horse.armor", "mob.horse.armor");
		register("entity.rabbit.ambient", "mob.rabbit.idle");
		register("block.piston.contract", "tile.piston.in");
		register("entity.cat.ambient", "mob.cat.meow");
		register("entity.pig.step", "mob.pig.step");
		register("record.strad", "records.strad");
		register("block.wood.hit", "step.wood");
		register("block.wood.fall", "step.wood");
		register("block.wood.step", "step.wood");
		register("block.portal.travel", "portal.travel");
		register("entity.guardian.death", "mob.guardian.death");
		register("entity.skeleton.death", "mob.skeleton.death");
		register("entity.horse.hurt", "mob.horse.hit");
		register("entity.villager.hurt", "mob.villager.hit");
		register("entity.skeleton_horse.ambient", "mob.horse.skeleton.idle");
		//manually mapped sounds
		register("block.chest.open", "random.chestopen");
		register("block.chest.close", "random.chestclosed");
	}

}
