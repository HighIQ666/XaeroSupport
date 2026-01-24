package gg.drak.xaerosupport.events;

import gg.drak.thebase.events.BaseEventHandler;
import host.plas.bou.events.ListenerConglomerate;
import gg.drak.xaerosupport.XaeroSupport;
import org.bukkit.Bukkit;

public class AbstractConglomerate implements ListenerConglomerate {
    public AbstractConglomerate() {
        register();
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, XaeroSupport.getInstance());
        BaseEventHandler.bake(this, XaeroSupport.getInstance());
        XaeroSupport.getInstance().logInfo("Registered listeners for: &c" + this.getClass().getSimpleName());
    }
}
