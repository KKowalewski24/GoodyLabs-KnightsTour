package pl.kkowalewski.knightstour.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kkowalewski.knightstour.model.Board;
import pl.kkowalewski.knightstour.model.Cell;
import pl.kkowalewski.knightstour.service.board.BoardService;
import pl.kkowalewski.knightstour.solver.Solver;
import pl.kkowalewski.knightstour.solver.WarnsdorffSolver;

import static pl.kkowalewski.knightstour.constant.Constants.PATH_BOARD_SOLUTION;
import static pl.kkowalewski.knightstour.constant.Constants.PATH_FRONTEND_CORS;

@RestController
public class BoardController {

    /*------------------------ FIELDS REGION ------------------------*/
    private final BoardService boardService;
    private final Solver warnsdorffSolver = new WarnsdorffSolver();

    /*------------------------ METHODS REGION ------------------------*/
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @CrossOrigin(origins = PATH_FRONTEND_CORS)
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
    