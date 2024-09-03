package winlyps.playerLaunch

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class PlayerLaunchTabCompleter : TabCompleter {

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): List<String> {
        if (args.size == 1) {
            return Bukkit.getOnlinePlayers().map { it.name }.filter { it.startsWith(args[0], ignoreCase = true) }
        }
        return emptyList()
    }
}