package dev.toastmc.toastclient;

import dev.toastmc.toastclient.api.util.font.FontAccessor;
import dev.toastmc.toastclient.api.util.font.StringRenderer;
import net.fabricmc.api.ModInitializer;
import org.lwjgl.system.CallbackI;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ToastClient implements ModInitializer {

    public static final String name = "ToastClient";
    public static final String version = "b2.1 Java-Rewrite";

    public static final String nameVersion = name + " " + version;

    public static final Logger logger = LogManager.getLogManager().getLogger(name);

    @Override
    public void onInitialize() {
        long start = System.currentTimeMillis();
        logger.info("Started loading " + nameVersion + ".");

        FontAccessor.fontRenderer = new StringRenderer(18f, "/assets/toastclient/font/" + FontAccessor.fontName);

        logger.info("Finished loading " + nameVersion + " in " + (System.currentTimeMillis() - start) + " millis.");

    }
}
