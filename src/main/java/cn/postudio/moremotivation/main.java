package cn.postudio.moremotivation;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    public static Plugin getPlugin(){
        return Bukkit.getPluginManager().getPlugin("MoreMotivation");
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("[PoStudio]MoreMotivation is active!");
    }

    @Override
    public void onLoad(){
        getLogger().info("[PoStudio]MoreMotivation is loading~");
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("[PoStudio]MoreMotivation is inactive!");
    }

    public void regEvent(){

    }
}
