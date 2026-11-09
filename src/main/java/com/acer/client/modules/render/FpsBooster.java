package com.acer.client.modules.render;

import com.acer.client.modules.Module;

public class FpsBooster extends Module {

    public FpsBooster() {
        super("FpsBooster", "Cuts lag and boosts FPS", Category.RENDER);
    }

    @Override
    public void onEnable() {
        // particle limits + entity culling will go here
    }

    @Override
    public void onTick() {
        // runtime optimisations
    }
}
