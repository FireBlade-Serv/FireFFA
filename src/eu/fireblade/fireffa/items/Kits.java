package eu.fireblade.fireffa.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
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
	// OK
	public static void kitFantome(Player p) {
		Clear(p);
		
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, ChatColor.GRAY+"Épée du fantôme", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 5, ChatColor.GRAY+"Bâton du châtiment", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.BLAZE_ROD, ChatColor.GRAY+"Warp stick",LoreCreator(ChatColor.BLUE+"Clique droit - Téléporte", ChatColor.BLUE+"Utilisable toute les minutes"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
	}
	// MANQUE ABILITÉ
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
	}
	// MANQUE ABILITÉ
	public static void kitFlic (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_BLUE+"Chapeau du flic", 1, 76, 127, 153));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_BLUE+"Tunique du flic", 1, 51, 76, 178));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_BLUE+"Pantalon du flic", 1, 51, 76, 178));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_BLUE+"Bottes du flic", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 3, ChatColor.DARK_BLUE+"Matraque", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.FLINT_AND_STEEL, ChatColor.DARK_BLUE+"Flingue",LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une munition"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.getInventory().setItem(2, ItemGen(Material.FIREBALL, ChatColor.DARK_BLUE+"Munition", null, 12));
	}
	// MANQUE ABILITÉ
	public static void kitMagicien (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.DIAMOND_HELMET, ChatColor.BLUE+"Casque du magicien", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLUE+"Tunique du magicien", 1, 51, 76, 178));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.BLUE+"Pantalon du magicien", 1, 51, 76, 178));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLUE+"Bottes du magicien", 1, 153, 51, 51));
		p.getInventory().setItem(0, ItemGen2(Material.STICK, Enchantment.KNOCKBACK, 3, Enchantment.DAMAGE_ALL, 2, ChatColor.BLUE+"Baguette magique", LoreCreator(ChatColor.BLUE+"Clique droit - Ralentit et aveugle", ChatColor.BLUE+"Consomme une poudre magique"), 1));
		p.getInventory().setItem(1, ItemGen(Material.BLAZE_POWDER, ChatColor.BLUE+"Poudre magique", null, 3));
		p.getInventory().setItem(2, generatePotItem(PotionType.REGEN, 2, ChatColor.BLUE+"Potion de régéneratrice du magicien", true));
		p.getInventory().setItem(3, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLUE+"Potion déstructrice du magicien", true));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
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
	// OK
	public static void kitCactus (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen2ColorLeather(Material.LEATHER_HELMET, Enchantment.THORNS, 4, ChatColor.GREEN+"Chapeau du cactus", 1, 127, 204, 25));
		p.getInventory().setChestplate(ItemGen2ColorLeather(Material.LEATHER_CHESTPLATE, Enchantment.THORNS, 4, ChatColor.GREEN+"Tunique du cactus", 1, 127, 204, 25));
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.THORNS, 4, ChatColor.GREEN+"Pantalon du cactus", 1, 127, 204, 25));
		p.getInventory().setBoots(ItemGen2ColorLeather(Material.LEATHER_BOOTS, Enchantment.THORNS, 4, ChatColor.GREEN+"Bottes du cactus", 1, 127, 204, 25));
		p.getInventory().setItem(0, ItemGen1(Material.FLINT, Enchantment.DAMAGE_ALL, 1, ChatColor.GREEN+"Épine", null,1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
	}
	// OK
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
	// MANQUE ABILITÉ
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
		p.getInventory().setItem(0, ItemGen(Material.STONE_SWORD, ChatColor.BLACK+"Épée du voleur d'âme",LoreCreator(ChatColor.BLUE+"Clique droit - Vole 1,5 coeurs", ChatColor.BLUE+"45 secondes de récupération"), 1));
		p.getInventory().setItem(1, ItemGen(Material.REDSTONE, ChatColor.BLACK+"Puit de sang",LoreCreator(ChatColor.BLUE+"Clique droit - Utilise les âmes accumulées pour se régénerer", ChatColor.BLUE+"Consomme le puit de sang (Expérience)"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ X2
	public static void kitOITCman (Player p) {
		Clear(p);
		
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_DAMAGE, 999, ChatColor.RED+"OITC bow", LoreCreator(ChatColor.BLUE+"Les fléches tuent à l'impacte", ChatColor.BLUE+"Consomme une fléche si la cible est ratée"), 1));
		p.getInventory().setItem(2, ItemGen(Material.ARROW, ChatColor.RED+"OITC arrow", null, 3));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 2, ChatColor.RED+"OITC sword", null, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE LE REGIVE DE FLECHE SI KILL
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
	// OK
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
		lore.add(ChatColor.BLUE+"Force I");
		lore.add(ChatColor.BLUE+"1 minute");
		PotionMeta.setLore(lore);
		PotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 20*60, 0), true);
		PotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*60, 0), true);
		Potion.setItemMeta(PotionMeta);

		p.getInventory().setItem(1, Potion);
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// OK
	public static void kitGrampa(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.GOLD_HELMET, ChatColor.DARK_GRAY+"Casque du grampa", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GRAY+"Tunique du grampa", 1, 254, 254, 254));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_GRAY+"Pantalon du grampa", 1, 229, 229, 51));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.DARK_GRAY+"Bottes du grampa", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.INK_SACK, Enchantment.DAMAGE_ALL, 4, ChatColor.DARK_GRAY+"Dentier", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 10, ChatColor.DARK_GRAY+"Canne", null, 1));
		ItemStack charcoal = new ItemStack(Material.COAL, 1, (byte) 1);
		ItemMeta charcoalM = charcoal.getItemMeta();
		charcoalM.setDisplayName(ChatColor.DARK_GRAY+"Pruneau");
		charcoalM.setLore(LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs", ChatColor.BLUE+"Récupération 1 minute 30"));
		charcoal.setItemMeta(charcoalM);
		p.getInventory().setItem(2, charcoal);
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// OK
	public static void kitMineur(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.YELLOW+"Chapeau du mineur", 1, 229, 229, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.YELLOW+"Tunique du mineur", 1, 76, 127, 153));
		p.getInventory().setLeggings(ItemGen(Material.LEATHER_LEGGINGS, ChatColor.YELLOW+"Pantalon du mineur", null, 1));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.YELLOW+"Bottes du mineur", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen2(Material.STONE_PICKAXE, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 1, ChatColor.YELLOW+"Pioche du mineur", null ,1));
		p.getInventory().setItem(1, ItemGen1(Material.IRON_INGOT, Enchantment.DAMAGE_ALL, 3, ChatColor.YELLOW+"Lingot de la mort", null, 1));
		p.getInventory().setItem(2, ItemGen2(Material.COAL, Enchantment.FIRE_ASPECT, 1, Enchantment.DAMAGE_ALL, 0-999, ChatColor.YELLOW+"Charbon du mineur", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// OK
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
	// MANQUE ABILITÉ
	public static void kitGamer (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.GREEN+"Chapeau du gamer", 1, 127, 204, 25));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.GREEN+"Tunique du gamer", 1, 127, 204, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GREEN+"Pantalon du gamer", 1, 127, 204, 25 ));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.GREEN+"Bottes du gamer", 1, 127, 204, 25));
		p.getInventory().setItem(0, ItemGen2(Material.WOOD_SWORD, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 8, ChatColor.GREEN+"Épée du hero", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.RED_MUSHROOM, ChatColor.GREEN+"Super champignon",LoreCreator(ChatColor.BLUE+"Clique droit - Force 2, 5 secondes", ChatColor.BLUE+"Récupération 30 secondes"), 1));
		p.getInventory().setItem(2, ItemGen(Material.RABBIT_FOOT, ChatColor.GREEN+"Super jump",LoreCreator(ChatColor.BLUE+"Clique droit - Saute à une hauteur de 5 blocs", ChatColor.BLUE+"Récupération 15 secondes"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
	public static void kitSauvage (Player p) {
		Clear(p);
		
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 5, ChatColor.DARK_PURPLE+"Pantalon du sauvage", 1, 102, 127, 51));
		p.getInventory().setItem(0, ItemGen1(Material.FISHING_ROD, Enchantment.DAMAGE_ALL, 4, ChatColor.DARK_PURPLE+"Massue", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.GRILLED_PORK, ChatColor.DARK_PURPLE+"Nourriture charnue", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 3 coeurs", ChatColor.BLUE+"1 utilisation"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
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
	// MANQUE ABILITÉ	
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
	// MANQUE ABILITÉ
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
	// OK
	public static void kitArcherelite (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_GREEN+"Chapeau de l'archer d'élite", 1, 114, 113, 57));
		p.getInventory().setItem(0, ItemGen1(Material.BOW, Enchantment.ARROW_INFINITE, 1, ChatColor.DARK_GREEN+"Arc mitrailleur", LoreCreator(ChatColor.BLUE+"N'a pas besoin d'être chargé", ChatColor.BLUE+"Pas de limite d'utilisation"), 1));
		p.getInventory().setItem(1, ItemGen(Material.ARROW, ChatColor.RED+"Fléche de l'archer élite", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
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
	// OK
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
	// OK
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
	// OK
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
	// MANQUE ABILITÉ
	public static void kitPatissier (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.LIGHT_PURPLE+"Chapeau du patissier", 1, 102, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.LIGHT_PURPLE+"Tunique du patissier", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.LIGHT_PURPLE+"Pantalon du patissier", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.LIGHT_PURPLE+"Bottes du patissier", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.PUMPKIN_PIE, Enchantment.DAMAGE_ALL, 2, ChatColor.LIGHT_PURPLE+"Tarte aux épines", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.CAKE, Enchantment.KNOCKBACK, 4, ChatColor.LIGHT_PURPLE+"Gâteau dans ta face", null, 1));
		p.getInventory().setItem(3, ItemGen(Material.COOKIE, ChatColor.LIGHT_PURPLE+"Cookie du patisser", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs + vitesse 2, 15 secondes", ChatColor.BLUE+"30 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}	
	// OK
	public static void kitOurs (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.LEATHER_HELMET, ChatColor.DARK_GRAY+"Chapeau de l'ourse", null, 1));
		p.getInventory().setChestplate(ItemGen(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GRAY+"Tunique de l'ourse", null, 1));
		p.getInventory().setLeggings(ItemGen(Material.LEATHER_LEGGINGS, ChatColor.DARK_GRAY+"Pantalon de l'ourse", null, 1));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.DARK_GRAY+"Bottes de l'ourse", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.STONE_HOE, Enchantment.DAMAGE_ALL, 2, ChatColor.DARK_GRAY+"Griffe de l'ourse", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.WOOD_PICKAXE, ChatColor.DARK_GRAY+"Crocs de l'ourse", LoreCreator(ChatColor.BLUE+"Clique droit - Vole 2 coeurs à la cible", ChatColor.BLUE+"1 minute de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
	public static void kitGuerriergalactique (Player p) {
		Clear(p);
		
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_AQUA+"Tunique du guerrier galactique", 1, 222, 178, 51));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.AQUA+"Pantalon du guerrier galactique", 1, 222, 178, 51));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.AQUA+"Bottes du guerrier galactique", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.FERMENTED_SPIDER_EYE, Enchantment.DAMAGE_ALL, 4, ChatColor.AQUA+"Poing du guerrier galactique", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.GOLD_NUGGET, ChatColor.AQUA+"Pouvoir du guerrier galactique", LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"20 secondes de récupération"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
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
	// OK
	public static void kitDomination (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.BLACK+"Chapeau de domination", 1, 25, 25, 25));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLACK+"Tunique de domination", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.BLACK+"Pantalon de domination", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLACK+"Bottes de domination", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.NETHER_STAR, Enchantment.DAMAGE_ALL, 3,ChatColor.BLACK+"Éclaire de terreur", LoreCreator(ChatColor.BLUE+"Clique droit - Fait tomber la foudre", ChatColor.BLUE+"30 secondes de récupération"),1));
		p.getInventory().setItem(1, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLACK+"Potion de domination", true));
		p.getInventory().setItem(2, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLACK+"Potion de domination", true));
		p.getInventory().setItem(3, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLACK+"Potion de domination", true));
		p.getInventory().setItem(4, generatePotItem(PotionType.SLOWNESS, 1, ChatColor.BLACK+"Potion anti-rebellion", true));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
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
	// MANQUE ABILITÉ
	public static void kitMathematicien(Player p) {
		Clear(p);
		
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.AQUA+"Tunique du mathématicien", 1, 153, 153, 153));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.AQUA+"Pantalon du mathématicien", 1, 25, 25, 25));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.AQUA+"Bottes du mathématicien", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.FISHING_ROD, Enchantment.DAMAGE_ALL, 2, ChatColor.AQUA+"Compa", null, 1));
		p.getInventory().setItem(1, ItemGen2(Material.REDSTONE_COMPARATOR, Enchantment.DAMAGE_ALL, 3, Enchantment.FIRE_ASPECT, 1, ChatColor.AQUA+"Calculatrice", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.BEACON, ChatColor.AQUA+"Y=MX+P", LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs", ChatColor.BLUE+"1 utilisation"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	// MANQUE ABILITÉ
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
	// MANQUE ABILITÉ
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
	
	public static void kitNuage(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen2ColorLeather(Material.LEATHER_HELMET, Enchantment.ARROW_DAMAGE, 10, "§fChapeau Nuage", 1, 255, 255, 255));
		p.getInventory().setChestplate(ItemGen2ColorLeather(Material.LEATHER_CHESTPLATE, Enchantment.ARROW_DAMAGE, 10, "§fPlastron Nuage", 1, 255, 255, 255));
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.ARROW_DAMAGE, 10, "§fPantalon Nuage", 1, 255, 255, 255));
		p.getInventory().setBoots(ItemGen2ColorLeather(Material.LEATHER_BOOTS, Enchantment.ARROW_DAMAGE, 10, "§fBottes Nuage", 1, 255, 255, 255));
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, "§fépée Nuage", LoreCreator("Oh les beaux nuages", "tu peux planer"), 1));
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_INFINITE, 1, "§fArc Nuage",  null, 1));
		p.getInventory().setItem(1, ItemGen(Material.ARROW, "Flèche", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
		
	}
	// MANQUE ABILITÉ
	private static void Clear(Player p) {
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