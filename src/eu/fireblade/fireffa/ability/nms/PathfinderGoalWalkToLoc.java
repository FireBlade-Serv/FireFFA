package eu.fireblade.fireffa.ability.nms;

import org.bukkit.Location;

import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.NavigationAbstract;
import net.minecraft.server.v1_8_R3.PathEntity;
import net.minecraft.server.v1_8_R3.PathfinderGoal;

public class PathfinderGoalWalkToLoc extends PathfinderGoal {

	private double speed;

	@SuppressWarnings("unused")
	private EntityInsentient entity;

	private Location loc;

	private NavigationAbstract navigation;

	public PathfinderGoalWalkToLoc(EntityInsentient entity, Location loc, double speed) {
		this.entity = entity;
		this.loc = loc;
		this.navigation = entity.getNavigation();
		this.speed = speed;
	}

	public boolean a() {
		return true;
	}
	
	public void c() {
        PathEntity pathEntity = this.navigation.a(loc.getX(), loc.getY(), loc.getZ());

        this.navigation.a(pathEntity, speed);
    }
}