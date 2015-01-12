/**
 * Klasse, welche von Monster abgeleitet wird; zur Erzeugung eines
 * Monsterobjekts, welches weniger Schaden nimmt ("Gummimonster").
 * 
 * @author Nico
 *
 */

public class MonsterA extends Monster {

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
     * allerdings nur mit 0.5*ATK.
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
}
