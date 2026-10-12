package com.huggy0824.tacticalflashlightmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TacticalFlashlightMod implements ModInitializer {
    public static final String MOD_ID = "tacticalflashlightmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static KeyBinding toggleFlashlightKey;
    private static boolean flashlightOn = false;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Tactical Flashlight Mod");
        ModItems.registerModItems();
        toggleFlashlightKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tacticalflashlightmod.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F,
                "category.tacticalflashlightmod.flashlight"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleFlashlightKey.wasPressed()) {
                flashlightOn = !flashlightOn;
                client.player.sendMessage(Text.literal(flashlightOn ? "Flashlight ON" : "Flashlight OFF"), true);
            }
        });
    }
}