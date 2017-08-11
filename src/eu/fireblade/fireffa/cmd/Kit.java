package eu.fireblade.fireffa.cmd;

import java.util.Arrays;
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

public class Kit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("§cVous devez être un joueur pour pouvoir executer cette commande !");
			return false;
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
		inv.setItem(10, genPerspectiveLeatherColor(Material.LEATHER_CHESTPLATE, "§9Démolisseur", 1, 89, 38, 38,
				Arrays.asList("§9+ Peut lancer des fireball")));
		inv.setItem(11, genPerspectiveEnch(Material.GOLD_HELMET, "§9Tank", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
				Arrays.asList("§9+ La meilleure armure","§9- Ne peut pas courir")));
		inv.setItem(12, genPerspectiveEnch(Material.STICK, "§9Flic", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
				Arrays.asList("§9+ A un pistolet")));	
		inv.setItem(13, genPerspective(Material.BLAZE_POWDER, "§9Magicien", (byte) 0,
				Arrays.asList("§9+ A des potions")));
		inv.setItem(14, genPerspective(Material.STONE_SWORD, "§9Chevalier", (byte) 0,
				Arrays.asList("§9+ Peu facilement combo")));
		inv.setItem(15, genPerspective(Material.CARROT_ITEM, "§9Lapin", (byte) 0,
				Arrays.asList("§9+ A JumpBoost 6")));
		inv.setItem(16, genPerspectivePot("§9Russe", PotionType.STRENGTH, false,
				Arrays.asList("§9+ A une potion de force")));
		inv.setItem(15, genPerspective(Material.CARROT_ITEM, "§9Lapin", (byte) 0,
				Arrays.asList("§9+ A JumpBoost 6")));
		inv.setItem(16, genPerspectiveEnch(Material.INK_SACK, "§9Grampa", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
				Arrays.asList("§9+ Peut faire un gros recul")));
		inv.setItem(17, genPerspective(Material.IRON_INGOT, "§9Mineur", (byte) 0,
				Arrays.asList("§9+ Peut enflamer ses advairsaires")));
		
		//fire
		inv.setItem(18, genPerspectiveEnch(Material.STAINED_GLASS, "§e§lKits Fire",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 4));
		
		if(p.hasPermission("fireffa.fire") || p.isOp()){
			inv.setItem(19, genPerspectiveEnch(Material.CACTUS, "§9Cactus",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§9+ A Speed II et il renvoie une partie des dégâts")));
			inv.setItem(20, genPerspectiveEnch(Material.FEATHER, "§9Piaf", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§9+ Peu se propulser vers le ciel et ne prend pas de dégâts de chute")));
			inv.setItem(21, genPerspective(Material.TNT, "§9Djiadiste", (byte) 0,
					Arrays.asList("§9+ A un arc flame")));
			
		}else{
			inv.setItem(19, genPerspectiveEnch(Material.CACTUS, "§9Cactus",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§8Vous devez avoir le grade Fire !")));
			inv.setItem(20, genPerspectiveEnch(Material.BARRIER, "§9Piaf", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§8Vous devez avoir le grade Fire !")));
			inv.setItem(21, genPerspective(Material.TNT, "§9Djiadiste", (byte) 0,
					Arrays.asList("§8Vous devez avoir le grade Fire !")));
		}
		
		//ultra
		inv.setItem(27, genPerspectiveEnch(Material.STAINED_GLASS, "§6§lKits Ultra",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 1));
		
		if(p.hasPermission("fireffa.ultra") || p.isOp()){
			inv.setItem(28, genPerspectivePot("§9Fantôme", PotionType.INVISIBILITY, false, Arrays.asList("§9+ Est invisible", "§9- Ne possède pas d'armure")));
			inv.setItem(29, genPerspectiveEnch(Material.SKULL_ITEM, "§9Cactus",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§9+ A Speed II et il renvoie une partie des dégâts")));
			inv.setItem(30, genPerspectiveEnch(Material.BOW, "§9OITC Man",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§9+ Il oneshot ses enemis et il possède du Speed", "§9- Il n'a pas d'armure")));
		}else{
			inv.setItem(28, genPerspectiveEnch(Material.BARRIER, "§cFantôme",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 1,
					Arrays.asList("§8Vous devez avoir le grade Ultra !")));
			inv.setItem(29, genPerspectiveEnch(Material.CACTUS, "§cCactus",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§8Vous devez avoir le grade Ultra !")));
			inv.setItem(30, genPerspectiveEnch(Material.BOW, "§cOITC Man",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§8Vous devez avoir un grade Ultra")));
		}
		
		//ultimate
		inv.setItem(36, genPerspectiveEnch(Material.STAINED_GLASS, "§c§lKits Ultimate",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 14));
		
		if(p.hasPermission("fireffa.ultimate") || p.isOp()){
			inv.setItem(19, genPerspectiveEnch(Material.BARRIER, "§9Voleur d'âme", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§9+ Possède des pots")));
		}else{
			inv.setItem(19, genPerspectiveEnch(Material.BARRIER, "§9Voleur d'âme", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0,
					Arrays.asList("§8Vous devez avoir le grade Ultimate !")));
		}
		
		inv.setItem(45, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(46, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(47, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(48, genPerspective(Material.LEAVES, "§1", (byte) 0));
		
		inv.setItem(49, genPerspectiveEnch(Material.EMERALD, "Plugin by Glowstoner & _goldocelot_",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0));
		
		inv.setItem(50, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(51, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(52, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(53, genPerspective(Material.LEAVES, "§1", (byte) 0));
		
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
