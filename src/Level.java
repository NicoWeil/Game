/**
 * Klasse, welche ein Spielfeld verwaltet.
 * 
 * @author Nico Weil 4596075 Gruppe 11
 */

public class Level {
    
    /**
     * Javadoc.
     */

    private char[][] map;
    private int positionJ;
    private int positionI;

    /**
     * Constructor des Spielfelds. Es wird der Startpunkt gesucht und die
     * Koordinaten zwischengespeichert.
     * 
     * @param mapData
     */

    public Level(char[][] mapData) {
        
        /**
         * @param mapdata
         */

        this.map = mapData;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    this.positionJ = j;
                    this.positionI = i;
                    return;
                }
            }
        }
    }

    /**
     * Methode drawField() geht mit einer verschachtelten Schleife das 2D-Array
     * durch und gibt pro Schleifendurchlauf ein Zeichen auf der Konsole aus.
     */

    public void drawField() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == this.positionI && j == this.positionJ) {
                    System.out.print("P ");
                } else {
                    System.out.print(map[i][j] + " "); // Ausgabe des Zeichens
                                                       // an Stelle
                                                       // i/j (Indizes)
                }
            }
            System.out.println(); // nur Zeilenumsprung
        }
        System.out.println();
    }

    /**
     * moveUp() bewegt den Spieler ein Feld nach oben falls dieses betretbar
     * ist.
     */

    public void moveUp() {
        if (this.isAccessible(this.positionI - 1, this.positionJ)) {
            this.positionI--;
        } else {
            System.out.println("Dieses Feld ist nicht betretbar!");
        }
    }

    /**
     * moveDown() bewegt Spieler ein Feld nach unten falls dieses betretbar ist.
     */

    public void moveDown() {
        if (this.isAccessible(this.positionI + 1, this.positionJ)) {
            this.positionI++;
        } else {
            System.out.println("Dieses Feld ist nicht betretbar!");
        }
    }

    /**
     * moveLeft() bewegt Spieler ein Feld nach links.
     */

    public void moveLeft() {
        if (this.isAccessible(this.positionI, this.positionJ - 1)) {
            this.positionJ--;
        } else {
            System.out.println("Dieses Feld ist nicht betretbar!");
        }
    }

    /**
     * moveRight bewegt Spieler ein Feld nach rechts falls dieses betretbar ist.
     */

    public void moveRight() {
        if (this.isAccessible(this.positionI, this.positionJ + 1)) {
            this.positionJ++;
        } else {
            System.out.println("Dieses Feld ist nicht betretbar!");
        }
    }

    /**
     * isAccessible() ueberprueft, ob ein in Klammern uebergebenes Feld
     * betretbar ist oder nicht.
     * 
     * @param i int
     * @param j int
     * @return boolean
     */

    private boolean isAccessible(int i, int j) {
        if ((j < 0) || (i < 0) || (i >= map.length) || (j >= map[i].length) || (map[i][j] == 'x')) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * printMovements() gibt Text mit Bewegungsmoeglichkeiten aus.
     */

    public void printMovements() {
        System.out.println("Wohin moechtest du dich bewegen?");
        System.out.println();
        System.out.println("w - hoch");
        System.out.println("s - runter");
        System.out.println("a - links");
        System.out.println("d - rechts");
    }

    /**
     * getTypeOfField() gibt den Typ eines Feldes als char zurueck.
     * 
     * @return char
     */
    public char getTypeOfField() {
        return this.map[this.positionI][this.positionJ];

    }

    /**
     * overWriteTypeOfField(char x) ueberschreibt das aktuelle Feld des Spielers
     * mit dem in Klammern uebergebenen Zeichen.
     * 
     * @param x (<- @param tag!!!)
     */

    public void overWriteTypeOfField(char x) {
        this.map[this.positionI][this.positionJ] = x;
    }
}
