package eu.fireblade.fireffa.ability.nms;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityBat;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityTypes;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PathEntity;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;

public class VampireObject extends EntityBat{

	public VampireObject(Location loc) {
		super(((CraftWorld)loc.getWorld()).getHandle());
		
		try {
            Field b = PathfinderGoalSelector.class.getDeclaredField("b");
            b.setAccessible(true);
            
            Field c = PathfinderGoalSelector.class.getDeclaredField("c");
            c.setAccessible(true);
   
            b.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            b.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
            
            c.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            c.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            
            Field a = PathfinderGoalSelector.class.getDeclaredField("a");
            
            a.setAccessible(true);
            
		} catch (Exception e) {
            e.printStackTrace();
		}
		
		NBTTagCompound nbt = new NBTTagCompound();
		
		this.c(nbt);
		
		nbt.setBoolean("NoAI", true);
		
		EntityLiving el = this;
		
		el.a(nbt);
	}
	
	@Override
	protected void initAttributes() {
		super.initAttributes();
		
		this.setCustomName("§5Vampire");
		this.setCustomNameVisible(true);
		
	}
	
	@Override
	public void setLocation(double x, double y, double z, float pitch, float yaw) {
		super.setLocation(x, y, z, pitch, yaw);
	}
	
	public static void move(Entity entity, Location location, double speed) {
	    Object pObject = entity;
	 
	    PathEntity path = ((EntityInsentient)pObject).getNavigation().a(location.getX(),
	      location.getY(), location.getZ());
	    if (path != null)
	    {
	      ((EntityInsentient)pObject).getNavigation().a(path, 2.0D);
	      ((EntityInsentient)pObject).getNavigation().a(new Double(speed));
	    }
	}
	
	public static void registerEntity(String name, int id, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass){
        try {
     
            List<Map<?, ?>> dataMap = new ArrayList<Map<?, ?>>();
            for (Field f : EntityTypes.class.getDeclaredFields()){
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())){
                    f.setAccessible(true);
                    dataMap.add((Map<?, ?>) f.get(null));
                }
            }
     
            if (dataMap.get(2).containsKey(id)){
                dataMap.get(0).remove(name);
                dataMap.get(2).remove(id);
            }
     
            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);
     
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
