package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Glowstone implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	public static HashMap<Player, Integer> tasks = new HashMap<Player, Integer>();
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e) {
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		
		if(item.equals(Kits.ItemGen(Material.TORCH, "§9L'aveugleur", Kits.LoreCreator("§9Clique droit - aveugle 5 secondes", "§920 secondes de récupération"), 1))) {
			
			if(Var.glowstone.contains(p)) {
				if(cooldown.contains(p)) {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else {
					effect(p, target);
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.glowstone.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
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
	
	public static void particles(final Player p, World w) {
		if(tasks.containsKey(p)) {
			Bukkit.getScheduler().cancelTask(tasks.get(p));
			
			tasks.remove(p);
		}
		
		tasks.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				PacketPlayOutWorldParticles ppowp = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true,
						(float) p.getLocation().getX(), (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 0, 0, 0, 0, 20);
				
				for(Player online : Bukkit.getOnlinePlayers()) {
					((CraftPlayer)online).getHandle().playerConnection.sendPacket(ppowp);
				}
			}
				
		}, 140L, 3L));
	}
	
	private static void effect(Player p, Player target) {
		p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
		
		target.playSound(p.getLocation(), Sound.LAVA_POP, 30, 30);
		
		target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
	}
}
