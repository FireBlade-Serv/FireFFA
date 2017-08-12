package eu.fireblade.fireffa.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestKit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("§cVous ne pouvez pas executer cette commande sur la console");
			return false;
		}
		
		Player p = (Player) sender;
		if(p.isOp()) {
			if(args[0].equalsIgnoreCase("Archerelementaire")) {
				eu.fireblade.fireffa.items.Kits.kitArcherelementaire(p);
			} else if(args[0].equalsIgnoreCase("Archerelite")) {
				eu.fireblade.fireffa.items.Kits.kitArcherelite(p);
			} else if(args[0].equalsIgnoreCase("Archervagabon")) {
				eu.fireblade.fireffa.items.Kits.kitArchervagabon(p);
			} else if(args[0].equalsIgnoreCase("Assassin")) {
				eu.fireblade.fireffa.items.Kits.kitAssassin(p);
			} else if(args[0].equalsIgnoreCase("Cactus")) {
				eu.fireblade.fireffa.items.Kits.kitCactus(p);
			} else if(args[0].equalsIgnoreCase("Chevalier")) {
				eu.fireblade.fireffa.items.Kits.kitChevalier(p);
			} else if(args[0].equalsIgnoreCase("Demolisseur")) {
				eu.fireblade.fireffa.items.Kits.kitDemolisseur(p);
				eu.fireblade.fireffa.Var.démolisseur.add(p);
			} else if(args[0].equalsIgnoreCase("Fantome")) {
				eu.fireblade.fireffa.items.Kits.kitFantome(p);
			} else if(args[0].equalsIgnoreCase("Flic")) {
				eu.fireblade.fireffa.items.Kits.kitFlic(p);
			} else if(args[0].equalsIgnoreCase("Gamer")) {
				eu.fireblade.fireffa.items.Kits.kitGamer(p);
			}  else if(args[0].equalsIgnoreCase("Grampa")) {
				eu.fireblade.fireffa.items.Kits.kitGrampa(p);
			} else if(args[0].equalsIgnoreCase("Informaticien")) {
				eu.fireblade.fireffa.items.Kits.kitInformaticien(p);
			} else if(args[0].equalsIgnoreCase("Jihadist")) {
				eu.fireblade.fireffa.items.Kits.kitJihadist(p);
			} else if(args[0].equalsIgnoreCase("Lapin")) {
				eu.fireblade.fireffa.items.Kits.kitLapin(p);
			} else if(args[0].equalsIgnoreCase("Magicien")) {
				eu.fireblade.fireffa.items.Kits.kitMagicien(p);
			} else if(args[0].equalsIgnoreCase("Mineur")) {
				eu.fireblade.fireffa.items.Kits.kitMineur(p);
			} else if(args[0].equalsIgnoreCase("Ocelot")) {
				eu.fireblade.fireffa.items.Kits.kitOcelot(p);
			} else if(args[0].equalsIgnoreCase("OITCman")) {
				eu.fireblade.fireffa.items.Kits.kitOITCman(p);
			} else if(args[0].equalsIgnoreCase("Panda")) {
				eu.fireblade.fireffa.items.Kits.kitPanda(p);
			} else if(args[0].equalsIgnoreCase("Piaf")) {
				eu.fireblade.fireffa.items.Kits.kitPiaf(p);
			} else if(args[0].equalsIgnoreCase("Russe")) {
				eu.fireblade.fireffa.items.Kits.kitRusse(p);
			} else if(args[0].equalsIgnoreCase("Sauvage")) {
				eu.fireblade.fireffa.items.Kits.kitSauvage(p);
			} else if(args[0].equalsIgnoreCase("Tank")) {
				eu.fireblade.fireffa.items.Kits.kitTank(p);
			} else if(args[0].equalsIgnoreCase("Voleurdame")) {
				eu.fireblade.fireffa.items.Kits.kitVoleurdame(p);
			} else if(args[0].equalsIgnoreCase("Programmeur")) {
				eu.fireblade.fireffa.items.Kits.kitProgrammeur(p);
			} else if(args[0].equalsIgnoreCase("Patissier")) {
				eu.fireblade.fireffa.items.Kits.kitPatissier(p);
			} else if(args[0].equalsIgnoreCase("Ours")) {
				eu.fireblade.fireffa.items.Kits.kitOurs(p);
			} else if(args[0].equalsIgnoreCase("Guerriergalactique")) {
				eu.fireblade.fireffa.items.Kits.kitGuerriergalactique(p);
			}
		}
		return false;
	}

}
