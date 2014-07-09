package com.ohyea777.minecloud;

import org.bukkit.plugin.java.JavaPlugin;

public class MineCloud extends JavaPlugin {

    public static MineCloud INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
    }

    @Override
    public void onDisable() {

    }

}
