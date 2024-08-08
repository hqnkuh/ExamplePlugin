package net.sailuna.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
    public static Plugin INSTANCE = new Plugin();

    @Override
    public void onEnable() {
        INSTANCE = this;
        // プラグインが開始した時の処理
    }

    @Override
    public void onDisable() {
        INSTANCE = this;
        // プラグインが停止した時の処理
    }
}
