/**
 * Klasse, welche von Monster abgeleitet wird; zur Erzeugung eines
 * Monsterobjekts, welches weniger Schaden nimmt ("Gummimonster").
 * 
 * @author Nico
 *
 */

public class MonsterA extends Monster {

    public MonsterA(int maxH, int a, double y) {

        this.hp = maxH;
        this.maxHP = maxH;
        this.atk = a;
        this.hitChance = y;
        this.frozen = false;
        this.specialAbilityDuration = 0;
        this.decreasedHitChance = false;
        this.decreasedHitPoints = 0.0;

    }

    public MonsterA() {

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
     * Methode takeDamage fuegt dem Charakter die Hälfte des durch damage
     * uebergebenen Schaden zu. Sie ueberschreibt takeDamage der Basisklasse.
     * 
     */

    public void takeDamage(int damage) {
        this.hp -= (damage * 0.5);
        if (this.hp <= 0) {
            this.hp = 0;
        }
    }

    /**
     * Methode attack(Player player) fuegt dem uebergebenen Objekt Schaden zu,
     * allerdings nur mit 0.5*ATK des Spielers.
     */

    public int attack(Player player) {
        double zufallsZahlVergleich = Math.random();
        if (zufallsZahlVergleich > (this.hitChance - this.decreasedHitPoints)) {
            return -1;
        } else {
            double zufallsZahl = Math.random() + 1;
            player.takeDamage((int) ((this.atk * 0.5) * zufallsZahl));
            return player.getHp();
        }
    }

    /**
     * Methode isSpecial() gibt booleanschen Wert zurueck ob Monster normal oder
     * speziell.
     */

    public boolean isSpecial() {
        return true;
    }
}
