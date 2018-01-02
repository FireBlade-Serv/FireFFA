package eu.fireblade.fireffa.ability;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.nms.DamageArmorStand;
import net.md_5.bungee.api.ChatColor;

public class Ogre implements Listener {
  
	@EventHandler
	public void onDamage (EntityDamageByEntityEvent e) {
		Entity d = e.getDamager();
		Entity t = e.getEntity();
		World w = d.getWorld();
		
		if(d.getType().equals(EntityType.PLAYER) && t.getType().equals(EntityType.PLAYER)) {
			Player dp = (Player) d;
			Player tp = (Player) t;
			
			if(!Var.ogre.contains(dp)) {
				return;
			}
			
			if(dp.getItemInHand().equals(Kits.ItemGen1(Material.LEVER, Enchantment.DAMAGE_ALL, 1, "§2Massue", 
					Kits.LoreCreator("§9Vous avez 35% de chance de faire plus de dégats", null), 1))){
				
				
				int random = ThreadLocalRandom.current().nextInt(100);
				
				if (random <= 35) {
					e.setDamage(6.25d);
					
					dp.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous avez infligé un gros coup.");
					dp.playSound(dp.getLocation(), Sound.GHAST_DEATH, 30, 30);
					tp.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Le joueur "+ dp.getName() +"vous a infligé un gros coup.");
					tp.playSound(dp.getLocation(), Sound.GHAST_DEATH, 30, 30);
					
					DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
					as.spawn((CraftPlayer) dp, tp.getLocation().getX(), tp.getLocation().getY(), tp.getLocation().getZ(),
							tp.getLocation().getPitch(), tp.getLocation().getYaw(), e.getDamage());
					as.destroyAuto((CraftPlayer) dp);
				}
			}
		}
	}
}
