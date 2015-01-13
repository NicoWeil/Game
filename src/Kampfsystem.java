/**
 * Diese Klasse fuehrt ein rundenbasiertes Kampfsystem aus. Pro Runde hat der
 * Spieler die Moeglichkeit, anzugreifen oder einen Heiltrank einzusetzen. Beides 
 * beendet den Zug des Spielers. Danach greift der Gegner an. Sobald einer der beiden
 * Spieler keine Lebenspunkte mehr hat, ist der Kampf beendet
 * 
 * Die Attribute der beiden Spieler sind fest definiert und koennen bei der Ausfuehrung
 * nicht veraendert werden.
 * 
 * Die Klasse erzeugt Objekte, welche in der Klasse Kaempfer.java definiert sind.
 * Dies gilt ebenfalls für einige Methoden.
 * 
 * @author Nico Weil (4569075)
 * @ 07.12.2014
 */

import java.util.Scanner;

public class Kampfsystem {

    public static void main(String args []) {

        Kaempfer player = new Kaempfer(100, 15, 100, 30, 0.7); // Objekt player
                                                               // mit (HP, ATK,
                                                               // maxHP, Item,
                                                               // HIT)
        Kaempfer monster = new Kaempfer(200, 13, 200, 0, 0.9); // Objekt
                                                               // monster
                                                               // mit (HP,
                                                               // ATK,
                                                               // maHP,
                                                               // Item,
                                                               // HIT);
                                                               // maxHP und
                                                               // Item
                                                               // nicht
                                                               // benötigt

        int round = 1;

        int anzahlItems = 3;

        Scanner sc = new Scanner(System.in);

        while (!player.isDead() && !monster.isDead()) { // Schleife solange
                                                        // beide am Leben sind
                                                        // (Umkehrung mit !)

            System.out.println("---------------------------------");
            System.out.println("Runde " + round);
            round++;

            System.out.println("Spieler -- HP " + player.getHealthPoints()
                    + " -- ATK " + player.getAttackPoints());
            System.out.println("Monster -- HP " + monster.getHealthPoints()
                    + " -- ATK " + monster.getAttackPoints());

            System.out.println("Welche Aktion soll ausgeführt werden?");
            System.out.println("1 Angriff");
            System.out.println("2 Item (" + anzahlItems + " verbleibend)");

            while (true) { // Schleife immer laufend
                String eingabe = sc.nextLine();
                if (eingabe.equals("1")) {
                    System.out.println("---------------------------------");
                    System.out.println("Spieler greift das Monster an!");
                    monster.attackedBy(player);
                    System.out.println("Spieler -- HP "
                        + player.getHealthPoints() + " -- ATK "
                        + player.getAttackPoints());
                    System.out.println("Monster -- HP "
                        + monster.getHealthPoints() + " -- ATK "
                        + monster.getAttackPoints());
                    break;
                 } else {
                     if (eingabe.equals("2")) {
                         if (anzahlItems > 0) {
                            player.usesItem();
                            anzahlItems--;
                            System.out.println("Spieler -- HP "
                                + player.getHealthPoints());
                         } else {
                            System.out.println("Keine Heiltraenke mehr!");
                         }
                     break;
                     }
                }
                System.out.println("Keine gültige Eingabe!"); // Wenn eingabe=1
                                                              // oder 2 dann
                                                              // break, wenn
                                                              // nicht Ausgabe
                                                              // und erneutes
                                                              // Durchlaufen
                System.out.println("Neue Eingabe?");
                }

            if (!monster.isDead()) {
                System.out.println("Drücke eine Enter!");
                sc.nextLine();

                System.out.println("---------------------------------");
                System.out.println("Das Monster greift Spieler an!");
                player.attackedBy(monster);
                System.out.println("Spieler -- HP " + player.getHealthPoints()
                    + " -- ATK " + player.getAttackPoints());
                System.out.println("Monster -- HP " + monster.getHealthPoints()
                   + " -- ATK " + monster.getAttackPoints());
                }
        }
        System.out.println("---------------------------------");

        if (player.isDead()) { // Wenn einer von beiden tot ist, dann Ausgabe
                               // des Gewinners

            System.out.println("Monster ist der Gewinner!");
            System.out.println("Spieler verliert!");

        } else {
            System.out.println("Spieler ist der Gewinner!");
            System.out.println("Monster verliert!");
        }
    }
}
