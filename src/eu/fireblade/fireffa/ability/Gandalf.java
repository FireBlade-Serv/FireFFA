package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Gandalf implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerClick(PlayerInteractAtPlayerEvent e){
		Player p = e.getPlayer();
		Player t = e.getTarget();
		ItemStack i = e.getItemInHand();
		
		if(Var.gandalf.contains(p) && i.equals(Kits.ItemGen2(Material.STICK, Enchantment.DAMAGE_ALL, 3, Enchantment.KNOCKBACK, 2, "�9You Shall Not Pass", 
				Kits.LoreCreator("�9Clique droit - �jecte le joueur", "�920 secondes de r�cup�ration"), 1))) {
			
			if(!cooldown.contains(p)) {
			
				cooldown.add(p);
				Vector vector = p.getLocation().getDirection().add(new Vector(0.f, 1.0f, 0.0f));
				t.setVelocity(vector);
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 30, 30);
				t.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 30, 30);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){
				
					@Override
					public void run() {
						if(Var.gandalf.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "�9Votre attaque est pr�te !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						
						}
					
						if(cooldown.contains(p)) {
							cooldown.remove(p);
						}
					}
				
				}, 100L);
			} else {
				p.sendMessage(ChatColor.GOLD+"�6[�eFireFFA�6] "+ChatColor.RED+"Vous �tes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}
		}
	}
}
