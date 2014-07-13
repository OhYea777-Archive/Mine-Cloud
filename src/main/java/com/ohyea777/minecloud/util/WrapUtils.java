package com.ohyea777.minecloud.util;

import com.ohyea777.minecloud.player.PlayerInfo;
import com.ohyea777.minecloud.player.PrisonPlayer;
import org.bukkit.entity.Player;

public class WrapUtils {

    public static PrisonPlayer wrapPlayer(Player player) {
        return new PlayerInfo().createPlayer(new PrisonPlayer(player));
    }

    public static boolean canWrap(Player player) {
        return wrapPlayer(player).getRank() != null;
    }

}
