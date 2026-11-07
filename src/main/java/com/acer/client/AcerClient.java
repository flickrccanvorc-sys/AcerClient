package com.acer.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcerClient implements ClientModInitializer {

    public static final String MOD_ID = "acerclient";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static MinecraftClient mc;

    @Override
    public void onInitializeClient() {
        mc = MinecraftClient.getInstance();
        LOGGER.info("AcerClient loaded - FPS + Crystal + Sword");
        
        // Module manager will go here next
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // tick modules later
        });
    }
}
