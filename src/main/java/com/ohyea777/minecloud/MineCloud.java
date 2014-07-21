package com.ohyea777.minecloud;

import com.ohyea777.minecloud.command.CommandManager;
import com.ohyea777.minecloud.lang.LanguageRegistry;
import com.ohyea777.minecloud.prison.RankRegistry;
import com.ohyea777.minecloud.util.VaultUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class MineCloud extends JavaPlugin {

    public static MineCloud INSTANCE;

    private VaultUtils vaultUtils;
    private RankRegistry rankRegistry;

    @Override
    public void onEnable() {
        INSTANCE = this;
        vaultUtils = new VaultUtils(INSTANCE);

        CommandManager.INSTANCE.init();

        onReload();
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return CommandManager.INSTANCE.onCommand(sender, command, label, args);
    }

    public VaultUtils getVaultUtils() {
        return vaultUtils;
    }

    public RankRegistry getRankRegistry() {
        return rankRegistry;
    }

    public void onReload() {
        rankRegistry = RankRegistry.load(new File(getDataFolder(), "Ranks.json"));
        File langFile = new File(getDataFolder(), "Lang.yml");

        if (rankRegistry == null) {
            saveResource("Ranks.json", true);

            rankRegistry = RankRegistry.load(new File(getDataFolder(), "Ranks.json"));
        }

        if (rankRegistry != null) {
            rankRegistry.init();
        }

        if (!langFile.exists()) {
            saveResource("Lang.yml", true);
        }

        LanguageRegistry.setConfiguration(YamlConfiguration.loadConfiguration(langFile));

        reloadConfig();
    }

}
