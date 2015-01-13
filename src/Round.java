/**
 * Klasse, welche die Runden des Kampfsystemes verwaltet.
 * @author Nico Weil 4569075 Gruppe 11
 */

public class Round {
    
    private static int round = 0;
    
    
    
    /**
     * Methode addRound() addiert 1 auf die Rundenzahl.
     */
    
    public static void addRound() {
        round++;
    }
    
    /**
     * Methode getRound liefert die aktuelle Runde zurueck.
     * @return int this.round
     */
    
    public static int getRound() {
        return round;
    }
    
    /**
     * Methode isEven() gibt booleanschen Wert zurueck, ob die Rundenzahl gerade oder ungerade ist.
     * @return boolean
     */
    
    public static boolean isEven() {
        int remainder = round % 2;
        if(remainder > 0) {
            return false;
        } else {
            return true;
        }
    }

}
