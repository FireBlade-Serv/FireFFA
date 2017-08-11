package eu.fireblade.fireffa.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.fireblade.fireffa.items.Kits;

public class TestKit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			return false;
		}
		
		Player p = (Player) sender;
		
		if(p.isOp()) {
			if (args[0].equalsIgnoreCase("Demolisseur")) {
				Kits.kitDemolisseur(p);
			} else if (args[0].equalsIgnoreCase("Fantome")) {
				Kits.kitFantome(p);
			} else if (args[0].equalsIgnoreCase("Tank")) {
				Kits.kitFantome(p);
			}
		}
		return false;
	}

}
