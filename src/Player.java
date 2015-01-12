
public class Player extends Character{
	
	private int healingPower;
	private int remainingItemUses;
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
		this.bonusAtk= 0;
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
	 * Methode attackMonster(Monster monster) fuegt dem uebergebenen Monsterobjekt Schaden zu.
	 * Methode hat zwei Angriffsarten: Wenn Option "Powerpille" gewaehlt wird, wird der Angriff mit durch takePowerPill() generierte BonusATK zusaetzlich zu den ATK durchgefuehrt. Wenn nicht, wird der Angriff mit den normalen ATK durchgefuehrt. 
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
		this.specialAbilityDuration = 3;
		double multiplier = (Math.random() * 0.9 + 0.1);
		this.bonusAtk = (int) (this.ap * multiplier);
	}
	
	/**
	 * Methode decreaseAp(int apCosts) verringert die AP des Spielers um den in Klammern angegebenen Wert.
	 */
	
	public void decreaseAp(int apCosts) {
		this.ap = this.ap - apCosts;
	}
	
	/**
	 * Methode roundFinished() verringert specialAbilityDuration um 1. Sie verhindert specialAbilityDuration<0 und setzt bonusATK=0, sobald specialAbilityDuration=0.
	 */
	
	public void roundFinished() {
		this.specialAbilityDuration --;
		if(this.specialAbilityDuration <= 0) {
			this.specialAbilityDuration = 0;
			if(this.bonusAtk > 0 && this.hp >0) {
				this.bonusAtk = 0;
				System.out.println("Die Wirkung der Powerpille laesst nach!");
			}
		}
	}
	
	public boolean enoughAp(int apNeeded) {
		return (this.ap >= apNeeded);
	}
	
	public int getBonusAtk() {
		return this.bonusAtk;
	}
}
