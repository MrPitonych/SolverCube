package test.java.ru;


import main.CubeSolverForTest;
import org.junit.Assert;
import org.junit.Test;

public class SolverTest {

  CubeSolverForTest newTest = new CubeSolverForTest();
    private int[] check1 = {1, 4, 1, 4, 2, 1, 2, 1, 3, 2, 3, 2, 4, 3, 4, 3, 5, 5, 5, 5, 6, 6, 6, 6};
    private int[] check2 = {1, 6, 1, 3, 2, 4, 6, 2, 1, 5, 3, 2, 4, 3, 4, 2, 5, 5, 5, 4, 6, 1, 3, 6};
    private int[] check3 = {1, 3, 4, 4, 5, 6, 4, 1, 6, 5, 2, 5, 6, 1, 2, 5, 6, 3, 3, 1, 3, 2, 2, 4};
    private int[] check4 = {3, 6, 1, 5, 2, 1, 6, 3, 3, 5, 2, 2, 1, 5, 4, 1, 6, 5, 6, 2, 4, 4, 4, 3};
  
  @Test
  public void solveCheck() {
    Assert.assertEquals("R ", newTest.getCheck(check1));
    Assert.assertEquals("U F U' R ", newTest.getCheck(check2));
    Assert.assertEquals("F' R U' R U' B D' ", newTest.getCheck(check3));
    Assert.assertEquals("F' F' R' U' F D L' F D  ", newTest.getCheck(check4));
  }
}
