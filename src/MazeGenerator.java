
public interface MazeGenerator {

    char WALL = '#'; 
    char FREE = '.'; 
    char START = 'S'; 
    char BATTLE = 'B'; 
    char SMITHY = 'T'; 
    char WELL = 'O'; 
    char GOAL = 'Z';
    char SPACE = ' ';
    
    
    char[][] generate(int height, int width);
    
}
