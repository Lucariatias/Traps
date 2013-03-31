package me.lucariatias.plugins.traps;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

	private Traps plugin;
	
	public PlayerMoveListener(Traps plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
	    if (event.isCancelled() || event.getFrom().getBlock().getLocation() == event.getFrom().getBlock().getLocation()) {
	        return;
	    }
	    
	    Block block = event.getTo().getBlock().getRelative(BlockFace.DOWN);
	    if (plugin.traps.get(block) != null) {
	    	if ((plugin.traps.get(block).active) && !(plugin.traps.get(block).player.equals(event.getPlayer().getDisplayName()))) {
	    		plugin.traps.get(block).trap(event.getPlayer());
	    		event.getPlayer().sendMessage(ChatColor.RED + "You were caught in " + plugin.traps.get(block).player + "'s trap!");
	    	}
	    }
	}

}
