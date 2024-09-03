package winlyps.playerLaunch

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class PlayerLaunchCommandExecutor(private val plugin: PlayerLaunch) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size != 1) {
            sender.sendMessage("Usage: /playerlaunch <player>")
            return false
        }

        val targetPlayerName = args[0]
        val targetPlayer = Bukkit.getPlayer(targetPlayerName)

        if (targetPlayer == null) {
            sender.sendMessage("Player not found!")
            return false
        }

        // Launch the player into the sky
        targetPlayer.velocity = targetPlayer.velocity.add(targetPlayer.location.direction.multiply(2)).setY(5)

        return true
    }
}