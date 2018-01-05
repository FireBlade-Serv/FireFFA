package eu.fireblade.fireffa;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.ability.ArcherElite;
import eu.fireblade.fireffa.ability.Bouftout;
import eu.fireblade.fireffa.ability.Copy;
import eu.fireblade.fireffa.ability.DevDePacotille;
import eu.fireblade.fireffa.ability.Domination;
import eu.fireblade.fireffa.ability.Enclumex;
import eu.fireblade.fireffa.ability.Enderman;
import eu.fireblade.fireffa.ability.Fantôme;
import eu.fireblade.fireffa.ability.Fiesta;
import eu.fireblade.fireffa.ability.Furicat;
import eu.fireblade.fireffa.ability.Gameur;
import eu.fireblade.fireffa.ability.Gandalf;
import eu.fireblade.fireffa.ability.Glowstone;
import eu.fireblade.fireffa.ability.Golem;
import eu.fireblade.fireffa.ability.Grampa;
import eu.fireblade.fireffa.ability.GuerrierGalactique;
import eu.fireblade.fireffa.ability.Invocation;
import eu.fireblade.fireffa.ability.Magicien;
import eu.fireblade.fireffa.ability.Moutarde;
import eu.fireblade.fireffa.ability.Nuage;
import eu.fireblade.fireffa.ability.Ocelot;
import eu.fireblade.fireffa.ability.Ours;
import eu.fireblade.fireffa.ability.PandaRoux;
import eu.fireblade.fireffa.ability.Patissier;
import eu.fireblade.fireffa.ability.Pharaon;
import eu.fireblade.fireffa.ability.Power;
import eu.fireblade.fireffa.ability.RedMan;
import eu.fireblade.fireffa.ability.RobinDesBois;
import eu.fireblade.fireffa.ability.Swap;
import eu.fireblade.fireffa.ability.Timer;
import eu.fireblade.fireffa.ability.VoleurÂmes;
import eu.fireblade.fireffa.items.Kits;

public class Var {
	
	public static String SqlUrlBase = "jdbc:mysql://", host, db, user, password;
	
	public static int wbtask, sqltask;
	
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
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static ArrayList<Player> inGame = new ArrayList<Player>();
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static HashMap<Player, Integer> killStreak = new HashMap<Player, Integer>();
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static ArrayList<Location> spawn = new ArrayList<Location>();
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	
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
			
