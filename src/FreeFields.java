public class FreeFields {

    public static int[] freeX;
    public static int[] freeY;
    public static int index;
    public static int freeXcoordinate;
    public static int freeYcoordinate;

    public static char[][] createList(char[][] array, int a, int b) {

        freeX = new int[a * b];
        freeY = new int[a * b];
        index = 0;

        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                if (array[y][x] == '.') {
                    freeY[index] = y;
                    freeX[index] = x;
                    index++;;
                    System.out.print("X " + freeX[x]);
                    System.out.println("Y " + freeY[y]);
                }
            }
        }
        return array;
    }
    
    public static void getRandomField() {
        
        int randomIndex = (int) (Math.random() * index);
        freeXcoordinate = freeX[randomIndex];
        freeYcoordinate = freeY[randomIndex];
        
        for(int i = randomIndex; i < freeX.length; i++) {
            freeX[i] = freeX[i + 1];
        }
        for(int i = randomIndex; i < freeY.length; i++) {
            freeY[i] = freeY[i + 1];
        }
        
    }
    

}
