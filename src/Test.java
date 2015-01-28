
public class Test {

    public static void main(String[] args) {
        
        RecursiveBacktracker generator = new RecursiveBacktracker();
        
        char[][] map = generator.generate(11, 11);
        
        
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                        System.out.print(map[i][j] + " "); // Ausgabe des Zeichens
                                                           // an Stelle
                                                           // i/j (Indizes)
                    
                }
                System.out.println(); // nur Zeilenumsprung
            }
            System.out.println();
        

    }
    
}
