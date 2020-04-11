package pl.kkowalewski.knightstour.solver;

import pl.kkowalewski.knightstour.exception.algorithm.SolutionNotFoundException;
import pl.kkowalewski.knightstour.model.Board;
import pl.kkowalewski.knightstour.model.Cell;

import java.util.concurrent.ThreadLocalRandom;

import static pl.kkowalewski.knightstour.model.Board.BOARD_SIZE;
import static pl.kkowalewski.knightstour.model.Board.coordinateX;
import static pl.kkowalewski.knightstour.model.Board.coordinateY;

public class WarnsdorffSolver implements Solver {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final int MAX_NUMBER_OF_ITERATION = 10000;

    /*------------------------ METHODS REGION ------------------------*/
    private boolean checkIfPositionStillOnBoard(int pointX, int pointY) {
        return ((pointX >= 0 && pointY >= 0) && (pointX < BOARD_SIZE && pointY < BOARD_SIZE));
    }

    private boolean checkIfSquareEmpty(int[] board, int pointX, int pointY) {
        return (checkIfPositionStillOnBoard(pointX, pointY))
                && (board[pointY * BOARD_SIZE + pointX] < 0);
    }

    private int getNumberOfEmptyCells(int[] board, int pointX, int pointY) {
        int counter = 0;

        for (int i = 0; i < BOARD_SIZE; ++i) {
            if (checkIfSquareEmpty(board, (pointX + coordinateX[i]), (pointY + coordinateY[i]))) {
                counter++;
            }
        }

        return counter;
    }

    private boolean checkIfTourClosed(int pointX, int pointY, int initialPointX,
                                      int initialPointY) {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            if (((pointX + coordinateX[i]) == initialPointX)
                    && ((pointY + coordinateY[i]) == initialPointY)) {
                return true;
            }
        }

        return false;
    }

    private Cell makeNextMove(int[] board, Cell initialCell) {
        int minimumDegreeIndex = -1;
        int minimumDegree = (BOARD_SIZE + 1);
        int newPointX;
        int newPointY;

        int start = ThreadLocalRandom.current().nextInt(1000) % BOARD_SIZE;
        for (int count = 0; count < BOARD_SIZE; ++count) {
            int i = (start + count) % BOARD_SIZE;
            newPointX = initialCell.getPointX() + coordinateX[i];
            newPointY = initialCell.getPointY() + coordinateY[i];

            if ((checkIfSquareEmpty(board, newPointX, newPointY))
                    && getNumberOfEmptyCells(board, newPointX, newPointY) < minimumDegree) {
                minimumDegreeIndex = i;
                minimumDegree = getNumberOfEmptyCells(board, newPointX, newPointY);
            }
        }

        if (minimumDegreeIndex == -1) {
            return null;
        }

        newPointX = initialCell.getPointX() + coordinateX[minimumDegreeIndex];
        newPointY = initialCell.getPointY() + coordinateY[minimumDegreeIndex];

        board[newPointY * BOARD_SIZE + newPointX]
                = board[(initialCell.getPointY()) * BOARD_SIZE + (initialCell.getPointX())] + 1;

        initialCell.setPointX(newPointX);
        initialCell.setPointY(newPointY);

        return initialCell;
    }

    /* displays the chessboard with all the
    legal knight's moves */
    //    TODO
    void print(int[] a) {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            for (int j = 0; j < BOARD_SIZE; ++j) {
                System.out.printf("%d\t", a[j * BOARD_SIZE + i]);
            }
            System.out.printf("\n");
        }
    }

    private boolean generateClosedTour(Board board) {
        int[] orderBoard = new int[BOARD_SIZE * BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; ++i) {
            orderBoard[i] = -1;
        }

        int initialPointX = board.getInitialCell().getPointX();
        int initialPointY = board.getInitialCell().getPointY();

        Cell cell = new Cell(initialPointX, initialPointY, 1);
        orderBoard[cell.getPointY() * BOARD_SIZE + cell.getPointX()] = 1;

        Cell resultCell = null;
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE - 1; ++i) {
            resultCell = makeNextMove(orderBoard, cell);
            if (resultCell == null) {
                return false;
            }
        }

        if (!checkIfTourClosed(resultCell.getPointX(), resultCell.getPointY(),
                initialPointX, initialPointY)) {
            return false;
        }

        print(orderBoard);

        for (int i = 0; i < orderBoard.length; i++) {
            board.getChestBoard().get(i).setOrderNumber(orderBoard[i]);
        }

        return true;
    }

    @Override
    public void solve(Board board) {
        boolean isSolved = false;

        for (int i = 0; i < MAX_NUMBER_OF_ITERATION; i++) {
            if (generateClosedTour(board)) {
                isSolved = true;
                break;
            }
        }

        if (!isSolved) {
            throw new SolutionNotFoundException();
        }
    }
}
    