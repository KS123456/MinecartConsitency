package com.koens.minecartconsitency;
	
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecartConsistency extends JavaPlugin {
	private final MinecartListener minecartListener = new MinecartListener();
	private final WorldListener worldListener = new WorldListener();
	@Override
	public void onEnable() {
		getLogger().info("MinecartConsistency v" + getDescription().getVersion() + "has been enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(minecartListener, this);
		pm.registerEvents(worldListener, this);
		
	}
	@Override
	public void onDisable() {
		getLogger().info("MinecartConsitency has been unloaded, just as minecarts will do now");
	}
}
