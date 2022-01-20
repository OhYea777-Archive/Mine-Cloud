package com.ohyea777.minecloud.prison;

import com.ohyea777.minecloud.util.GsonUtils;
import net.minecraft.util.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankRegistry {

    private List<Rank> ranks;

    private transient Map<String, Rank> groupRanks;

    public RankRegistry() { }

    public RankRegistry(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void init() {
        groupRanks = new HashMap<String, Rank>();

        for (Rank rank : ranks) {
            groupRanks.put(rank.getGroup(), rank);
        }
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public boolean canDefault(String group) {
        if (groupRanks.containsKey(group)) {
            return !groupRanks.get(group).isSubRank();
        }

        return false;
    }

    public boolean canSub(String group) {
        if (groupRanks.containsKey(group)) {
            return groupRanks.get(group).isSubRank();
        }

        return false;
    }

    public Rank getRank(String group) {
        if (groupRanks.containsKey(group)) {
            return groupRanks.get(group);
        }

        return null;
    }

    public Rank getNextRank(Rank rank) {
        if (ranks.contains(rank) && !rank.isSubRank()) {
            for (int i = ranks.indexOf(rank) + 1; i < ranks.size(); i ++) {
                if (ranks.get(i) != null && !ranks.get(i).isSubRank()) {
                    return ranks.get(i);
                }
            }
        }

        return null;
    }

    public boolean hasNextRank(Rank rank) {
        return getNextRank(rank) != null && !rank.isSubRank();
    }

    public static RankRegistry load(File file) {
        try {
            String json = FileUtils.readFileToString(file);
            return GsonUtils.getGson().fromJson(json, RankRegistry.class);
        } catch (IOException ignored) { /* Ignored */ }

        return null;
    }

}
