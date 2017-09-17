package eu.fireblade.fireffa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.ability.Copy;
import eu.fireblade.fireffa.ability.Enderman;
import eu.fireblade.fireffa.ability.Gameur;
import eu.fireblade.fireffa.cmd.GUI;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.nms.DamageArmorStand;
import eu.fireblade.fireffa.sql.SQLConnectionFFA;
import eu.fireblade.fireffa.util.Methods;
import eu.fireblade.fireffa.util.Scoreboard;
import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Events implements Listener {
	
	public static ItemStack generateSkull(String owner) {
		
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		skullMeta.setOwner(owner);
		skullMeta.setDisplayName("§d"+owner);
		skull.setItemMeta(skullMeta);
		
		return skull;
	}

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		e.setJoinMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à rejoint le FireFFA !");
		
		Tp.tpSpawn(p);
		
		GlowstoneTitle gt = new GlowstoneTitle(p, "§6Bienvenue sur le FFA !", "§l"+p.getName(), 20, 50, 20);
		gt.send();
		
		Var.killStreak.put(p, 0);
		
		if(!SQLConnectionFFA.hasAccount(p)) {
			SQLConnectionFFA.createAccount(p);
		}
		
		Scoreboard.displayScoreboard(p);
		
		Kits.Clear(p);
		
		p.getInventory().setItem(4, Kits.ItemGen(Material.COMPASS, "§9Selectionner un kit", null, 1));
		p.getInventory().setHeldItemSlot(4);
		
		p.getInventory().setItem(0, Kits.ItemGen(Material.DIAMOND, "§9Infos", null, 1));
		p.getInventory().setItem(8, Kits.ItemGen(Material.EMERALD, "§9Crédits", null, 1));
		
		p.setLevel(0);
		
		p.setGameMode(GameMode.ADVENTURE);
		
		Methods.refreshTabRank(p);
	}
	
	@EventHandler
	public void onRain(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		final Player p = e.getPlayer();
		
		p.sendMessage("§6[§eFireFFA§6] §cVous ne pouvez pas drop des items !");
		p.playSound(p.getEyeLocation(), Sound.ITEM_BREAK, 30, 30);
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		
		e.setQuitMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à quitté le FireFFA !");
		
		Var.killStreak.remove(p);
		Var.inGame.remove(p);
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		final Entity entity = e.getEntity();
		final net.minecraft.server.v1_8_R3.Entity nmsentity = ((CraftEntity) entity).getHandle();
		final World w = entity.getWorld();
		final DamageCause cause = e.getCause();
		final Entity damager = e.getDamager();
		
		if(entity instanceof Player) {
			Player p = (Player) entity;
			
			if(!Var.inGame.contains(p)) {
				e.setCancelled(true);
				
				return;
			}
			
			w.playEffect(entity.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
		}
		
		if(nmsentity instanceof EntityArmorStand) {
			e.setCancelled(true);
			
			return;
		}
			
		if(cause.equals(DamageCause.BLOCK_EXPLOSION)) {
			if(entity instanceof Player) {
				Player v = (Player) entity;
				
				if(Var.panda.contains(v)) {
					return;
				}else if(Var.jihadist.contains(v)) {
					if(e.getDamage() >= 20) {
						return;
					}
				}
				
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) v, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
						entity.getLocation().getPitch(), entity.getLocation().getYaw(), e.getDamage());
				as.destroyAuto((CraftPlayer) v);
			}
		}else if(cause.equals(DamageCause.ENTITY_ATTACK)) {
			if(damager instanceof Player) {
				Player p = (Player) damager;
				
				if(Var.ogre.contains(p)) {
					return;
				}
				
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) p, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
						entity.getLocation().getPitch(), entity.getLocation().getYaw(), e.getDamage());
				as.destroyAuto((CraftPlayer) p);
			}
		}else if(cause.equals(DamageCause.ENTITY_EXPLOSION)) {
			if(entity instanceof Player) {
				Player v = (Player) entity;
				
				if(Var.panda.contains(v)) {
					return;
				}else if(Var.jihadist.contains(v)) {
					if(e.getDamage() >= 20) {
						return;
					}
				}
				
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) v, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
						entity.getLocation().getPitch(), entity.getLocation().getYaw(), e.getDamage());
				as.destroyAuto((CraftPlayer) v);
			}
		}else if(cause.equals(DamageCause.LIGHTNING)) {
			if(entity instanceof Player) {
				Player p = (Player) entity;
				
				if(Var.domination.contains(p)) {
					return;
				}
				
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) p, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
						entity.getLocation().getPitch(), entity.getLocation().getYaw(), e.getDamage());
				as.destroyAuto((CraftPlayer) p);
			}
		}else if(cause.equals(DamageCause.PROJECTILE)) {
			if(damager instanceof Arrow || damager instanceof Fireball || damager instanceof Snowball) {
				Projectile proj = (Projectile) damager;
				
				if(proj.getShooter() instanceof Player) {
					Player p = (Player) proj.getShooter();
					
					if(damager instanceof Snowball) {
						if(Var.flic.contains(p)) {
							DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
							as.spawn((CraftPlayer) p, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
									entity.getLocation().getPitch(), entity.getLocation().getYaw(), 3.0d);
							as.destroyAuto((CraftPlayer) p);
						}else if(Var.swap.contains(p)) {
							DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
							as.spawn((CraftPlayer) p, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
									entity.getLocation().getPitch(), entity.getLocation().getYaw(), "§lSWAP !");
							as.destroyAuto((CraftPlayer) p);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		final Entity entity = e.getEntity();
		final DamageCause cause = e.getCause();
		final World w = entity.getWorld();
		
		if(entity instanceof Player) {
			Player p = (Player) entity;
			
			if(!Var.inGame.contains(p)) {
				e.setCancelled(true);
				
				return;
			}
		}
		
		if(cause.equals(DamageCause.VOID)) {
			return;
		}else if(cause.equals(DamageCause.SUICIDE)) {
			return;
		}else if(cause.equals(DamageCause.FALL)) {
			if(entity instanceof Player);{
				Player p = (Player) entity;
				
				if(Var.nuage.contains(p) || Var.piaf.contains(p)) {
					return;
				}
				
				if(Enderman.nod.contains(p) || Copy.nod.contains(p) || Gameur.nod.contains(p)) {
					return;
				}
				
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) p, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
						entity.getLocation().getPitch(), entity.getLocation().getYaw(), e.getDamage());
				as.destroyAuto((CraftPlayer) p);
			}
		}else if(cause.equals(DamageCause.SUFFOCATION)) {
			e.setCancelled(true);
			
			return;
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Entity victime = e.getEntity();
		World w = victime.getWorld();
		
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
				
				SQLConnectionFFA.setKills(jawad, SQLConnectionFFA.getKills(jawad) + 1);
				
				IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \" + 1 KILL \"}");
				
				((CraftPlayer) jawad).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(icbc, (byte) 2));
				
				jawad.playSound(jawad.getLocation(), Sound.ORB_PICKUP, 30, 30);
				
				Methods.refreshRank(jawad);
				
				Scoreboard.displayScoreboard(jawad);
			}
			
			for(Player online : Bukkit.getOnlinePlayers()) {
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) online, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(),
						p.getLocation().getPitch(), p.getLocation().getYaw(), "§l+ 1 KILL");
					as.destroyAuto((CraftPlayer) online);
			}
		}catch(Exception ex){
			for(Player online : Bukkit.getOnlinePlayers()) {
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) online, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(),
						p.getLocation().getPitch(), p.getLocation().getYaw(), "§l+ 1 MORT");
					as.destroyAuto((CraftPlayer) online);
			}
		}finally {
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
					
					if(Var.inGame.contains(p)) {
						Var.inGame.remove(p);
					}
					
					Scoreboard.displayScoreboard(p);
					
					Kits.Clear(p);
					
					p.getInventory().setItem(4, Kits.ItemGen(Material.COMPASS, "§9Selectionner un kit", null, 1));
					p.getInventory().setHeldItemSlot(4);
					
					p.getInventory().setItem(0, Kits.ItemGen(Material.DIAMOND, "§9Infos", null, 1));
					p.getInventory().setItem(8, Kits.ItemGen(Material.EMERALD, "§9Crédits", null, 1));
				}
				
			}, 8L);
		}
	}
	
	@EventHandler
	public void onSaturationDown(FoodLevelChangeEvent e) {
		Player p = (Player) e.getEntity();
		
		if(!Var.inGame.contains(p)) {
			e.setFoodLevel(20);
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		
		if(!Var.inGame.contains(p)) {
			return;
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			@Override
			public void run() {
				Tp.tpSpawn(p);
				
				Kits.Clear(p);
				
				GUI.mainMenu(p);
				
				p.setLevel(0);
				
				Var.clearKitArray(p);
				
				Var.killStreak.replace(p, 0);
				
				if(Var.inGame.contains(p)) {
					Var.inGame.remove(p);
				}
				
				Scoreboard.displayScoreboard(p);
				
				Kits.Clear(p);
				
				p.getInventory().setItem(4, Kits.ItemGen(Material.COMPASS, "§9Selectionner un kit", null, 1));
				p.getInventory().setHeldItemSlot(4);
				
				p.getInventory().setItem(0, Kits.ItemGen(Material.DIAMOND, "§9Infos", null, 1));
				p.getInventory().setItem(8, Kits.ItemGen(Material.EMERALD, "§9Crédits", null, 1));
			}
			
		}, 10L);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		final SlotType slot = e.getSlotType();
		
		if(slot.equals(SlotType.QUICKBAR)) {
			e.setCancelled(true);
		}
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onHit(ProjectileHitEvent e) {
		final Entity entity = e.getEntity();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				entity.remove();
			}
			
		}, 1L);
	}
	
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		final ItemStack item = e.getItem();
		
		if(item.getItemMeta().getDisplayName().equals("§9Nourriture") && item.getType().equals(Material.CARROT_ITEM)) {
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
	@EventHandler(priority = EventPriority.MONITOR)
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
		final Entity kE = p.getKiller();
		
		if(!(kE instanceof Player)) {
			return;
		}
		
		Player k = (Player) kE;
	
		Var.killStreak.replace(k, Var.killStreak.get(k) + 1);	
		
		Scoreboard.displayScoreboard(k);
		
		if(Var.killStreak.get(k) % 5 == 0){
			Var.getKit(k);
			Bukkit.broadcastMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Le joueur "+k.getName()+" est en série de "+Var.killStreak.get(k)+" kill !");
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 5 kill, votre kit est reset !");
		}
		
		if(Var.killStreak.get(k) % 10 == 0) {
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 10 kill, vous obtenez résistance ");
			k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 0));
		}
		
		if(Var.killStreak.get(k) % 15 == 0) {
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 15 kill, vous obtenez régénération ! ");
			k.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0));
		}
		
		if(Var.killStreak.get(k) % 20 == 0) {
			k.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Bonus pour avoir fait 15 kill, vous obtenez force ! ");
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
			
			if(item.equals(Kits.ItemGen(Material.COMPASS, "§9Selectionner un kit", null, 1))) {
				GUI.mainMenu(p);
			}else if(item.equals(Kits.ItemGen(Material.DIAMOND, "§9Infos", null, 1))) {
				
				Inventory Info = Bukkit.createInventory(null, 9, ChatColor.BLUE+"Infos");
				
				Info.setItem(0, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Info.setItem(1, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Info.setItem(2, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Info.setItem(3, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Info.setItem(4, GUI.genPerspective(Material.INK_SACK, ChatColor.BLUE+"Discord", (byte) 4));
				Info.setItem(5, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Info.setItem(6, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Info.setItem(7, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Info.setItem(8, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				
				p.openInventory(Info);
				
			}else if(item.equals(Kits.ItemGen(Material.EMERALD, "§9Crédits", null, 1))) {
				
				Inventory Crédits = Bukkit.createInventory(null, 9, ChatColor.BLUE+"Développé par:");
				
				Crédits.setItem(0, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Crédits.setItem(1, generateSkull("baptistego"));
				Crédits.setItem(2, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Crédits.setItem(3, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Crédits.setItem(4, generateSkull("Glowstoner"));
				Crédits.setItem(5, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Crédits.setItem(6, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				Crédits.setItem(7, generateSkull("_goldocelot_"));
				Crédits.setItem(8, GUI.genPerspective(Material.LEAVES, "§1", (byte) 0));
				
				p.openInventory(Crédits);
				
			}
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
	
	@EventHandler
	public void onMelt(BlockFadeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		if(PermissionsEx.getUser(p).inGroup("Membre")){
		   Methods.setFormat(p, ChatColor.GRAY+"[Membre]", msg, e);
		}else if (PermissionsEx.getUser(p).inGroup("Fire")) {
			Methods.setFormat(p, ChatColor.YELLOW+"[Fire]", msg, e);
		}else if (PermissionsEx.getUser(p).inGroup("Ultra")) {
			Methods.setFormat(p, ChatColor.GOLD+"[Ultra]", msg, e);
		}else if (PermissionsEx.getUser(p).inGroup("Ultimate")) {
			Methods.setFormat(p,"§5[Ultimate]", msg, e);
		}
		
	}
}