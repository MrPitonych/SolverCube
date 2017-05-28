package main;

public class CubeSolver {

    private Turn newTurn = new Turn();
    private String[] humanStep = {"F", "F'", "B", "B'", "R", "R'", "L", "L'", "U", "U'", "D", "D'"};

    public String[] moves(int depth, int[] positionRibs, int[] rotationRibs) {

        String[] humanSolve = {""};
        int[] startPosition = new int[8];
        int[] startRotation = new int[8];
        startPosition = positionRibs;
        startRotation = rotationRibs;

        String sits = "";
        for (int s = 0; s < depth; s++) {
            sits = sits + "5";
        }

        for (long i = 0; i <= Long.parseLong(sits, 6); ++i) {
            positionRibs = startPosition;
            rotationRibs = startRotation;
            String movestring = Long.toString(i, 12);
            String a [] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

            String[] moves = new String[movestring.length()];
            for (int d = 0; d < movestring.length(); d++) {
                String move = "";

                //Так я делал изначально, но скорость падает в 2 раза. Затем поменял на эту огромную конструкцию
                if (movestring.substring(d, d + 1).matches("[-+]?\\d+")) {
                    move = humanStep[Integer.parseInt(movestring.substring(d, d + 1))];
                    if (movestring.substring(d, d + 1).equals("a")) {
                        move = humanStep[10];
                    }
                } else if (movestring.substring(d, d + 1).equals("a")) {
                    move = humanStep[10];
                } else if (movestring.substring(d, d + 1).equals("b")) {
                    move = humanStep[11];
                }

                //
                /* if (movestring.substring(d, d + 1).equals("0")) {
                    move = humanStep[0];
                } else if (movestring.substring(d, d + 1).equals("1")) {
                    move = humanStep[1];
                } else if (movestring.substring(d, d + 1).equals("2")) {
                    move = humanStep[2];
                } else if (movestring.substring(d, d + 1).equals("3")) {
                    move = humanStep[3];
                } else if (movestring.substring(d, d + 1).equals("4")) {
                    move = humanStep[4];
                } else if (movestring.substring(d, d + 1).equals("5")) {
                    move = humanStep[5];
                } else if (movestring.substring(d, d + 1).equals("6")) {
                    move = humanStep[6];
                } else if (movestring.substring(d, d + 1).equals("7")) {
                    move = humanStep[7];
                } else if (movestring.substring(d, d + 1).equals("8")) {
                    move = humanStep[8];
                } else if (movestring.substring(d, d + 1).equals("9")) {
                    move = humanStep[9];
                } else if (movestring.substring(d, d + 1).equals("a")) {
                    move = humanStep[10];
                } else if (movestring.substring(d, d + 1).equals("b")) {
                    move = humanStep[11];
                }*/
                moves[d] = move;
            }
            rotationRibs = newTurn.rotateSide(moves, rotationRibs);
            positionRibs = newTurn.shiftPosition(moves, positionRibs);
            int correctCount = 0;
            for (int number = 0; number < 8; number++) {
                if ((positionRibs[number] == number) && (rotationRibs[number] == 0)) {
                    correctCount++;
                }
            }
            if (correctCount == 8) {
                humanSolve = moves;
                break;
            }
        }
        positionRibs = startPosition;
        rotationRibs = startRotation;

        return humanSolve;
    }

}

