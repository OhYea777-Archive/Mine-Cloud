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
        return _(get(location).replace("{prefix}", get("prefix")));
    }

    //public static String

    public static String _(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
