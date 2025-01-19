package me.block2block.hubparkour.api.plates;

import org.bukkit.Location;

public class BorderPoint extends PressurePlate {

    @SuppressWarnings("unused")
    public BorderPoint(Location location) {
        super(location, null);
    }

    @Override
    public int getType() {
        return 4;
    }
}
