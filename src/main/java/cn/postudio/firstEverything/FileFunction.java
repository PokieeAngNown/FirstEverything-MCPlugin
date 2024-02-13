package cn.postudio.firstEverything;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class FileFunction {
    public static File f = new File("");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);


    public static @NotNull Boolean CreateNewFile(String name, String suffix) throws IOException {
        f = new File(main.getDataFolderPathString(), name + "." +suffix);
        return f.createNewFile();
    }

    public static @NotNull Boolean CreateNewFile(File file) throws IOException {
        f = file;
        return f.createNewFile();
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull File getFile(String name, String suffix){
        return new File(main.getDataFolderPathString(),name + "." + suffix);
    }

    public static FileConfiguration getFileCfg(File file){
        f = file;
        return cfg;
    }

    public static void writeYAMLFile(File file, String key, Object object) throws IOException {
        f = file;
        cfg.set(key, object);
        cfg.save(file);
    }
}
