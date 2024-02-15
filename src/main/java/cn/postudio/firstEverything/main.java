package cn.postudio.firstEverything;

import cn.postudio.firstEverything.Event.PlayerFirstEvents.AttendServer;
import cn.postudio.firstEverything.Event.PlayerFirstEvents.Biomes;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.*;

public final class main extends JavaPlugin {
    public static String message;
    public static @NotNull String getDataFolderPathString(){
        return getPlugin().getDataFolder().getPath();
    }
    public static Plugin getPlugin(){
        return Bukkit.getPluginManager().getPlugin("FirstEverything");
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        regEvent();
        InitializationPluginFile();
        getLogger().info("Plugin is active!");
    }

    @Override
    public void onLoad(){
        // Plugin onload logic
        getLogger().info("Plugin is loading~");
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin is inactive!");
    }

    public void regEvent(){
        getServer().getPluginManager().registerEvents(new AttendServer(), getPlugin());
        getServer().getPluginManager().registerEvents(new Biomes(), getPlugin());
    }

    public void InitializationPluginFile(){
        this.saveResource("config.yml", false);
        this.saveResource("lang/en-US.yml", true);
        Path path;
        try {
            path = Paths.get(getDataFolderPathString(), "PlayerData");
            Files.createDirectories(path);
        }catch (IOException ignored) {}
    }
}
