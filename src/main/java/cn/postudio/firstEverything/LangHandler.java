package cn.postudio.firstEverything;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LangHandler {
    static String langPath = main.getDataFolderPathString() + "/lang/" + main.getPlugin().getConfig().getString("Language") + ".yml";


    public static String getLangContent(String key) {
        File file = new File(langPath);
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
        List<String> stringList = fileConfiguration.getStringList(key);
        if (stringList.equals(new ArrayList<>())){
            return Objects.requireNonNull(fileConfiguration.getString(key));
        }else{
            return String.join("\n", stringList);
        }
    }
}
