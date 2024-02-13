package cn.postudio.firstEverything;

import cn.postudio.firstEverything.Event.PlayerFirstEvents.AttendServer;
import cn.postudio.firstEverything.Event.PlayerFirstEvents.Biomes;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.*;

public final class main extends JavaPlugin {
    public static @NotNull String getDataFolderPathString(){
        return getPlugin().getDataFolder().getPath();
    }
    public static Plugin getPlugin(){
        return Bukkit.getPluginManager().getPlugin("MoreMotivation");
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
        Path path;
        try {
            path = Paths.get(getDataFolderPathString(), "PlayerData");
            Files.createDirectories(path);
        }catch (IOException ignored) {}
    }
}
