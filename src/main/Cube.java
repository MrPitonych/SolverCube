package main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dav19 on 28.05.2017.
 */
public class Cube {

    private CubeSolver newSolve;
    private int[] positionRibs;
    private int[] rotationRibs;
    private int moveCount;
    private String moveList;
    private long newTime;
    private long stopTime;



    public Cube() {
        newSolve = new CubeSolver();
        positionRibs = new int[8];
        rotationRibs = new int[8];
        moveCount = 0;
        moveList = "";

    }

    public void startSolve(){
        //Считываем весь куб
        Scanner scan = new Scanner(System.in);
        int[] input = new int[24];
        System.out.println("Для ввода комбинации с кубика введите 1, если у вас есть готовая комбинация нажмите 2: ");
        int a = scan.nextInt();
        if (a == 1) {
            String[] g = new String[24];
            g = ViewInConsole.viewBoard();
            for (int x = 0; x < 24; x++) {
                String p = g[x];
                input[x] = p.charAt(0);
            }
            initRibs(input);
        } else if (a == 2) {
            System.out.println("Введите готовую комбинацию: ");
            for (int x = 0; x < 24; x++) {
                input[x] = Integer.parseInt(scan.next());
            }
            initRibs(input);
        }
        scan.close();
        newTime = System.nanoTime();
        String[] turns = newSolve.moves(14, positionRibs, rotationRibs);
        for (String turn : turns) {
            moveList += turn;
            moveList += " ";
            moveCount += 1;
        }
        endSolve();
    }

    private void endSolve(){
        stopTime = (System.nanoTime() - newTime) / 1000000;
        System.out.println(moveList);
        System.out.format("Нужно шагов: %d\n", +moveCount);
        System.out.println(stopTime + " милисекунд");
    }

    //Иницилизируем рёбра
    public void initRibs(int[] input) {
        int[][] ribs = new int[8][3];

        ribs[0] = new int[]{input[0], input[16], input[14]};
        ribs[1] = new int[]{input[1], input[15], input[21]};
        ribs[2] = new int[]{input[2], input[4], input[17]};
        ribs[3] = new int[]{input[3], input[20], input[5]};
        ribs[4] = new int[]{input[10], input[12], input[18]};
        ribs[5] = new int[]{input[11], input[23], input[13]};
        ribs[6] = new int[]{input[8], input[19], input[6]};
        ribs[7] = new int[]{input[9], input[7], input[22]};

        //yellow-1
        //green-2
        //white-3
        //blue-4
        //red-5
        //orange-6
        //Определяем навравление цветов
        int[][] RibsPosition = {
                {1, 5, 4}, {5, 4, 1}, {4, 1, 5},
                {1, 4, 6}, {4, 6, 1}, {6, 1, 4},
                {1, 2, 5}, {2, 5, 1}, {5, 1, 2},
                {1, 6, 2}, {6, 2, 1}, {2, 1, 6},
                {3, 4, 5}, {4, 5, 3}, {5, 3, 4},
                {3, 6, 4}, {6, 4, 3}, {4, 3, 6},
                {3, 5, 2}, {5, 2, 3}, {2, 3, 5},
                {3, 2, 6}, {2, 6, 3}, {6, 3, 2}
        };
        for (int x = 0; x < 8; x++) {
            int index = 0;
            while (!Arrays.equals(ribs[x], RibsPosition[index])) {
                index++;
            }
            positionRibs[x] = (index / 3);
            rotationRibs[x] = (index % 3);
        }
    }

    public int[] getPositionRibs(){
        return positionRibs;
    }

    public int[] getRotationRibs(){
        return rotationRibs;
    }

}
