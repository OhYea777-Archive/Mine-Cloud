package com.ohyea777.minecloud.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TestCommand extends PrisonCommand {

    @Override
    public String getName() {
        return "Test";
    }

    @Override
    public String getCommand() {
        return "test";
    }

    @Override
    public String[] getAliases() {
        return new String[] { "t" };
    }

    @Override
    public String[] getHelp() {
        return new String[] { "{prefix} &8: [&e" + getName() + "&8] &7Help&8:" };
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Hai");

        return false;
    }

}
