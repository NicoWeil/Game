/**
 * Klasse, welche die Runden des Kampfsystemes verwaltet.
 * @author Nico Weil 4569075 Gruppe 11
 */

public class Round {
    
    protected int round;
    
    public Round(int t) {
        this.round = t;
    }
    
    /**
     * Methode addRound() addiert 1 auf die Rundenzahl.
     */
    
    public void addRound() {
        this.round = this.round + 1;
    }
    
    /**
     * Methode getRound liefert die aktuelle Runde zurueck.
     * @return int this.round
     */
    
    public int getRound() {
        return this.round;
    }
    
    /**
     * Methode isEven() gibt booleanschen Wert zurueck, ob die Rundenzahl gerade oder ungerade ist.
     * @return boolean
     */
    
    public static boolean isEven(int x) {
        int remainder = x % 2;
        if(remainder < 0) {
            return false;
        } else {
            return true;
        }
    }

}
