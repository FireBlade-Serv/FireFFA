package eu.fireblade.fireffa.ability;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;

public class ArcherElementaire implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		final Entity victim = e.getEntity();
		final Entity jawad = e.getDamager();
		
		if(victim instanceof Player && jawad instanceof Arrow){
			Arrow arrow = (Arrow) jawad;
			
			Player p = (Player) victim;
			
			if(arrow.getShooter() instanceof Player){
				Player sniper = (Player) arrow.getShooter();
				
				if(Var.archerélémentaire.contains(sniper)){
					if(sniper.getItemInHand().equals(Kits.ItemGen(Material.BOW, ChatColor.GREEN+"Arc de glace", 
							Kits.LoreCreator(ChatColor.BLUE+"Ses fléches ralentissent et aveugles", ChatColor.BLUE+"Pendant 2 secondes"), 1))){
						
						p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 0));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 0));
						
						p.playSound(p.getEyeLocation(), Sound.PIG_DEATH, 30, 30);
						sniper.playSound(p.getEyeLocation(), Sound.IRONGOLEM_HIT, 30, 30);
					}
				}
			}
		}
	}

}
