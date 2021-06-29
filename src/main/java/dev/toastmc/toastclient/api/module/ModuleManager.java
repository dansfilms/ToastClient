package dev.toastmc.toastclient.api.module;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ModuleManager {

    public ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        Set<Class<? extends Module>> reflections = new Reflections("dev.toastmc.toastclient.impl.modules").getSubTypesOf(Module.class);
        reflections.forEach(aClass -> {
            try {
                modules.add(aClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        modules.sort(Comparator.comparing(object -> object.getName())); // Sorting the modules
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public List<Module> getModulesByCategory(Module.Category c) {
        List<Module> modules = new ArrayList<>();
        for (Module m : this.modules) if (m.category == c) modules.add(m);

        return modules;
    }

    public Module getModule(String name) {
        for (Module module : modules) if (module.getName().equalsIgnoreCase(name)) return module;

        return null;
    }
}
