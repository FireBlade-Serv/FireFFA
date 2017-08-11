package eu.fireblade.fireffa.cmd;

import org.bukkit.Bukkit;
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

public class Kit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("§cVous devez être un joueur pour pouvoir executer cette commande !");
		}
		
		Player p = (Player) sender;
		
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
		
		//membre
		inv.setItem(9, genPerspective(Material.STAINED_GLASS, "§f§lKits Membre", (byte) 0));
		inv.setItem(10, genPerspectiveEnch(Material.GOLD_HELMET, "§9Tank", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0));
		
		//fire
		inv.setItem(18, genPerspective(Material.STAINED_GLASS, "§e§lKits Fire", (byte) 4));
		
		//ultra
		inv.setItem(27, genPerspective(Material.STAINED_GLASS, "§6§lKits Ultra", (byte) 1));
		
		//ultimate
		inv.setItem(36, genPerspective(Material.STAINED_GLASS, "§c§lKits Ultimate", (byte) 14));
		
		p.openInventory(inv);
		
		return false;
	}
	
	private static ItemStack genPerspective(Material m, String name, byte data){
		ItemStack item = new ItemStack(m, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(name);
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

}
