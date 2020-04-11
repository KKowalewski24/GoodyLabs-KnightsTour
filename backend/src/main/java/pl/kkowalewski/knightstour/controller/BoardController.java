package pl.kkowalewski.knightstour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kkowalewski.knightstour.model.Board;
import pl.kkowalewski.knightstour.model.Cell;
import pl.kkowalewski.knightstour.service.BoardService;
import pl.kkowalewski.knightstour.solver.Solver;
import pl.kkowalewski.knightstour.solver.WarnsdorffSolver;

import static pl.kkowalewski.knightstour.constant.Constants.PATH_BOARD_SOLUTION;

@RestController
public class BoardController {

    /*------------------------ FIELDS REGION ------------------------*/
    private final BoardService boardService;
    private final Solver warnsdorffSolver = new WarnsdorffSolver();

    /*------------------------ METHODS REGION ------------------------*/
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(PATH_BOARD_SOLUTION)
    public Board getSolution(
            @RequestParam(value = "pointx") int pointX,
            @RequestParam(value = "pointy") int pointY) {

        Board board = new Board(new Cell(pointX, pointY, 1));
        warnsdorffSolver.solve(board);
        boardService.save(board);

        return board;
    }
}
    