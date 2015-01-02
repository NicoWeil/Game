import java.util.Scanner;


public class Game {
	
	public static void main(String[] args) {
		
		Monster[] monster = new Monster[5];
		
		/*
		 * Constructor: Monster(maxHP, ATK, HitChance)
		 */
		
		monster[0] = new Monster();
		monster[1] = new Monster(100, 18, 0.8);
		monster[2] = new Monster(150, 20, 0.5);
		monster[3] = new Monster(210, 10, 0.9);
		monster[4] = new Monster(125, 13, 0.7);
		
		int monsterIndex = (int) (Math.random() * monster.length);
		
		Monster opponent = monster[monsterIndex];
		
		System.out.println("Ein wildes Monster " + monsterIndex + " erscheint!");
		System.out.println(opponent.toString());
		
		/*
		 * Contsruktor: Player(maxHP, ATK, HealingPower, ItmeUses, HitChance, maxAP, startAP, APregenerate)
		 */
		
		Player player = new Player(100, 15, 40, 3, 0.7, 40, 20, 5);
		
		int round = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(!player.isDefeated() && !opponent.isDefeated()) {
			
			System.out.println("---------------------------------");
            System.out.println("Runde " + round);
            round++;
            System.out.println(opponent.getHitChance());
            System.out.println(player.toString());
            System.out.println(opponent.toString());
            System.out.println("Welche Aktion soll ausgeführt werden?");
            System.out.println("1 Angriff");
            System.out.println("2 Item (" + player.getRemainingItemUses() + ")");
            System.out.println("3 Flucht");
            System.out.println("4 Powerpille (25 AP)");
            System.out.println("5 Eisstrahl (30 AP)");
            System.out.println("6 Nebel (20 AP)");
            
            while (true) { // Schleife immer laufend
                String eingabe = sc.nextLine();
                if (eingabe.equals("1")) {
                    System.out.println("---------------------------------");
                    System.out.println("Spieler greift das Monster an!");
                    int monsterHp = player.attackMonster(opponent);
                    if(monsterHp == -1) {
                    	System.out.println("Die Attacke ging daneben!");
                    } else {
                    	System.out.println(player.toString());
                    	System.out.println(opponent.toString());
                    }
                    break;
                    
                } else {
                    if(eingabe.equals("2")) {
                    	if(player.heal()) {
                    		System.out.println("Heilung erfolgreich!");
                    		System.out.println(player.toString());
                    	} else {
                    		System.out.println("Keine Heiltraenke mehr uebrig!");
                    	}
                    	break;
                    } else {
                    	if(eingabe.equals("3")) {
                    		System.out.println("Feigling...");
                    		break;
                    	} else {
                    		if(eingabe.equals("4")) {
                    			System.out.println("Spieler setzt eine Powerpille ein!");
                    			player.decreaseAp(20);
                    			player.takePowerPill();
                    			break;
                    		} else {
                    			if(eingabe.equals("5")) {
                    				System.out.println("Spieler friert das Monster ein!");
                    				player.decreaseAp(25);
                    				opponent.freeze();
                    				break;
                    			} else {
                    				if(eingabe.equals("6")) {
                    					System.out.println("Spieler dreht das Monster im Kreis! Dem Monster ist schwindelig!");
                    					opponent.hasDecreasedHitChance(0.2);
                    					break;
                    				}
                    			}
                    		}
                    	}
                    }
                    System.out.println("Keine gültige Eingabe!");
                    System.out.println("Neue Eingabe?");
                    }
                
            }
            
            if(!opponent.isDefeated()) {
            	System.out.println("Drücke Enter!");
                sc.nextLine();

                System.out.println("---------------------------------");
                
                if(opponent.isFrozen()) {
                	System.out.println("Das Monster ist gefroren und kann deshalb nicht angreifen.");
                	System.out.println(player.toString());
                	System.out.println(opponent.toString());
                } else {
                System.out.println("Das Monster greift Spieler an!");
                	int playerHp = opponent.attack(player);
                	if(playerHp == -1) {
                		System.out.println("Die Attacke ging daneben!");
                	} else {
                		System.out.println(player.toString());
                		System.out.println(opponent.toString());
                	}
                }
            }
            
            System.out.println("---------------------------------");
            
            int refilledAp = player.regenerateAp();
            System.out.println("Es wurden " + refilledAp + " AP regeneriert!");
            
            opponent.roundFinished();
            player.roundFinished();
            
            }
		if(player.isDefeated()) {
			System.out.println("Monster ist der Gewinner!");
			System.out.println("Spieler verliert!");
			
		} else {
			System.out.println("Spieler ist der Gewinner!");
			System.out.println("Monster verliert!");
		
		}

	}
}

