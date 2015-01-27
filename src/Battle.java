/**
 * Klasse, welche den Kampf zwischen Spieler und Monster verwaltet.
 * @author Nico Weil 4569075 Gruppe 11
 */

import java.util.Scanner;

public class Battle {

    /**
     * battle(Player player) fuehrt den Kampf zwischen Monster und dem in
     * Klammern uebergebenen Spielerobjekt aus. Wenn der Spoieler gewinnt wird
     * true zurueckgegeben, wenn nicht false.
     * 
     * @param player
     * @return true(false
     */

    public static boolean battle(Player player) {

        Monster opponent = MonsterFactory.createMonster();

        Scanner sc = new Scanner(System.in);

        while (!player.isDefeated() && !opponent.isDefeated()) {

            System.out.println("---------------------------------");
            System.out.println("Runde " + Round.getRound());
            Round.addRound();
            System.out.println(player.toString());
            System.out.println(opponent.toString());
            System.out.println("Welche Aktion soll ausgefuehrt werden?");
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
                    if (monsterHp == -1) {
                        System.out.println("Die Attacke ging daneben!");
                    } else {
                        System.out.println(player.toString());
                        System.out.println(opponent.toString());
                    }
                    break;

                } else {
                    if (eingabe.equals("2")) {
                        if (player.heal()) {
                            System.out.println("Heilung erfolgreich!");
                            System.out.println(player.toString());
                        } else {
                            System.out.println("Keine Heiltraenke mehr uebrig!");
                        }
                        break;
                    } else {
                        if (eingabe.equals("3")) {
                            System.out.println("Feigling...");
                            break;
                        } else {
                            if (eingabe.equals("4")) {
                                if (!player.enoughAp(25)) {
                                    System.out.println("Nicht genug AP!");
                                    System.out.println("Neue Eingabe?");
                                    continue;
                                } else {
                                    if (!opponent.isAbilityActive() && !player.isAbilityActive()) {
                                        System.out.println("Spieler setzt eine Powerpille ein!");
                                        player.decreaseAp(25);
                                        player.takePowerPill();
                                        System.out.println("Die ATK des Spielers wurden um " + player.getBonusAtk()
                                                + " erhoeht.");
                                        break;
                                    } else {
                                        System.out.println("Spieler hat bereits eine Faehigkeit aktiviert.");
                                        System.out.println("Neue Eingabe?");
                                        continue;
                                    }
                                }
                            } else {
                                if (eingabe.equals("5")) {
                                    if (!player.enoughAp(35)) {
                                        System.out.println("Nicht genug AP!");
                                        System.out.println("Neue Eingabe?");
                                        continue;
                                    } else {
                                        if (!opponent.isAbilityActive() && !player.isAbilityActive()) {
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
                                    if (eingabe.equals("6")) {
                                        if (!player.enoughAp(20)) {
                                            System.out.println("Nicht genug AP!");
                                            System.out.println("Neue Eingabe?");
                                            continue;
                                        } else {
                                            if (!opponent.isAbilityActive() && !player.isAbilityActive()) {
                                                player.decreaseAp(20);
                                                opponent.hasDecreasedHitChance(0.4);
                                                System.out
                                                        .println("Spieler dreht das Monster im Kreis! Dem Monster ist schwindelig!");
                                                System.out.println("Die Genauigkeit des Monsters wurde um "
                                                        + opponent.getDecreasedHitPoints() + " verringert.");
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
                    System.out.println("Keine gueltige Eingabe!");
                    System.out.println("Neue Eingabe?");
                }

            }

            if (!opponent.isDefeated()) {
                System.out.println("Druecke Enter!");
                sc.nextLine();

                System.out.println("---------------------------------");

                if (opponent.isFrozen()) {
                    System.out.println("Das Monster ist gefroren und kann deshalb nicht angreifen.");
                    System.out.println(player.toString());
                    System.out.println(opponent.toString());
                } else {

                    int playerHp = opponent.attack(player);
                    switch (playerHp) {
                    case (-1):
                        System.out.println("Das Monster greift Spieler an!");
                        System.out.println("Die Attacke ging daneben!");
                        break;
                    case (1):
                        System.out.println("Das Monster laedt sich auf!");
                        break;
                    default:
                        System.out.println("Das Monster greift Spieler an!");
                        System.out.println(player.toString());
                        System.out.println(opponent.toString());
                        break;
                    }
                }
            }

            System.out.println("---------------------------------");

            int refilledAp = player.regenerateAp();
            System.out.println("Es wurden " + refilledAp + " AP regeneriert!");

            opponent.roundFinished();
            player.roundFinished();

        }
        if (player.isDefeated()) {
            System.out.println("Monster ist der Gewinner!");
            System.out.println("Spieler verliert!");
            System.out.println();
            return false;

        } else {
            System.out.println("Spieler ist der Gewinner!");
            System.out.println("Monster verliert!");
            System.out.println();
            return true;
        }

    }
}
