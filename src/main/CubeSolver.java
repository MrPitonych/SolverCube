package main;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class CubeSolver
{
  private static int[] positionRibs = new int[8];
  private static int[] rotationRibs = new int[8];
  private static int moveCount = 0;
  private static String moveList = "";
  private static String[] humanStep = { "F", "F'", "B", "B'", "R", "R'", "L", "L'", "U", "U'", "D", "D'" };
  
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    char[] input = new char[24];
    System.out.println("Для ввода комбинации с кубика введите 1, если у вас есть готовая комбинация нажмите 2: ");
    int a = scan.nextInt();
    if (a == 1)
    {
      String[] g = new String[24];
      g = ViewInConsole.viewBoard();
      for (int x = 0; x < 24; x++)
      {
        String p = g[x];
        input[x] = p.charAt(0);
      }
      initRibs(input);
    }
    else if (a == 2)
    {
      System.out.println("Введите готовую комбинацию: ");
      for (int x = 0; x < 24; x++) {
        input[x] = scan.next().charAt(0);
      }
      initRibs(input);
    }
    scan.close();
    
    long startTime = System.nanoTime();
    
    String[] turns = moves(14);
    for (String turn : turns)
    {
      moveList += turn;
      moveList += " ";
      moveCount += 1;
    }
    long stopTime = (System.nanoTime() - startTime) / 1000000L;
    
    System.out.println(moveList);
    System.out.format("Нужно шагов: %d\n", new Object[] { Integer.valueOf(moveCount) });
    System.out.println(stopTime + " минисекунд");
  }
  
  private static void initRibs(char[] input)
  {
    char[][] ribs = new char[8][3];
    
    ribs[0] = new char[]{input[0], input[16], input[14]};
    ribs[1] = new char[]{input[1], input[15], input[21]};
    ribs[2] = new char[]{input[2], input[4], input[17]};
    ribs[3] = new char[]{input[3], input[20], input[5]};
    ribs[4] = new char[]{input[10], input[12], input[18]};
    ribs[5] = new char[]{input[11], input[23], input[13]};
    ribs[6] = new char[]{input[8], input[19], input[6]};
    ribs[7] = new char[]{input[9], input[7], input[22]};
    
    char[][] seachRibsPosition = { { 'y', 'r', 'b' }, { 'r', 'b', 'y' }, { 'b', 'y', 'r' }, { 'y', 'b', 'o' }, { 'b', 'o', 'y' }, { 'o', 'y', 'b' }, { 'y', 'g', 'r' }, { 'g', 'r', 'y' }, { 'r', 'y', 'g' }, { 'y', 'o', 'g' }, { 'o', 'g', 'y' }, { 'g', 'y', 'o' }, { 'w', 'b', 'r' }, { 'b', 'r', 'w' }, { 'r', 'w', 'b' }, { 'w', 'o', 'b' }, { 'o', 'b', 'w' }, { 'b', 'w', 'o' }, { 'w', 'r', 'g' }, { 'r', 'g', 'w' }, { 'g', 'w', 'r' }, { 'w', 'g', 'o' }, { 'g', 'o', 'w' }, { 'o', 'w', 'g' } };
    for (int x = 0; x < 8; x++)
    {
      int index = 0;
      while (!Arrays.equals(ribs[x], seachRibsPosition[index])) {
        index++;
      }
      positionRibs[x] = (index / 3);
      rotationRibs[x] = (index % 3);
    }
  }
  
  private static String[] moves(int depth)
  {
    String[] humanSolve = { "" };
    int[] startPosition = new int[8];
    int[] startRotation = new int[8];
    startPosition = positionRibs;
    startRotation = rotationRibs;
    
    String sits = "";
    for (int s = 0; s < depth; s++) {
      sits = sits + "5";
    }
    for (long i = 0L; i <= Long.parseLong(sits, 6); i += 1L)
    {
      positionRibs = startPosition;
      rotationRibs = startRotation;
      String movestring = Long.toString(i, 12);
      String[] moves = new String[movestring.length()];
      for (int d = 0; d < movestring.length(); d++)
      {
        String move = "";
        if (movestring.substring(d, d + 1).equals("0")) {
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
        }
        moves[d] = move;
      }
      rotateSide(moves);
      int correctCount = 0;
      for (int number = 0; number < 8; number++) {
        if ((positionRibs[number] == number) && (rotationRibs[number] == 0)) {
          correctCount++;
        }
      }
      if (correctCount == 8)
      {
        humanSolve = moves;
        break;
      }
    }
    positionRibs = startPosition;
    rotationRibs = startRotation;
    
    return humanSolve;
  }
  
  private static void rotateSide(String[] moves)
  {
    for (String face : moves) {
      switch (face)
      {
      case "F": 
        positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[6], positionRibs[2], positionRibs[4], positionRibs[5], positionRibs[7], positionRibs[3] };
        rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], (rotationRibs[6] + 1) % 3, (rotationRibs[2] + 2) % 3, rotationRibs[4], rotationRibs[5], (rotationRibs[7] + 2) % 3, (rotationRibs[3] + 1) % 3 };
        break;
      case "F'": 
        positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[3], positionRibs[7], positionRibs[4], positionRibs[5], positionRibs[2], positionRibs[6] };
        rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], (rotationRibs[3] + 1) % 3, (rotationRibs[7] + 2) % 3, rotationRibs[4], rotationRibs[5], (rotationRibs[2] + 2) % 3, (rotationRibs[6] + 1) % 3 };
        break;
      case "B": 
        positionRibs = new int[] { positionRibs[1], positionRibs[5], positionRibs[2], positionRibs[3], positionRibs[0], positionRibs[4], positionRibs[6], positionRibs[7] };
        rotationRibs = new int[] { (rotationRibs[1] + 2) % 3, (rotationRibs[5] + 1) % 3, rotationRibs[2], rotationRibs[3], (rotationRibs[0] + 1) % 3, (rotationRibs[4] + 2) % 3, rotationRibs[6], rotationRibs[7] };
        break;
      case "B'": 
        positionRibs = new int[] { positionRibs[4], positionRibs[0], positionRibs[2], positionRibs[3], positionRibs[5], positionRibs[1], positionRibs[6], positionRibs[7] };
        rotationRibs = new int[] { (rotationRibs[4] + 2) % 3, (rotationRibs[0] + 1) % 3, rotationRibs[2], rotationRibs[3], (rotationRibs[5] + 1) % 3, (rotationRibs[1] + 2) % 3, rotationRibs[6], rotationRibs[7] };
        break;
      case "R": 
        positionRibs = new int[] { positionRibs[0], positionRibs[3], positionRibs[2], positionRibs[7], positionRibs[4], positionRibs[1], positionRibs[6], positionRibs[5] };
        rotationRibs = new int[] { rotationRibs[0], (rotationRibs[3] + 2) % 3, rotationRibs[2], (rotationRibs[7] + 1) % 3, rotationRibs[4], (rotationRibs[1] + 1) % 3, rotationRibs[6], (rotationRibs[5] + 2) % 3 };
        break;
      case "R'": 
        positionRibs = new int[] { positionRibs[0], positionRibs[5], positionRibs[2], positionRibs[1], positionRibs[4], positionRibs[7], positionRibs[6], positionRibs[3] };
        rotationRibs = new int[] { rotationRibs[0], (rotationRibs[5] + 2) % 3, rotationRibs[2], (rotationRibs[1] + 1) % 3, rotationRibs[4], (rotationRibs[7] + 1) % 3, rotationRibs[6], (rotationRibs[3] + 2) % 3 };
        break;
      case "L": 
        positionRibs = new int[] { positionRibs[4], positionRibs[1], positionRibs[0], positionRibs[3], positionRibs[6], positionRibs[5], positionRibs[2], positionRibs[7] };
        rotationRibs = new int[] { (rotationRibs[4] + 1) % 3, rotationRibs[1], (rotationRibs[0] + 2) % 3, rotationRibs[3], (rotationRibs[6] + 2) % 3, rotationRibs[5], (rotationRibs[2] + 1) % 3, rotationRibs[7] };
        break;
      case "L'": 
        positionRibs = new int[] { positionRibs[2], positionRibs[1], positionRibs[6], positionRibs[3], positionRibs[0], positionRibs[5], positionRibs[4], positionRibs[7] };
        rotationRibs = new int[] { (rotationRibs[2] + 1) % 3, rotationRibs[1], (rotationRibs[6] + 2) % 3, rotationRibs[3], (rotationRibs[0] + 2) % 3, rotationRibs[5], (rotationRibs[4] + 1) % 3, rotationRibs[7] };
        break;
      case "U": 
        positionRibs = new int[] { positionRibs[2], positionRibs[0], positionRibs[3], positionRibs[1], positionRibs[4], positionRibs[5], positionRibs[6], positionRibs[7] };
        rotationRibs = new int[] { rotationRibs[2], rotationRibs[0], rotationRibs[3], rotationRibs[1], rotationRibs[4], rotationRibs[5], rotationRibs[6], rotationRibs[7] };
        break;
      case "U'": 
        positionRibs = new int[] { positionRibs[1], positionRibs[3], positionRibs[0], positionRibs[2], positionRibs[4], positionRibs[5], positionRibs[6], positionRibs[7] };
        rotationRibs = new int[] { rotationRibs[1], rotationRibs[3], rotationRibs[0], rotationRibs[2], rotationRibs[4], rotationRibs[5], rotationRibs[6], rotationRibs[7] };
        break;
      case "D": 
        positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[2], positionRibs[3], positionRibs[5], positionRibs[7], positionRibs[4], positionRibs[6] };
        rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], rotationRibs[2], rotationRibs[3], rotationRibs[5], rotationRibs[7], rotationRibs[4], rotationRibs[6] };
        break;
      case "D'": 
        positionRibs = new int[] { positionRibs[0], positionRibs[1], positionRibs[2], positionRibs[3], positionRibs[6], positionRibs[4], positionRibs[7], positionRibs[5] };
        rotationRibs = new int[] { rotationRibs[0], rotationRibs[1], rotationRibs[2], rotationRibs[3], rotationRibs[6], rotationRibs[4], rotationRibs[7], rotationRibs[5] };
      }
    }
  }
  
  public static String getElementsInArray(String[] testInput)
  {
    moveList = "";
    char[] input = new char[24];
    String p;
    for (int i = 0; i < 24; i++)
    {
      p = testInput[i];
      input[i] = p.charAt(0);
    }
    initRibs(input);
    String[] turns = moves(14);
    for (String turn : turns)
    {
      moveList += turn;
      moveList += " ";
    }
    return moveList;
  }
}
