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
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class GUI implements CommandExecutor {

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
		
		inv.setItem(31, genPerspective(Material.STAINED_GLASS, "§f§lKits Membre/FFA", (byte) 0));
		inv.setItem(13, genPerspectiveEnch(Material.STAINED_GLASS, "§e§lKits Fire",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 4));
		inv.setItem(14, genPerspectiveEnch(Material.STAINED_GLASS, "§c§lKits Ultimate",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 14));
		inv.setItem(12, genPerspectiveEnch(Material.STAINED_GLASS, "§6§lKits Ultra",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 1));
		
		p.openInventory(inv);
	}
	
	public static void ffaMenu(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§9Kits FireFFA");
		
		inv.setItem(36, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(37, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(38, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(39, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(44, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(43, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(42, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(41, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(52, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(51, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(46, genPerspective(Material.LEAVES, "§1", (byte) 0));
		inv.setItem(47, genPerspective(Material.LEAVES, "§1", (byte) 0));
		
		inv.setItem(45, genPerspective(Material.STAINED_GLASS, "§f§lMenu Principal", (byte) 0));
		inv.setItem(53, genPerspective(Material.STAINED_GLASS, "§f§lMenu Principal", (byte) 0));
		
		//vagabond
		inv.setItem(0, genPerspective(Material.STAINED_GLASS, "§b§lKits Vagabond", (byte) 3));
		inv.setItem(9, genPerspective(Material.STONE_SWORD, "§9Kit Chevalier", (byte) 0));
		inv.setItem(18, genPerspective(Material.BLAZE_POWDER, "§9Kit Magicien", (byte) 0));
		inv.setItem(27, genPerspective(Material.BOW, "§9Kit Archer Vagabond", (byte) 0));
		
		//inquisiteur
		inv.setItem(1, genPerspective(Material.STAINED_GLASS, "§e§lKits Inquisiteur", (byte) 4));
		inv.setItem(10, genPerspective(Material.IRON_INGOT, "§9Kit Mineur", (byte) 0));
		inv.setItem(19, genPerspective(Material.SUGAR_CANE, "§9Kit Panda", (byte) 0));
		inv.setItem(28, genPerspective(Material.LEATHER_HELMET, "§9Kit Ours", (byte) 0));
		
		//meurtrier
		inv.setItem(2, genPerspective(Material.STAINED_GLASS, "§5§lKits Meurtrier", (byte) 2));
		inv.setItem(11, genPerspectiveEnch(Material.GOLD_HELMET, "§9Kit Tank", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0));
		inv.setItem(20, genPerspectiveEnch(Material.STICK, "§9Kit Flic", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0));
		inv.setItem(29, genPerspective(Material.SHEARS, "§9Kit Assassin", (byte) 0));
		
		//mercenaire
		inv.setItem(3, genPerspective(Material.STAINED_GLASS, "§a§lKits Mercenaire", (byte) 5));
		//inv.setItem(12, genPerspective(Material.CARROT_ITEM, "§9Lapin", (byte) 0,
		//		Arrays.asList("§9+ A JumpBoost VI")));
		inv.setItem(12, genPerspective(Material.FERMENTED_SPIDER_EYE, "§9Kit Guerrier Galactique", (byte) 0));
		inv.setItem(21, genPerspectiveEnch(Material.RED_MUSHROOM, "§9Kit Gameur", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		inv.setItem(30, genPerspective(Material.CAKE, "§9Kit Patissier", (byte) 0));
		
		//bourreau
		inv.setItem(4, genPerspective(Material.STAINED_GLASS, "§9§lKits Bourreau", (byte) 11));
		inv.setItem(13, genPerspectiveEnch(Material.INK_SACK, "§9Kit Grampa", Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 0));
		inv.setItem(22, genPerspective(Material.STONE_AXE, "§9Kit Boucher", (byte) 0));
		inv.setItem(31, genPerspectiveEnch(Material.LEASH, "§9Kit Esclave", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		
		//executeur
		inv.setItem(5, genPerspective(Material.STAINED_GLASS, "§1§lKits Executeur", (byte) 13));
		inv.setItem(14, genPerspective(Material.PORK, "§9Kit Sauvage", (byte) 0));
		inv.setItem(23, genPerspectiveLeatherColor(Material.LEATHER_HELMET, "§9Kit Archer d'élite", 1, 114, 113, 57));
		inv.setItem(32, genPerspectiveEnch(Material.SEEDS, "§9Kit Moutarde", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		
		//sanguinaire
		inv.setItem(6, genPerspective(Material.STAINED_GLASS, "§c§lKits Sanguinaire", (byte) 14));
		inv.setItem(15, genPerspectiveEnch(Material.WOOD_SWORD, "§9Kit Pyro", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		inv.setItem(24, genPerspectiveSkullItem("§9Kit Enderman", "MHF_Enderman"));
		inv.setItem(33, genPerspective(Material.SAPLING, "§9Kit Robin des bois", (byte) 0));
		
		//massacreur
		inv.setItem(7, genPerspective(Material.STAINED_GLASS, "§6§lKits Massacreur", (byte) 1));
		inv.setItem(16, genPerspective(Material.RAW_FISH, "§9Kit Ocelot", (byte) 0));
		inv.setItem(25, genPerspective(Material.BRICK, "§9Kit Rulio", (byte) 0));
		inv.setItem(34, genPerspectiveEnch(Material.REDSTONE_COMPARATOR, "§9Kit Mathématicien", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		
		//déchiqueteur
		inv.setItem(8, genPerspective(Material.STAINED_GLASS, "§7§lKits Déchiqueteur", (byte) 8));
		inv.setItem(17, genPerspectiveEnch(Material.TORCH, "§9Kit FuriCat", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		inv.setItem(26, genPerspective(Material.COMPASS, "§9Kit Timer", (byte) 0));
		inv.setItem(35, genPerspectiveEnch(Material.IRON_TRAPDOOR, "§9Kit TrapMan", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		
		//deathgod
		inv.setItem(40, genPerspective(Material.STAINED_GLASS, "§0§lKits DeathGod", (byte) 15));
		inv.setItem(50, genPerspectiveLeatherColor(Material.LEATHER_CHESTPLATE, "§9Kit Démolisseur", 1, 89, 38, 38));
		inv.setItem(49, genPerspectiveEnch(Material.DETECTOR_RAIL, "§9Kit Informaticien", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		inv.setItem(48, genPerspectiveEnch(Material.STICK, "§9Kit Gandalf", Enchantment.PROTECTION_ENVIRONMENTAL, 1,(byte) 0));
		
		
		p.openInventory(inv);
	}
	
	public static void fireMenu(Player p){
		Inventory inv = Bukkit.createInventory(null, InventoryType.ENCHANTING, "test");
		
		p.openInventory(inv);
	}

	public static ItemStack genPerspective(Material m, String name, byte data){
		ItemStack item = new ItemStack(m, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack genPerspectiveEnch(Material m, String name, Enchantment ench, int lvl, byte data){
		ItemStack item = new ItemStack(m, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(ench, lvl, true);
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack genPerspectivePot(String name, PotionType pt, boolean setsplash, List<String> list){
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
	
	public static ItemStack genPerspectiveLeatherColor(Material leatherPiece, String n, int nombre, int red, int green, int blue) {
		ItemStack item = new ItemStack(leatherPiece);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setDisplayName(n);
		meta.setColor(Color.fromBGR(blue, green, red));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.spigot().setUnbreakable(true);
		item.setItemMeta(meta);
		
		return item;
	}
	
	public static ItemStack genPerspectiveSkullItem(String name, String owner){
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
		skullMeta.setOwner(owner);
		skullMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		skullMeta.setDisplayName(name);
		item.setItemMeta(skullMeta);
		
		return item;
	}
}
