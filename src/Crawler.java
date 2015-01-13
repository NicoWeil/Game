/**
 * Main-Klasse, welche einen Dungeon Crawler erstellt.
 * @author Nico Weil 4569075 Gruppe 11
 *
 */
public class Crawler {
    
    public static void main(String[] args) {
        
        char[] [] mapData = {
                {'x','x','x','x','x'},
                {'x','B','.','x','x'},
                {'.','O','.','x','x'},
                {'T','.','x','O','S'},
                {'x','Z','x','x','x'},
                
        };
        
        Level playingField = new Level(mapData);
        System.out.println(playingField);
        
    }

}
