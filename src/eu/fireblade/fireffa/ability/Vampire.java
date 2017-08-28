package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PathEntity;

public class Vampire implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();	
	
	public static Map<Player, Entity> bats = new HashMap<Player, Entity>();
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(item.equals(Kits.ItemGen(Material.INK_SACK, "§5Transformation", 
				Kits.LoreCreator("§9Clique droit - te transforme en chauve souris", "§940 secondes de récupération"), 1))) {
			
			if(!Var.vampire.contains(p)) {
				return;
			}
			
			Bat bat = (Bat) p.getWorld().spawn(p.getLocation(), Bat.class);
			
			Entity nmsEntity = ((CraftEntity) bat).getHandle();

	        NBTTagCompound tag = new NBTTagCompound();

	        nmsEntity.c(tag);

	        tag.setBoolean("NoAI", true);

	        EntityLiving el = (EntityLiving) nmsEntity;
	        el.a(tag);
			
			bats.put(p, nmsEntity);
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		
		if(Var.vampire.contains(p)) {
			if(bats.containsKey(p)) {
				move(bats.get(p), p.getEyeLocation(), 2.0d);
			}
		}
	}
	
	private static void move(Entity entity, Location location, double speed) {
	    Object pObject = entity;
	 
	    PathEntity path = ((EntityInsentient)pObject).getNavigation().a(location.getX(),
	      location.getY(), location.getZ());
	    if (path != null)
	    {
	      ((EntityInsentient)pObject).getNavigation().a(path, 2.0D);
	      ((EntityInsentient)pObject).getNavigation().a(new Double(speed));
	    }
	}
}
