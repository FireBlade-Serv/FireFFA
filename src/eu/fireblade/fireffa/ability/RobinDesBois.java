package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class RobinDesBois implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e){
		final Player p = e.getPlayer();
		final Player t = e.getTarget();
		final ItemStack i = e.getItemInHand();
		
		if(Var.robindesbois.contains(p) && i.equals(Kits.ItemGen1(Material.WOOD_SWORD, Enchantment.DAMAGE_ALL, 1, "�9�p�e des bois", 
				Kits.LoreCreator("�9clique droit - vole un item al�atoire au joueur", "�930 secondes de r�cup�ration"), 1))){
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"�6[�eFireFFA�6] "+ChatColor.RED+"Vous �tes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}else {
				ItemStack[] targetItem = t.getInventory().getContents();
				ItemStack[] targetArmor = t.getInventory().getArmorContents();
				Random r = new Random();
				int iOra = r.nextInt(1);
				if (iOra == 0) {
					Random r2 = new Random();
					int Itemx = r2.nextInt(targetItem.length);
					if (Itemx > r2.nextInt(targetItem.length) - 1) {
						Itemx--;
					}
					t.getInventory().remove(targetItem[Itemx]);
					p.getInventory().addItem(targetItem[Itemx]);
				} else if(iOra == 1) {
					Random r3 = new Random();
					int Armorx = r3.nextInt(targetArmor.length);
					if (Armorx > r3.nextInt(targetItem.length) - 1) {
						Armorx--;
					}
					t.getInventory().remove(targetArmor[Armorx]);
					p.getInventory().addItem(targetArmor[Armorx]);
				}
				targetItem = null;
				targetArmor = null;
				cooldown.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.robindesbois.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "�9Votre attaque est pr�te !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						if(cooldown.contains(p)) {
							cooldown.remove(p);
						}			
					}									
				}, 600L);
			}
		}
	}
}