package com.ohyea777.minecloud.util;

import com.ohyea777.minecloud.MineCloud;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultUtils {

    private final MineCloud plugin;

    private Permission permissions;
    private Economy economy;
    private Chat chat;

    public VaultUtils(MineCloud plugin) {
        this.plugin = plugin;

        setupPermissions();
        setupEconomy();
        setupChat();
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = plugin.getServer().getServicesManager().getRegistration(Permission.class);

        if (permissionProvider != null) {
            permissions = permissionProvider.getProvider();

            return true;
        }

        return false;
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = plugin.getServer().getServicesManager().getRegistration(Economy.class);

        if (economyProvider != null) {
            economy = economyProvider.getProvider();

            return true;
        }

        return false;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> chatProvider = plugin.getServer().getServicesManager().getRegistration(Chat.class);

        if (chatProvider != null) {
            chat = chatProvider.getProvider();

            return true;
        }

        return false;
    }

    public Permission getPermissions() {
        return permissions;
    }

    public Economy getEconomy() {
        return economy;
    }

    public Chat getChat() {
        return chat;
    }

}
