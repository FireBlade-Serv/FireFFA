package eu.fireblade.fireffa.nms;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

import eu.fireblade.fireffa.Main;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R3.World;

public class DamageArmorStand{
	
	private EntityArmorStand entity;
	private double damage;

	public DamageArmorStand(World world) {
		this.entity = new EntityArmorStand(world);
	}
	
	public void spawn(CraftPlayer cp, double x, double y, double z, float pitch, float yaw, double damage) {
		setLocation(x, y, z, pitch, yaw);
		setDamage(damage);
		initEntity();
		sendPacketAdd(cp, constructEntityPacketAdd());
	}
	
	public void spawn(CraftPlayer cp, double x, double y, double z, float pitch, float yaw, String text) {
		setLocation(x, y, z, pitch, yaw);
		initEntityText(text);
		sendPacketAdd(cp, constructEntityPacketAdd());
	}
	
	public void destroyAuto(CraftPlayer cp) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				sendPacketRemove(cp, constructEntityPacketRemove());
			}
			
		}, 15L);
	}
	
	public void destroy(CraftPlayer cp) {
		sendPacketRemove(cp, constructEntityPacketRemove());
	}
	
	public void destroy(CraftPlayer cp, DamageArmorStand instance) {
		sendPacketRemove(cp, constructEntityPacketRemove(instance));
	}
	
	public void initEntity() {
		this.entity.setCustomName("§c§l- "+this.damage+" ❤");
		this.entity.setCustomNameVisible(true);
		this.entity.setGravity(false);
		this.entity.setInvisible(true);
	}
	
	public void initEntityText(String text) {
		this.entity.setCustomName(text);
		this.entity.setCustomNameVisible(true);
		this.entity.setGravity(false);
		this.entity.setInvisible(true);
	}
	
	public void setLocation(double x, double y, double z, float pitch, float yaw) {
		this.entity.setLocation(x, y, z, pitch, yaw);
	}
	
	public void setDamage(double damage) {
		this.damage = damage;
	}
	
	public PacketPlayOutSpawnEntityLiving constructEntityPacketAdd() {
		return new PacketPlayOutSpawnEntityLiving(this.entity);
	}
	
	public void sendPacketRemove(CraftPlayer cp, PacketPlayOutEntityDestroy packetout) {
		cp.getHandle().playerConnection.sendPacket(packetout);
	}
	
	public PacketPlayOutEntityDestroy constructEntityPacketRemove() {
		return new PacketPlayOutEntityDestroy(getInstance().entity.getId());
	}
	
	public PacketPlayOutEntityDestroy constructEntityPacketRemove(DamageArmorStand instance) {
		return new PacketPlayOutEntityDestroy(instance.entity.getId());
	}
	
	public void sendPacketAdd(CraftPlayer cp, PacketPlayOutSpawnEntityLiving packetout) {
		cp.getHandle().playerConnection.sendPacket(packetout);
	}

	public DamageArmorStand getInstance() {
		return this;
	}
}
