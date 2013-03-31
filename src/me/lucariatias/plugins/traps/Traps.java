package me.lucariatias.plugins.traps;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Traps extends JavaPlugin {
	
	public Map<Block, Trap> traps = new HashMap<Block, Trap>();
	
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() { public void run() {
			for (World world : Bukkit.getServer().getWorlds())
			for (Entity entity : world.getEntities()) {
				if (entity instanceof LivingEntity && !(entity instanceof Player)) {
					Block block = entity.getLocation().getBlock().getRelative(BlockFace.DOWN);
				    if (((Traps) Bukkit.getServer().getPluginManager().getPlugin("Traps")).traps.get(block) != null) {
				    	if ((((Traps) Bukkit.getServer().getPluginManager().getPlugin("Traps")).traps.get(block).active)) {
				    		((Traps) Bukkit.getServer().getPluginManager().getPlugin("Traps")).traps.get(block).trap((LivingEntity) entity);
				    	}
				    }
				}
			}
		} }, 20, 20);
	}

}
