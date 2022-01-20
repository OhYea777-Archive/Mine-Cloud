package com.ohyea777.minecloud.util;

import org.bukkit.craftbukkit.libs.com.google.gson.Gson;
import org.bukkit.craftbukkit.libs.com.google.gson.GsonBuilder;

public class GsonUtils {

    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();

        builder.setPrettyPrinting();

        gson = builder.create();
    }

    public static Gson getGson() {
        return gson;
    }

}
