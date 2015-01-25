/**
 * Klasse zur Erzeugung eines speziellen Monsterobjektes, welches nur jede
 * zweite Runde angreift, dafür allerdings mit doppelter ATK.
 * 
 * @author Nico Weil 4569075 Gruppe 11
 *
 */

public class MonsterB extends Monster {

    /**
     * Constructor.
     * 
     * @param maxH
     * @param a
     * @param y
     */

    public MonsterB(int maxH, int a, double y) {

        this.hp = maxH;
        this.maxHP = maxH;
        this.atk = a;
        this.hitChance = y;
        this.frozen = false;
        this.specialAbilityDuration = 0;
        this.decreasedHitChance = false;
        this.decreasedHitPoints = 0.0;

    }

    /**
     * Constructor.
     */

    public MonsterB() {

        this.hp = 200;
        this.maxHP = 200;
        this.atk = 10;
        this.hitChance = 0.9;
        this.frozen = false;
        this.specialAbilityDuration = 0;
        this.decreasedHitChance = false;
        this.decreasedHitPoints = 0.0;

    }

    /**
     * Methode attack(Player player) fügt dem uebergebenen Objekt Schaden zu.
     */

    public int attack(Player player) {
        if (Round.isEven()) {
            double zufallsZahlVergleich = Math.random();
            if (zufallsZahlVergleich > (this.hitChance - this.decreasedHitPoints)) {
                return -1;
            } else {
                double zufallsZahl = Math.random() + 2;
                player.takeDamage((int) (this.atk * zufallsZahl));
                return player.getHp();
            }

        } else {
            return 1;
        }
    }

    /**
     * isSpecial() gibt zurueck, ob Monster spezielle Faehigkeiten hat.
     */

    public boolean isSpecial() {
        return true;
    }
}
