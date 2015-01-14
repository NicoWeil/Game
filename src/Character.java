/**
 * Basisklasse, von der u.a. Monster, MonsterA/B, Player abgeleitet werden (d.h.
 * sie besitzt alle Instanzen, die sowohl Player als auch Monster benoetigen).
 * 
 * @author Nico
 *
 */
public class Character {

    protected int hp;
    protected int maxHP;
    protected int atk;
    protected double hitChance;
    protected int specialAbilityDuration;

    /**
     * Methode isDefeated ueberprueft, ob Monster besiegt ist
     */

    public boolean isDefeated() {
        if (this.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode takeDamage fuegt dem Charakter den durch damage uebergebenen
     * Schaden zu.
     */

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
        }
    }

    /**
     * Methode isAbilityActive() ueberprueft ob eine spezielle Faehigkeit noch
     * aktiv ist.
     */

    public boolean isAbilityActive() {
        if (this.specialAbilityDuration > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode getHP() gibt Lebenspunkte zurueck.
     */

    public int getHp() {
        return this.hp;

    }

}
