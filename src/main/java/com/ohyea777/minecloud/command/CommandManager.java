package com.ohyea777.minecloud.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static Map<String, PrisonCommand> commands;

    static {
        commands = new HashMap<String, PrisonCommand>();
    }

    public static void registerCommand(PrisonCommand command) {
        commands.put(command.getCommand().toLowerCase(), command);

        for (String s : command.getAliases()) {
            commands.put(s.toLowerCase(), command);
        }
    }

    public static boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("minecloud")) {
            if (args.length > 0) {
                if (args.length == 1 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("list"))) {

                }
            } else {

            }
        } else if (commands.containsKey(label.toLowerCase())) {
            PrisonCommand cmd = commands.get(label.toLowerCase());

            if (cmd.getName().equalsIgnoreCase(cmd.getCommand())) {
                return cmd.onCommand(sender, command, label, Arrays.copyOfRange(args, 1, args.length - 1));
            }
        }

        return false;
    }

}
