package cn.postudio.firstEverything.Event.PlayerFirstEvents;

import cn.postudio.firstEverything.FileFunction;
import cn.postudio.firstEverything.main;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class AttendServer implements Listener {

    public void PlayerInitialization(@NotNull OfflinePlayer offlinePlayer){
        UUID uuid = offlinePlayer.getUniqueId();
        File file = new File(main.getDataFolderPathString() + "/PlayerData/", uuid + ".yml");
        FileConfiguration cfg = FileFunction.getFileCfg(file);
        try {
            if (!FileFunction.CreateNewFile(file)){
                return;
            }
            cfg.set("Experience.Biomes.World", new ArrayList<>());
            cfg.set("Experience.Biomes.Nether", new ArrayList<>());
            cfg.set("Experience.Biomes.TheEnd", new ArrayList<>());
            cfg.save(file);
        } catch (IOException ignored) {}
    }


    @EventHandler
    public void PlayerFistAttendServer(@NotNull PlayerJoinEvent event){
        OfflinePlayer offlinePlayer = event.getPlayer();
        PlayerInitialization(offlinePlayer);




    }

}
