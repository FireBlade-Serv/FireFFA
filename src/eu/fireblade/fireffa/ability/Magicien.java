package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Magicien implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onDamage(PlayerInteractAtEntityEvent e){
		final Player jawadV2 = e.getPlayer();
		final Entity boloss = e.getRightClicked();
		
		if(boloss instanceof Player){
			Player bolossV2 = (Player) boloss;
			
			if(Var.magicien.contains(jawadV2)){
				if(jawadV2.getItemInHand().equals(Kits.ItemGen2(Material.STICK, Enchantment.KNOCKBACK, 3, Enchantment.DAMAGE_ALL, 2,
						ChatColor.BLUE+"Baguette magique", Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Ralentit et aveugle",
								ChatColor.BLUE+"Consomme une poudre magique"), 1))){
					
					if(jawadV2.getInventory().containsAtLeast(Kits.ItemGen(Material.BLAZE_POWDER, ChatColor.BLUE+"Poudre magique", null, 1), 1)){
						if(cooldown.contains(jawadV2)){
							jawadV2.sendMessage(ChatColor.GOLD+"[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
							jawadV2.playSound(jawadV2.getLocation(), Sound.ITEM_BREAK, 30, 30);
							
							return;
						}else{
							damage(bolossV2);
							
							jawadV2.getInventory().remove(Kits.ItemGen(Material.BLAZE_POWDER, ChatColor.BLUE+"Poudre magique", null, 1));
							
							cooldown.add(jawadV2);
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

								@Override
								public void run() {
									if(Var.magicien.contains(jawadV2)){
										GlowstoneTitle gt = new GlowstoneTitle(jawadV2, "", "§9Votre attaque est prête !", 20, 30, 20);
										gt.send();
										
										jawadV2.playSound(jawadV2.getLocation(), Sound.ORB_PICKUP, 30, 30);
									}
									
									cooldown.remove(jawadV2);
								}
								
							}, 100L);
						}
					}else{
						jawadV2.playSound(jawadV2.getLocation(), Sound.ITEM_BREAK, 30, 30);
						
						jawadV2.sendMessage(ChatColor.GOLD+"[§eFireFFA§6] "+ChatColor.RED+"Vous n'avez plus de poudre magique.");
					}
				}
			}
		}
	}
	
	private static void damage(Player victime){
		victime.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 1));
		victime.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 1));
		
		victime.sendMessage("[§eFireFFA§6] §fUn magicien vous à lancé un mauvais sort !");
	}

}
