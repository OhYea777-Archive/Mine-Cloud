package com.ohyea777.minecloud.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PrisonCommand {

    public abstract String getName();

    public abstract String getCommand();

    public abstract String[] getAliases();

    public boolean usesPermissions() {
        return false;
    }

    public String getPermission() {
        return "minecloud." + getName().toLowerCase();
    }

    public boolean hasPermission(Player player) {
        return usesPermissions() ? true : player.hasPermission(getPermission());
    }

    public abstract String[] getHelp();

    public abstract boolean onCommand(Command command, CommandSender sender, String label, String[] args);

}