			if(Grampa.cooldown.contains(p)) {
				Grampa.cooldown.remove(p);
			}
		}else if(mineur.contains(p)) {
			mineur.remove(p);
		}else if(jihadist.contains(p)) {
			jihadist.remove(p);
		}else if(gamer.contains(p)) {
			gamer.remove(p);
			
			if(Gameur.cooldown.contains(p)) {
				Gameur.cooldown.remove(p);
			}
			
			if(Gameur.cooldown2.contains(p)) {
				Gameur.cooldown2.remove(p);
			}
		}else if(sauvage.contains(p)) {
			sauvage.remove(p);
		}else if(archerélémentaire.contains(p)) {
			archerélémentaire.remove(p);
		}else if(ocelot.contains(p)) {
			ocelot.remove(p);
			
			if(Ocelot.cooldown.contains(p)) {
				Ocelot.cooldown.remove(p);
			}
		}else if(archerélite.contains(p)) {
			archerélite.remove(p);
			ArcherElite.cooldown.remove(p);
		}else if(assassin.contains(p)) {
			assassin.remove(p);
		}else if(panda.contains(p)) {
			panda.remove(p);
			
			if(PandaRoux.cooldown.contains(p)) {
				PandaRoux.cooldown.remove(p);
			}
		}else if(informaticien.contains(p)) {
			informaticien.remove(p);
		}else if(programmeur.contains(p)) {
			programmeur.remove(p);
			
			if(DevDePacotille.cooldown.contains(p)) {
				DevDePacotille.cooldown.remove(p);
			}
		}else if(patissier.contains(p)) {
			patissier.remove(p);
			
			if(Patissier.cooldown.contains(p)) {
				Patissier.cooldown.remove(p);
			}
		}else if(ours.contains(p)) {
			ours.remove(p);
			
			if(Ours.cooldown.contains(p)) {
				Ours.cooldown.remove(p);
			}
		}else if(guerriergalactique.contains(p)) {
			guerriergalactique.remove(p);
			
			if(GuerrierGalactique.cooldown.contains(p)) {
				GuerrierGalactique.cooldown.remove(p);
			}
		}else if(esclave.contains(p)) {
			esclave.remove(p);
		}else if(domination.contains(p)) {
			domination.remove(p);
			
			if(Domination.cooldown.contains(p)) {
				Domination.cooldown.remove(p);
			}
		}else if(boucher.contains(p)) {
			boucher.remove(p);
		}else if(mathématicien.contains(p)) {
			mathématicien.remove(p);
		}else if(pyro.contains(p)) {
			pyro.remove(p);
		}else if(moutarde.contains(p)) {
			moutarde.remove(p);
			
			if(Moutarde.cooldown.contains(p)) {
				Moutarde.cooldown.remove(p);
			}
		}else if(vampire.contains(p)) {
			vampire.remove(p);
		}else if(nuage.contains(p)) {
			nuage.remove(p);
			
			if(Nuage.tasks.containsKey(p)) {
				Bukkit.getScheduler().cancelTask(Nuage.tasks.get(p));
				
				Nuage.tasks.remove(p);
			}
		}else if(timer.contains(p)) {
			timer.remove(p); 
			
			if(Timer.cooldown.contains(p)) {
				Timer.cooldown.remove(p);
			}
		}else if(robindesbois.contains(p)) {
			robindesbois.remove(p);
			
			if(RobinDesBois.cooldown.contains(p)) {
				RobinDesBois.cooldown.remove(p);
			}
		}else if(gandalf.contains(p)) {
			gandalf.remove(p);
			
			if(Gandalf.cooldown.contains(p)) {
				Gandalf.cooldown.remove(p);
			}
		}else if(glowstone.contains(p)) {
			glowstone.remove(p);
			
			if(Glowstone.cooldown.contains(p)) {
				Glowstone.cooldown.remove(p);
			}
			
			if(Glowstone.tasks.containsKey(p)) {
				Bukkit.getScheduler().cancelTask(Glowstone.tasks.get(p));
				
				Glowstone.tasks.remove(p);
			}
		}else if(enderman.contains(p)) {
			enderman.remove(p);
			
			if(Enderman.cooldown.contains(p)) {
				Enderman.cooldown.remove(p);
			}
		}else if(rulio.contains(p)) {
			rulio.remove(p);
		}else if(copy.contains(p)) {
			copy.remove(p);
			
			if(Copy.cooldown.contains(p)) {
				Copy.cooldown.contains(p);
			}
		}else if(pharaon.contains(p)) {
			pharaon.remove(p);
			
			if(Pharaon.cooldown.contains(p)) {
				Pharaon.cooldown.remove(p);
			}
		}else if(furicat.contains(p)) {
			furicat.remove(p);
			
			if(Furicat.cooldown.contains(p)) {
				Furicat.cooldown.remove(p);
			}
		}else if(redman.contains(p)) {
			redman.remove(p);
			
			if(RedMan.cooldown.contains(p)) {
				RedMan.cooldown.remove(p);
			}
		}else if(trapman.contains(p)) {
			trapman.remove(p);
		}else if(swap.contains(p)) {
			swap.remove(p);
		}else if(golem.contains(p)) {
			golem.remove(p);
			
			if(Golem.cooldown.contains(p)) {
				Golem.cooldown.remove(p);
			}
		}else if(ogre.contains(p)) {
			ogre.remove(p);
		}else if(bouftout.contains(p)) {
			bouftout.remove(p);
			
			if(Bouftout.cooldown.contains(p)) {
				Bouftout.cooldown.remove(p);
			}
		}else if(enclumex.contains(p)) {
			enclumex.remove(p);
			
			if(Enclumex.cooldown.contains(p)) {
				Enclumex.cooldown.remove(p);
			}
		}else if(fiesta.contains(p)) {
			fiesta.remove(p);
			
			if(Fiesta.cooldown.contains(p)) {
				Fiesta.cooldown.remove(p);
			}
		}else if(power.contains(p)) {
			power.remove(p);
			
			if(Power.cooldown.contains(p)) {
				Power.cooldown.remove(p);
			}
			
			if(Power.inload.contains(p)) {
				Power.inload.remove(p);
			}
			
			if(Power.max.containsKey(p)) {
				Power.max.remove(p);
			}
			
			if(Power.tasks.containsKey(p)) {
				Bukkit.getScheduler().cancelTask(Power.tasks.get(p));
				
				Power.tasks.remove(p);
			}
			
			if(Power.cooldown2.contains(p)) {
				Power.cooldown2.remove(p);
			}
			
			if(Power.Bouclier.contains(p)) {
				Power.Bouclier.remove(p);
			}
		}else if(dieu.contains(p)) {
			dieu.remove(p);
		}else if(invocation.contains(p)) {
			invocation.remove(p);
			
			if(Invocation.cooldown.contains(p)) {
				Invocation.cooldown.remove(p);
			}
		}else if(archervagabon.contains(p)) {
			archervagabon.remove(p);
		}
	}
	
	public static void switchArray(Player p, Player t) {
		if(démolisseur.contains(t)) {
			démolisseur.remove(t);
			swap.add(t);
			démolisseur.add(p);
			swap.remove(p);
		}else if(fantôme.contains(t)) {
			fantôme.remove(t);
			swap.add(t);
			t.removePotionEffect(PotionEffectType.INVISIBILITY);
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
			fantôme.add(p);
			swap.remove(p);
		}else if(tank.contains(t)) {
			tank.remove(t);
			swap.add(t);
			t.removePotionEffect(PotionEffectType.SLOW);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0));
			tank.add(p);
			swap.remove(p);
		}else if(flic.contains(t)) {
			flic.remove(t);
			swap.add(t);
			flic.add(p);
			swap.remove(p);
		}else if(magicien.contains(t)) {
			magicien.remove(t);
			swap.add(t);
			magicien.add(p);
			swap.remove(p);	
		}else if(chevalier.contains(t)) {
			chevalier.remove(t);
			swap.add(t);
			chevalier.add(p);
			swap.remove(p);
		}else if(cactus.contains(t)) {
			cactus.remove(t);
			swap.add(t);
			t.removePotionEffect(PotionEffectType.SPEED);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
			cactus.add(p);
			swap.remove(p);
		}else if(piaf.contains(t)) {
			piaf.remove(t);
			swap.add(t);
			piaf.add(p);
			swap.remove(p);
		}else if(voleurdame.contains(t)) {
			voleurdame.remove(t);
			swap.add(t);
			voleurdame.add(p);
			swap.remove(p);
		}else if(OITCman.contains(t)) {
			OITCman.remove(t);
			swap.add(t);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
			t.removePotionEffect(PotionEffectType.SPEED);
			OITCman.add(p);
			swap.remove(p);
		}else if(lapin.contains(t)) {
			lapin.remove(t);
			swap.add(t);
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 6));
			t.removePotionEffect(PotionEffectType.JUMP);
			lapin.add(p);
			swap.remove(p);
		}else if(russe.contains(t)) {
			russe.remove(t);
			swap.add(t);
			russe.add(p);
			swap.remove(p);
		}else if(grampa.contains(t)) {
			grampa.remove(t);
			swap.add(t);
			grampa.add(p);
			swap.remove(p);
		}else if(mineur.contains(t)) {
			mineur.remove(t);
			swap.add(t);
			mineur.add(p);
			swap.remove(p);
		}else if(jihadist.contains(t)) {
			jihadist.remove(t);
			swap.add(t);
			jihadist.add(p);
			swap.remove(p);
		}else if(gamer.contains(t)) {
			gamer.remove(t);
			swap.add(t);
			gamer.add(p);
			swap.remove(p);gamer.remove(t);
		}else if(sauvage.contains(t)) {
			sauvage.remove(t);
			swap.add(t);
			sauvage.add(p);
			swap.remove(p);
		}else if(archerélémentaire.contains(t)) {
			archerélémentaire.remove(t);
			swap.add(t);
			archerélémentaire.add(p);
			swap.remove(p);
		}else if(ocelot.contains(t)) {
			ocelot.remove(t);
			swap.add(t);
			ocelot.add(p);
			swap.remove(p);
		}else if(archerélite.contains(t)) {
			archerélite.remove(t);
			swap.add(t);
			archerélite.add(p);
			swap.remove(p);
		}else if(assassin.contains(t)) {
			assassin.remove(t);
			swap.add(t);
			assassin.add(p);
			swap.remove(p);
		}else if(panda.contains(t)) {
			panda.remove(t);
			swap.add(t);
			panda.add(p);
			swap.remove(p);
		}else if(informaticien.contains(t)) {
			informaticien.remove(t);
			swap.add(t);
			informaticien.add(p);
			swap.remove(p);
		}else if(programmeur.contains(t)) {
			programmeur.remove(t);
			swap.add(t);
			programmeur.add(p);
			swap.remove(p);
		}else if(patissier.contains(t)) {
			patissier.remove(t);
			swap.add(t);
			patissier.add(p);
			swap.remove(p);
		}else if(ours.contains(t)) {
			ours.remove(t);
			swap.add(t);
			ours.add(p);
			swap.remove(p);
		}else if(guerriergalactique.contains(t)) {
			guerriergalactique.remove(t);
			swap.add(t);
			guerriergalactique.add(p);
			swap.remove(p);
		}else if(esclave.contains(t)) {
			esclave.remove(t);
			swap.add(t);
			esclave.add(p);
			swap.remove(p);
		}else if(domination.contains(t)) {
			domination.remove(t);
			swap.add(t);
			domination.add(p);
			swap.remove(p);
		}else if(boucher.contains(t)) {
			boucher.remove(t);
			swap.add(t);
			boucher.add(p);
			swap.remove(p);
		}else if(mathématicien.contains(t)) {
			mathématicien.remove(t);
			swap.add(t);
			mathématicien.add(p);
			swap.remove(p);
		}else if(pyro.contains(t)) {
			pyro.remove(t);
			swap.add(t);
			pyro.add(p);
			swap.remove(p);
		}else if(moutarde.contains(t)) {
			moutarde.remove(t);
			swap.add(t);
			moutarde.add(p);
			swap.remove(p);
		}else if(vampire.contains(t)) {
			vampire.remove(t);
			swap.add(t);
			vampire.add(p);
			swap.remove(p);
		}else if(nuage.contains(t)) {
			nuage.remove(t);
			swap.add(t);
			nuage.add(p);
			swap.remove(p);
		}else if(timer.contains(t)) {
			timer.remove(t);
			swap.add(t);
			timer.add(p);
			swap.remove(p);
		}else if(robindesbois.contains(t)) {
			robindesbois.remove(t);
			swap.add(t);
			robindesbois.add(p);
			swap.remove(p);
		}else if(gandalf.contains(t)) {
			gandalf.remove(t);
			swap.add(t);
			gandalf.add(p);
			swap.remove(p);
		}else if(glowstone.contains(t)) {
			glowstone.remove(t);
			swap.add(t);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
			t.removePotionEffect(PotionEffectType.SPEED);
			glowstone.add(p);
			swap.remove(p);
		}else if(enderman.contains(t)) {
			enderman.remove(t);
			swap.add(t);
			enderman.add(p);
			swap.remove(p);
		}else if(rulio.contains(t)) {
			rulio.remove(t);
			swap.add(t);
			rulio.add(p);
			swap.remove(p);
		}else if(copy.contains(t)) {
			copy.remove(t);
			swap.add(t);
			copy.add(p);
			swap.remove(p);
		}else if(pharaon.contains(t)) {
			pharaon.remove(t);
			swap.add(t);
			pharaon.add(p);
			swap.remove(p);
		}else if(furicat.contains(t)) {
			furicat.remove(t);
			swap.add(t);
			furicat.add(p);
			swap.remove(p);
		}else if(redman.contains(t)) {
			redman.remove(t);
			swap.add(t);
			redman.add(p);
			swap.remove(p);
		}else if(trapman.contains(t)) {
			trapman.remove(t);
			swap.add(t);
			trapman.add(p);
			swap.remove(p);
		}else if(swap.contains(t)) {
		}else if(golem.contains(t)) {
			golem.remove(t);
			swap.add(t);
			golem.add(p);
			swap.remove(p);
		}else if(ogre.contains(t)) {
			ogre.remove(t);
			swap.add(t);
			ogre.add(p);
			swap.remove(p);
		}else if(bouftout.contains(t)) {
			bouftout.remove(t);
			swap.add(t);
			bouftout.add(p);
			swap.remove(p);
		}else if(enclumex.contains(t)) {
			enclumex.remove(t);
			swap.add(t);
			enclumex.add(p);
			swap.remove(p);
		}else if(fiesta.contains(t)) {
			fiesta.remove(t);
			swap.add(t);
			fiesta.add(p);
			swap.remove(p);
		}else if(power.contains(t)) {
			power.remove(t);
			swap.add(t);
			power.add(p);
			swap.remove(p);
		}else if(dieu.contains(t)) {
			dieu.remove(t);
			swap.add(t);
			dieu.add(p);
			swap.remove(p);
		}else if(invocation.contains(t)) {
			invocation.remove(t);
			swap.add(t);
			invocation.add(p);
			swap.remove(p);
		}else if(archervagabon.contains(t)) {
			archervagabon.remove(t);
			swap.add(t);
			archervagabon.add(p);
			swap.remove(p);
		}
	}
	
	public static void getKit(Player t) {
		if(démolisseur.contains(t)) {
			Kits.kitDemolisseur(t);
		}else if(fantôme.contains(t)) {
			Kits.kitFantome(t);
		}else if(tank.contains(t)) {
			Kits.kitTank(t);
		}else if(flic.contains(t)) {
			Kits.kitFlic(t);
		}else if(magicien.contains(t)) {
			Kits.kitMagicien(t);
		}else if(chevalier.contains(t)) {
			Kits.kitChevalier(t);
		}else if(cactus.contains(t)) {
			Kits.kitCactus(t);
		}else if(piaf.contains(t)) {
			Kits.kitPiaf(t);
		}else if(voleurdame.contains(t)) {
			Kits.kitVoleurdame(t);
		}else if(OITCman.contains(t)) {
			Kits.kitOITCman(t);
		}else if(lapin.contains(t)) {
			Kits.kitLapin(t);
		}else if(russe.contains(t)) {
			Kits.kitRusse(t);
		}else if(grampa.contains(t)) {
			Kits.kitGrampa(t);
		}else if(mineur.contains(t)) {
			Kits.kitMineur(t);
		}else if(jihadist.contains(t)) {
			Kits.kitJihadist(t);
		}else if(gamer.contains(t)) {
			Kits.kitGamer(t);
		}else if(sauvage.contains(t)) {
			Kits.kitSauvage(t);
		}else if(archerélémentaire.contains(t)) {
			Kits.kitArcherelementaire(t);
		}else if(ocelot.contains(t)) {
			Kits.kitOcelot(t);
		}else if(archerélite.contains(t)) {
			Kits.kitArcherelite(t);
		}else if(assassin.contains(t)) {
			Kits.kitAssassin(t);
		}else if(panda.contains(t)) {
			Kits.kitPanda(t);
		}else if(informaticien.contains(t)) {
			Kits.kitInformaticien(t);
		}else if(programmeur.contains(t)) {
			Kits.kitProgrammeur(t);
		}else if(patissier.contains(t)) {
			Kits.kitPatissier(t);
		}else if(ours.contains(t)) {
			Kits.kitOurs(t);
		}else if(guerriergalactique.contains(t)) {
			Kits.kitGuerriergalactique(t);
		}else if(esclave.contains(t)) {
			Kits.kitEsclave(t);
		}else if(domination.contains(t)) {
			Kits.kitDomination(t);
		}else if(boucher.contains(t)) {
			Kits.kitBoucher(t);
		}else if(mathématicien.contains(t)) {
			Kits.kitMathematicien(t);
		}else if(pyro.contains(t)) {
			Kits.kitPyro(t);
		}else if(moutarde.contains(t)) {
			Kits.kitMoutarde(t);
		}else if(vampire.contains(t)) {
			Kits.kitVampire(t);
		}else if(nuage.contains(t)) {
			Kits.kitNuage(t);
		}else if(timer.contains(t)) {
			Kits.kitTimer(t);
		}else if(robindesbois.contains(t)) {
			Kits.kitRobinDesBois(t);
		}else if(gandalf.contains(t)) {
			Kits.kitGandalf(t);
		}else if(glowstone.contains(t)) {
			Kits.kitGlowstone(t);
		}else if(enderman.contains(t)) {
			Kits.kitEnderman(t);
		}else if(rulio.contains(t)) {
			Kits.kitRulio(t);
		}else if(copy.contains(t)) {
			Kits.kitCopy(t);
		}else if(pharaon.contains(t)) {
			Kits.kitPharaon(t);
		}else if(furicat.contains(t)) {
			Kits.kitFuricat(t);
		}else if(redman.contains(t)) {
			Kits.kitRedMan(t);
		}else if(trapman.contains(t)) {
			Kits.kitTrapman(t);
		}else if(swap.contains(t)) {
			Kits.kitSwap(t);
		}else if(golem.contains(t)) {
			Kits.kitGolem(t);
		}else if(ogre.contains(t)) {
			Kits.kitOgre(t);
		}else if(bouftout.contains(t)) {
			Kits.kitBoufTout(t);
		}else if(enclumex.contains(t)) {
			Kits.kitEnclumex(t);
		}else if(fiesta.contains(t)) {
			Kits.kitFiesta(t);
		}else if(power.contains(t)) {
			Kits.kitPower(t);
		}else if(dieu.contains(t)) {
			Kits.kitDieu(t);
		}else if(invocation.contains(t)) {
			Kits.kitInvocation(t);
		}else if(archervagabon.contains(t)) {
			Kits.kitArchervagabon(t);
		}
	}
}

