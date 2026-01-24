package gg.drak.xaerosupport.config;

import gg.drak.thebase.storage.resources.flat.simple.SimpleConfiguration;
import gg.drak.xaerosupport.XaeroSupport;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainConfig extends SimpleConfiguration {
    public MainConfig() {
        super("config.yml", XaeroSupport.getInstance(), true);
    }

    @Override
    public void init() {
        getXaeroServerId();
    }

    public int getXaeroServerId() {
        reloadResource();

        return getOrSetDefault("ids.server", getRandomServerId());
    }

    public String getWorldMapChannel() {
        reloadResource();

        return getOrSetDefault("channels.world-map.main", "xaeroworldmap:main");
    }

    public String getMinimapChannel() {
        reloadResource();

        return getOrSetDefault("channels.minimap.main", "xaerominimap:main");
    }

    public int getRandomServerId() {
        Random random = ThreadLocalRandom.current();

        return random.nextInt(1, 1000000);
    }
}
