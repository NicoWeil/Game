import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Rundenbasiertes Kampsystem. Der Spieler kaempft gegen ein aus fuenf zur
 * verfuegung stehenden Monstern (zufaellig gewaehlt) und hat mehrere Optionen
 * im Angriff (Angriff, Heiltrank, [Flucht], spezielle Faehigkeiten). Am Ende
 * wird ein Gewinner ausgegeben.
 * 
 * @author Nico Weil 4569075 Gruppe 11
 */

public class Game {
    
    
	public static void main(String[] args) {
	    /*
	     * Contsruktor: Player(maxHP, ATK, HealingPower, ItmeUses, HitChance, maxAP, startAP, APregenerate)
	     */
	    
	    Player player = new Player(100, 15, 40, 3, 0.7, 60, 20, 10);
	    
	    Battle.battle(player);
	}
}