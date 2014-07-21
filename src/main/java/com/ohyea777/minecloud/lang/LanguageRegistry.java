package com.ohyea777.minecloud.lang;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageRegistry {

    private static YamlConfiguration configuration;
    private static Map<String, String> localisedLocations;

    static {
        localisedLocations = new HashMap<String, String>();

        localisedLocations.put("prefix", "Options.Prefix");
        localisedLocations.put("help", "Options.HelpFormat");
        localisedLocations.put("noperm", "Options.NoPerm");
        localisedLocations.put("nocmd", "Options.InvalidCommand");
        localisedLocations.put("highestrank", "Messages.Rankup.HighestRank");
        localisedLocations.put("rankuptoopoor", "Messages.Rankup.TooPoor");
        localisedLocations.put("prisonersonly", "Options.OnlyPrisoners");
        localisedLocations.put("playersonly", "Options.PlayersOnly");
        localisedLocations.put("econfail", "Options.EconomyFail");
        localisedLocations.put("rankedup", "Messages.Rankup.RankedUp");
    }

    public static void setConfiguration(YamlConfiguration configuration) {
        LanguageRegistry.configuration = configuration;
    }

    public static String get(String location) {
        return localisedLocations.containsKey(location.toLowerCase()) ? configuration.getString(localisedLocations.get(location.toLowerCase())) : configuration.getString(location);
    }

    public static List<String> getStringList(String location) {
        return localisedLocations.containsKey(location.toLowerCase()) ? configuration.getStringList(localisedLocations.get(location.toLowerCase())) : configuration.getStringList(location);
    }

    public static String getFormatted(String location) {
        return addPrefix(get(location));
    }

    public static String addPrefix(String s) {
        return _(s.replace("{prefix}", get("prefix")));
    }

    public static String[] addPrefix(String... args) {
        String[] formatted = new String[args.length];

        for (int i = 0; i < args.length; i ++) {
            formatted[i] = addPrefix(args[i]);
        }

        return formatted;
    }

    //public static String

    public static String _(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
