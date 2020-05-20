package toast.client.commands.cmds;

import net.minecraft.util.Formatting;
import toast.client.commands.Command;
import toast.client.dontobfuscate.Config;
import toast.client.utils.Logger;

public class CommandReload extends Command {
    public CommandReload() {
        super("reload [config]", "Reloads all or one of the configuration files", false, "reload", "rl");
    }

    public void run(String[] args) {
        if (args.length < 1) {
            Config.loadOptionsAuto();
            Config.loadModulesAuto();
            Config.loadKeyBindsAuto();
            Config.loadClickGui();
            Logger.message("Reloaded all configuration files.", Logger.INFO);
        } else {
            switch (args[0]) {
                case "options":
                    Config.loadOptionsAuto();
                    Logger.message("Reloaded module options.", Logger.INFO);
                    break;
                case "modules":
                    Config.loadModulesAuto();
                    Logger.message("Reloaded modules.", Logger.INFO);
                    break;
                case "keybinds":
                    Config.loadKeyBindsAuto();
                    Logger.message("Reloaded keybinds.", Logger.INFO);
                    break;
                case "clickgui":
                    Config.loadClickGui();
                    Logger.message("Reloaded clickgui.", Logger.INFO);
                    break;
                case "config":
                    Config.loadClickGui();
                    Logger.message("Reloaded client config.", Logger.INFO);
                    break;
                default:
                    Logger.message("Invalid argument, valid arguments are:", Logger.WARN);
                    Logger.message(Formatting.GRAY + "  options " + Formatting.YELLOW + "reloads all module options", Logger.EMPTY);
                    Logger.message(Formatting.GRAY + "  modules " + Formatting.YELLOW + "reloads the enabled state of modules", Logger.EMPTY);
                    Logger.message(Formatting.GRAY + "  keybinds " + Formatting.YELLOW + "reloads all keybinds", Logger.EMPTY);
                    Logger.message(Formatting.GRAY + "  clickgui " + Formatting.YELLOW + "reloads the clickgui", Logger.EMPTY);
                    Logger.message(Formatting.GRAY + "  config " + Formatting.YELLOW + "reloads client config (not modules)", Logger.EMPTY);
            }
        }
    }
}
