package main;

/**
 * Created by dav19 on 28.05.2017.
 */
public class CubeSolverForTest {
    private Cube newCube = new Cube();
    private CubeSolver testSolve = new CubeSolver();

    public  String getCheck(int[] testInput) {
        String moveList = "";
        int[] input = testInput;

        newCube.initRibs(input);
        String[] turns = testSolve.moves(14, newCube.getPositionRibs(), newCube.getRotationRibs());
        for (String turn : turns) {
            moveList += turn;
            moveList += " ";
        }
        return moveList;
    }
}
