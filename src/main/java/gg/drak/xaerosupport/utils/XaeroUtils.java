package gg.drak.xaerosupport.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gg.drak.xaerosupport.XaeroSupport;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class XaeroUtils {
    /**
     * Sends the server ID to the player on the specified channel.
     * @param player The player to send the message to.
     * @param channel The channel to send the message on.
     * @param serverId The server ID to send.
     */
    public static void sendServerId(Player player, String channel, int serverId) {
        ByteArrayDataOutput bytes = ByteStreams.newDataOutput();
        bytes.writeByte(0);
        bytes.writeInt(serverId);

        player.sendPluginMessage(XaeroSupport.getInstance(), channel, bytes.toByteArray());
    }

    /**
     * Sends the server ID to the player on the specified channel.
     * @param player The player to send the message to.
     * @param channel The channel to send the message on.
     */
    public static void sendServerId(Player player, String channel) {
        sendServerId(player, channel, getServerId());
    }

    /**
     * Sends the server ID to the player on both the world map and minimap channels.
     * @param player The player to send the message to.
     */
    public static void sendWithBoth(Player player) {
        XaeroUtils.sendServerId(player, getWorldMapChannel());
        XaeroUtils.sendServerId(player, getMinimapChannel());
    }

    /**
     * Registers the outgoing plugin channels for world map and minimap.
     */
    public static void registerChannels() {
        XaeroSupport.getInstance().logInfo("Registering channels...");
        registerChannel(getWorldMapChannel());
        registerChannel(getMinimapChannel());
    }

    /**
     * Unregisters the outgoing plugin channels for world map and minimap.
     */
    public static void unregisterChannels() {
        XaeroSupport.getInstance().logInfo("Unregistering channels...");
        unregisterChannel(getWorldMapChannel());
        unregisterChannel(getMinimapChannel());
    }

    /**
     * Registers an outgoing plugin channel.
     * @param channel The channel to register.
     */
    public static void registerChannel(String channel) {
        Bukkit.getMessenger().registerOutgoingPluginChannel(XaeroSupport.getInstance(), channel);
        XaeroSupport.getInstance().logInfo("Registered channel: " + channel);
    }

    /**
     * Unregisters an outgoing plugin channel.
     * @param channel The channel to unregister.
     */
    public static void unregisterChannel(String channel) {
        Bukkit.getMessenger().unregisterOutgoingPluginChannel(XaeroSupport.getInstance(), channel);
        XaeroSupport.getInstance().logInfo("Unregistered channel: " + channel);
    }

    /**
     * Gets the world map channel from the configuration.
     * @return The world map channel.
     */
    public static String getWorldMapChannel() {
        return XaeroSupport.getMainConfig().getWorldMapChannel();
    }

    /**
     * Gets the minimap channel from the configuration.
     * @return The minimap channel.
     */
    public static String getMinimapChannel() {
        return XaeroSupport.getMainConfig().getMinimapChannel();
    }

    /**
     * Gets the server ID from the configuration.
     * @return The server ID.
     */
    public static int getServerId() {
        return XaeroSupport.getMainConfig().getXaeroServerId();
    }
}
