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
		item.setItemMeta(itemM);
		
		if(lore != null){
			itemM.setLore(lore);
		}
		
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
	
	public static ItemStack generateMutiplePot(PotionEffectType pt, int level, int time, PotionEffectType pt2, int level2, int time2, String name, ArrayList<String> lore, int nombre) {
		ItemStack Potion = new ItemStack(Material.POTION, 1);
		PotionMeta PotionMeta = (PotionMeta) Potion.getItemMeta();
		PotionMeta.setDisplayName(name);
		PotionMeta.setLore(lore);
		PotionMeta.addCustomEffect(new PotionEffect(pt, level, time), true);
		PotionMeta.addCustomEffect(new PotionEffect(pt2, level2, time2), true);
		Potion.setItemMeta(PotionMeta);
		Potion po = new Potion((byte) 8258);
		po.apply(Potion);
		return Potion;
	}
	
	public static void kitDemolisseur(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_RED+"Chapeau du d�molisseur", 1, 89, 38, 38));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_RED+"Tunique du d�molisseur", 1, 89, 38, 38));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_RED+"Pantalon du d�molisseur", 1, 89, 38, 38));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_RED+"Bottes du d�molisseur", 1, 89, 38, 38));
		p.getInventory().setItem(0, ItemGen2(Material.IRON_AXE, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 2, ChatColor.DARK_RED+"Hache de guerre", LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une boule de feu"), 1)); 
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.getInventory().setItem(1, ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 16));
	}
	
	public static void kitFantome(Player p) {
		Clear(p);
		
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, ChatColor.GRAY+"�p�e du fant�me", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 5, ChatColor.GRAY+"B�ton du ch�timent", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.BLAZE_ROD, ChatColor.GRAY+"Warp stick", LoreCreator(ChatColor.BLUE+"Clique droit -T�l�porte", ChatColor.BLUE+"Utilisable toute les minutes"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
	}
	
	public static void kitTank(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen1(Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 4, ChatColor.GOLD+"Casque du tank", null, 1));
		p.getInventory().setChestplate(ItemGen1(Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_FIRE, 4, ChatColor.GOLD+"Plastron du tank", null, 1));
		p.getInventory().setLeggings(ItemGen1(Material.GOLD_LEGGINGS, Enchantment.PROTECTION_FIRE, 4, ChatColor.GOLD+"Jambi�res du tank", null, 1));
		p.getInventory().setBoots(ItemGen1(Material.GOLD_BOOTS, Enchantment.PROTECTION_FIRE, 4, ChatColor.GOLD+"Bottes du tank", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.WOOD_SWORD, Enchantment.KNOCKBACK, 4, ChatColor.GOLD+"�p�e du tank", null, 1));
		p.getInventory().setItem(1, generatePotItem(PotionType.INSTANT_HEAL, 2, ChatColor.GOLD+"Potion curative du tank", true));
		p.getInventory().setItem(2, generatePotItem(PotionType.INSTANT_HEAL, 2, ChatColor.GOLD+"Potion curative du tank", true));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
	public static void kitFlic (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_BLUE+"Chapeau du flic", 1, 76, 127, 153));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_BLUE+"Tunique du flic", 1, 51, 76, 178));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_BLUE+"Pantalon du flic", 1, 51, 76, 178));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_BLUE+"Bottes du flic", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 3, ChatColor.DARK_BLUE+"Matraque", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.FLINT_AND_STEEL, ChatColor.DARK_BLUE+"Flingue", LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une munition"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.getInventory().setItem(2, ItemGen(Material.FIREBALL, ChatColor.DARK_BLUE+"Munition", null, 12));
	}
	
	public static void kitMagicien (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.DIAMOND_HELMET, ChatColor.BLUE+"Casque du magicien", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLUE+"Tunique du magicien", 1, 51, 76, 178));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.BLUE+"Pantalon du magicien", 1, 51, 76, 178));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLUE+"Bottes du magicien", 1, 153, 51, 51));
		p.getInventory().setItem(0, ItemGen2(Material.STICK, Enchantment.KNOCKBACK, 3, Enchantment.DAMAGE_ALL, 1, ChatColor.BLUE+"Baguette magique", LoreCreator(ChatColor.BLUE+"Clique droit - Ralentit et aveugle", ChatColor.BLUE+"Consomme une poudre magique"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.getInventory().setItem(1, ItemGen(Material.BLAZE_POWDER, ChatColor.BLUE+"Poudre magique", null, 3));
		p.getInventory().setItem(2, generatePotItem(PotionType.REGEN, 2, ChatColor.BLUE+"Potion de r�g�neratrice du magicien", true));
		p.getInventory().setItem(3, generatePotItem(PotionType.INSTANT_DAMAGE, 2, ChatColor.BLUE+"Potion d�structrice du magicien", true));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
	public static void kitChevalier (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.GRAY+"Chapeau du chevalier", 1, 153, 153, 153));
		p.getInventory().setChestplate(ItemGen(Material.CHAINMAIL_CHESTPLATE, ChatColor.GRAY+"Cotte de maille du chevalier", null, 1));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GRAY+"Pantalon du chevalier", 1, 153, 153, 153));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.GRAY+"Bottes du chevalier", 1, 153, 153, 153));
		p.getInventory().setItem(0, ItemGen1(Material.STONE_SWORD, Enchantment.KNOCKBACK, 0-2, ChatColor.GRAY+"�p�e du Chevalier", null, 1));
		p.getInventory().setItem(1, generatePotItem(PotionType.INSTANT_HEAL, 2, ChatColor.GRAY+"Potion curative du chevalier", false));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
	public static void kitCactus (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen2ColorLeather(Material.LEATHER_HELMET, Enchantment.THORNS, 4, ChatColor.GREEN+"Chapeau du cactus", 1, 127, 204, 25));
		p.getInventory().setChestplate(ItemGen2ColorLeather(Material.LEATHER_CHESTPLATE, Enchantment.THORNS, 4, ChatColor.GREEN+"Tunique du cactus", 1, 127, 204, 25));
		p.getInventory().setLeggings(ItemGen2ColorLeather(Material.LEATHER_LEGGINGS, Enchantment.THORNS, 4, ChatColor.GREEN+"Pantalon du cactus", 1, 127, 204, 25));
		p.getInventory().setBoots(ItemGen2ColorLeather(Material.LEATHER_BOOTS, Enchantment.THORNS, 4, ChatColor.GREEN+"Bottes du cactus", 1, 127, 204, 25));
		p.getInventory().setItem(0, ItemGen1(Material.FLINT, Enchantment.DAMAGE_ALL, 1, ChatColor.GREEN+"�pine", null,1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
	}
	
	public static void kitPiaf (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.GRAY+"Chapeau du piaf", 1, 216, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.GRAY+"Tunique du piaf", 1, 127, 204, 25));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.GRAY+"Pantalon du piaf", 1, 153, 51, 51));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.GRAY+"Bottes du piaf", 1, 229, 229, 51));
		p.getInventory().setItem(0, ItemGen1(Material.SUGAR, Enchantment.DAMAGE_ALL, 4, ChatColor.GRAY+"Fiente", null, 1));
		p.getInventory().setItem(1, ItemGen(Material.FEATHER, ChatColor.GRAY+"Vol", LoreCreator(ChatColor.BLUE+"Clique droit - Propulse en hauteur", ChatColor.BLUE+"Utilisable 25 fois"), 25));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		
	}

	public static void kitVoleurdame (Player p) {
		Clear(p);
		
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
		ItemMeta skullM = skull.getItemMeta();
		skullM.setDisplayName(ChatColor.BLACK+"Cr�ne du voleur d'�me");
		skullM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		skull.setItemMeta(skullM);	
		
		p.getInventory().setHelmet(skull);
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.BLACK+"Tunique du voleur d'�me", 1, 25, 25, 25));
		p.getInventory().setLeggings(ItemGen(Material.CHAINMAIL_LEGGINGS, ChatColor.BLACK+"Jambi�re de maile du voleur d'�me", null, 1));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.BLACK+"Bottes du voleur d'�me", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen(Material.STONE_SWORD, ChatColor.BLACK+"�p�e du voleur d'�me", LoreCreator(ChatColor.BLUE+"Clique droit - Vole 1,5 coeurs", ChatColor.BLUE+"45 secondes de r�cup�ration"), 1));
		p.getInventory().setItem(1, ItemGen(Material.REDSTONE, ChatColor.BLACK+"Puit de sang", LoreCreator(ChatColor.BLUE+"Clique droit - Utilise les �mes accumul�es pour se r�g�nerer", ChatColor.BLUE+"Consomme le puit de sang (Exp�rience)"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
	public static void kitOITCman (Player p) {
		Clear(p);
		
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_DAMAGE, Integer.MAX_VALUE, ChatColor.RED+"OITC bow", LoreCreator(ChatColor.BLUE+"Les fl�ches tuent � l'impacte", ChatColor.BLUE+"Consomme une fl�che si la cible est rat�e"), 1));
		p.getInventory().setItem(2, ItemGen(Material.ARROW, ChatColor.RED+"OITC arrow", null, 3));
		p.getInventory().setItem(0, ItemGen(Material.STONE_SWORD, ChatColor.RED+"OITC sword", null, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
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
	
	public static void kitRusse(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_GREEN+"Chapeau du russe", 1, 102, 127, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GREEN+"Tunique du russe", 1, 63, 76, 38));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_GREEN+"Pantalon du russe", 1, 63, 76, 38));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_GREEN+"Bottes du russe", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen1(Material.WOOD_SWORD, Enchantment.DAMAGE_ALL, 2, ChatColor.DARK_GREEN+"�p�e de combat", null, 1));
		p.getInventory().setItem(1, generateMutiplePot(PotionEffectType.INCREASE_DAMAGE, 2, 90, PotionEffectType.CONFUSION, 1, 90, ChatColor.DARK_GREEN+"Vodka", LoreCreator(ChatColor.BLUE+"Force II et naus� II", ChatColor.BLUE+"1 minute"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
	public static void kitGrampa(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGen(Material.GOLD_HELMET, ChatColor.DARK_GRAY+"Casque du grampa", null, 1));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_GRAY+"Tunique du grampa", 1, 254, 254, 254));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_GRAY+"Pantalon du grampa", 1, 229, 229, 51));
		p.getInventory().setBoots(ItemGen(Material.LEATHER_BOOTS, ChatColor.DARK_GRAY+"Bottes du grampa", null, 1));
		p.getInventory().setItem(0, ItemGen1(Material.INK_SACK, Enchantment.DAMAGE_ALL, 4, ChatColor.DARK_GRAY+"Dentier", null, 1));
		p.getInventory().setItem(1, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 10, ChatColor.DARK_GRAY+"Canne", null, 1));
		p.getInventory().setItem(2, ItemGen(Material.INK_SACK, ChatColor.DARK_GRAY+"Pruneau", LoreCreator(ChatColor.BLUE+"Clique droit - R�g�ne 2 coeurs", ChatColor.BLUE+"R�cup�ration 1 minute 30"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}

	public static void kitMineur(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.YELLOW+"Chapeau du mineur", 1, 229, 229, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.YELLOW+"Tunique du mineur", 1, 76, 127, 153));
		p.getInventory().setLeggings(ItemGen(Material.LEATHER_LEGGINGS, ChatColor.YELLOW+"Pantalon du mineur", null, 1));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.YELLOW+"Bottes du mineur", 1, 25, 25, 25));
		p.getInventory().setItem(0, ItemGen2(Material.STONE_PICKAXE, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 1, ChatColor.YELLOW+"Pioche du mineur", null ,1));
		p.getInventory().setItem(1, ItemGen1(Material.IRON_INGOT, Enchantment.DAMAGE_ALL, 3, ChatColor.YELLOW+"Lingot de la mort", null, 1));
		p.getInventory().setItem(2, ItemGen2(Material.COAL, Enchantment.FIRE_ASPECT, 1, Enchantment.DAMAGE_ALL, 0-Integer.MAX_VALUE, ChatColor.YELLOW+"Charbon du mineur", null, 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
	public static void kitJihadist (Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_RED+"Chapeau du jihadist", 1, 213, 209, 51));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_RED+"Tunique du jihadist", 1, 121, 104, 63));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_RED+"Pantalon du jihadist", 1, 121, 104, 63 ));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_RED+"Bottes du jihadist", 1, 216, 127, 51));
		p.getInventory().setItem(1, ItemGen1(Material.BOW, Enchantment.ARROW_FIRE, 1, ChatColor.DARK_RED+"Kalachnikov", null, 1));
		p.getInventory().setItem(3, ItemGen(Material.ARROW, ChatColor.DARK_RED+"Munitions", null, 32));
		p.getInventory().setItem(2, ItemGen(Material.REDSTONE, ChatColor.DARK_RED+"Allah akbar", LoreCreator(ChatColor.BLUE+"Clique droit - Se faire exploser", ChatColor.BLUE+"Vous tue instantan�ment"), 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
	}
	
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