package cn.postudio.moremotivation;

import cn.postudio.moremotivation.Event.ToolUnbreakable;
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
        regEvent();
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
        getServer().getPluginManager().registerEvents(new ToolUnbreakable(), getPlugin());
    }
}
