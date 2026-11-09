package com.acer.client.gui;

import com.acer.client.modules.Module;
import com.acer.client.modules.ModuleManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGui extends Screen {

    private final ModuleManager moduleManager;
    private static final int PRIMARY = 0xFF7EC8FF;   // light blue
    private static final int SECONDARY = 0xFF1E90FF; // deep blue
    private static final int GLOW = 0xFFA0E7FF;      // cyan glow

    public ClickGui(ModuleManager moduleManager) {
        super(Text.literal("AcerClient"));
        this.moduleManager = moduleManager;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // dark background
        context.fill(0, 0, this.width, this.height, 0xCC0A0A12);

        // title with glow
        context.drawCenteredTextWithShadow(this.textRenderer, "AcerClient", this.width / 2, 20, PRIMARY);

        int y = 50;
        for (Module module : moduleManager.getModules()) {
            int color = module.isEnabled() ? GLOW : 0xFFAAAAAA;
            context.drawTextWithShadow(this.textRenderer, module.getName(), 40, y, color);
            y += 18;
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
