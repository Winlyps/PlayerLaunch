package winlyps.playerLaunch

import org.bukkit.plugin.java.JavaPlugin

class PlayerLaunch : JavaPlugin() {

    override fun onEnable() {
        // Register the command
        this.getCommand("playerlaunch")?.let {
            it.setExecutor(PlayerLaunchCommandExecutor(this))
            it.tabCompleter = PlayerLaunchTabCompleter()
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
