package com.ohyea777.minecloud.player;

import com.ohyea777.minecloud.MineCloud;
import com.ohyea777.minecloud.prison.Rank;
import com.ohyea777.minecloud.prison.RankRegistry;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;

import java.util.List;

public class PrisonPlayer extends WrappedPlayer {

    private PlayerInfo playerInfo;

    public PrisonPlayer(Player player) {
        super(player);
    }

    public Permission getPermissionProvider() {
        return MineCloud.INSTANCE.getVaultUtils().getPermissions();
    }

    public Economy getEconomyProvider() {
        return MineCloud.INSTANCE.getVaultUtils().getEconomy();
    }

    public Chat getChat() {
        return MineCloud.INSTANCE.getVaultUtils().getChat();
    }

    public double getBalance() {
        return getEconomyProvider().getBalance(this);
    }

    public EconomyResponse deposit(double value) {
        return getEconomyProvider().depositPlayer(this, value);
    }

    public EconomyResponse withdraw(double value) {
        return getEconomyProvider().withdrawPlayer(this, value);
    }

    public EconomyResponse setBalance(double value) {
        if (!withdraw(getBalance()).transactionSuccess()) {
            return null;
        }

        return deposit(value);
    }

    public RankRegistry getRankRegistry() {
        return MineCloud.INSTANCE.getRankRegistry();
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public Rank getRank() {
        return playerInfo.getDefaultRank();
    }

    public List<Rank> getSubRanks() {
        return playerInfo.getSubRanks();
    }

    public boolean hasNextRank() {
        return getRankRegistry().hasNextRank(getRank());
    }

    public Rank getNextRank() {
        return getRankRegistry().getNextRank(getRank());
    }

}
