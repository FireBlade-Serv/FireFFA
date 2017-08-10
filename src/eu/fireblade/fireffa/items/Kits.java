package eu.fireblade.fireffa.items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kits {
	public static void ItemGen0(Material m, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		item.setItemMeta(itemM);
	}
	
	public static void ItemGen1(Material m, Enchantment ench, int level, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		itemM.addEnchant(ench, level, true);
		item.setItemMeta(itemM);
	}
	
	public static void ItemGen2(Material m, Enchantment ench, int level, Enchantment ench2, int level2, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		itemM.addEnchant(ench, level, true);
		itemM.addEnchant(ench2, level2, true);
		item.setItemMeta(itemM);
	}
	
	public static void ItemGen3(Material m, Enchantment ench, int level, Enchantment ench2, int level2, Enchantment ench3,
			int level3, String n, String l1, String l2, String l3) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(n);
		itemM.setLore(Arrays.asList(l1, l2, l3));
		itemM.addEnchant(ench, level, true);
		itemM.addEnchant(ench2, level2, true);
		itemM.addEnchant(ench3, level3, true);
		item.setItemMeta(itemM);
	}
}
	
