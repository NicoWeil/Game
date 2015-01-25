import java.util.Scanner;

/**
 * Main-Klasse, welche einen Dungeon Crawler erstellt.
 * 
 * @author Nico Weil 4569075 Gruppe 11
 *
 */
public class Crawler {
    /**
     * Javadoc Comment.
     * @param args
     */

    public static void main(String[] args) {

        char[][] mapData = {{'x', 'x', 'x', 'x', 'x', 'x'}, 
                            {'x', '.', 'T', 'B', '.', 'x'},
                            {'x', 'O', '.', 'O', 'B', 'x'}, 
                            {'x', 'B', 'x', 'x', '.', 'x'}, 
                            {'x', '.', 'B', 'B', '.', 'Z'},
                            {'x', 'S', 'x', 'x', 'x', 'x'},
                            };

        Level playingField = new Level(mapData);

        Player player = new Player(100, 15, 40, 3, 0.7, 45, 20, 10);

        Scanner sc = new Scanner(System.in);

        System.out.println(player.toString());

        DungeonCrawler: while (true) {
            playingField.drawField();
            playingField.printMovements();
            String input2 = sc.nextLine();
            switch (input2) {
            case "w":
                playingField.moveUp();
                break;
            case "s":
                playingField.moveDown();
                break;
            case "a":
                playingField.moveLeft();
                break;
            case "d":
                playingField.moveRight();
                break;
            default:
                System.out.println("Keine gueltige Eingabe. Neue Eingabe?");
            }
            char typeOfField = playingField.getTypeOfField();
            switch (typeOfField) {
            case 'O':
                player.entersFountain();
                System.out.println(player.toString());
                break;
            case 'T':
                player.entersSmith();
                playingField.overWriteTypeOfField('t');
                System.out.println(player.toString());
                break;
            case 'B':
                if (Battle.battle(player)) {
                    playingField.overWriteTypeOfField('I');
                    break;
                } else {
                    System.out.println("Du hast verloren.");
                    System.out.println("-Game Over-");
                    break DungeonCrawler;
                }
            case 'Z':
                System.out.println("Du hast das Ziel erreicht! Herzlichen Glueckwunsch!");
                break DungeonCrawler;
            case 'I':
                player.addItem();
                System.out.println("Du hast einen Heiltrank gefunden!");
                System.out.println(player);
                break;
            case 't':
                System.out.println("Die Schmiede hat geschlossen.");
            default:
                break;
            }
        }
    }
}
