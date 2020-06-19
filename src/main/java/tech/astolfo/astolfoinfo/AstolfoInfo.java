package tech.astolfo.astolfoinfo;

import org.bukkit.plugin.java.JavaPlugin;
import tech.astolfo.astolfoinfo.commands.combat;

public final class AstolfoInfo extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("AstolfoInfo has been enabled!");
        this.getCommand("acombat").setExecutor(new combat());
    }
}
