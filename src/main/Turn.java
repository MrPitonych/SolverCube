package main;

/**
 * Created by dav19 on 28.05.2017.
 */
public class Turn {
    public int[] rotateSide(String[] moves, int[] rotationRibs){     //Принимает массив, с помощью которого крутит грани
        for (String face : moves) {                      //Каждая буква это поворот грани. Например, F - поворот фасада по часовой, F' - против часовой
            switch (face) {
                case "F":
                    rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], (rotationRibs[6] + 1) % 3, (rotationRibs[2] + 2) % 3, rotationRibs[4], rotationRibs[5], (rotationRibs[7] + 2) % 3, (rotationRibs[3] + 1) % 3 };
                    break;
                case "F'":
                    rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], (rotationRibs[3] + 1) % 3, (rotationRibs[7] + 2) % 3, rotationRibs[4], rotationRibs[5], (rotationRibs[2] + 2) % 3, (rotationRibs[6] + 1) % 3 };
                    break;
                case "B":
                    rotationRibs = new int[] { (rotationRibs[1] + 2) % 3, (rotationRibs[5] + 1) % 3, rotationRibs[2], rotationRibs[3], (rotationRibs[0] + 1) % 3, (rotationRibs[4] + 2) % 3, rotationRibs[6], rotationRibs[7] };
                    break;
                case "B'":
                    rotationRibs = new int[] { (rotationRibs[4] + 2) % 3, (rotationRibs[0] + 1) % 3, rotationRibs[2], rotationRibs[3], (rotationRibs[5] + 1) % 3, (rotationRibs[1] + 2) % 3, rotationRibs[6], rotationRibs[7] };
                    break;
                case "R":
                    rotationRibs = new int[] { rotationRibs[0], (rotationRibs[3] + 2) % 3, rotationRibs[2], (rotationRibs[7] + 1) % 3, rotationRibs[4], (rotationRibs[1] + 1) % 3, rotationRibs[6], (rotationRibs[5] + 2) % 3 };
                    break;
                case "R'":
                    rotationRibs = new int[] { rotationRibs[0], (rotationRibs[5] + 2) % 3, rotationRibs[2], (rotationRibs[1] + 1) % 3, rotationRibs[4], (rotationRibs[7] + 1) % 3, rotationRibs[6], (rotationRibs[3] + 2) % 3 };
                    break;
                case "L":
                    rotationRibs = new int[] { (rotationRibs[4] + 1) % 3, rotationRibs[1], (rotationRibs[0] + 2) % 3, rotationRibs[3], (rotationRibs[6] + 2) % 3, rotationRibs[5], (rotationRibs[2] + 1) % 3, rotationRibs[7] };
                    break;
                case "L'":
                    rotationRibs = new int[] { (rotationRibs[2] + 1) % 3, rotationRibs[1], (rotationRibs[6] + 2) % 3, rotationRibs[3], (rotationRibs[0] + 2) % 3, rotationRibs[5], (rotationRibs[4] + 1) % 3, rotationRibs[7] };
                    break;
                case "U":
                    rotationRibs = new int[] { rotationRibs[2], rotationRibs[0], rotationRibs[3], rotationRibs[1], rotationRibs[4], rotationRibs[5], rotationRibs[6], rotationRibs[7] };
                    break;
                case "U'":
                    rotationRibs = new int[] { rotationRibs[1], rotationRibs[3], rotationRibs[0], rotationRibs[2], rotationRibs[4], rotationRibs[5], rotationRibs[6], rotationRibs[7] };
                    break;
                case "D":
                    rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], rotationRibs[2], rotationRibs[3], rotationRibs[5], rotationRibs[7], rotationRibs[4], rotationRibs[6] };
                    break;
                case "D'":
                    rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], rotationRibs[2], rotationRibs[3], rotationRibs[6], rotationRibs[4], rotationRibs[7], rotationRibs[5] };
            }
        }
        return rotationRibs;
    }

    public int[] shiftPosition(String[] moves, int [] positionRibs){
        for (String face : moves) {
            switch (face) {
                case "F":
                    positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[6], positionRibs[2], positionRibs[4], positionRibs[5], positionRibs[7], positionRibs[3] };
                    break;
                case "F'":
                    positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[3], positionRibs[7], positionRibs[4], positionRibs[5], positionRibs[2], positionRibs[6] };
                    break;
                case "B":
                    positionRibs = new int[] { positionRibs[1], positionRibs[5], positionRibs[2], positionRibs[3], positionRibs[0], positionRibs[4], positionRibs[6], positionRibs[7] };
                    break;
                case "B'":
                    positionRibs = new int[] { positionRibs[4], positionRibs[0], positionRibs[2], positionRibs[3], positionRibs[5], positionRibs[1], positionRibs[6], positionRibs[7] };
                    break;
                case "R":
                    positionRibs = new int[] { positionRibs[0], positionRibs[3], positionRibs[2], positionRibs[7], positionRibs[4], positionRibs[1], positionRibs[6], positionRibs[5] };
                    break;
                case "R'":
                    positionRibs = new int[] { positionRibs[0], positionRibs[5], positionRibs[2], positionRibs[1], positionRibs[4], positionRibs[7], positionRibs[6], positionRibs[3] };
                    break;
                case "L":
                    positionRibs = new int[] { positionRibs[4], positionRibs[1], positionRibs[0], positionRibs[3], positionRibs[6], positionRibs[5], positionRibs[2], positionRibs[7] };
                    break;
                case "L'":
                    positionRibs = new int[] { positionRibs[2], positionRibs[1], positionRibs[6], positionRibs[3], positionRibs[0], positionRibs[5], positionRibs[4], positionRibs[7] };
                    break;
                case "U":
                    positionRibs = new int[] { positionRibs[2], positionRibs[0], positionRibs[3], positionRibs[1], positionRibs[4], positionRibs[5], positionRibs[6], positionRibs[7] };
                    break;
                case "U'":
                    positionRibs = new int[] { positionRibs[1], positionRibs[3], positionRibs[0], positionRibs[2], positionRibs[4], positionRibs[5], positionRibs[6], positionRibs[7] };
                    break;
                case "D":
                    positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[2], positionRibs[3], positionRibs[5], positionRibs[7], positionRibs[4], positionRibs[6] };
                    break;
                case "D'":
                    positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[2], positionRibs[3], positionRibs[6], positionRibs[4], positionRibs[7], positionRibs[5] };
            }
        }
        return positionRibs;
    }
}
