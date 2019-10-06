package me.abhi.lunarclientapi.event;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class PlayerAuthenticateEvent extends Event {

    private static HandlerList handlerList = new HandlerList();
    private Player player;

    public PlayerAuthenticateEvent(Player player) {
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
