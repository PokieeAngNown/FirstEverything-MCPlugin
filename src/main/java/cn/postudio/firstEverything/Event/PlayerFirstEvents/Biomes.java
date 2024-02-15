package cn.postudio.firstEverything.Event.PlayerFirstEvents;

import cn.postudio.firstEverything.FileFunction;
import cn.postudio.firstEverything.LangHandler;
import cn.postudio.firstEverything.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.*;

public class Biomes implements Listener {
    Biome biome;
    @EventHandler
    public void PlayerFirstAttendBiomes(@NotNull PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location location = event.getTo();
        UUID uuid = player.getUniqueId();
        File file = FileFunction.getFile("/PlayerData/" + uuid, "yml");
        World world = Bukkit.getWorld("world");
        World nether = Bukkit.getWorld("world_nether");
        World theEnd = Bukkit.getWorld("world_the_end");
        assert world != null;
        assert nether != null;
        assert theEnd != null;

        try{
            if (location.getWorld() == world) {
                Biome worldbiome = world.getBiome(location);
                List<String> worldlist = getPlayerBiomeStringList(player, World.Environment.NORMAL);
                assert worldlist != null;
                if (!worldlist.contains(worldbiome.getKey().asString())) {
                    biome = worldbiome;
                    if (!worldlist.contains(biome.getKey().asString())){
                        main.message = LangHandler.getLangContent("event.player.biomes");
                        main.message = main.message.replace("%Biomes_Name%", handleBiomesKeyToName(biome.getKey().asString()));
                        player.sendMessage(main.message);
                    }
                    worldlist.add(worldbiome.getKey().asString());
                    FileFunction.writeYAMLFile(file, "Experience.Biomes.World", worldlist);
                }
            }
            if (location.getWorld() == nether){
                Biome netherbiome = nether.getBiome(location);
                List<String> netherlist = getPlayerBiomeStringList(player, World.Environment.NETHER);
                assert netherlist != null;
                if (!netherlist.contains(netherbiome.getKey().asString())) {
                    biome = netherbiome;
                    if (!netherlist.contains(biome.getKey().asString())){
                        main.message = LangHandler.getLangContent("event.player.biomes");
                        main.message = main.message.replace("%Biomes_Name%", handleBiomesKeyToName(biome.getKey().asString()));
                        player.sendMessage(main.message);
                    }
                    netherlist.add(netherbiome.getKey().asString());
                    FileFunction.writeYAMLFile(file, "Experience.Biomes.Nether", netherlist);

                }
            }
            if (location.getWorld() == theEnd){
                Biome theEndbiome = theEnd.getBiome(location);
                List<String> theEndlist = getPlayerBiomeStringList(player, World.Environment.THE_END);
                assert theEndlist != null;
                if (!theEndlist.contains(theEndbiome.getKey().asString())) {
                    biome = theEndbiome;
                    if (!theEndlist.contains(biome.getKey().asString())){
                        main.message = LangHandler.getLangContent("event.player.biomes");
                        main.message = main.message.replace("%Biomes_Name%", handleBiomesKeyToName(biome.getKey().asString()));
                        player.sendMessage(main.message);
                    }
                    theEndlist.add(theEndbiome.getKey().asString());
                    FileFunction.writeYAMLFile(file, "Experience.Biomes.TheEnd", theEndlist);
                }
            }
        }catch (IOException | InvalidConfigurationException ignored){}
    }

    private static @Nullable List<String> getPlayerBiomeStringList(@NotNull Player player, World.@NotNull Environment environment){
        UUID uuid = player.getUniqueId();
        File file = new File(main.getDataFolderPathString() + "/PlayerData/", uuid + ".yml");
        FileConfiguration cfg = FileFunction.getFileCfg(file);
        switch (environment){
            case NORMAL: return cfg.getStringList("Experience.Biomes.World");
            case NETHER: return cfg.getStringList("Experience.Biomes.Nether");
            case THE_END: return cfg.getStringList("Experience.Biomes.TheEnd");
        }
        return null;
    }

    private static @NotNull String handleBiomesKeyToName(@NotNull String biomesKey){
        return LangHandler.getLangContent(biomesKey);
    }
}
