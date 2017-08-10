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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
	
	public static ItemStack ItemGen0(Material m, String n, ArrayList<String> lore, int nombre) {
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
	
	public static ItemStack ItemGenColorLeather(Material leatherPiece, String n, int nombre, int blue, int green, int red) {
		ItemStack item = new ItemStack(leatherPiece);
		  LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		  meta.setDisplayName(n);
		  meta.setColor(Color.fromBGR(blue, green, red));
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
	
	public static void kitDemolisseur(Player p) {
		Clear(p);
		
		p.getInventory().setHelmet(ItemGenColorLeather(Material.LEATHER_HELMET, ChatColor.DARK_RED+"Chapeau du démolisseur", 1, 89, 39, 39));
		p.getInventory().setChestplate(ItemGenColorLeather(Material.LEATHER_CHESTPLATE, ChatColor.DARK_RED+"Tunique du démolisseur", 1, 89, 39, 39));
		p.getInventory().setLeggings(ItemGenColorLeather(Material.LEATHER_LEGGINGS, ChatColor.DARK_RED+"Pantalon du démolisseur", 1, 89, 39, 39));
		p.getInventory().setBoots(ItemGenColorLeather(Material.LEATHER_BOOTS, ChatColor.DARK_RED+"Bottes du démolisseur", 1, 89, 39, 39));
		p.getInventory().setItem(0, ItemGen2(Material.IRON_AXE, Enchantment.DAMAGE_ALL, 5, Enchantment.KNOCKBACK, 2, ChatColor.DARK_RED+"Hache de guerre",
				LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une boule de feu"), 1)); 
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.getInventory().setItem(1, new ItemStack(Material.FIREBALL, 16));
	}
	
	public static void kitFantome(Player p) {
		Clear(p);
		
		p.getInventory().setItem(0, ItemGen(Material.WOOD_SWORD, ChatColor.GRAY+"Épée du fantôme", new ArrayList<String>(), 1));
		p.getInventory().setItem(1, ItemGen1(Material.STICK, Enchantment.KNOCKBACK, 5, ChatColor.GRAY+"Bâton du châtiment", new ArrayList<String>(), 1));
		p.getInventory().setItem(2, ItemGen0(Material.BLAZE_ROD, ChatColor.GRAY+"Warp stick", 
				LoreCreator(ChatColor.BLUE+"Clique droit -Téléporte", ChatColor.BLUE+"Utilisable toute les minutes"), 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
	}
	
	private static void Clear(Player p) {
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		p.getActivePotionEffects().clear();
	}
}


