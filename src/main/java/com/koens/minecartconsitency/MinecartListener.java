package com.koens.minecartconsitency;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class MinecartListener implements Listener{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onVehicleMove(VehicleMoveEvent e) {
		Vehicle vehicle = e.getVehicle();
		Location location = vehicle.getLocation();
		Block block = location.getBlock();
		Chunk chunk = block.getChunk();
		
		int x = chunk.getX();
		int z = chunk.getZ();
		
		World world = chunk.getWorld();
		for (int i = -3; i <= 3; i++) {
			for (int h = -3; h <= 3; i++) {
				if (!world.isChunkLoaded(x + i, h + z)) {
					world.loadChunk(x + 1, h + z);
				}
			}
		}
	}
}
