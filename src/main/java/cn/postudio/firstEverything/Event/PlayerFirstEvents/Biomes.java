package cn.postudio.firstEverything.Event.PlayerFirstEvents;

import cn.postudio.firstEverything.FileFunction;
import cn.postudio.firstEverything.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Biomes implements Listener {

    public static @Nullable List<String> getPlayerBiomeStringList(@NotNull OfflinePlayer offlinePlayer, World.@NotNull Environment environment){
        UUID uuid = offlinePlayer.getUniqueId();
        File file = new File(main.getDataFolderPathString() + "/PlayerData/", uuid + ".yml");
        FileConfiguration cfg = FileFunction.getFileCfg(file);
        switch (environment){
            case NORMAL: return cfg.getStringList("Experience.Biomes.World");
            case NETHER: return cfg.getStringList("Experience.Biomes.Nether");
            case THE_END: return cfg.getStringList("Experience.Biomes.TheEnd");
            default: return null;
        }
    }

    @EventHandler
    public void PlayerFirstAttendBiomes(@NotNull PlayerMoveEvent event){
        OfflinePlayer offlinePlayer = event.getPlayer();
        Location location = event.getTo();
        World world = Bukkit.getWorld("world");
        World nether = Bukkit.getWorld("world_nether");
        World theEnd = Bukkit.getWorld("world_the_end");
        assert world != null;
        assert nether != null;
        assert theEnd != null;

        Biome worldbiome = world.getBiome(location);
        Biome netherbiome = nether.getBiome(location);
        Biome theEndbiome = theEnd.getBiome(location);
        List<String> worldlist = getPlayerBiomeStringList(offlinePlayer, World.Environment.NORMAL);
        List<String> netherlist = getPlayerBiomeStringList(offlinePlayer, World.Environment.NETHER);
        List<String> theEndlist = getPlayerBiomeStringList(offlinePlayer, World.Environment.THE_END);
        try{
            assert worldlist != null;
            assert netherlist != null;
            assert theEndlist != null;
            if (location.getWorld() == world) {
                if (!worldlist.contains(worldbiome.getKey().asString())) {
                    UUID uuid = offlinePlayer.getUniqueId();
                    FileFunction.f = new File(main.getDataFolderPathString() + "/PlayerData/", uuid + ".yml");
                    worldlist.add(worldbiome.getKey().asString());
                    FileFunction.writeYAMLFile(FileFunction.f, "Experience.Biomes.World", worldlist);
                }
            }
            if (location.getWorld() == nether){
                if (!netherlist.contains(netherbiome.getKey().asString())) {
                    UUID uuid = offlinePlayer.getUniqueId();
                    FileFunction.f = new File(main.getDataFolderPathString() + "/PlayerData/", uuid + ".yml");
                    netherlist.add(netherbiome.getKey().asString());
                    FileFunction.writeYAMLFile(FileFunction.f, "Experience.Biomes.Nether", netherlist);
                }
            }
            if (location.getWorld() == theEnd){
                if (!theEndlist.contains(theEndbiome.getKey().asString())) {
                    UUID uuid = offlinePlayer.getUniqueId();
                    FileFunction.f = new File(main.getDataFolderPathString() + "/PlayerData/", uuid + ".yml");
                    theEndlist.add(theEndbiome.getKey().asString());
                    FileFunction.writeYAMLFile(FileFunction.f, "Experience.Biomes.TheEnd", netherlist);
                }
            }
        }catch (IOException ignored){}
    }
}
