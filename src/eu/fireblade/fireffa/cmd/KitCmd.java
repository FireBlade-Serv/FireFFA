package eu.fireblade.fireffa.cmd;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class KitCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		
		if(!(sender instanceof Player)){
			sender.sendMessage("§cVous ne pouvez pas executer cette commande sur la console");
			return false;
		}
		
		Player p = (Player) sender;
		
		mainMenu(p);
		
		return false;
	}
	
	public static void mainMenu(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§9Kits");
		
		inv.setItem(0, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(1, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(2, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(3, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(4, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(5, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(6, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(7, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(8, genPerspective(Material.LEAVES, "§1", (byte) 0));
		
		inv.setItem(9, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(10, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(18, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(19, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(27, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(28, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(36, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(37, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(38, genPerspective(Material.LEAVES, "§1", (byte) 0));
		
		inv.setItem(17, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(16, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(26, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(25, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(35, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(34, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(44, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(43, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(42, genPerspective(Material.LEAVES, "§1", (byte) 0));
		
		inv.setItem(45, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(46, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(47, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(48, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(49, genPerspectiveEnch(Material.EMERALD, "Plugin by Glowstoner & _goldocelot_",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0));
		inv.setItem(50, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(51, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(52, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(53, genPerspective(Material.LEAVES, "§1", (byte) 0));
		
		inv.setItem(31, genPerspective(Material.STAINED_GLASS, "§f§lKits Membre", (byte) 0));
		inv.setItem(13, genPerspectiveEnch(Material.STAINED_GLASS, "§e§lKits Fire",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 4));
		inv.setItem(14, genPerspectiveEnch(Material.STAINED_GLASS, "§c§lKits Ultimate",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 14));
		inv.setItem(12, genPerspectiveEnch(Material.STAINED_GLASS, "§6§lKits Ultra",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 1));
		
		p.openInventory(inv);
	}

	private static ItemStack genPerspective(Material m, String name, byte data){
		ItemStack item = new ItemStack(m, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack genPerspective(Material m, String name, byte data, List<String> lore){
		ItemStack item = new ItemStack(m, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(name);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack genPerspectiveEnch(Material m, String name, Enchantment ench, int lvl, byte data){
		ItemStack item = new ItemStack(m, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(ench, lvl, true);
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack genPerspectiveEnch(Material m, String name, Enchantment ench, int lvl, byte data, List<String> lore){
		ItemStack item = new ItemStack(m, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(ench, lvl, true);
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack genPerspectivePot(String name, PotionType pt, boolean setsplash, List<String> list){
		Potion p = new Potion(pt);
		p.setSplash(setsplash);
		
		ItemStack item = p.toItemStack(1);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		meta.setDisplayName(name);
		meta.setLore(list);
		item.setItemMeta(meta);
		
		return item;
	}
	
	private static ItemStack genPerspectiveLeatherColor(Material leatherPiece, String n, int nombre, int red, int green, int blue, List<String> list) {
		ItemStack item = new ItemStack(leatherPiece);
		  LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		  meta.setDisplayName(n);
		  meta.setColor(Color.fromBGR(blue, green, red));
		  meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		  meta.setLore(list);
		  meta.spigot().setUnbreakable(true);
		  item.setItemMeta(meta);
		  return item;
	}
}
