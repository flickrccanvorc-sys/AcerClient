package com.acer.client.modules;

import com.acer.client.modules.combat.CrystalAura;
import com.acer.client.modules.combat.SwordPvP;
import com.acer.client.modules.render.FpsBooster;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // Combat
        modules.add(new CrystalAura());
        modules.add(new SwordPvP());

        // Render
        modules.add(new FpsBooster());
    }

    public List<Module> getModules() {
        return modules;
    }

    public Module getModuleByName(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    public void onTick() {
        for (Module m : modules) {
            if (m.isEnabled()) m.onTick();
        }
    }
}
