/**
 * Diese Klasse definiert ein Objekt. Mit Verwendung eines Constructors
 * kann dem Objekt Attribute beigefuegt werden.
 * Außerdem werden Methoden definiert, welche in der main-Klasse
 * Kmapfsystem.java benötigt werden.
 * 
 * @author Nico Weil (4569075)
 * @ 07.12.2014
 */

import java.util.Random;

public class Kaempfer {
    
    private int healthPoints;
    private int attackPoints;
    private int maxHealthPoints;
    private int item;
    private double hitPoints; // double da Gleitkommatyp
    
    public Kaempfer(int h, int a, int m, int i, double x) { //in Klammern: Parameter, die mit uebergeben werden koennen

        this.healthPoints = h;
        this.attackPoints = a;
        this.maxHealthPoints = m;
        this.item = i;
        this.hitPoints = x;
    }
    
    public int getHealthPoints() { //Deklaration einer Methode um HP zu holen
        return this.healthPoints;
    }
    
    public int getAttackPoints() {
        return this.attackPoints;
    }
    
    public int getMaxHealthPoints() {
        return this.maxHealthPoints;
    }
    
    public int getItem() {
        return this.item;
    }
    
    public double getHitPints() {
        return this.hitPoints;
    }
    
    private Random random = new Random(); //Objekt welches ZZ generiert
    
    
    public void attackedBy(Kaempfer andererKaempfer) {
        double zufallsZahlVergleich = random.nextDouble(); //Erzeugung der ZZ zw. 0 und 1
        if(zufallsZahlVergleich > this.hitPoints){
            System.out.println("Die Attacke ging daneben!");
        } else {
            double zufallsZahlAngriff = random.nextDouble() + 1; //Erzeugung einer ZZ zw. 1 und 2
            this.healthPoints -= (andererKaempfer.attackPoints * zufallsZahlAngriff); //Typwandlung
            if(this.healthPoints < 0) { //Ueberpruefung ob Angegriffener tot
    	        this.healthPoints = 0;
            }
        }
    }
    
    public void usesItem() {
        this.healthPoints = this.healthPoints + this.item;
        if(this.healthPoints > this.maxHealthPoints) {
            this.healthPoints = this.maxHealthPoints;
        }
    }
    
    public boolean isDead() {
        return this.healthPoints <= 0;
    }
}
