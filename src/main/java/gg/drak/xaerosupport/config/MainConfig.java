package gg.drak.xaerosupport.config;

import gg.drak.thebase.storage.resources.flat.simple.SimpleConfiguration;
import gg.drak.xaerosupport.XaeroSupport;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainConfig extends SimpleConfiguration {
    public MainConfig() {
        super("config.yml", XaeroSupport.getInstance(), true);
    }

    /**
     * Initialize the configuration by loading necessary values.
     */
    @Override
    public void init() {
        checkAndGenerateNewId(); // Reloads the configuration automatically. (Sets if not set yet.)
    }

    /**
     * Get the Xaero server ID from the configuration.
     * @return The Xaero server ID.
     */
    public int getXaeroServerId() {
        reloadResource();

        return getOrSetDefault("ids.server", getRandomServerId());
    }

    /**
     * Get the world map channel name from the configuration.
     * @return The world map channel name.
     */
    public String getWorldMapChannel() {
        reloadResource();

        return getOrSetDefault("channels.world-map.main", "xaeroworldmap:main");
    }

    /**
     * Get the minimap channel name from the configuration.
     * @return The minimap channel name.
     */
    public String getMinimapChannel() {
        reloadResource();

        return getOrSetDefault("channels.minimap.main", "xaerominimap:main");
    }

    /**
     * Set the Xaero server ID in the configuration.
     * @param id The Xaero server ID to set.
     */
    public void setServerId(int id) {
        write("ids.server", id);
    }

    /**
     * Set the world map channel name in the configuration.
     * @param channel The world map channel name to set.
     */
    public void setWorldMapChannel(String channel) {
        write("channels.world-map.main", channel);
    }

    /**
     * Set the minimap channel name in the configuration.
     * @param channel The minimap channel name to set.
     */
    public void setMinimapChannel(String channel) {
        write("channels.minimap.main", channel);
    }

    /**
     * Determine if a new server ID should be generated.
     *
     * Note: This will reload the configuration automatically. No need to call reloadResource() before.
     * @return True if the current server ID is 0, false otherwise.
     */
    public boolean isGenerateNewId() {
        int currentId = getXaeroServerId();
        return currentId == 0;
    }

    /**
     * Check if a new server ID should be generated and generate one if necessary.
     * Note: This will reload the configuration automatically. No need to call reloadResource() before.
     */
    public void checkAndGenerateNewId() {
        if (! isGenerateNewId()) return;

        int newId = getRandomServerId();
        setServerId(newId);
    }

    /**
     * Generate a random server ID between -1,000,000 and 1,000,000.
     * @return The generated server ID.
     */
    public int getRandomServerId() {
        Random random = ThreadLocalRandom.current();

        return random.nextInt(-1000000, 1000000);
    }
}
