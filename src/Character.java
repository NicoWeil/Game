
public class Character {
    
    private int hp;
    private int maxHP;
    private int atk;
    private double hitChance;
    private int specialAbilityDuration;

    
    /**
     * Methode isDefeated ueberprueft, ob Monster besiegt ist
     */
    
    public boolean isDefeated() {
        if(this.hp <= 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Methode takeDamage f�gt dem Monster den durch damage �bergebenen Schaden zu.
     */
    
    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0) {
            this.hp = 0;
        }
    }
    
    /**
     * Methode isAbilityActive() ueberprueft ob eine spezielle Faehigkeit noch aktiv ist.
     */
    
    public boolean isAbilityActive() {
        if(this.specialAbilityDuration > 0) {
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
