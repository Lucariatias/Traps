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
	}

}
