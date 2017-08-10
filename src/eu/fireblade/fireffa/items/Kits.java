package eu.fireblade.fireffa.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Kits {
	
	public static ItemStack ItemGen(Material m, String n, int nombre) {
		ItemStack item = new ItemStack(m, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		item.setItemMeta(itemM);
		
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
	
	public static ItemStack Bouf(Material m, int nombre) {
		ItemStack item = new ItemStack(m, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(ChatColor.BLUE+"Nourriture");
		item.setItemMeta(itemM);
		return item;		
	}
	
	public static void kitAgile(Player p) {
		p.getInventory().clear();
		
		p.getInventory().setHelmet(ItemGen(Material.IRON_HELMET, ChatColor.BLUE+"Kit agile", 1));
		p.getInventory().setChestplate(ItemGen(Material.IRON_CHESTPLATE, ChatColor.BLUE+"Kit agile", 1));
		p.getInventory().setLeggings(ItemGen(Material.IRON_LEGGINGS, ChatColor.BLUE+"Kit agile", 1));
		p.getInventory().setBoots(ItemGen(Material.GOLD_BOOTS, ChatColor.BLUE+"Botte d'agilité", 1));
		p.getInventory().setItem(0, ItemGen(Material.IRON_SWORD, ChatColor.BLUE+"Kit agile", 1));
		p.getInventory().setItem(8, Bouf(Material.CARROT_ITEM, 64));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
	}
}

