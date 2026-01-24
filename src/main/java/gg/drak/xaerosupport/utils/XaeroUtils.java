package gg.drak.xaerosupport.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gg.drak.xaerosupport.XaeroSupport;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class XaeroUtils {
    public static void sendServerId(Player player, String channel, int serverLevelId) {
        ByteArrayDataOutput bytes = ByteStreams.newDataOutput();
        bytes.writeByte(0);
        bytes.writeInt(serverLevelId);

        player.sendPluginMessage(XaeroSupport.getInstance(), channel, bytes.toByteArray());
    }

    public static void sendServerId(Player player, String channel) {
        sendServerId(player, channel, getServerId());
    }

    public static void sendWithBoth(Player player) {
        XaeroUtils.sendServerId(player, getWorldMapChannel());
        XaeroUtils.sendServerId(player, getMinimapChannel());
    }

    public static void registerChannels() {
        XaeroSupport.getInstance().logInfo("Registering channels...");
        registerChannel(getWorldMapChannel());
        registerChannel(getMinimapChannel());
    }

    public static void unregisterChannels() {
        XaeroSupport.getInstance().logInfo("Unregistering channels...");
        unregisterChannel(getWorldMapChannel());
        unregisterChannel(getMinimapChannel());
    }

    public static void registerChannel(String channel) {
        Bukkit.getMessenger().registerOutgoingPluginChannel(XaeroSupport.getInstance(), channel);
        XaeroSupport.getInstance().logInfo("Registered channel: &c" + channel);
    }

    public static void unregisterChannel(String channel) {
        Bukkit.getMessenger().unregisterOutgoingPluginChannel(XaeroSupport.getInstance(), channel);
        XaeroSupport.getInstance().logInfo("Unregistered channel: &c" + channel);
    }

    public static String getWorldMapChannel() {
        return XaeroSupport.getMainConfig().getWorldMapChannel();
    }

    public static String getMinimapChannel() {
        return XaeroSupport.getMainConfig().getMinimapChannel();
    }

    public static int getServerId() {
        return XaeroSupport.getMainConfig().getXaeroServerId();
    }
}
