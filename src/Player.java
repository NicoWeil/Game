
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
	
	public Player( int maxH, int a, int x, int r, double y) {
		
		this.hp = maxH;
		this.maxHP = maxH;
		this.atk = a;
		this.healingPower = x;
		this.remainingItemUses = r;
		this.hitChance = y;
		
	}
	
	public Player(int maxH, int a, int w, int r, double x, int y, int z) {
		
		this.hp = maxH;
		this.maxHP = maxH;
		this.atk = a;
		this.healingPower = w;
		this.remainingItemUses = r;
		this.hitChance = x;
		this.maxAp = y;
		this.ap = y;
		this.apRegen = z;
		this.bonusAtk= 0;
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
		if(this.hp <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Methode takeDamage(int damage) fügt dem Spieler den ducrh damage angegebenen Schaden zu.
	 */
	
	public void takeDamage(int damage) {
		this.hp -= damage;
		if(this.hp <= 0) {
			this.hp = 0;
		}
	}
	
	/**
	 * Methode attackMonster(Monster monster) fügt dem übergebenen Monsterobjekt Schaden zu.
	 */
	
	public int attackMonster(Monster monster) {
		double zufallsZahlVergleich = Math.random();
		if(zufallsZahlVergleich > this.hitChance) {
			return -1;
		} else {
			double zufallsZahl = Math.random() + 1;
			monster.takeDamage((int) ((this.atk + this.bonusAtk) * zufallsZahl));
			return monster.getHp();
		}
	}
	
	/**
	 * Methode getRemainingItemUses() gibt an, wie oft der Spieler noch einen Heiltrank einsetzen kann.
	 */
	
	public int getRemainingItemUses() {
		return this.remainingItemUses;
	}
	
	/**
	 * Die Methode heal() setzt einen Heiltrank ein (falls noch übrig).
	 */
	
	public boolean heal() {
		if(this.remainingItemUses > 0) {
			this.hp = this.hp + this.healingPower;
			this.remainingItemUses = this.remainingItemUses -1;
			if(this.hp > this.maxHP) {
				this.hp = this.maxHP;
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Methode toString() gibt HP, ATK, AP, Items zurueck.
	 */
	
	public String toString() {
		return "Spieler -- HP " + this.hp  + " -- ATK " + this.atk + " -- " + " BonusATK " + this.bonusAtk + " -- AP " + this.ap  + " -- " + this.remainingItemUses + " Heiltraenke";
		
	}
	
	/**
	 * Methode regenerateAp() regeneriert die AP des Spielers bis zum maxAp.
	 */
	
	public int regenerateAp() {
		int preAp = this.ap;
		this.ap = this.ap + this.apRegen;
		if(this.ap > this.maxAp) {
			this.ap = this.maxAp;
		}
		return this.ap - preAp;
	}
	
	/** 
	 * Methode takePowerPill() generiert Bonus-ATK, sodass auf die ATK im Angriff nicht nur 0, sondern ein Anteil der ATK addiert werden.
	 */
	
	public void takePowerPill() {
		this.ap = this.ap - 15;
		double multiplier = (Math.random());
		this.bonusAtk = (int) (this.ap * multiplier);
	}
	
	/**
	 * Methode powerPillVanishes() setzt die Bonus-ATK wieder auf 0, also die Gegenmethode zu takePowerPill.
	 */
	
	public void powerPillVanishes() {
		this.bonusAtk = 0;
	}
	
	/**
	 * Methode getHP() gibt HP zurueck.
	 */
	
	public int getHp() {
		return this.hp;
	
	}

}
