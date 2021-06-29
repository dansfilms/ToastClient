package dev.toastmc.toastclient.api.module;

import net.minecraft.client.MinecraftClient;

public class Module {

    private String name;
    private String description;
    public Module.Category category;

    private boolean enabled;

    private int key = -1;

    public MinecraftClient mc = MinecraftClient.getInstance();

    public Module(String name, String description, Category category) {
        super();
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enable() {
        setEnabled(true);
        onEnable();
    }

    public void disable() {
        setEnabled(false);
        onDisable();
    }

    public void toggle() {
        if (enabled) disable();
        else enable();
    }

    public void onEnable() {}

    public void onDisable() {}

    public void onUpdate() {}

    public enum Category {
        Client,
        Combat,
        Misc,
        Movement,
        Player,
        Render
    }
}
