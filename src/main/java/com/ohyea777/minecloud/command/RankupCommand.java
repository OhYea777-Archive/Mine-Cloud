package com.ohyea777.minecloud.command;

import com.ohyea777.minecloud.lang.LanguageRegistry;
import com.ohyea777.minecloud.util.WrapUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankupCommand extends PrisonCommand {

    @Override
    public String getName() {
        return "Rankup";
    }

    @Override
    public String getCommand() {
        return "rankup";
    }

    @Override
    public String[] getAliases() {
        return new String[] { "ru", "rup" };
    }

    @Override
    public String[] getHelp() {
        return new String[] { "{prefix} &8: [&e" + getName() + "&8] &7Help&8:", LanguageRegistry.get("help").replace("{help}", getName()).replace("{command}", "Use '/rankup' to Rankup") };
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (WrapUtils.canWrap(p)) {
                WrapUtils.wrapPlayer(p).rankup();
            } else {
                sender.sendMessage(LanguageRegistry.getFormatted("prisonersonly"));
            }
        } else {
            sender.sendMessage(LanguageRegistry.getFormatted("playersonly"));
        }

        return false;
    }

}