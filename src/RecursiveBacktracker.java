public class RecursiveBacktracker implements MazeGenerator {

    int startX;
    int startY;
    char[][] map;

    /**
     * Methode generatePath(int y, int x) erzeugt einen zufaelligen Pfad von in
     * Klammern uebergebenen Startkoordinaten. Dazu wird eine Liste von
     * Richtungen angelegt, in die der Algorithmus vom aktuellen Raum "laufen"
     * kann. Aus dieser Liste wird zufaellig eine Richtung gewaehlt. Ist das
     * benachbarte Feld in diser Richtung betretbar (sprich ist es weder Mauer,
     * noch auﬂerhalb des Feldes, noch schon besucht), wird die Mauer zwischen
     * den Raeumen entfernt (also mit freiem Feld ueberschrieben) und der Raum
     * als beucht markiert. Dann wird die Methode rekursiv fuer diesen Raum
     * angewendet etc. Ist der Raum nicht betretbar wird die naechste Richtung
     * der Liste genutzt, um einen Raum zu pruefen. Ist man wieder beim
     * Startraum angelangt, wird true zurueckgegegeben.
     * 
     * @param y
     * @param x
     * @return
     */

    private boolean generatePath(int y, int x) {

        this.map[y][x] = FREE; // als betreten markiert
        char[] direction = new char[4];
        int index = (int) (Math.random() * 4);
        direction[index] = 'N';
        direction[(index + 1) % 4] = 'E';
        direction[(index + 2) % 4] = 'S';
        direction[(index + 3) % 4] = 'W';

        for (int i = 0; i < direction.length; i++) {
            int nextY = y;
            int nextX = x;
            switch (direction[i]) {
            case 'N':
                nextY = y - 2;
                break;
            case 'E':
                nextX = x + 2;
                break;
            case 'S':
                nextY = y + 2;
                break;
            case 'W':
                nextX = x - 2;
                break;
            }
            if (isAvailable(nextY, nextX)) {
                int wallY = (y + nextY) / 2; // Mittelwert
                int wallX = (x + nextX) / 2;
                this.map[wallY][wallX] = FREE;
                if (generatePath(nextY, nextX)) { // rekursiver Aufruf
                    return true;
                }
            }
        }
        if (y == startY && x == startX) {
            return true;
        }
        return false;
    }

    /**
     * Methode isAvailable() ueberprueft, ob ein Feld betretbar ist oder nicht
     * und gibt einen booleanschen Wert zurueck.
     * 
     * @param y
     * @param x
     * @return
     */

    private boolean isAvailable(int y, int x) {
        return (y < this.map.length && y >= 0 && x < this.map[y].length && x >= 0 && this.map[y][x] == SPACE);
    }

    /**
     * Methode generate(int height, int width) erzeugt ein 2D char Array mit der
     * in Klammern uebergebenen Dimension und gibt dieses zurueck. Das 2D Array
     * besteht zuerst aus freien Feldern, die von Waenden umgeben sind (Raeume).
     * Durch die Methode generatePath() wird ein Pfad in diesem Array durch
     * entfernen von Waenden zwischen Raeumen von einem in Klammern uebergebenen
     * Startraum erzeugt. Merke: Hoehe und Breite des Spielfeldes (Dimension)
     * muessen ungerade sein, da es sonst seuin koennte, dass es nach auﬂen
     * offene Raeume gibt. Um zu vermeiden, dass gerade Zahlen uebergeben
     * werden, existiert eine IllegalArgumentException. Die Startkoordinaten des
     * Raumes werden so generiert, dass sie in jedem Fall auf einem ungeraden
     * Index des Arrays landen, da freie Felder nur auf ungeraden Indizes liegen
     * koennen.
     * 
     */

    public char[][] generate(int height, int width) {

        if (height % 2 == 0 || width % 2 == 0) {
            throw new IllegalArgumentException("Generate darf nicht mit geraden Zahlen aufgerufen werden.");
        }
        this.map = new char[height][width];
        for (int y = 0; y < this.map.length; y++) {
            for (int x = 0; x < this.map[y].length; x++) {
                if (y % 2 == 0 || x % 2 == 0) {
                    this.map[y][x] = WALL;
                } else {
                    this.map[y][x] = SPACE;
                  }
            }
        }
        this.startX = (int) (Math.random() * (width / 2)) * 2 + 1; // width
                                                                   // ungerade
        this.startY = (int) (Math.random() * (height / 2)) * 2 + 1;
        generatePath(startY, startX);
        map[startY][startX] = START;
        this.map = FreeFields.placeSpecialFields(map, height, width, 5, 7, 10);
        return this.map;
    }
}
