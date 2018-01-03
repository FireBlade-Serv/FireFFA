package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftArrow;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class ArcherElementaire implements Listener {
	
	public static Map<Player, Integer> tasks = new HashMap<Player, Integer>();
	public static ArrayList<Player> inLoad = new ArrayList<Player>();
	
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
	
	@EventHandler
	public void onShoot(ProjectileLaunchEvent e) {
		final Entity entity = e.getEntity();
		
		if(entity instanceof Arrow) {
			final Arrow ball = (Arrow) entity;
			
			if(ball.getShooter() instanceof Player) {
				Player p = (Player) ball.getShooter();
				
				if(!Var.archerélémentaire.contains(p)) {
					return;
				}
				
				if(!tasks.containsKey(p)) {
					tasks.put(p, 0);
				}
				
				if(inLoad.contains(p)) {	
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous avez déjà une flèche en execution !");
					
					p.getInventory().addItem(Kits.ItemGen(Material.ARROW, ChatColor.GREEN+"Fléche de l'arche élémentaire", null, 1));
					
					e.setCancelled(true);
					
					return;
				}
				
				inLoad.add(p);
				
				tasks.replace(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(ball.isDead() || ball.equals(null) || ((CraftArrow) ball).isOnGround()) {
							inLoad.remove(p);
							
							Bukkit.getScheduler().cancelTask(tasks.get(p));
						}else {
							PacketPlayOutWorldParticles ppowp = new PacketPlayOutWorldParticles(EnumParticle.SMOKE_NORMAL, true,
									(float) entity.getLocation().getX(), (float) entity.getLocation().getY(), (float) entity.getLocation().getZ(), 0, 0, 0, 0, 30);
							
							for(Player online : Bukkit.getOnlinePlayers()) {
								((CraftPlayer)online).getHandle().playerConnection.sendPacket(ppowp);
							}
						}
					}
					
				}, 0L, 1L));
			}
		}
	}
	
	@EventHandler
	public void onBump(ProjectileLaunchEvent e) {
		final Entity entity = e.getEntity();
		
			if(entity instanceof Arrow) {
				final Arrow ball = (Arrow) entity;
				
				if(ball.getShooter() instanceof Player) {
					Player p = (Player) ball.getShooter();
				
				if(!Var.archerélémentaire.contains(p)) {
					return;
				}
				
				if(p.getItemInHand().equals(Kits.ItemGen1(Material.BOW, Enchantment.ARROW_KNOCKBACK, 5, ChatColor.GREEN+"Arc des adieux", Kits.LoreCreator(ChatColor.BLUE+"Tirer normalement pour utiliser",ChatColor.BLUE+"5 secondes de récupération"), 1))){
					p.getInventory().setItem(0, Kits.ItemGen(Material.BARRIER, ChatColor.RED+"En récupération", Kits.LoreCreator(ChatColor.BLUE+"5 secondes de récupération", null), 1));
					p.playSound(p.getLocation(), Sound.FUSE, 30, 30);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.archerélémentaire.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre arc est prêt !", 20, 30, 20);
								gt.send();
								p.getInventory().setItem(0, Kits.ItemGen1(Material.BOW, Enchantment.ARROW_KNOCKBACK, 5, ChatColor.GREEN+"Arc des adieux", Kits.LoreCreator(ChatColor.BLUE+"Tirer normalement pour utiliser",ChatColor.BLUE+"5 secondes de récupération"), 1));
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
						}						
					}, 100L);
				}
			}
		}
	}
}