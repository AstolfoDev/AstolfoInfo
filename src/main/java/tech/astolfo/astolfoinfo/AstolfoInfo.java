package tech.astolfo.astolfoinfo;

import org.bukkit.plugin.java.JavaPlugin;
import tech.astolfo.astolfoinfo.commands.combat;
import tech.astolfo.astolfoinfo.commands.general;

import java.util.Objects;

public final class AstolfoInfo extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("AstolfoInfo has been enabled!");
        Objects.requireNonNull(this.getCommand("ageneral")).setExecutor(new general());
        Objects.requireNonNull(this.getCommand("acombat")).setExecutor(new combat());
    }
}
