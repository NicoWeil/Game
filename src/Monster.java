
public class Monster {
	
	private int hp;
	private int maxHP;
	private int atk;
	private double hitChance;
	private boolean isFrozen;
	
	public Monster(int maxH, int a, double y) {
		
		this.hp = maxH;
		this.maxHP = maxH;
		this.atk = a;
		this.hitChance = y;
		this.isFrozen = false;
	}
	
	public Monster() {
		
		this.hp = 200;
		this.maxHP = 200;
		this.atk = 10;
		this.hitChance = 0.9;
		this.isFrozen = false;
	
	}
	
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
	 * Methode takeDamage f�gt dem Monster den durch damage �bergebenen Schaden zu
	 */
	
	public void takeDamage(int damage) {
		this.hp -= damage;
		if(this.hp <= 0) {
			this.hp = 0;
		}
	}
	
	/**
	 * Methode attack(Player player) f�gt dem uebergebenen Objekt Schaden zu
	 */
	
	public int attack(Player player) {
		double zufallsZahlVergleich = Math.random();
		if(zufallsZahlVergleich > this.hitChance) {
			return -1;
		} else {
			double zufallsZahl = Math.random() + 1;
			player.takeDamage((int) (this.atk * zufallsZahl));
			return player.getHp();
		}
	}
	
	/**
	 * Methode toString() gibt HP, ATK, Items zurueck 
	 */
	
	public String toString() {
		return "Monster -- HP " + this.hp + " -- ATK " + this.atk;
	}
	
	public void freeze() {
		this.isFrozen = true;
	}
	
	public boolean isFrozen() {
		return this.isFrozen;
	}
	
	/**
	 * Methode getHP() gibt Lebenspunkte zurueck
	 */
	
	public int getHp() {
		return this.hp;
		
	}

}
