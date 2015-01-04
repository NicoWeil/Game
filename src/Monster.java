public class Monster {

    private int hp;
    private int maxHP;
    private int atk;
    private double hitChance;
    private boolean frozen;
    private int specialAbilityDuration;
    private double decreasedHitPoints;

    public Monster(int maxH, int a, double y) {

        this.hp = maxH;
        this.maxHP = maxH;
        this.atk = a;
        this.hitChance = y;
        this.frozen = false;
        this.specialAbilityDuration = 0;
        this.decreasedHitPoints = 0.0;

    }

    public Monster() {

        this.hp = 200;
        this.maxHP = 200;
        this.atk = 10;
        this.hitChance = 0.9;
        this.frozen = false;
        this.specialAbilityDuration = 0;
        this.decreasedHitPoints = 0.0;

    }

    /**
     * Methode isDefeated ueberprueft, ob Monster besiegt ist.
     */

    public boolean isDefeated() {
        if (this.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode takeDamage f�gt dem Monster den durch damage �bergebenen Schaden
     * zu.
     */

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
        }
    }

    /**
     * Methode attack(Player player) f�gt dem uebergebenen Objekt Schaden zu.
     */

    public int attack(Player player) {
        double zufallsZahlVergleich = Math.random();
        if (zufallsZahlVergleich > (this.hitChance - this.decreasedHitPoints)) {
            return -1;
        } else {
            double zufallsZahl = Math.random() + 1;
            player.takeDamage((int) (this.atk * zufallsZahl));
            return player.getHp();
        }
    }

    /**
     * Methode toString() gibt HP, ATK, Items zurueck.
     */

    public String toString() {
        return "Monster -- HP " + this.hp + " -- ATK " + this.atk + " -- Decreased Hit Chance " + this.decreasedHitPoints;
    }

    /**
     * Methode freeze() "friert" das Monster ein, sein Angriff auf den Spieler
     * wird also uebersprungen.
     */

    public void freeze() {
        this.specialAbilityDuration = 3;
        this.frozen = true;
    }

    /**
     * Methode isFrozen() gibt einen booleanschen Wert zurueck, ob das Monster
     * "eingefroren" ist oder nicht.
     */

    public boolean isFrozen() {
        return this.frozen;
    }

    /**
     * Methode roundFinishes() senkt die specialAbilityDuration (falls >0) um 1
     * und setzt this.frozen auf 0, sobald specialAbilityDuration=0. Au�erdem
     * werden die decreasedHitPints auf 0 gesetzt falls diese > 0.
     */

    public void roundFinished() {
        this.specialAbilityDuration--;
        if (this.specialAbilityDuration <= 0) {
            this.specialAbilityDuration = 0;
            if (this.frozen) {
                this.frozen = false;
                if (this.hp > 0) {
                    System.out.println("Das Monster taut wieder auf!");
                }
            }
            if (this.decreasedHitPoints != 0 && this.hp > 0) {
                this.decreasedHitPoints = 0;
                System.out.println("Dem Monster ist nicht mehr schwindelig!");
            }
        }
    }

    /**
     * Methode hasDecreasedHitChance(doubel x) setzt specialAbilityDuration auf
     * 3 und decreasedHitPints (welche im Angriff abgezogen werden) auf den in
     * den Klammern uebergebenen Wert.
     */

    public void hasDecreasedHitChance(double x) {
        this.specialAbilityDuration = 3;
        this.decreasedHitPoints = x;
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
     * Methode getDecreasedHitPoints() gibt decreasedHitPoints zurueck.
     */

    public double getDecreasedHitPoints() {
        return this.decreasedHitPoints;
    }

    /**
     * Methode getHP() gibt Lebenspunkte zurueck.
     */

    public int getHp() {
        return this.hp;

    }

}
