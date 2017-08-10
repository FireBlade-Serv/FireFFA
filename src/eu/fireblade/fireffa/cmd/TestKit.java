package eu.fireblade.fireffa.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.fireblade.fireffa.items.Kits;

public class TestKit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(sender.isOp()) {
			if (args[1].equalsIgnoreCase("Agile")) {
				Kits.kitAgile(p);
			}
		}
		return false;
	}

}
