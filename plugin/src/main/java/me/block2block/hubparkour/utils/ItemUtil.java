package me.block2block.hubparkour.utils;

import me.block2block.hubparkour.HubParkour;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

@SuppressWarnings("deprecation")
public class ItemUtil {

    public static ItemStack ci(Material type, String name, int amount, String lore, short data, String skullName, String action) {
        ItemStack is = new ItemStack(type, amount, data);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(HubParkour.c(false, name));
        if (lore != null) {
            im.setLore(Arrays.asList(HubParkour.c(false, lore).split(";")));
        }
        if (skullName != null) {
            SkullMeta sm = (SkullMeta) im;
            sm.setOwner(skullName);
            im = sm;
        }

        if (HubParkour.isPre1_13()) {
            im.spigot().setUnbreakable(true);
        } else {
            im.setUnbreakable(true);
        }

        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        is.setItemMeta(im);

        if (action != null) {
            is = NBTEditor.set(is, action, NBTEditor.CUSTOM_DATA, "hubparkour_item");
        }
        return is;
    }
    public static ItemStack ci(Material type, String name, int amount, String lore, short data, String action) {
        return ci(type, name, amount, lore, data, null, action);
    }
    public static ItemStack ci(Material type, String name, int amount, String lore, short data) {
        return ci(type, name, amount, lore, data, null, null);
    }
    public static ItemStack ci(Material type, String name, int amount, String lore) {
        return ci(type, name, amount, lore, (short)0, null);
    }
    public static ItemStack ci(Material type, String name, int amount) {
        return ci(type, name, amount, null);
    }
    public static ItemStack ci(Material type, String name) {
        return ci(type, name, 1);
    }
    @SuppressWarnings("unused")
    public static ItemStack ci(Material type) {
        return ci(type, "");
    }

}
