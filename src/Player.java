/**
 * Methode zur Erzeugung eines Spielerobjekts in der main-Klasse.
 * 
 * @author Nico Weil 4569075 Gruppe 11
 *
 */

public class Player {

    private int hp;
    private int maxHP;
    private int atk;
    private int healingPower;
    private int remainingItemUses;
    private double hitChance;
    private int ap;
    private int maxAp;
    private int apRegen;
    private int bonusAtk;
    private int specialAbilityDuration;

    public Player(int maxH, int a, int x, int r, double y) {

        this.hp = maxH;
        this.maxHP = maxH;
        this.atk = a;
        this.healingPower = x;
        this.remainingItemUses = r;
        this.hitChance = y;

    }

    public Player(int maxH, int a, int w, int r, double x, int maxY, int y, int z) {

        this.hp = maxH;
        this.maxHP = maxH;
        this.atk = a;
        this.healingPower = w;
        this.remainingItemUses = r;
        this.hitChance = x;
        this.maxAp = maxY;
        this.ap = y;
        this.apRegen = z;
        this.bonusAtk = 0;
        this.specialAbilityDuration = 0;
    }

    public Player() {

        this.maxHP = 100;
        this.hp = this.maxHP;
        this.atk = 15;
        this.healingPower = 40;
        this.remainingItemUses = 3;
        this.hitChance = 0.7;
    }

    /**
     * Methode isDefeated() kontrolloiert, ob Spieler besiegt ist.
     */

    public boolean isDefeated() {
        if (this.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode takeDamage(int damage) fügt dem Spieler den ducrh damage
     * angegebenen Schaden zu.
     */

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
        }
    }

    /**
     * Methode attackMonster(Monster monster) fuegt dem uebergebenen
     * Monsterobjekt Schaden zu. Methode hat zwei Angriffsarten: Wenn Option
     * "Powerpille" gewaehlt wird, wird der Angriff mit durch takePowerPill()
     * generierte BonusATK zusaetzlich zu den ATK durchgefuehrt. Wenn nicht,
     * wird der Angriff mit den normalen ATK durchgefuehrt. Methode gibt -1
     * zurueck falls der Angriff nicht trifft.
     */

    public int attackMonster(Monster monster) {
        double zufallsZahlVergleich = Math.random();
        if (zufallsZahlVergleich > this.hitChance) {
            return -1;
        } else {
            double zufallsZahl = Math.random() + 1;
            monster.takeDamage((int) ((this.atk + this.bonusAtk) * zufallsZahl));
            return monster.getHp();
        }
    }

    /**
     * Methode getRemainingItemUses() gibt an, wie oft der Spieler noch einen
     * Heiltrank einsetzen kann.
     */

    public int getRemainingItemUses() {
        return this.remainingItemUses;
    }

    /**
     * Die Methode heal() setzt einen Heiltrank ein (falls noch uebrig). Methode
     * gibt true zurueck, wenn die Heilung erfolgreich war, und false, falls die
     * Heilung nicht erfolgreich war.
     */

    public boolean heal() {
        if (this.remainingItemUses > 0) {
            this.hp = this.hp + this.healingPower;
            this.remainingItemUses = this.remainingItemUses - 1;
            if (this.hp > this.maxHP) {
                this.hp = this.maxHP;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode fullHp() gibt booleanschen Wert zurueck ob die HP = maxHP.
     */

    public boolean fullHp() {
        return (this.hp == this.maxHP);
    }

    /**
     * Methode toString() gibt HP, ATK, BonusATK, AP, Items zurueck.
     */

    public String toString() {
        return "Spieler -- HP " + this.hp + " -- ATK " + this.atk + " -- " + " BonusATK " + this.bonusAtk + " -- AP "
                + this.ap + " -- " + this.remainingItemUses + " Heiltraenke";

    }

    /**
     * Methode regenerateAp() regeneriert die AP des Spielers bis zum maxAp und
     * gibt die Differenz zurueck.
     */

    public int regenerateAp() {
        int preAp = this.ap;
        this.ap = this.ap + this.apRegen;
        if (this.ap > this.maxAp) {
            this.ap = this.maxAp;
        }
        return this.ap - preAp;
    }

    /**
     * Methode takePowerPill() generiert Bonus-ATK, sodass auf die ATK im
     * Angriff nicht nur 0, sondern ein Anteil der ATK addiert werden.
     */

    public void takePowerPill() {
        this.specialAbilityDuration = 3;
        double multiplier = (Math.random() * 0.9 + 0.1);
        this.bonusAtk = (int) (this.ap * multiplier);
    }

    /**
     * Methode decreaseAp(int apCosts) verringert die AP des Spielers um den in
     * Klammern angegebenen Wert.
     */

    public void decreaseAp(int apCosts) {
        this.ap = this.ap - apCosts;
    }

    /**
     * Methode roundFinished() verringert specialAbilityDuration um 1. Sie
     * verhindert specialAbilityDuration<0 und setzt bonusATK=0, sobald
     * specialAbilityDuration=0. Methode wird benoetigt, um Objekten
     * "mitzuteilen", dass eine Runde zuende ist.
     */

    public void roundFinished() {
        this.specialAbilityDuration--;
        if (this.specialAbilityDuration <= 0) {
            this.specialAbilityDuration = 0;
            if (this.bonusAtk > 0 && this.hp > 0) {
                this.bonusAtk = 0;
                System.out.println("Die Wirkung der Powerpille laesst nach!");
            }
        }
    }

    /**
     * Methode isAbilityActive() ueberprueft, ob eine spezielle Faehigkeit noch
     * aktiv ist.
     */

    public boolean isAbilityActive() {
        return (this.specialAbilityDuration > 0);
    }

    /**
     * Methode enoughAp() gibt boolenschen Wert zurueck, ob so viele AP
     * vorhanden sind, wie in den Klammern angegeben.
     */

    public boolean enoughAp(int apNeeded) {
        return (this.ap >= apNeeded);
    }

    /**
     * Methode getBonusAtk() gibt die BonusATK zurueck.
     */

    public int getBonusAtk() {
        return this.bonusAtk;
    }

    /**
     * Methode getHP() gibt HP zurueck.
     */

    public int getHp() {
        return this.hp;
    }

}
