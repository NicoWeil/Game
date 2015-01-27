/**
 * Statische Klasse zur zufaelligen Bestimmung eines Monsters als Gegener.
 * 
 * @author Nico Weil 4569075 Gruppe 11
 *
 */

public class MonsterFactory {

    /**
     * createMonster() erzeugt ein Monster und gibt dieses als Objekt zurueck.
     * 
     * @return opponent
     */

    public static Monster createMonster() {

        Monster[][] monster = new Monster[3][5];

        /*
         * Constructor: Monster(maxHP, ATK, HitChance)
         */

        monster[0][0] = new Monster();
        monster[0][1] = new Monster(100, 18, 0.8);
        monster[0][2] = new Monster(150, 20, 0.5);
        monster[0][3] = new Monster(210, 10, 0.9);
        monster[0][4] = new Monster(125, 13, 0.7);
        monster[1][0] = new MonsterA();
        monster[1][1] = new MonsterA(100, 18, 0.8);
        monster[1][2] = new MonsterA(150, 20, 0.5);
        monster[1][3] = new MonsterA(210, 10, 0.9);
        monster[1][4] = new MonsterA(125, 13, 0.7);
        monster[2][0] = new MonsterB();
        monster[2][1] = new MonsterB(100, 18, 0.8);
        monster[2][2] = new MonsterB(150, 20, 0.5);
        monster[2][3] = new MonsterB(210, 10, 0.9);
        monster[2][4] = new MonsterB(125, 13, 0.7);

        int arrayIndex = (int) (Math.random() * monster.length);

        int monsterIndex = (int) (Math.random() * monster[arrayIndex].length);

        Monster opponent = monster[arrayIndex][monsterIndex];

        if (opponent.isSpecial()) {
            System.out.println("Ein spezielles Monster greift an!");
            opponent.toString();
        } else {
            System.out.println("Ein normales Monster greift an!");
            opponent.toString();

        }
        return opponent;
    }
}
