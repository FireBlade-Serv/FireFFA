package eu.fireblade.fireffa.items;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Kits {
	
	public static ItemStack ItemGen0(Material m, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		item.setItemMeta(itemM);
		
		return item;
	}
	
	public static ItemStack ItemGen1(Material m, Enchantment ench, int level, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		itemM.addEnchant(ench, level, true);
		item.setItemMeta(itemM);
		
		return item;
	}
	
	public static ItemStack ItemGen2(Material m, Enchantment ench, int level, Enchantment ench2, int level2, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		itemM.addEnchant(ench, level, true);
		itemM.addEnchant(ench2, level2, true);
		item.setItemMeta(itemM);
		
		return item;
	}
	
	public static ItemStack ItemGen3(Material m, Enchantment ench, int level, Enchantment ench2, int level2, Enchantment ench3,

		int level3, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.spigot().setUnbreakable(true);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		itemM.addEnchant(ench, level, true);
		itemM.addEnchant(ench2, level2, true);
		itemM.addEnchant(ench3, level3, true);
		item.setItemMeta(itemM);
		
		return item;
	}
	
	public static ItemStack Bouf(Material m) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(ChatColor.BLUE+"Nourriture");
		item.setItemMeta(itemM);
		return item;		
	}
	
	public static void kitAgile(Player p) {
		p.getInventory().setItem(1, ItemGen0(Material.IRON_HELMET, ChatColor.BLUE+"Kit agile", null, null, null));
		p.getInventory().setItem(1, ItemGen0(Material.IRON_CHESTPLATE, ChatColor.BLUE+"Kit agile", null, null, null));
		p.getInventory().setItem(1, ItemGen0(Material.IRON_LEGGINGS, ChatColor.BLUE+"Kit agile", null, null, null));
		p.getInventory().setItem(1, ItemGen0(Material.GOLD_BOOTS, ChatColor.BLUE+"Botte d'agilité", "", "", 
				ChatColor.WHITE+"Une légende raconte que son détenteur cours plus vite que la lumiére."));
		p.getInventory().setItem(1, ItemGen0(Material.IRON_SWORD, ChatColor.BLUE+"Kit agile", null, null, null));
		p.getInventory().setItem(64, Bouf(Material.CARROT_ITEM));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
	}
}

