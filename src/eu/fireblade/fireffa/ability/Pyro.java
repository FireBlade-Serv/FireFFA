package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Pyro implements Listener {
	
	public static HashMap<Player, Integer> tasks = new HashMap<Player, Integer>();
	public static ArrayList<Player> inLoad = new ArrayList<Player>();

	@EventHandler
	public void onInteract (PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		
		if((a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) && 
				e.getItem().equals(Kits.ItemGen1(Material.WOOD_SWORD, Enchantment.FIRE_ASPECT, 1, ChatColor.RED+"Épée lanceuse de boules de feu", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une boule de feu"), 1)) && Var.pyro.contains(p)){
			
			if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.FIREBALL, ChatColor.RED+"Boule de feu", null, 1), 1)) {
				if(inLoad.contains(p)) {
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous avez déjà une boulle de feu en execution !");
					
					return;
				}
				
				p.launchProjectile(Fireball.class);
				p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
				p.getInventory().removeItem(Kits.ItemGen(Material.FIREBALL, ChatColor.RED+"Boule de feu", null, 1));
			} else {
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous n'avez plus de boule de feu.");
			}
		}
	}
	
	@EventHandler
	public void onLaunch(ProjectileLaunchEvent e) {
		final Entity entity = e.getEntity();
		final World w = entity.getWorld();
		
		if(entity instanceof Fireball) {
			final Fireball ar = (Fireball) entity;
			
			if(ar.getShooter() instanceof Player) {
				final Player p = (Player) ar.getShooter();
				
				if(!Var.pyro.contains(p)) {
					return;
				}
				
				if(!tasks.containsKey(p)) {
					tasks.put(p, 0);
				}
				
				if(inLoad.contains(p)) {					
					return;
				}
				
				final Entity truc = w.spawn(ar.getLocation(), ArmorStand.class);
				
				ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				SkullMeta skullM = (SkullMeta) skull.getItemMeta();
				skullM.setOwner("Satan");
				skull.setItemMeta(skullM);
				
				ArmorStand as = (ArmorStand) truc;
				
				as.setCustomName("§6§lTES TAS TOS");
				as.setCustomNameVisible(true);
				as.setVisible(false);
				as.setArms(true);
				as.setBasePlate(false);
				as.setGravity(false);
				as.setItemInHand(Kits.ItemGen(Material.IRON_SWORD, "badaboom", null, 1));
				
				as.setHelmet(skull);
				as.setChestplate(Kits.ItemGenColorLeather(Material.LEATHER_CHESTPLATE, "tes tas tos", 1, 89, 38, 38));
				as.setLeggings(Kits.ItemGenColorLeather(Material.LEATHER_LEGGINGS, "tes tas tos", 1, 89, 38, 38));
				as.setBoots(Kits.ItemGenColorLeather(Material.LEATHER_BOOTS, "tes tas tos", 1, 89, 38, 38));
				
				ar.setPassenger(truc);
				
				w.playSound(ar.getLocation(), Sound.BLAZE_BREATH, 30, 30);
				
				inLoad.add(p);
				
				tasks.replace(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(ar.isDead() || ar.equals(null) || ((CraftEntity)ar).getHandle().onGround) {
							ar.remove();
							truc.remove();
							
							inLoad.remove(p);
							
							Bukkit.getScheduler().cancelTask(tasks.get(p));
						}else {
							PacketPlayOutWorldParticles ppowp = new PacketPlayOutWorldParticles(EnumParticle.LAVA, true,
									(float) entity.getLocation().getX(), (float) entity.getLocation().getY(), (float) entity.getLocation().getZ(), 1, 1, 1, 1, 30);
							
							for(Player online : Bukkit.getOnlinePlayers()) {
								((CraftPlayer)online).getHandle().playerConnection.sendPacket(ppowp);
							}
						}
					}
					
				}, 0L, 3L));
			}
		}
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Fireball){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEntityFire(ExplosionPrimeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Fireball){
			e.setFire(false);
		}
	}
	
}
