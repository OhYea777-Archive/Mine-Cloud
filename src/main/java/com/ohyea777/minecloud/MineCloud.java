package com.ohyea777.minecloud;

import com.ohyea777.minecloud.prison.Rank;
import com.ohyea777.minecloud.prison.RankRegistry;
import com.ohyea777.minecloud.util.VaultUtils;
import com.ohyea777.minecloud.util.WrapUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

        onReload();
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (WrapUtils.canWrap(player)) {
                sender.sendMessage(WrapUtils.wrapPlayer(player).getRank().toString());
            } else {
                sender.sendMessage("Can't Wrap Your Player Instance!");
            }
        } else {
            for (Rank rank : getRankRegistry().getRanks()) {
                sender.sendMessage(rank.toString());
                sender.sendMessage(String.format("Rank = '%s', nextRank = '%s'", rank.getLocalisedName(), getRankRegistry().hasNextRank(rank) ? getRankRegistry().getNextRank(rank).getLocalisedName() : "None"));
            }
        }

        return true;
    }

    public VaultUtils getVaultUtils() {
        return vaultUtils;
    }

    public RankRegistry getRankRegistry() {
        return rankRegistry;
    }

    public void onReload() {
        rankRegistry = RankRegistry.load(new File(getDataFolder(), "Ranks.json"));

        if (rankRegistry == null) {
            saveResource("Ranks.json", true);

            rankRegistry = RankRegistry.load(new File(getDataFolder(), "Ranks.json"));
        }

        reloadConfig();
    }

}
