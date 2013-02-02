/*
 * Copyright (C) 2012 mewin <mewin001@hotmail.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mewin.WGCustomFlags;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;

/**
 *
 * @author mewin <mewin001@hotmail.de>
 */
public class WGCustomFlagsListener implements Listener {
    private WGCustomFlagsPlugin plugin;

    public WGCustomFlagsListener(WGCustomFlagsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent e) {
        this.plugin.loadFlagsForWorld(e.getWorld());
    }

    @EventHandler
    public void onWorldInit(WorldInitEvent e) {
        this.plugin.loadFlagsForWorld(e.getWorld());
    }

    @EventHandler
    public void onWorldSave(WorldSaveEvent e) {
        this.plugin.saveFlagsForWorld(e.getWorld());
    }

    @EventHandler
    public void onWorldUnload(WorldUnloadEvent e) {
        this.plugin.saveFlagsForWorld(e.getWorld());
    }

    /*@EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        String[] split = e.getMessage().toLowerCase().trim().split(" ");
        if ((!split[0].equals("/rg") && !split[0].equals("/region")) || split.length < 2) {
            return;
        }

        if (split[1].equals("save") && e.getPlayer().hasPermission("worldguard.region.save")) {
            if (split.length <= 2) {
                plugin.saveAllWorlds();
            } else {
                World w = plugin.getServer().getWorld(split[2]);

                if (w != null) {
                    plugin.saveFlagsForWorld(w);
                }
            }   
        } else if (split[1].equals("load") && e.getPlayer().hasPermission("worldguard.region.load")) {
            if (split.length <= 2) {
                plugin.loadAllWorlds();
            } else {
                World w = plugin.getServer().getWorld(split[2]);

                if (w != null) {
                    plugin.loadFlagsForWorld(w);
                }
            }   
        } else if (split[0].equals("/worldguard") || split[0].equals("/wg")) {
            if (split[1].equals("reload") && e.getPlayer().hasPermission("worldguard.reload")) //?
            {
                Command cmd = plugin.getCommand("wg");
                if(cmd.execute(e.getPlayer(), split[0], new String[] {"reload"}))
                {
                    plugin.loadAllWorlds();
                }
                e.setCancelled(true);
            }
        }
    }*/
}