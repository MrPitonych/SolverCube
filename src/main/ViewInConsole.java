package main;

import java.io.PrintStream;
import java.util.Scanner;

public class ViewInConsole
{
  static String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X" };
  
  static String[] viewBoard()
  {
    String[] inputFromUser = new String[24];
    Scanner scan = new Scanner(System.in);
    int rows = 2;
    System.out.println("Возьмите кубик так, чтобы жёлтая сторона смотрела вверх");
    System.out.print("               ______ ______");
    System.out.print("\n              |      |      |");
    System.out.print("\n              |   A  |   B  |");
    System.out.print("\n              |______|______|");
    System.out.print("\n              |      |      |");
    System.out.print("\n              |   C  |   D  |");
    System.out.print("\n ______ ______|______|______|______ ______");
    System.out.print("\n|      |      |      |      |      |      |");
    System.out.print("\n|   Q  |   R  |   E  |   F  |   U  |   V  |");
    System.out.print("\n|______|______|______|______|______|______|");
    System.out.print("\n|      |      |      |      |      |      |");
    System.out.print("\n|   S  |   T  |   G  |   H  |   W  |   X  |");
    System.out.print("\n|______|______|______|______|______|______|");
    System.out.print("\n              |      |      |");
    System.out.print("\n              |   I  |   J  |");
    System.out.print("\n              |______|______|");
    System.out.print("\n              |      |      |");
    System.out.print("\n              |   K  |   L  |");
    System.out.print("\n              |______|______|");
    System.out.print("\n              |      |      |");
    System.out.print("\n              |   M  |   N  |");
    System.out.print("\n              |______|______|");
    System.out.print("\n              |      |      |");
    System.out.print("\n              |   O  |   P  |");
    System.out.print("\n              |______|______|");
    System.out.println();
    for (int i = 0; i < 24; i++)
    {
      System.out.println("Введите " + alphabet[i] + ": ");
      inputFromUser[i] = scan.next();
    }
    return inputFromUser;
  }
}
