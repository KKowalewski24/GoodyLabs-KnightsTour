package pl.kkowalewski.knightstour.solver;

import org.junit.jupiter.api.Test;
import pl.kkowalewski.knightstour.model.Board;
import pl.kkowalewski.knightstour.model.Cell;

import static org.junit.jupiter.api.Assertions.*;

class WarnsdorffSolverTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private Board board = new Board(new Cell(0, 0, 1));
    private Solver solver = new WarnsdorffSolver();

    /*------------------------ METHODS REGION ------------------------*/

    @Test
    void testSolution() {
//        System.out.println(board.generateVisualization());
        solver.solve(board);
        System.out.println(board.generateVisualization());
    }
}
