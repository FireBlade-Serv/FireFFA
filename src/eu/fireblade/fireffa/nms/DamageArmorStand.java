package eu.fireblade.fireffa.nms;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

import eu.fireblade.fireffa.Main;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R3.World;

public class DamageArmorStand extends EntityArmorStand{
	
	private double damage;

	public DamageArmorStand(World world) {
		super(world);
	}
	
	public void spawn(CraftPlayer cp, double x, double y, double z, double damage) {
		initEntity();
		setLocation(x, y, z);
		setDamage(damage);
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
		this.setCustomName("§c- "+this.damage+" ❤");
		this.setCustomNameVisible(true);
		this.setGravity(false);
		this.setInvisible(true);
	}
	
	public void setLocation(double x, double y, double z) {
		this.setLocation(x, y, z);
	}
	
	public void setDamage(double damage) {
		this.damage = damage;
	}
	
	public PacketPlayOutSpawnEntityLiving constructEntityPacketAdd() {
		return new PacketPlayOutSpawnEntityLiving(this);
	}
	
	public void sendPacketRemove(CraftPlayer cp, PacketPlayOutEntityDestroy packetout) {
		cp.getHandle().playerConnection.sendPacket(packetout);
	}
	
	public PacketPlayOutEntityDestroy constructEntityPacketRemove() {
		return new PacketPlayOutEntityDestroy(getInstance().getId());
	}
	
	public PacketPlayOutEntityDestroy constructEntityPacketRemove(DamageArmorStand instance) {
		return new PacketPlayOutEntityDestroy(instance.getId());
	}
	
	public void sendPacketAdd(CraftPlayer cp, PacketPlayOutSpawnEntityLiving packetout) {
		cp.getHandle().playerConnection.sendPacket(packetout);
	}

	public DamageArmorStand getInstance() {
		return this;
	}
}
