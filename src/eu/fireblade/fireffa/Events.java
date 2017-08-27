package eu.fireblade.fireffa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.cmd.GUI;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.util.Scoreboard;
import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class Events implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		e.setJoinMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à rejoint le FireFFA !");
		
		Tp.tpSpawn(p);
		
		GlowstoneTitle gt = new GlowstoneTitle(p, "§6Bienvenue sur le FFA !", "§l"+p.getName(), 20, 50, 20);
		gt.send();
		
		Scoreboard.displayScoreboard(p);
		
		Var.killStreak.put(p, 0);
	}
	
	@EventHandler
	public void onRain(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		
		e.setQuitMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à quitté le FireFFA !");
		
		Var.killStreak.remove(p);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		final Entity entity = e.getEntity();
		final World w = entity.getWorld();
		final double damage = e.getDamage();
		
		if(entity instanceof Player) {
			w.playEffect(entity.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
		}
		
		if(entity instanceof ArmorStand) {
			e.setCancelled(true);
			
			return;
		}
		
		Entity eNas = w.spawn(entity.getLocation().add(0.0d, 0.3d, 0.0d), ArmorStand.class);
		
		ArmorStand as = (ArmorStand) eNas;
		
		as.setCustomName("§c§l - "+damage+" ❤");
		as.setCustomNameVisible(true);
		as.setVisible(false);
		as.setGravity(false);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				as.remove();
			}
			
		}, 10L);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Entity victime = e.getEntity();
		
		if(!(victime instanceof Player)){
			return;
		}
		
		
		
		Player p = (Player) victime;
		
		try{
			Player jawad = p.getKiller();
		
			if(!jawad.equals(p)){
				if(jawad.getHealth() >= 14){
					jawad.setHealth(jawad.getMaxHealth());
				}else{
					jawad.setHealth(jawad.getHealth() + 6);
				}
			}
		}catch(Exception ex){}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){
			
            public void run(){
                if(p.isDead()){
                	PacketPlayInClientCommand packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
                	
                	 ((CraftPlayer) p).getHandle().playerConnection.a(packet);
                }
            }
            
        });
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			@Override
			public void run() {
				Tp.tpSpawn(p);
				
				Kits.Clear(p);
				
				GUI.mainMenu(p);
				
				p.setLevel(0);
				
				Var.clearKitArray(p);
				
				Var.killStreak.replace(p, 0);
				
				Scoreboard.displayScoreboard(p);
			}
			
		}, 10L);
	}
	
	@EventHandler
	public void onHit(ProjectileHitEvent e) {
		final Entity entity = e.getEntity();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				entity.remove();
			}
			
		}, 3L);
	}
	
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		final ItemStack item = e.getItem();
	
		if(item.getType().equals(Material.CARROT_ITEM)) {
			return;
		}
		
		if(item.getType().equals(Material.POTION)) {
			return;
		}
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerRightClickPlayer(PlayerInteractAtEntityEvent e){
		final Player p = e.getPlayer();
		final Entity entity = e.getRightClicked();
		
		if(entity instanceof Player){
			Player target = (Player) entity;
			
			Bukkit.getPluginManager().callEvent(new eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent(p, target, p.getItemInHand(), p.getWorld()));
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onKill(PlayerDeathEvent e){
		final Player entity = e.getEntity();
		final Player jawad = entity.getKiller();
		
		if(jawad instanceof Player){
			Bukkit.getPluginManager().callEvent(new eu.fireblade.fireffa.events.PlayerKillEvent(entity, jawad, jawad.getItemInHand(), entity.getWorld()));
		}
	}
	
	@EventHandler
	public void onKillStreak(PlayerDeathEvent e){
		final Player p = e.getEntity();
		final Player k = p.getKiller();
	
		Var.killStreak.replace(k, Var.killStreak.get(k) + 1);	
		
		Scoreboard.displayScoreboard(k);
		
		if(Var.killStreak.get(k) % 5 == 0){
			Var.getKit(k);
			Bukkit.broadcastMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Le joueur "+k.getName()+" est en série de "+Var.killStreak.get(k)+" kill !");
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 5 kill, votre kit est reset !");
		}else if(Var.killStreak.get(k) % 10 == 0) {
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 10 kill, vous obtenez résistance ");
			k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 0));
		}else if(Var.killStreak.get(k) % 15 == 0) {
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 15 kill, vous obtenez régénération ! ");
			k.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0));
		}else if(Var.killStreak.get(k) % 20 == 0) {
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 15 kill, vous obtenez régénération ! ");
			k.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0));
		}
	}

	@EventHandler
	public void onRightClickInteract(PlayerInteractEvent e){
		final Action a = e.getAction();
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)){
			Bukkit.getPluginManager().callEvent(new eu.fireblade.fireffa.events.PlayerRightClickInteractEvent(p, item, p.getWorld()));
		}
	}
	
	@EventHandler
	public void onDamageEvent(EntityDamageEvent e) {
		final Entity entity = e.getEntity();
		final World w = entity.getWorld();
		final double damage = e.getDamage();
		final DamageCause cause = e.getCause();
		
		if(entity instanceof Player) {
			Player p = (Player) entity;
			
			Bukkit.getPluginManager().callEvent(new eu.fireblade.fireffa.events.PlayerDamageEvent(p, w, damage, cause));
		}
	}
}