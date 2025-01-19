package me.block2block.hubparkour.api.plates;

import org.bukkit.Location;

public class RestartPoint extends PressurePlate {

    @SuppressWarnings("unused")
    public RestartPoint(Location location) {
        super(location, null);
    }

    @Override
    public int getType() {
        return 2;
    }
}
