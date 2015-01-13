import java.lang.reflect.Array;
import java.util.Scanner;


public class Game {
    
    
	public static void main(String[] args) {
		
		Monster[] [] monster = new Monster[2] [5];
		
		/*
		 * Constructor: Monster(maxHP, ATK, HitChance)
		 */
		
		monster[0] [0] = new Monster();
		monster[0] [1] = new Monster(100, 18, 0.8);
		monster[0] [2] = new Monster(150, 20, 0.5);
		monster[0] [3] = new Monster(210, 10, 0.9);
		monster[0] [4] = new Monster(125, 13, 0.7);
		monster[1] [0] = new MonsterA();
		monster[1] [1] = new MonsterA(100, 18, 0.8);
		monster[1] [2] = new MonsterA(150, 20, 0.5);
		monster[1] [3] = new MonsterA(210, 10, 0.9);
		monster[1] [4] = new MonsterA(125, 13, 0.7);
		
		int arrayIndex = (int) (Math.random() * monster.length);
		
		int monsterIndex = (int) (Math.random() * monster[arrayIndex].length);
		
		Monster opponent = monster[arrayIndex] [monsterIndex];
		
		if(opponent.isSpecial()) {
		    System.out.println("Ein spezielles Monster greift an!");
		    opponent.toString();
		} else {
		    System.out.println("Ein normales Monster greift an!");
	          opponent.toString();

		}
		/*
		 * Contsruktor: Player(maxHP, ATK, HealingPower, ItmeUses, HitChance, maxAP, startAP, APregenerate)
		 */
		
		Player player = new Player(100, 15, 40, 3, 0.7, 60, 20, 10);
		
		Round round = new Round(1);
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(!player.isDefeated() && !opponent.isDefeated()) {
			
			System.out.println("---------------------------------");
            System.out.println("Runde " + round.getRound());
            round.addRound();
            System.out.println(player.toString());
            System.out.println(opponent.toString());
            System.out.println("Welche Aktion soll ausgeführt werden?");
            System.out.println("1 Angriff");
            System.out.println("2 Item (" + player.getRemainingItemUses() + ")");
            System.out.println("3 Flucht");
            System.out.println("4 Powerpille (25 AP)");
            System.out.println("5 Eisstrahl (35 AP)");
            System.out.println("6 Monster im Kreis drehen (20 AP)");
            
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
                    			if(!player.enoughAp(25)) {
                    				System.out.println("Nicht genug AP!");
                    				System.out.println("Neue Eingabe?");
                    				continue;
                    			} else {
                    				if(!opponent.isAbilityActive() && !player.isAbilityActive()) {
                    				System.out.println("Spieler setzt eine Powerpille ein!");
                    				player.decreaseAp(25);
                    				player.takePowerPill();
                    				System.out.println("Die ATK des Spielers wurden um " + player.getBonusAtk() + " erhöht.");
                    				break;
                    				} else {
                    					System.out.println("Spieler hat bereits eine Faehigkeit aktiviert.");
                    					System.out.println("Neue Eingabe?");
                    					continue;
                    				}
                    			}
                    		} else {
                    			if(eingabe.equals("5")) {
                    				if(!player.enoughAp(35)) {
                    					System.out.println("Nicht genug AP!");
                        				System.out.println("Neue Eingabe?");
                        				continue;
                    				} else {
                    					if(!opponent.isAbilityActive() && !player.isAbilityActive()) {
                    						player.decreaseAp(35);
                    						opponent.freeze();
                    						System.out.println("Spieler friert das Monster ein!");
                    						break;
                    					} else {
                    						System.out.println("Spieler hat bereits eine Faehigkeit aktiviert.");
                    						System.out.println("Neue Eingabe?");
                    						continue;
                    					}
                    				}
                        		} else {
                        			if(eingabe.equals("6")) {
                        				if(!player.enoughAp(20)) {
                        					System.out.println("Nicht genug AP!");
                            				System.out.println("Neue Eingabe?");
                            				continue;
                        				} else {
                        					if(!opponent.isAbilityActive() && !player.isAbilityActive()) {
                        						player.decreaseAp(20);
                        						opponent.hasDecreasedHitChance(0.4);
                        						System.out.println("Spieler dreht das Monster im Kreis! Dem Monster ist schwindelig!");
                        						System.out.println("Die Genauigkeit des Monsters wurde um " + opponent.getDecreasedHitPoints() + " verringert.");
                        						break;
                        					} else {
                        						System.out.println("Spieler hat bereits eine Faehigkeit aktiviert.");
                        						System.out.println("Neue Eingabe?");
                        						continue;
                        					}
                        				}
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

