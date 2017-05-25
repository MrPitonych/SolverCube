package test.java.ru;

import main.CubeSolver;
import org.junit.Assert;
import org.junit.Test;

public class SolverTest {

  String[] checkB = { "r", "r", "y", "y", "g", "g", "g", "g", "w", "w", "o", "o", "b", "b", "b", "b", "w", "r", "w", "r", "o", "y", "o", "y" };
  String[] checkF = { "y", "y", "r", "r", "g", "g", "g", "g", "o", "o", "w", "w", "b", "b", "b", "b", "r", "w", "r", "w", "y", "o", "y", "o" };
  String[] checkL = { "b", "y", "b", "y", "y", "g", "y", "g", "g", "w", "g", "w", "w", "b", "w", "b", "r", "r", "r", "r", "o", "o", "o", "o" };
  String[] checkR = { "y", "g", "y", "g", "g", "w", "g", "w", "w", "b", "w", "b", "b", "y", "b", "y", "r", "r", "r", "r", "o", "o", "o", "o" };
  String[] checkU = { "y", "y", "y", "y", "o", "o", "g", "g", "w", "w", "w", "w", "b", "b", "r", "r", "g", "g", "r", "r", "b", "b", "o", "o" };
  String[] checkD = { "y", "y", "y", "y", "g", "g", "r", "r", "w", "w", "w", "w", "o", "o", "b", "b", "r", "r", "b", "b", "o", "o", "g", "g" };
  String[] checkHard = { "o", "o", "g", "g", "w", "w", "g", "o", "r", "b", "w", "r", "b", "y", "y", "b", "g", "r", "r", "y", "o", "w", "y", "b" };
  
  @Test
  public void solveCheck() {
    Assert.assertEquals(CubeSolver.getCheck(this.checkB), "B ");
    Assert.assertEquals(CubeSolver.getCheck(this.checkF), "F' ");
    Assert.assertEquals(CubeSolver.getCheck(this.checkL), "L' ");
    Assert.assertEquals(CubeSolver.getCheck(this.checkR), "R' ");
    Assert.assertEquals(CubeSolver.getCheck(this.checkU), "U' ");
    Assert.assertEquals(CubeSolver.getCheck(this.checkD), "D' ");
    
    Assert.assertEquals(CubeSolver.getCheck(this.checkHard), "F' R' U' F' R F F ");
  }
}
