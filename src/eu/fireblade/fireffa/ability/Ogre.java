package eu.fireblade.fireffa.ability;


import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;

public class Ogre implements Listener {
  
	@EventHandler
	public void onDamage (EntityDamageByEntityEvent e) {
		Entity d = e.getDamager();
		Entity t = e.getEntity();
		
		if(d.getType().equals(EntityType.PLAYER) && t.getType().equals(EntityType.PLAYER) && Var.ogre.contains(d)) {
			Player dp = (Player) d;
			Player tp = (Player) t;
			
			if(dp.getItemInHand().equals(Kits.ItemGen1(Material.LEVER, Enchantment.DAMAGE_ALL, 1, "�9Massue", Kits.LoreCreator("�9Vous avez 15% de chance de faire plus de d�gat", null), 1))){
				
				Random r = new Random();
				int rn = 0 + r.nextInt(100);
				if (rn <= 15) {
					tp.damage(6.25);
				}
			}
		}
	  
  }
}
