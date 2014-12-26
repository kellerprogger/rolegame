import java.util.Scanner;

/**
 * Dieses ist ein kleines Minispiel
 * 
 * @author kellerprogger
 *
 */
public class Game {

	public static void main(String[] args) {
		Scanner eingabe = new Scanner(System.in);
		Player Spieler = new Player();
		Monster Monster = new Monster(200, 15, 0.8);
		Monster MonsterWeak = new Monster(90, 9, 0.9);
		Monster MonsterStrong = new Monster(120, 12, 0.7);

		
		System.out.println(Spieler);
		System.out.println(Monster);
		
		while (Spieler.isAlive() && Monster.isAlive()) {
			System.out.println("Moegliche Aktionen:");
			System.out.println("1 -> Angriff");
			System.out.println("2 -> Item (" + Spieler.getRemainingItemUses() + " verbleibend");
			System.out.println("3 -> Spezialfähigkeiten (" + Spieler.getRemainingAP() + " AP verbleibend)");
			System.out.println("Welche Aktion?:");
		    String antwort = eingabe.nextLine();
			int damage;
		    
		    switch(antwort) {
	    		case "1": {																		// Case for attack			
	    			if((damage = Spieler.attack(Monster)) >= 0) {
	    				Monster.takeDamage(damage);
		    			System.out.println("Du hast einen Schaden von " + damage + " Punkten gemacht!");
		    			System.out.println(Spieler);
		    			System.out.println(Monster);
	    			} else {
		    			System.out.println("Ziel verfehlt!");
		    			System.out.println(Spieler);
		    			System.out.println(Monster);
	    			}
	    			break;
	    		} case "2": {																	// Case for heal
	    			if (Spieler.heal()) {
	    				System.out.println("Du wurdest um " + Spieler.getHealingPower() + " Punkte geheilt.");
		    			System.out.println(Spieler);
	    			} else {
	    				System.out.println("Du hast keine Tränke mehr. Der Gegner greift nun an!");
	    			}
	    			break;
	    		} case "3": {
	    			System.out.println("1 -> Furienschlag (50% Chance bis zu 6 mal zu treffen mit je 30% des Angriffs)");
	    			System.out.println("2 -> Selbstaufopferung (Hälfte deines Lebens wird dir und dem Gegner abgezogen");
	    			System.out.println("3 -> Fluch d. Schwerts (Doppelteattacke für eine Runde)");
	    			String ap = eingabe.nextLine();
	    			switch(ap) {
	    			 	case "1": {																	// Special Attack Furienschlag
	    			 		Spieler.fury(Monster);
	    			 		int attackrounds = Spieler.fury(Monster);
	    			 		damage = (int) (attackrounds * 0.3 * Spieler.getAtk());
	    			 		Monster.takeDamage(damage);
	    			 		System.out.println("Du hast " + attackrounds + " mal getroffen und " + damage + " Schaden verursacht");
	    			 		break;
	    			 	} case "2": {																	// Special Attack Selbstaufopferung
	    			 		damage = Spieler.sacrific();
	    			 		Monster.takeDamage(damage);
	    			 		System.out.println("Du hast " + damage + " Schaden verursacht und die Hälfte deines Lebens verloren");
	    			 		break;
	    			 	} case "3": {																	// Special Attack Schwer
	    			 		damage = Spieler.sword();
	    			 		Monster.takeDamage(damage);
	    			 		System.out.println("Du hast dein Schwert verflucht und verursacht doppelten Schaden diese Runde.");
	    			 		break;
	    			 	}
	    			}
    			    Spieler.regenerateAp();
			 		break;
		    	} default: {																	// Case for wrong enter
	    			System.out.println("noob, still too low! level higher for more feautures!");
	    			continue;
	    		}

		    }
		    System.out.println("");
		    if (Monster.isAlive()) {
		    	System.out.println("Das Monster greift an!");
		    	if((damage = Monster.attack(Spieler)) >= 0) {
    				Spieler.takeDamage(damage);
	    			System.out.println("Monster hat einen Schaden von " + damage + " Punkten gemacht!");
	    			System.out.println(Spieler);
	    			System.out.println(Monster);
    			} else {
	    			System.out.println("Ziel verfehlt!");
	    			System.out.println(Spieler);
	    			System.out.println(Monster);
	    			System.out.println();
    			}
		    } 
		}
		// Ende von der while-Schleife --> irgendwer is tot
	    eingabe.close();		
	    if (Spieler.isAlive()) {
	    	System.out.println("Du hast gewonnen!");
	    } else {
	    	System.out.println("Das Monster hat dich getötet! Ein neuer Versuch?s");
	    }
	}
}
