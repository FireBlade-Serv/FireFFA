package eu.fireblade.fireffa.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Kits {
	
	public static ArrayList<String> LoreCreator(String a, String b){
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(a);
		lore.add(b);
		
		return lore;
	}
	
	public static ItemStack ItemGen(Material m, String n, ArrayList<String> lore,  int nombre) {
		ItemStack item = new ItemStack(m, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		
		if(lore != null){
			itemM.setLore(lore);
		}
		
		itemM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_POTION_EFFECTS);
		
		item.setItemMeta(itemM);
		
		return item;
		
		
    }
		
	public static ItemStack ItemGen1(Material m, Enchantment ench, int level, String n, ArrayList<String> lore, int nombre) {
		ItemStack item = new ItemStack(m, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		
		if(lore != null){
			itemM.setLore(lore);
		}
		
		itemM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_POTION_EFFECTS);
		
		itemM.addEnchant(ench, level, true);
		item.setItemMeta(itemM);
		
		return item;
	}
	
	public static ItemStack ItemGen2(Material m, Enchantment ench, int level, Enchantment ench2, int level2, String n, ArrayList<String> lore, int nombre) {
		ItemStack item = new ItemStack(m, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		
		if(lore != null){
			itemM.setLore(lore);
		}
		
		itemM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_POTION_EFFECTS);
		
		itemM.addEnchant(ench, level, true);
		itemM.addEnchant(ench2, level2, true);
		item.setItemMeta(itemM);
		
		return item;
	}
	
	public static ItemStack ItemGen3(Material m, Enchantment ench, int level, Enchantment ench2, int level2, Enchantment ench3,

		int level3, String n, ArrayList<String> lore, int nombre) {
		ItemStack item = new ItemStack(m, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		
		if(lore != null){
			itemM.setLore(lore);
		}
		
		itemM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_POTION_EFFECTS);
		
		itemM.addEnchant(ench, level, true);
		itemM.addEnchant(ench2, level2, true);
		itemM.addEnchant(ench3, level3, true);
		item.setItemMeta(itemM);
		
		return item;
	}
	
	public static ItemStack ItemGenColorLeather(Material leatherPiece, String n, int nombre, int red, int green, int blue) {
		ItemStack item = new ItemStack(leatherPiece);
		  LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		  meta.setDisplayName(n);
		  meta.setColor(Color.fromBGR(blue, green, red));
		  meta.spigot().setUnbreakable(true);
		  item.setItemMeta(meta);
		  return item;
	}
	
	public static ItemStack ItemGen2ColorLeather(Material leatherPiece, Enchantment ench, int level ,String n, int nombre, int red, int green, int blue) {
		ItemStack item = new ItemStack(leatherPiece);
		  LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		  meta.setDisplayName(n);
		  meta.setColor(Color.fromBGR(blue, green, red));
		  meta.addEnchant(ench, level, true);
		  meta.spigot().setUnbreakable(true);
		  item.setItemMeta(meta);
		  return item;
	}
	
	public static ItemStack Bouf(Material m, int nombre) {
		ItemStack item = new ItemStack(m, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(ChatColor.BLUE+"Nourriture");
		item.setItemMeta(itemM);
		return item;		
	}
	
	public static ItemStack generatePotItem(PotionType pt, int level, String name, boolean splash) {
		Potion pot = new Potion(pt, level);
		pot.setSplash(splash);
		ItemStack potion = pot.toItemStack(1);
		ItemMeta meta = potion.getItemMeta();
		meta.setDisplayName(name);
		potion.setItemMeta(meta);
		
		return potion;
	}
	
	public static ItemStack generateSkull(String name, String owner){
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(owner);
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		
		return item;
	}
	
	// FAIT
	public static void kitDemolisseur(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_RED+"Chapeau du démolisseur", 1, 89, 38, 38));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_RED+"Tunique du démolisseur", 1, 89, 38, 38));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_RED+"Pantalon du démolisseur", 1, 89, 38, 38));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_RED+"Bottes du démolisseur", 1, 89, 38, 38));
		p.getInventory().setItem(0, ItemGen2(Material.IRON_AXE, Enchantment.DAMAGE_ALL, 1, Enchantment.KNOCKBACK, 2, ChatColor.DARK_RED+"Hache de guerre", LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une boule de feu"), 1)); 
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.getInventory().setItem(1, ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 16));
	}
	// FAIT
	public static void kitFantome(Player p) {
		Clear(p);
		
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, ChatColor.GRAY+"Épée du fantôme", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 5, ChatColor.GRAY+"Bâton du châtiment", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.BLAZE_ROD, ChatColor.GRAY+"Warp stick",LoreCreator(ChatColor.BLUE+"Clique droit - Téléporte", ChatColor.BLUE+"Utilisable toute les minutes"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
	}
	// FAIT
	public static void kitTank(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen1(Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 4, ChatColor.GOLD+"Casque du tank", null, 1));
		p.getInventory().setChestplate(ItemGen1(Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_FIRE, 4, ChatColor.GOLD+"Plastron du tank", null, 1));
		p.getInventory().setLeggings(ItemGen1(Material.GOLD_LEGGINGS, Enchantment.PROTECTION_FIRE, 4, ChatColor.GOLD+"Jambiéres du tank", null, 1));
		p.getInventory().setBoots(ItemGen1(Material.GOLD_BOOTS, Enchantment.PROTECTION_FIRE, 4, ChatColor.GOLD+"Bottes du tank", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.WOOD_SWORD, Enchantment.KNOCKBACK, 4, ChatColor.GOLD+"Épée du tank", null, 1));
		p.getInventory().setItem(1, generatePotItem(PotionType.INSTANT_HEAL, 2, ChatColor.GOLD+"Potion curative du tank", true));
		p.getInventory().setItem(2, generatePotItem(PotionType.INSTANT_HEAL, 2, ChatColor.GOLD+"Potion curative du tank", true));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0));
	}
	// FAIT
	public static void kitFlic (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_BLUE+"Chapeau du flic", 1, 76, 127, 153));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_BLUE+"Tunique du flic", 1, 51, 76, 178));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_BLUE+"Pantalon du flic", 1, 51, 76, 178));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_BLUE+"Bottes du flic", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 3, ChatColor.DARK_BLUE+"Matraque", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.FLINT_AND_STEEL, ChatColor.DARK_BLUE+"Flingue",LoreCreator(ChatColor.BLUE+"Clique droit - Tire une balle", ChatColor.BLUE+"Consomme une munition"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.getInventory().setItem(2, ItemGen(Material.SNOW_BALL, ChatColor.DARK_BLUE+"Munition", null, 12));
	}
	// FAIT
	public static void kitMagicien (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.DIAMOND_HELMET, ChatColor.BLUE+"Casque du magicien", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLUE+"Tunique du magicien", 1, 51, 76, 178));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.BLUE+"Pantalon du magicien", 1, 51, 76, 178));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLUE+"Bottes du magicien", 1, 153, 51, 51));
		p.getInventory().setItem(0, ItemGen2(Material.STICK, Enchantment.KNOCKBACK, 3, Enchantment.DAMAGE_ALL, 2, ChatColor.BLUE+"Baguette magique", LoreCreator(ChatColor.BLUE+"Clique droit - Ralentit et aveugle", ChatColor.BLUE+"Consomme une poudre magique"), 1));
		p.getInventory().setItem(1, ItemGen(Material.BLAZE_POWDER, ChatColor.BLUE+"Poudre magique", null, 3));
		p.getInventory().setItem(2, generatePotItem(PotionType.REGEN, 2, ChatColor.BLUE+"Potion régéneratrice du magicien", true));
		p.getInventory().setItem(3, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLUE+"Potion déstructrice du magicien", true));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitChevalier (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.GRAY+"Chapeau du chevalier", 1, 153, 153, 153));
		p.getInventory().setChestplate(ItemGen(Material.CHAINMAIL_CHESTPLATE, ChatColor.GRAY+"Cotte de maille du chevalier", null, 1));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GRAY+"Pantalon du chevalier", 1, 153, 153, 153));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.GRAY+"Bottes du chevalier", 1, 153, 153, 153));
		p.getInventory().setItem(0, ItemGen1(Material.STONE_SWORD, Enchantment.KNOCKBACK, 0-2, ChatColor.GRAY+"Épée du Chevalier", null, 1));
		p.getInventory().setItem(1, generatePotItem(PotionType.INSTANT_HEAL, 2, ChatColor.GRAY+"Potion curative du chevalier", false));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitCactus (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen1(Material.CACTUS, Enchantment.THORNS, 4, ChatColor.GREEN+"Chapeau du cactus",null, 1));
		p.getInventory().setChestplate(ItemGen2ColorLeather(Material.LEATHER_CHESTPLATE, Enchantment.THORNS, 4, ChatColor.GREEN+"Tunique du cactus", 1, 127, 204, 25));
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.THORNS, 4, ChatColor.GREEN+"Pantalon du cactus", 1, 127, 204, 25));
		p.getInventory().setBoots(ItemGen2ColorLeather(Material.LEATHER_BOOTS, Enchantment.THORNS, 4, ChatColor.GREEN+"Bottes du cactus", 1, 127, 204, 25));
		p.getInventory().setItem(0, ItemGen1(Material.FLINT, Enchantment.DAMAGE_ALL, 1, ChatColor.GREEN+"Épine", null,1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
	}
	// FAIT
	public static void kitPiaf (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.GRAY+"Chapeau du piaf", 1, 216, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.GRAY+"Tunique du piaf", 1, 127, 204, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GRAY+"Pantalon du piaf", 1, 153, 51, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.GRAY+"Bottes du piaf", 1, 229, 229, 51));
		p.getInventory().setItem(0, ItemGen1(Material.SUGAR, Enchantment.DAMAGE_ALL, 4, ChatColor.GRAY+"Fiente", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.FEATHER, ChatColor.GRAY+"Vol",LoreCreator(ChatColor.BLUE+"Clique droit - Propulse en hauteur", ChatColor.BLUE+"Utilisable 25 fois"), 25));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}
	// manque abilité
	public static void kitVoleurdame (Player p) {
		Clear(p);
		
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
		ItemMeta skullM = skull.getItemMeta();
		skullM.setDisplayName(ChatColor.BLACK+"Crâne du voleur d'âme");
		skullM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		skull.setItemMeta(skullM);	
		
		p.getInventory().setHelmet(skull);
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLACK+"Tunique du voleur d'âme", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGen(Material.CHAINMAIL_LEGGINGS, ChatColor.BLACK+"Jambiére de maile du voleur d'âme", null, 1));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLACK+"Bottes du voleur d'âme", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen(Material.STONE_SWORD, ChatColor.BLACK+"Épée du voleur d'âme",LoreCreator(ChatColor.BLUE+"Clique droit - Vole une âme (1,5 coeurs)", ChatColor.BLUE+"45 secondes de récupération"), 1));
		p.getInventory().setItem(1, ItemGen(Material.REDSTONE, ChatColor.BLACK+"Puit de sang",LoreCreator(ChatColor.BLUE+"Clique droit - Utilise les âmes accumulées pour se régénerer", ChatColor.BLUE+"Consomme le puit de sang (Expérience)"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitOITCman (Player p) {
		Clear(p);
		
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_DAMAGE, 999, ChatColor.RED+"OITC bow", LoreCreator(ChatColor.BLUE+"Les fléches tuent à l'impacte", ChatColor.BLUE+"Consomme une fléche si la cible est ratée"), 1));
		p.getInventory().setItem(2, ItemGen(Material.ARROW, ChatColor.RED+"OITC arrow", null, 3));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 2, ChatColor.RED+"OITC sword", null, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitLapin (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.WHITE+"Chapeau du lapin", 1, 255, 255, 255));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.WHITE+"Tunique du lapin", 1, 255, 255, 255));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.WHITE+"Pantalon du lapin", 1, 255, 255, 255));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.WHITE+"Bottes du lapin", 1, 255, 255, 255));
		p.getInventory().setItem(0, ItemGen1(Material.CARROT_ITEM, Enchantment.KNOCKBACK, 4, ChatColor.WHITE+"Carotte du lapin", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.GOLDEN_CARROT, Enchantment.DAMAGE_ALL, 4, ChatColor.WHITE+"Carotte magique du lapin", null, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 6));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitRusse(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_GREEN+"Chapeau du russe", 1, 102, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GREEN+"Tunique du russe", 1, 63, 76, 38));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_GREEN+"Pantalon du russe", 1, 63, 76, 38));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_GREEN+"Bottes du russe", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, ChatColor.DARK_GREEN+"Épée de combat", null, 1));
		
		ItemStack Potion = new ItemStack(Material.POTION, 1);
		PotionMeta PotionMeta = (PotionMeta) Potion.getItemMeta();
		PotionMeta.setDisplayName(ChatColor.BLUE+"Vodka");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE+"Nausée I");
		lore.add(ChatColor.BLUE+"Vitesse I");
		lore.add(ChatColor.BLUE+"1 minute");
		PotionMeta.setLore(lore);
		PotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 20*60, 0), true);
		PotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*60, 0), true);
		Potion.setItemMeta(PotionMeta);

		p.getInventory().setItem(1, Potion);
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitGrampa(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.GOLD_HELMET, ChatColor.DARK_GRAY+"Casque du grampa", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GRAY+"Tunique du grampa", 1, 254, 254, 254));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_GRAY+"Pantalon du grampa", 1, 229, 229, 51));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.DARK_GRAY+"Bottes du grampa", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.INK_SACK, Enchantment.DAMAGE_ALL, 4, ChatColor.DARK_GRAY+"Dentier", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 10, ChatColor.DARK_GRAY+"Canne", null, 1));
		ItemStack charcoal = new ItemStack(Material.COAL, 1, (byte) 0);
		ItemMeta charcoalM = charcoal.getItemMeta();
		charcoalM.setDisplayName(ChatColor.DARK_GRAY+"Pruneau");
		charcoalM.setLore(LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs", ChatColor.BLUE+"Récupération 1 minute 30"));
		charcoal.setItemMeta(charcoalM);
		p.getInventory().setItem(2, charcoal);
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitMineur(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.YELLOW+"Chapeau du mineur", 1, 229, 229, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.YELLOW+"Tunique du mineur", 1, 76, 127, 153));
		p.getInventory().setLeggings(ItemGen(Material.LEATHER_LEGGINGS, ChatColor.YELLOW+"Pantalon du mineur", null, 1));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.YELLOW+"Bottes du mineur", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen2(Material.STONE_PICKAXE, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 1, ChatColor.YELLOW+"Pioche du mineur", null ,1));
		p.getInventory().setItem(1, ItemGen1(Material.IRON_INGOT, Enchantment.DAMAGE_ALL, 3, ChatColor.YELLOW+"Lingot de la mort", null, 1));
		p.getInventory().setItem(2, ItemGen1(Material.COAL, Enchantment.FIRE_ASPECT, 1, ChatColor.YELLOW+"Charbon du mineur", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitJihadist (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_RED+"Chapeau du jihadist", 1, 213, 209, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_RED+"Tunique du jihadist", 1, 121, 104, 63));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_RED+"Pantalon du jihadist", 1, 121, 104, 63 ));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_RED+"Bottes du jihadist", 1, 216, 127, 51));
		p.getInventory().setItem(0, ItemGen1(Material.BOW, Enchantment.ARROW_FIRE, 1, ChatColor.DARK_RED+"Kalachnikov", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.ARROW, ChatColor.DARK_RED+"Munitions", null, 32));
		p.getInventory().setItem(1, ItemGen(Material.REDSTONE, ChatColor.DARK_RED+"Allah akbar",LoreCreator(ChatColor.BLUE+"Clique droit - Se faire exploser", ChatColor.BLUE+"Vous tue instantanément"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitGamer (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.GREEN+"Chapeau du gamer", 1, 127, 204, 25));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.GREEN+"Tunique du gamer", 1, 127, 204, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GREEN+"Pantalon du gamer", 1, 127, 204, 25 ));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.GREEN+"Bottes du gamer", 1, 127, 204, 25));
		p.getInventory().setItem(0, ItemGen2(Material.WOOD_SWORD, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 8, ChatColor.GREEN+"Épée du hero", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.RED_MUSHROOM, ChatColor.GREEN+"Super champignon",LoreCreator(ChatColor.BLUE+"Clique droit - Force 1, 3 secondes", ChatColor.BLUE+"Récupération 30 secondes"), 1));
		p.getInventory().setItem(2, ItemGen(Material.RABBIT_FOOT, ChatColor.GREEN+"Super jump",LoreCreator(ChatColor.BLUE+"Clique droit - Saute à une hauteur de 5 blocs", ChatColor.BLUE+"Récupération 15 secondes"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitSauvage (Player p) {
		Clear(p);
		
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 5, ChatColor.DARK_PURPLE+"Pantalon du sauvage", 1, 102, 127, 51));
		p.getInventory().setItem(0, ItemGen1(Material.FISHING_ROD, Enchantment.DAMAGE_ALL, 4, ChatColor.DARK_PURPLE+"Massue", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.GRILLED_PORK, ChatColor.DARK_PURPLE+"Nourriture charnue", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 3 coeurs", ChatColor.BLUE+"1 utilisation"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitArcherelementaire (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.GREEN+"Chapeau de l'archer élémentaire", 1, 102, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.GREEN+"Tunique de l'archer élémentaire", 1, 102, 127, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GREEN+"Pantalon de l'archer élémentaire", 1, 102, 127, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.GREEN+"Bottes de l'archer élémentaire", 1, 102, 127, 51));
		p.getInventory().setItem(3, ItemGen(Material.ARROW, ChatColor.GREEN+"Fléche de l'arche élémentaire", null, 32));
		p.getInventory().setItem(0, ItemGen1(Material.BOW, Enchantment.ARROW_KNOCKBACK, 5, ChatColor.GREEN+"Arc des adieux", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_FIRE, 1, ChatColor.GREEN+"Arc de feu", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.BOW, ChatColor.GREEN+"Arc de glace", LoreCreator(ChatColor.BLUE+"Ses fléches ralentissent et aveugles", ChatColor.BLUE+"Pendant 2 secondes"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));		
	}
	// FAIT
	public static void kitOcelot (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.YELLOW+"Chapeau de l'ocelot", 1, 229, 229, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.YELLOW+"Tunique de l'ocelot", 1, 229, 229, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.YELLOW+"Pantalon de l'ocelot", 1, 229, 229, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.YELLOW+"Bottes de l'ocelot", 1, 229, 229, 51));
		p.getInventory().setItem(0, ItemGen2(Material.RAW_FISH, Enchantment.DAMAGE_ALL, 3, Enchantment.KNOCKBACK, 6, ChatColor.YELLOW+"Coup de poisson", null, 1));
		ItemStack bonemeal = new ItemStack(Material.INK_SACK, 1, (short)15);
		ItemMeta bonemealM = bonemeal.getItemMeta();
		bonemealM.setDisplayName(ChatColor.YELLOW+"Pelote de laine");
		bonemealM.setLore(LoreCreator(ChatColor.BLUE+"Clique droit - Vitesse 2 pendant 5 secondes", ChatColor.BLUE+"Consomme 1 ficelle de pelote de laine, 10 secondes de récupération"));
		bonemeal.setItemMeta(bonemealM);
		p.getInventory().setItem(1, bonemeal);
		p.getInventory().setItem(2, ItemGen(Material.STRING, ChatColor.YELLOW+"Ficelle de pelote laine", null, 3));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));			
	}
	// FAIT
	public static void kitArchervagabon (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_GREEN+"Chapeau de l'archer vagabon", 1, 63, 76, 38));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GREEN+"Tunique de l'archer vagabon", 1, 63, 76, 38));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_GREEN+"Pantalon de l'archer vagabon", 1, 63, 76, 38));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_GREEN+"Bottes de l'archer vagabon", 1, 63, 76, 38));
		p.getInventory().setItem(0, ItemGen1(Material.BOW, Enchantment.ARROW_KNOCKBACK, 10, ChatColor.DARK_GREEN+"Arc de la mort", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.BOW, ChatColor.DARK_GREEN+"Arc de l'archer vagabon", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.ARROW, ChatColor.DARK_GREEN+"Fléche de l'archer vagabon", null, 32));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitArcherelite (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_GREEN+"Chapeau de l'archer d'élite", 1, 114, 113, 57));
		p.getInventory().setItem(0, ItemGen1(Material.BOW, Enchantment.ARROW_INFINITE, 1, ChatColor.DARK_GREEN+"Arc mitrailleur", LoreCreator(ChatColor.BLUE+"N'a pas besoin d'être chargé", ChatColor.BLUE+"Pas de limite d'utilisation"), 1));
		p.getInventory().setItem(1, ItemGen(Material.ARROW, ChatColor.RED+"Fléche de l'archer élite", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// A MODIF
	public static void kitAssassin (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.BLACK+"Chapeau de l'assassin", 1, 25, 25, 25));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLACK+"Tunique de l'assassin", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.BLACK+"Pantalon de l'assassin", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLACK+"Bottes de l'assassin", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.WOOD_SWORD, Enchantment.KNOCKBACK, -10, ChatColor.BLACK+"Dague",null ,1));
		p.getInventory().setItem(1, ItemGen1(Material.SHEARS, Enchantment.DAMAGE_ALL, 4, ChatColor.BLACK+"Couteau de l'égorgeur", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitPanda (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.WHITE+"Chapeau du panda", 1, 255, 255, 255));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.WHITE+"Tunique du panda", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.WHITE+"Pantalon du panda", 1, 255, 255, 255));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.WHITE+"Bottes du panda", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen2(Material.SUGAR_CANE, Enchantment.DAMAGE_ALL, 3, Enchantment.KNOCKBACK, 1, ChatColor.WHITE+"Bamboo", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.CLAY_BALL, ChatColor.WHITE+"Charge au sol", LoreCreator(ChatColor.BLUE+"Clique droit - Petite explosion", ChatColor.BLUE+"30 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitInformaticien (Player p) {
		Clear(p);
		
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.GRAY+"Tunique de l'informaticien", 1, 102, 153, 216));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GRAY+"Pantalon de l'informaticien", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.GRAY+"Bottes de l'informaticien", null, 1));
		p.getInventory().setItem(0, ItemGen2(Material.CAULDRON_ITEM, Enchantment.DAMAGE_ALL, 4, Enchantment.KNOCKBACK, 1, ChatColor.GRAY+"Tour de pc", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.WOOD_HOE, Enchantment.KNOCKBACK, 5, ChatColor.GRAY+"Tournevis", null, 1));
		p.getInventory().setItem(2, ItemGen1(Material.POWERED_RAIL, Enchantment.FIRE_ASPECT, 2, ChatColor.GRAY+"Carte graphique (AMD)", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitProgrammeur (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_PURPLE+"Chapeau du programmeur", 1, 102, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_PURPLE+"Tunique du programmeur", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_PURPLE+"Pantalon du programmeur", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_PURPLE+"Bottes du programmeur", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.NETHER_BRICK_ITEM, Enchantment.DAMAGE_ALL, 4, ChatColor.DARK_PURPLE+"Command prompt: DAMAGE", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.CLAY_BRICK, Enchantment.KNOCKBACK, 10, ChatColor.DARK_PURPLE+"Command prompt: KICK", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.IRON_INGOT, ChatColor.DARK_PURPLE+"Command prompt: BLIND", LoreCreator(ChatColor.BLUE+"Clique droit - Aveugle", ChatColor.BLUE+"5 secondes de récupération"), 1));
		p.getInventory().setItem(3, ItemGen1(Material.GOLD_INGOT, Enchantment.FIRE_ASPECT, 2, ChatColor.DARK_PURPLE+"Command prompt: FLAME", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitPatissier (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.LIGHT_PURPLE+"Chapeau du patissier", 1, 102, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.LIGHT_PURPLE+"Tunique du patissier", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.LIGHT_PURPLE+"Pantalon du patissier", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.LIGHT_PURPLE+"Bottes du patissier", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.PUMPKIN_PIE, Enchantment.DAMAGE_ALL, 2, ChatColor.LIGHT_PURPLE+"Tarte aux épines", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.CAKE, Enchantment.KNOCKBACK, 4, ChatColor.LIGHT_PURPLE+"Gâteau dans ta face", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.COOKIE, ChatColor.LIGHT_PURPLE+"Cookie du patisser", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs + vitesse 2, 15 secondes", ChatColor.BLUE+"30 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}	
	// FAIT
	public static void kitOurs (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.LEATHER_HELMET, ChatColor.DARK_GRAY+"Chapeau de l'ours", null, 1));
		p.getInventory().setChestplate(ItemGen(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GRAY+"Tunique de l'ours", null, 1));
		p.getInventory().setLeggings(ItemGen(Material.LEATHER_LEGGINGS, ChatColor.DARK_GRAY+"Pantalon de l'ourse", null, 1));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.DARK_GRAY+"Bottes de l'ours", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.STONE_HOE, Enchantment.DAMAGE_ALL, 2, ChatColor.DARK_GRAY+"Griffe de l'ours", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.WOOD_PICKAXE, ChatColor.DARK_GRAY+"Crocs de l'ours", LoreCreator(ChatColor.BLUE+"Clique droit - Vole 2 coeurs à la cible", ChatColor.BLUE+"1 minute de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitGuerriergalactique (Player p) {
		Clear(p);
		
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_AQUA+"Tunique du guerrier galactique", 1, 222, 178, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.AQUA+"Pantalon du guerrier galactique", 1, 222, 178, 51));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.AQUA+"Bottes du guerrier galactique", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.FERMENTED_SPIDER_EYE, Enchantment.DAMAGE_ALL, 4, ChatColor.AQUA+"Poing du guerrier galactique", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.GOLD_NUGGET, ChatColor.AQUA+"Pouvoir du guerrier galactique", LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"20 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitEsclave(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_GRAY+"Chapeau de l'esclave", 1, 76, 76, 76));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GRAY+"Tunique de l'esclave", 1, 76, 76, 76));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_GRAY+"Pantalon de l'esclave", 1, 76, 76, 76));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_GRAY+"Bottes de l'esclave", 1, 76, 76, 76));
		p.getInventory().setItem(0, ItemGen1(Material.LEASH, Enchantment.DAMAGE_ALL, 4, ChatColor.DARK_GRAY+"Fouet volé", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.WOOD_HOE, Enchantment.KNOCKBACK, 2, ChatColor.DARK_GRAY+"Hoe de l'esclave", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitDomination (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.BLACK+"Chapeau de domination", 1, 25, 25, 25));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLACK+"Tunique de domination", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.BLACK+"Pantalon de domination", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLACK+"Bottes de domination", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.NETHER_STAR, Enchantment.DAMAGE_ALL, 3,ChatColor.BLACK+"Éclair de terreur", LoreCreator(ChatColor.BLUE+"Clique droit - Fait tomber la foudre", ChatColor.BLUE+"30 secondes de récupération"),1));
		p.getInventory().setItem(1, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLACK+"Potion de domination", true));
		p.getInventory().setItem(2, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLACK+"Potion de domination", true));
		p.getInventory().setItem(3, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLACK+"Potion de domination", true));
		p.getInventory().setItem(4, generatePotItem(PotionType.SLOWNESS, 1, ChatColor.BLACK+"Potion anti-rebellion", true));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// A BUFF (0 degat eclaire + cac trop faible)
	public static void kitBoucher(Player p) {
		Clear(p);
		
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_RED+"Tunique de boucher", 1, 255, 255, 255));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_RED+"Pantalon de boucher", 1, 76, 127, 153));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_RED+"Bottes de boucher", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen2(Material.STONE_AXE, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 2, ChatColor.DARK_RED+"Couteau à viande", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.RAW_BEEF, ChatColor.DARK_RED+"Viande saignante", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 1 coeur", ChatColor.BLUE+"1 utilisation"), 1));
		p.getInventory().setItem(2, ItemGen(Material.MUTTON, ChatColor.DARK_RED+"Viande fraiche", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs", ChatColor.BLUE+"1 utilisation"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitMathematicien(Player p) {
		Clear(p);
		
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.AQUA+"Tunique du mathématicien", 1, 153, 153, 153));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.AQUA+"Pantalon du mathématicien", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.AQUA+"Bottes du mathématicien", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.FISHING_ROD, Enchantment.DAMAGE_ALL, 2, ChatColor.AQUA+"Compa", null, 1));
		p.getInventory().setItem(1, ItemGen2(Material.REDSTONE_COMPARATOR, Enchantment.DAMAGE_ALL, 3, Enchantment.FIRE_ASPECT, 1, ChatColor.AQUA+"Calculatrice", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.BEACON, ChatColor.AQUA+"Y=MX+P", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 3 coeurs", ChatColor.BLUE+"1 utilisation"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitPyro(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen1(Material.LEATHER_HELMET, Enchantment.PROTECTION_FIRE, 10, ChatColor.RED+"Chapeau du pyro", null, 1));
		p.getInventory().setChestplate(ItemGen1(Material.LEATHER_CHESTPLATE, Enchantment.PROTECTION_FIRE, 10, ChatColor.RED+"Tunique du pyro", null, 1));
		p.getInventory().setLeggings(ItemGen1(Material.LEATHER_LEGGINGS, Enchantment.PROTECTION_FIRE, 10, ChatColor.RED+"Pantalon du pyro", null, 1));
		p.getInventory().setBoots(ItemGen1(Material.LEATHER_BOOTS, Enchantment.PROTECTION_FIRE, 10, ChatColor.RED+"Bottes du pyro", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.WOOD_SWORD, Enchantment.FIRE_ASPECT, 1, ChatColor.RED+"Épée lanceuse de boules de feu", LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une boule de feu"), 1));
		p.getInventory().setItem(1, ItemGen(Material.FIREBALL, ChatColor.RED+"Boule de feu", null, 6));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitMoutarde(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.YELLOW+"Chapeau de la moutarde", 1, 229, 229, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.YELLOW+"Tunique de la moutarde", 1, 229, 229, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.YELLOW+"Pantalon de la moutarde", 1, 229, 229, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.YELLOW+"Bottes de la moutarde", 1, 229, 229, 51));
		p.getInventory().setItem(0, ItemGen1(Material.SEEDS, Enchantment.DAMAGE_ALL, 3, ChatColor.YELLOW+"Graine de moutarde", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.POTION, ChatColor.YELLOW+"Gaz moutarde", LoreCreator(ChatColor.BLUE+"Clique droit - Donne poison 2 à la cible pendant 2 secondes", ChatColor.BLUE+"15 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// Manque abilité
	public static void kitVampire(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§5Chapeau du vampire", 1, 57, 31, 31));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§5Tunique du vampire", 1, 57, 31, 31));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§5Pantalon du vampire", 1, 57, 31, 31));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§5Bottes du vampire", 1, 57, 31, 31));
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, "§5Epée du vampire", LoreCreator("§9Clique droit - permet de ce tp dans le dos du joueur", "§920 secondes de récupération"), 1));
		p.getInventory().setItem(1, ItemGen(Material.INK_SACK, "§5Transformation", LoreCreator("§9Clique droit - te transforme en chauve souris", "§940 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// manque abilité
	public static void kitNuage(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen2ColorLeather(Material.LEATHER_HELMET, Enchantment.ARROW_DAMAGE, 10, "§fChapeau Nuage", 1, 255, 255, 255));
		p.getInventory().setChestplate(ItemGen2ColorLeather(Material.LEATHER_CHESTPLATE, Enchantment.ARROW_DAMAGE, 10, "§fPlastron Nuage", 1, 255, 255, 255));
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.ARROW_DAMAGE, 10, "§fPantalon Nuage", 1, 255, 255, 255));
		p.getInventory().setBoots(ItemGen2ColorLeather(Material.LEATHER_BOOTS, Enchantment.ARROW_DAMAGE, 10, "§fBottes Nuage", 1, 255, 255, 255));
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, "§9épée Nuage", LoreCreator("Oh les beaux nuages", "tu peux planer"), 1));
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_INFINITE, 1, "§9Arc Nuage",  null, 1));
		p.getInventory().setItem(2, ItemGen(Material.ARROW, "§9Flèche", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
		
	}
	// manque abilité
	public static void kitTimer(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§3Chapeau du Timer", 1, 102, 153, 216));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§3Plastron du Timer", 1, 102, 153, 216));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§3Pantalon du timer", 1, 102, 153, 216));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§3Bottes du Timer", 1, 102, 153, 216));
		p.getInventory().setItem(0, ItemGen1(Material.WATCH, Enchantment.DAMAGE_ALL, 2, "§9Montre du Temps", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.COMPASS, Enchantment.KNOCKBACK, 5, "§9Ejecteur Temporel", LoreCreator("§9Clique droit - permet de frezze 5s", "§930 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// FAIT
	public static void kitRobinDesBois(Player p) {
	    Clear(p);
	    
	    p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§2Chapeau des bois", 1, 114, 165, 38));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§2Tunique des bois", 1, 114, 165, 38));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§2Pantalon des bois", 1, 114, 165, 38));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§2Bottes des bois", 1, 114, 165, 38));
		p.getInventory().setItem(0, ItemGen1(Material.WOOD_SWORD, Enchantment.DAMAGE_ALL, 1, "§9épée des bois", LoreCreator("§9clique droit - vole un item aléatoire au joueur", "§930 secondes de récupération"), 1));
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_DAMAGE, 1, "§9Arc des bois", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.ARROW, "§9Flèche", null, 16));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// manque abilité
	public static void kitGandalf(Player p) {
	    Clear(p);
	    
	    p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§2Chapeau de Gandalf", 1, 153, 153, 153 ));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§2Tunique de Gandalf", 1, 153, 153, 153));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§2Pantalon de gandalf", 1, 153, 153, 153));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§2Bottes de Gandalf", 1, 153, 153, 153));
		p.getInventory().setItem(0, ItemGen2(Material.STICK, Enchantment.DAMAGE_ALL, 3, Enchantment.KNOCKBACK, 2, "§9You Shall Not Pass", LoreCreator("§9Clique droit - éjecte le joueur", "§920 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}   
	// FAIT
	public static void kitGlowstone(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.GLOWSTONE, "§eUniforme Glowstoner", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§eUniforme Glowstone", 1, 229, 229, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§eUniforme Glowstone", 1, 229, 229, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§eUniforme Glowstone", 1, 229, 229, 51));
		p.getInventory().setItem(0, ItemGen2(Material.GLOWSTONE_DUST, Enchantment.DAMAGE_ALL, 2, Enchantment.FIRE_ASPECT, 2, "§9Lumière puissante", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.TORCH, "§9L'aveugleur", LoreCreator("§9Clique droit - aveugle 5 secondes", "§920 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
	}
	// FAIT
    public static void kitSwap(Player p) {
		Clear(p);
		
		p.getInventory().setChestplate(ItemGen(Material.LEATHER_CHESTPLATE, "§6Plastron swap", null, 1));
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, "§9épée swap", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.SNOW_BALL, "swaper", LoreCreator("§9Lancer la boule - Swap votre inventaire avec le joueur touché", null), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
    }
    //manque abilité
    public static void kitRulio(Player p) {
		Clear(p);
		p.getInventory().setChestplate(ItemGen(Material.LEATHER_CHESTPLATE, "§6Tunique de Travail", null, 1));
		p.getInventory().setLeggings(ItemGen(Material.LEATHER_CHESTPLATE, "§6Pantalon de travail", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.BRICK, Enchantment.DAMAGE_ALL, 2, "§9Brique", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.STONE_SLAB2, Enchantment.KNOCKBACK, 6, "§9Dalle", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.NAME_TAG, "§9Truelle", LoreCreator("§Clique Droit - donne poison 5s", "§15 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
    
    }
	//manque abilité
	public static void kitCopy(Player p) {
		Clear(p);
		p.getInventory().setItem(0, ItemGen(Material.STRING, "§9Copieur d'arme", LoreCreator("§9Clique Droit - copie l'arme ennemi", null), 1));
		p.getInventory().setItem(1, ItemGen(Material.TRIPWIRE_HOOK, "§9Copieur d'armure", LoreCreator("§9Clique Droit - copie l'armure ennemi", null), 1));
		p.getInventory().setItem(2, ItemGen(Material.FEATHER, "§9Plumart", LoreCreator("§9Clique Droit - saut de plusieurs blocs", null), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	//manque abilité
	public static void kitPharaon(Player p) {
		Clear(p);
		p.getInventory().setHelmet(ItemGen(Material.GOLD_HELMET, "§eCouronne", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§eToge", 1, 216, 127, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§eToge", 1, 216, 127, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§eChausson", 1, 216, 127, 51));
		p.getInventory().setItem(0, ItemGen2(Material.GOLD_SPADE, Enchantment.DAMAGE_ALL, 1, Enchantment.FIRE_ASPECT, 2, "§9Sceptre du Pharaon", LoreCreator("§9Clique Droit - donne nausé 5s", "§930 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	//manque abilité
	public static void kitFuricat(Player p) {
		Clear(p);
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§2Chapeau furicat", 1, 127, 204, 25));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§dTunique furicat", 1, 242, 127, 165));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§3Pantalon furicat", 1, 102, 153, 216));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§cBottes furicat", 1, 153, 51, 51));
		p.getInventory().setItem(0, ItemGen2(Material.TORCH, Enchantment.DAMAGE_ALL, 2, Enchantment.FIRE_ASPECT, 1, "§9Titute", LoreCreator("§9Clique Droit - Aveugle 5s", "§915 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}
	//FAIT
	public static void kitRedMan(Player p) {
		Clear(p);
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§2Chapeau Redman", 1, 242, 127, 165));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Redman", 1, 242, 127, 165));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§2Pantalon Redman", 1, 242, 127, 165));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§2Bottes Redman", 1, 242, 127, 165));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 2, "§9Boum Boum", LoreCreator("§9Cliqque Droit - Lance des TNT", "§9Consomme une recharge"), 1));
		p.getInventory().setItem(1, ItemGen(Material.REDSTONE, "§9Poudre de Regen", LoreCreator("§9Regen 2 coeurs", "§9 20 secondes de récupérations"), 1));
		p.getInventory().setItem(2, ItemGen(Material.TNT, "§9Recharge", null, 20));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}
	//OK !
	public static void kitTrapman(Player p) {
		Clear(p);
		p.getInventory().setHelmet(ItemGen2ColorLeather(Material.LEATHER_HELMET, Enchantment.PROTECTION_EXPLOSIONS, 4, "§cChapeau TrapMant", 1, 153, 51, 51));
		p.getInventory().setChestplate(ItemGen2ColorLeather(Material.LEATHER_CHESTPLATE, Enchantment.PROTECTION_EXPLOSIONS, 4, "§cTunique TrapMant", 1, 153, 51, 51));
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.PROTECTION_EXPLOSIONS, 4, "§cPantalon TrapMant", 1, 153, 51, 51));
		p.getInventory().setBoots(ItemGen2ColorLeather(Material.LEATHER_BOOTS, Enchantment.PROTECTION_FALL, 4, "§cBottes TrapMant", 1, 153, 51, 51));
		p.getInventory().setItem(0, ItemGen1(Material.TRAP_DOOR, Enchantment.DAMAGE_ALL, 2, "§9Chestar", null, 1));
		p.getInventory().setItem(1, ItemGen2(Material.IRON_TRAPDOOR, Enchantment.FIRE_ASPECT, 1, Enchantment.KNOCKBACK, 2, "§9Dolouris", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	//manque abilité
	public static void kitGolem(Player p) {
		Clear(p);
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§fChapeau Golem", 1, 255, 255, 255 ));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§fTunique Golem", 1, 255, 255, 255));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§fPantalon Golem", 1, 255, 255, 255));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§fBottes Golem", 1, 255, 255, 255));
		p.getInventory().setItem(0, ItemGen(Material.IRON_INGOT, "§9Balanceur", LoreCreator("§9Clique Droit - expulse vos ennemis", "§95 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	
	}
	//FAIT
	public static void kitBoufTout(Player p) {
		Clear(p);
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§fTunique BoufTout", 1, 255, 255, 255));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§fPantalon BoufTout", 1, 76, 127, 153));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§fBottes BoufTout", 1, 102, 76, 51));
		p.getInventory().setItem(0, ItemGen1(Material.COOKED_BEEF, Enchantment.DAMAGE_ALL, 3, "§9Steak Saignant", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.COOKED_CHICKEN, Enchantment.FIRE_ASPECT, 2, "§9Poulet Brûlant", LoreCreator("§9Clique Droit - vole 3 coeurs", "§930 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	//FAIT
	public static void kitEnclumex(Player p) {
		Clear(p);
		p.getInventory().setHelmet(ItemGen(Material.ANVIL, "Chapeau EnClumex", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§fPlastron EnClumex", 1, 76, 76, 76));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§fPantalon EnClumex", 1, 76, 76, 76));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§fBottes EnClumex", 1, 76, 76, 76));
		p.getInventory().setItem(0, ItemGen1(Material.IRON_BLOCK, Enchantment.DAMAGE_ALL, 1, "§9Enclumax", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 999, "§9UltiMax", LoreCreator("§9Clique Gauche - tue votre ennemis ", "§930 secondes de récupération"), 1) );
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}
	//manque abilité
	public static void kitFiesta(Player p) {
		Clear(p);
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§2Chapeau fiesta", 1, 127, 204, 25));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§dTunique fiesta", 1, 242, 127, 165));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§3Pantalon fiesta", 1, 102, 153, 216));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§cBottes fiesta", 1, 153, 51, 51));
		p.getInventory().setItem(0, ItemGen2(Material.ARROW, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 3, "§9Cotillon", LoreCreator("§9Clique Droit - tp les joueurs sur 10 blocs", "§940 secodnes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
			
	}
	//FAIT
	public static void kitPower(Player p) {
		Clear(p);
		p.getInventory().setItem(0, ItemGen(Material.STICK, "§9Jumper", LoreCreator("§9Clique droit - jump de 12 blocs", "15 secondes de récupération"), 1));
		p.getInventory().setItem(1, ItemGen(Material.SLIME_BALL, "§9Poing", LoreCreator("§9Clique droit - charge le poing", "§9Clique gauche - tape selon la charge"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}
	//FAIT
	public static void kitDieu(Player p) {
	    Clear(p);
	    p.getInventory().setHelmet(ItemGen2ColorLeather(Material.LEATHER_HELMET, Enchantment.ARROW_DAMAGE, 10, "§fChapeau Dieu", 1, 255, 255, 255 ));
		p.getInventory().setChestplate(ItemGen2ColorLeather(Material.LEATHER_CHESTPLATE, Enchantment.ARROW_DAMAGE, 10, "§fTunique Dieu", 1, 255, 255, 255));
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.ARROW_DAMAGE, 10, "§fPantalon Dieu", 1, 255, 255, 255));
		p.getInventory().setBoots(ItemGen2ColorLeather(Material.LEATHER_BOOTS, Enchantment.ARROW_DAMAGE, 10, "§fBottes Dieu", 1, 255, 255, 255));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 15, "Bâton d'expulsion", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.INK_SACK, Enchantment.DAMAGE_ALL, 2, "§9sac aux pêchers", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}
	//ok
	public static void kitInvocation(Player p) {
	    Clear(p);
	    p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, "§fChapeau d'invocation", 1, 25, 25, 25 ));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§fTunique d'invocation", 1, 76, 127, 153));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§fPantalon d'invocation", 1, 76, 127, 153));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§fBottes d'invocation", 1, 76, 127, 153));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 1, "§9Invocation Stick", LoreCreator("§9Clique Droit - invoque un bouclier pendant 10s", "§945 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	//MANQUE ABILITé
	public static void kitOgre(Player p) {
	    Clear(p);
	    
	    p.getInventory().setHelmet(generateSkull("§2Ogre", "Shrek"));
	    p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§2Tunique d'ogre", 1, 102, 127, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§2Pantalon d'ogre", 1, 102, 127, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§2Bottes d'ogre", 1, 102, 127, 51));
		p.getInventory().setItem(0, ItemGen1(Material.LEVER, Enchantment.DAMAGE_ALL, 1, "§9Massue", LoreCreator("§9Vous avez 15% de chance de faire plus de dégats", null), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}
	//FAIT
	public static void kitEnderman(Player p) {
	    Clear(p);
	    p.getInventory().setHelmet(generateSkull("§7Enderman", "MHF_Enderman"));
	    p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "§7Tunique d'Enderman", 1, 102, 127, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, "§7Pantalon d'Enderman", 1, 102, 127, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, "§7Bottes d'Enderman", 1, 102, 127, 51));
		p.getInventory().setItem(0, ItemGen1(Material.FLINT, Enchantment.DAMAGE_ALL, 3, "§9Main de l'enderman", LoreCreator("§9Clique droit - vous tp aléatoirement", "§930 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));			
	}
	// FAIT
	public static void Clear(Player p) {
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		for (PotionEffect effect : p.getActivePotionEffects()) {
	        p.removePotionEffect(effect.getType());
		}
	}
}