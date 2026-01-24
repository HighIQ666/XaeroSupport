package gg.drak.xaerosupport.events;

import gg.drak.xaerosupport.XaeroSupport;
import gg.drak.xaerosupport.utils.XaeroUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;

import java.util.Objects;

public class MainListener extends AbstractConglomerate {
    @EventHandler
    public void onPlayerRegisterChannel(PlayerRegisterChannelEvent event) {
        Player player = event.getPlayer();

        String worldMapChannel = XaeroSupport.getMainConfig().getWorldMapChannel();
        String minimapChannel = XaeroSupport.getMainConfig().getMinimapChannel();

        String channel = event.getChannel();
        if (! (Objects.equals(worldMapChannel, channel) || Objects.equals(minimapChannel, channel))) return;

        XaeroUtils.sendServerId(player, channel);
    }

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        XaeroUtils.sendWithBoth(player);
    }
}
