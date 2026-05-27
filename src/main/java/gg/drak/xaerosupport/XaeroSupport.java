package gg.drak.xaerosupport;

import gg.drak.xaerosupport.utils.XaeroUtils;
import host.plas.bou.BetterPlugin;
import gg.drak.xaerosupport.config.MainConfig;
import gg.drak.xaerosupport.events.MainListener;

public final class XaeroSupport extends BetterPlugin {
    private static XaeroSupport instance;
    private static MainConfig mainConfig;

    private static MainListener mainListener;

    public XaeroSupport() {
        super();
    }

    public static XaeroSupport getInstance() {
        return instance;
    }

    public static void setInstance(XaeroSupport instance) {
        XaeroSupport.instance = instance;
    }

    public static MainConfig getMainConfig() {
        return mainConfig;
    }

    public static void setMainConfig(MainConfig mainConfig) {
        XaeroSupport.mainConfig = mainConfig;
    }

    public static MainListener getMainListener() {
        return mainListener;
    }

    public static void setMainListener(MainListener mainListener) {
        XaeroSupport.mainListener = mainListener;
    }

    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
    }

    @Override
    public void onBaseEnabled() {
        // Plugin startup logic
        setInstance(this); // Set the instance of the plugin. // For use in other classes.

        setMainConfig(new MainConfig()); // Instantiate the main config and set it.

        setMainListener(new MainListener()); // Instantiate the main listener and set it.

        XaeroUtils.registerChannels(); // Register the plugin channels.
    }

    @Override
    public void onBaseDisable() {
        // Plugin shutdown logic
        XaeroUtils.unregisterChannels();
    }
}
