package oluni.official.minecraft.fart;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Fart extends JavaPlugin {

    @Override
    public void onEnable() {
        /*
       Піздець, нахуй я це пишу
         */
        Objects.requireNonNull(getCommand("fart")).setExecutor(new FartCMD(this));
        saveDefaultConfig();
    }
}
