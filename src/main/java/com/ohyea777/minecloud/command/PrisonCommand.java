package com.ohyea777.minecloud.command;

import com.ohyea777.minecloud.lang.LanguageRegistry;
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

    public boolean hasPermission(CommandSender sender) {
        return !usesPermissions() || sender.hasPermission(getPermission());
    }

    public String getNoPerm() {
        return LanguageRegistry.getFormatted("noperm");
    }

    public abstract String[] getHelp();

    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);

}
