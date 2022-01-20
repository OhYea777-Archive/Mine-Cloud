package com.ohyea777.minecloud.player;

import com.ohyea777.minecloud.prison.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerInfo {

    private UUID uuid;

    private transient Rank defaultRank;
    private transient List<Rank> subRanks;

    public PlayerInfo() { }

    public PrisonPlayer createPlayer(PrisonPlayer player) {
        subRanks = new ArrayList<Rank>();

        for (String group : player.getPermissionProvider().getPlayerGroups(player)) {
            if (defaultRank == null && player.getRankRegistry().canDefault(group)) {
                defaultRank = player.getRankRegistry().getRank(group);
            } else if (player.getRankRegistry().canSub(group)) {
                subRanks.add(player.getRankRegistry().getRank(group));
            }
        }

        player.setPlayerInfo(this);

        return player;
    }

    public Rank getDefaultRank() {
        return defaultRank;
    }

    public List<Rank> getSubRanks() {
        return subRanks;
    }

}
