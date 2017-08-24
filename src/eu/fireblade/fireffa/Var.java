package eu.fireblade.fireffa;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import eu.fireblade.fireffa.ability.Fantôme;
import eu.fireblade.fireffa.ability.Magicien;
import eu.fireblade.fireffa.ability.VoleurÂmes;

public class Var {
	
	public static String SqlUrlBase = "jdbc:mysql://", host, user, password;
	
	public static ArrayList<Player> démolisseur = new ArrayList<Player>();
	
	public static ArrayList<Player> fantôme = new ArrayList<Player>();
	
	public static ArrayList<Player> tank = new ArrayList<Player>();
	
	public static ArrayList<Player> flic = new ArrayList<Player>();
	
	public static ArrayList<Player> magicien = new ArrayList<Player>();
	
	public static ArrayList<Player> chevalier = new ArrayList<Player>();
	
	public static ArrayList<Player> cactus = new ArrayList<Player>();
	
	public static ArrayList<Player> piaf = new ArrayList<Player>();
	
	public static ArrayList<Player> voleurdame = new ArrayList<Player>();
	
	public static ArrayList<Player> OITCman = new ArrayList<Player>();
	
	public static ArrayList<Player> lapin = new ArrayList<Player>();
	
	public static ArrayList<Player> russe = new ArrayList<Player>();
	
	public static ArrayList<Player> grampa = new ArrayList<Player>();
	
	public static ArrayList<Player> mineur = new ArrayList<Player>();
	
	public static ArrayList<Player> jihadist = new ArrayList<Player>();	
	
	public static ArrayList<Player> gamer = new ArrayList<Player>();
	
	public static ArrayList<Player> sauvage = new ArrayList<Player>();
	
	public static ArrayList<Player> archerélémentaire = new ArrayList<Player>();
	
	public static ArrayList<Player> ocelot = new ArrayList<Player>();
	
	public static ArrayList<Player> archerélite = new ArrayList<Player>();
	
	public static ArrayList<Player> assassin = new ArrayList<Player>();
	
	public static ArrayList<Player> panda = new ArrayList<Player>();
	
	public static ArrayList<Player> informaticien = new ArrayList<Player>();
	
	public static ArrayList<Player> programmeur = new ArrayList<Player>();
	
	public static ArrayList<Player> patissier = new ArrayList<Player>();
	
	public static ArrayList<Player> ours = new ArrayList<Player>();
	
	public static ArrayList<Player> guerriergalactique = new ArrayList<Player>();
	
	public static ArrayList<Player> esclave = new ArrayList<Player>();
	
	public static ArrayList<Player> domination = new ArrayList<Player>();
	
	public static ArrayList<Player> boucher = new ArrayList<Player>();
	
	public static ArrayList<Player> mathématicien = new ArrayList<Player>();
	
	public static ArrayList<Player> pyro = new ArrayList<Player>();
	
	public static ArrayList<Player> moutarde = new ArrayList<Player>();

	public static ArrayList<Player> vampire = new ArrayList<Player>();
	
	public static ArrayList<Player> nuage = new ArrayList<Player>();
	
	public static ArrayList<Player> timer = new ArrayList<Player>();
	
	public static ArrayList<Player> robindesbois = new ArrayList<Player>();
	
	public static ArrayList<Player> gandalf = new ArrayList<Player>();
	
	public static ArrayList<Player> glowstone = new ArrayList<Player>();
	
	public static ArrayList<Player> enderman = new ArrayList<Player>();
	
	public static ArrayList<Player> rulio = new ArrayList<Player>();
	
	public static ArrayList<Player> copy = new ArrayList<Player>();
	
	public static ArrayList<Player> pharaon = new ArrayList<Player>();
	
	public static ArrayList<Player> furicat = new ArrayList<Player>();
	
	public static ArrayList<Player> redman = new ArrayList<Player>();
	
	public static ArrayList<Player> trapman = new ArrayList<Player>();
	
	public static ArrayList<Player> swap = new ArrayList<Player>();
	
	public static ArrayList<Player> golem = new ArrayList<Player>();
	
	public static ArrayList<Player> ogre = new ArrayList<Player>();
	
	public static ArrayList<Player> bouftout = new ArrayList<Player>();
	
	public static ArrayList<Player> enclumex = new ArrayList<Player>();
	
	public static ArrayList<Player> fiesta = new ArrayList<Player>();
	
	public static ArrayList<Player> power = new ArrayList<Player>();
	
	public static ArrayList<Player> dieu = new ArrayList<Player>();
	
	public static ArrayList<Player> invocation = new ArrayList<Player>();
	
