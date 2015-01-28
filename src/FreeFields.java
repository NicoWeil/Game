public class FreeFields {

    private static int[] freeX;
    private static int[] freeY;
    private static int index;
    private static int freeXcoordinate;
    private static int freeYcoordinate;

    public static char[][] placeSpecialFields(char[][] array, int v, int w, int o, int s, int b) {

        freeX = new int[v * w];
        freeY = new int[v * w];
        index = 0;

        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                if (array[y][x] == '.') {
                    freeY[index] = y;
                    freeX[index] = x;
                    index++;
                    ;
                }
            }
        }

        for (int i = o; i == 0; i--) {
            getRandomField();
            array[freeYcoordinate][freeXcoordinate] = 'O';
        }
        for (int i = s; i == 0; i--) {
            getRandomField();
            array[freeYcoordinate][freeXcoordinate] = 'S';
        }
        for (int i = b; i == 0; i--) {
            getRandomField();
            array[freeYcoordinate][freeXcoordinate] = 'B';
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); // nur Zeilenumsprung
        }
        return array;
    }

    private static void getRandomField() {

        int randomIndex = (int) (Math.random() * index);
        freeXcoordinate = freeX[randomIndex];
        freeYcoordinate = freeY[randomIndex];

        for (int i = randomIndex; i < index - 1; i++) {
            freeX[i] = freeX[i + 1];
        }
        for (int i = randomIndex; i < index - 1; i++) {
            freeY[i] = freeY[i + 1];
        }
        index--;
    }
}
