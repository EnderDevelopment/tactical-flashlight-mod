package com.huggy0824.tacticalflashlightmod.registry;

import com.huggy0824.tacticalflashlightmod.item.FlashlightItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.huggy0824.tacticalflashlightmod.TacticalFlashlightMod.MOD_ID;

public class ModItems {
    public static final Item FLASHLIGHT = registerItem("flashlight",
            new FlashlightItem(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }

    public static void registerModItems() {
        TacticalFlashlightMod.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}