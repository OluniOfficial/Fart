package oluni.official.minecraft.fart;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class FartCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("fart.fart")) {
                Location loc = player.getLocation();
                loc.setY(loc.getY() + 0.6);
                loc.add(player.getLocation().getDirection().multiply(-0.5));
                Particle.DustTransition transition = new Particle.DustTransition(Color.fromRGB(153, 255, 102), Color.fromRGB(0, 153, 0), 1.8F);
                player.getWorld().spawnParticle(Particle.DUST_COLOR_TRANSITION, loc, 15, 0.2, 0.2, 0.2, 0.05, transition);
                Random random = new Random();
                String sound;
                if (random.nextBoolean()) {
                    sound = "minecraft:fart";
                } else {
                    sound = "minecraft:fart2";
                }
                player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
            }

        } else {
            commandSender.sendMessage("§cКоманду може писати тільки гравець!");
        }
        return false;
    }
}
