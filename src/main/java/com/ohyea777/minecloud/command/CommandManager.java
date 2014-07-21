package com.ohyea777.minecloud.command;

import com.ohyea777.minecloud.lang.LanguageRegistry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.*;

public enum CommandManager {

    INSTANCE;

    private Map<String, PrisonCommand> commands;

    public void init() {
        commands = new HashMap<String, PrisonCommand>();

        registerCommand(new TestCommand());
        registerCommand(new RankupCommand());
    }

    public void registerCommand(PrisonCommand command) {
        commands.put(command.getCommand().toLowerCase(), command);

        for (String s : command.getAliases()) {
            commands.put(s.toLowerCase(), command);
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("minecloud")) {
            if (args.length > 0) {
                if (args.length == 1 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("list"))) {
                    sender.sendMessage(getHelpList());

                    return true;
                } else if (args.length == 2 && args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("h")) {
                    if (commands.containsKey(args[1].toLowerCase())) {
                        sender.sendMessage(LanguageRegistry.addPrefix(commands.get(args[1].toLowerCase()).getHelp()));

                        return true;
                    } else {
                        sender.sendMessage(LanguageRegistry.getFormatted("nocmd"));

                        return true;
                    }
                }
            } else {


                return true;
            }
        } else if (commands.containsKey(label.toLowerCase())) {
            PrisonCommand cmd = commands.get(label.toLowerCase());

            if (cmd.getName().equalsIgnoreCase(cmd.getCommand())) {
                if (cmd.hasPermission(sender)) {
                    return cmd.onCommand(sender, command, label, args);
                } else {
                    sender.sendMessage(cmd.getNoPerm());

                    return true;
                }
            }
        }

        return false;
    }

    public String getHelpList() {
        List<PrisonCommand> cmds = new ArrayList<PrisonCommand>();

        for (PrisonCommand cmd : commands.values()) {
            if (!cmds.contains(cmd))
                cmds.add(cmd);
        }

        String def = LanguageRegistry.get("help");
        StringBuilder str = new StringBuilder(LanguageRegistry.addPrefix("{prefix} Command Help&8:"));

        for (PrisonCommand cmd : cmds) {
            str.append("\n").append(LanguageRegistry._(def.replace("{help}", cmd.getName()).replace("{command}", "/mc help " + cmd.getAliases()[0])));
        }

        return str.toString();
    }

}
