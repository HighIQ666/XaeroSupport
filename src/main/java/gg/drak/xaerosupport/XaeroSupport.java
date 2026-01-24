package gg.drak.xaerosupport;

import gg.drak.xaerosupport.utils.XaeroUtils;
import host.plas.bou.BetterPlugin;
import gg.drak.xaerosupport.config.MainConfig;
import gg.drak.xaerosupport.events.MainListener;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class XaeroSupport extends BetterPlugin {
    @Getter @Setter
    private static XaeroSupport instance;
    @Getter @Setter
    private static MainConfig mainConfig;

    @Getter @Setter
    private static MainListener mainListener;

    public XaeroSupport() {
        super();
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
