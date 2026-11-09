package com.acer.client;

import com.acer.client.gui.ClickGui;
import com.acer.client.modules.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcerClient implements ClientModInitializer {

    public static final String MOD_ID = "acerclient";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static MinecraftClient mc;
    public static ModuleManager moduleManager;
    private static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        mc = MinecraftClient.getInstance();
        moduleManager = new ModuleManager();

        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.acerclient.gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.acerclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            moduleManager.onTick();

            while (openGuiKey.wasPressed()) {
                client.setScreen(new ClickGui(moduleManager));
            }
        });

        LOGGER.info("AcerClient loaded – FPS + Crystal + Sword | Right Shift for menu");
    }
}
