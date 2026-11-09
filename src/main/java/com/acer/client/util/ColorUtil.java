package com.acer.client.util;

public class ColorUtil {

    public static final int LIGHT_BLUE = 0xFF7EC8FF;
    public static final int DEEP_BLUE  = 0xFF1E90FF;
    public static final int GLOW_CYAN  = 0xFFA0E7FF;
    public static final int DARK_BG    = 0xFF0A0A12;
    public static final int PANEL      = 0xEE12121F;

    public static int withAlpha(int color, int alpha) {
        return (color & 0x00FFFFFF) | (alpha << 24);
    }
}
