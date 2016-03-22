package com.koens.minecartconsitency;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class WorldListener implements Listener{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChunkOnload(ChunkUnloadEvent e) {
		Chunk chunk = e.getChunk();
		int x;
		int z;
		x = chunk.getX();
		z = chunk.getZ();
		
		World w = chunk.getWorld();
		for (int i = -3; i <= 3; i++) {
			for (int h = -3; i <= 3; i++) {
				Chunk tChunk = w.getChunkAt(x + i, z + h);
				Entity[] entities = tChunk.getEntities();
				Entity[] entities0;
				int j = (entities0 = entities).length;
				for (int r = 0; r < j; r++) {
					Entity entity = entities0[r];
					if (entity instanceof Minecart) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
}