	public static ArrayList<Player> archervagabon = new ArrayList<Player>();
//------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static HashMap<Player, Integer> killStreak = new HashMap<Player, Integer>();
//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static ArrayList<Location> spawn = new ArrayList<Location>();
	
	public static void clearKitArray(Player p) {
		if(démolisseur.contains(p)) {
			démolisseur.remove(p);
		}else if(fantôme.contains(p)) {
			fantôme.remove(p);
			
			if(Fantôme.cooldown.contains(p)) {
				Fantôme.cooldown.remove(p);
			}
		}else if(tank.contains(p)) {
			tank.remove(p);
		}else if(flic.contains(p)) {
			flic.remove(p);
		}else if(magicien.contains(p)) {
			magicien.remove(p);
			
			if(Magicien.cooldown.contains(p)) {
				Magicien.cooldown.remove(p);
			}
		}else if(chevalier.contains(p)) {
			chevalier.remove(p);
		}else if(cactus.contains(p)) {
			cactus.remove(p);
		}else if(piaf.contains(p)) {
			piaf.remove(p);
		}else if(voleurdame.contains(p)) {
			voleurdame.remove(p);
			
			if(VoleurÂmes.cooldown.contains(p)) {
				VoleurÂmes.cooldown.remove(p);
			}
			
			if(VoleurÂmes.soul.containsKey(p)) {
				VoleurÂmes.soul.remove(p);
			}
		}else if(OITCman.contains(p)) {
			OITCman.remove(p);
			
			
		}else if(lapin.contains(p)) {
			lapin.remove(p);
		}else if(russe.contains(p)) {
			russe.remove(p);
		}else if(grampa.contains(p)) {
			grampa.remove(p);
		}else if(mineur.contains(p)) {
			mineur.remove(p);
		}else if(jihadist.contains(p)) {
			jihadist.remove(p);
		}else if(gamer.contains(p)) {
			gamer.remove(p);
		}else if(sauvage.contains(p)) {
			sauvage.remove(p);
		}else if(archerélémentaire.contains(p)) {
			archerélémentaire.remove(p);
		}else if(ocelot.contains(p)) {
			ocelot.remove(p);
		}else if(archerélite.contains(p)) {
			archerélite.remove(p);
		}else if(assassin.contains(p)) {
			assassin.remove(p);
		}else if(panda.contains(p)) {
			panda.remove(p);
		}else if(informaticien.contains(p)) {
			informaticien.remove(p);
		}else if(programmeur.contains(p)) {
			programmeur.remove(p);
		}else if(patissier.contains(p)) {
			patissier.remove(p);
		}else if(ours.contains(p)) {
			ours.remove(p);
		}else if(guerriergalactique.contains(p)) {
			guerriergalactique.remove(p);
		}else if(esclave.contains(p)) {
			esclave.remove(p);
		}else if(domination.contains(p)) {
			domination.remove(p);
		}else if(boucher.contains(p)) {
			boucher.remove(p);
		}else if(mathématicien.contains(p)) {
			mathématicien.remove(p);
		}else if(pyro.contains(p)) {
			pyro.remove(p);
		}else if(moutarde.contains(p)) {
			moutarde.remove(p);
		}else if(vampire.contains(p)) {
			vampire.remove(p);
		}else if(nuage.contains(p)) {
			nuage.remove(p);
		}else if(timer.contains(p)) {
			timer.remove(p);
		}else if(robindesbois.contains(p)) {
			robindesbois.remove(p);
		}else if(gandalf.contains(p)) {
			gandalf.remove(p);
		}else if(glowstone.contains(p)) {
			glowstone.remove(p);
		}else if(enderman.contains(p)) {
			enderman.remove(p);
		}else if(rulio.contains(p)) {
			rulio.remove(p);
		}else if(copy.contains(p)) {
			copy.remove(p);
		}else if(pharaon.contains(p)) {
			pharaon.remove(p);
		}else if(furicat.contains(p)) {
			furicat.remove(p);
		}else if(redman.contains(p)) {
			redman.remove(p);
		}else if(trapman.contains(p)) {
			trapman.remove(p);
		}else if(swap.contains(p)) {
			swap.remove(p);
		}else if(golem.contains(p)) {
			golem.remove(p);
		}else if(ogre.contains(p)) {
			ogre.remove(p);
		}else if(bouftout.contains(p)) {
			bouftout.remove(p);
		}else if(enclumex.contains(p)) {
			enclumex.remove(p);
		}else if(fiesta.contains(p)) {
			fiesta.remove(p);
		}else if(power.contains(p)) {
			power.remove(p);
		}else if(dieu.contains(p)) {
			dieu.remove(p);
		}else if(invocation.contains(p)) {
			invocation.remove(p);
		}else if(archervagabon.contains(p)) {
			archervagabon.remove(p);
		}
	}
}
