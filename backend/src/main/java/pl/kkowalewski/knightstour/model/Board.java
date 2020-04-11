package pl.kkowalewski.knightstour.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kkowalewski.knightstour.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Board extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final int BOARD_SIZE = 8;
    public static final int coordinateX[] = {1, 1, 2, 2, -1, -1, -2, -2};
    public static final int coordinateY[] = {2, -2, 1, -1, 2, -2, 1, -1};

    @OneToMany
    private List<Cell> chestBoard = Arrays.asList(new Cell[BOARD_SIZE * BOARD_SIZE]);
    @OneToOne
    private Cell initialCell;
    private LocalDateTime dateTime = LocalDateTime.now();

    /*------------------------ METHODS REGION ------------------------*/
    public Board(Cell initialCell) {
        this.initialCell = initialCell;
    }

    private boolean checkIfPositionStillOnBoard(int axisX, int axisY) {
        return (axisX >= 0 && axisY >= 0) && (axisX < BOARD_SIZE && axisY < BOARD_SIZE);
    }

    private boolean checkIfSquareEmpty(int board[], int pointX, int pointY) {
        return checkIfPositionStillOnBoard(pointX, pointY)
                && (board[pointY * BOARD_SIZE + pointX] < 0);
    }

    private int getNumberOfEmptyCells(int board[], int pointX, int pointY) {
        int counter = 0;

        for (int i = 0; i < BOARD_SIZE; ++i) {
            if (checkIfSquareEmpty(board, (pointX + coordinateX[i]), (pointY + coordinateY[i]))) {
                counter++;
            }
        }

        return counter;
    }

//    public String generateVisualization(){
//
//    }
}
    