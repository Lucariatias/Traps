package me.lucariatias.plugins.traps;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Trap {
	
	public Block block;
	public Boolean active;
	public String player;
	
	public Trap(Block block, Player player) {
		this.block = block;
		this.player = player.getDisplayName();
		this.active = true;
		((Traps) Bukkit.getServer().getPluginManager().getPlugin("Traps")).traps.put(block, this);
	}
	
	public void trap(LivingEntity entity) {
		this.active = false;
	}

}
