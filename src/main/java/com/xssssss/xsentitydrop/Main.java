package com.xssssss.xsentitydrop;

import com.xssssss.xsentitydrop.Commands.CommandsXsEntityDrop;
import com.xssssss.xsentitydrop.Listener.onEntityDeath;
import com.xssssss.xsentitydrop.Metrics.Metrics.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    public static Plugin plugin = null;
    public static YamlConfiguration config;
    public static Logger logger;
    @Override
    public void onEnable() {
        // Plugin startup logic
        logger = getLogger();
        plugin = this;
        config = createResource(this,"","config.yml",false);
        int pluginId = 21897;
        Metrics metrics = new Metrics(this, pluginId);
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "\n"+
                        "__   __     _____      _   _ _        ______                 \n" +
                        "\\ \\ / /    |  ___|    | | (_) |       |  _  \\                \n" +
                        " \\ V / ___ | |__ _ __ | |_ _| |_ _   _| | | |_ __ ___  _ __  \n" +
                        " /   \\/ __||  __| '_ \\| __| | __| | | | | | | '__/ _ \\| '_ \\ \n" +
                        "/ /^\\ \\__ \\| |__| | | | |_| | |_| |_| | |/ /| | | (_) | |_) |\n" +
                        "\\/   \\/___/\\____/_| |_|\\__|_|\\__|\\__, |___/ |_|  \\___/| .__/ \n" +
                        "                                  __/ |               | |    \n" +
                        "                                 |___/                |_|    "
                );
        getLogger().info("XsEntityDrop已加载！");
        getLogger().info("作者：XiaoShuaiOwO");
        getLogger().info("版本："+getDescription().getVersion());

        //注册指令
        getCommand("XsEntityDrop").setExecutor(new CommandsXsEntityDrop());
        //注册监听器
        getServer().getPluginManager().registerEvents(new onEntityDeath(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static YamlConfiguration createResource(Plugin plugin, String dir, String fileName, boolean cover) {
        File dataFolder = plugin.getDataFolder();
        File folder = new File(dataFolder, dir);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder, fileName);
        if (!file.exists() || cover) {
            try {
                if (file.exists() && cover) {
                    file.delete();
                }
                if (!file.exists()) {
                    try (InputStream in = plugin.getResource(fileName)) {
                        Files.copy(in, file.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }

}
