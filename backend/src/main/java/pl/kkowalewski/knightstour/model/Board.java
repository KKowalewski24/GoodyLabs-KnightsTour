package pl.kkowalewski.knightstour.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pl.kkowalewski.knightstour.model.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Board extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final int BOARD_SIZE = 8;
    public static final int[] coordinateX = {1, 1, 2, 2, -1, -1, -2, -2};
    public static final int[] coordinateY = {2, -2, 1, -1, 2, -2, 1, -1};

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cell> chestBoard = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Cell initialCell;
    private LocalDateTime dateTime = LocalDateTime.now();

    /*------------------------ METHODS REGION ------------------------*/
    public Board() {
        fillChestBoard();
    }

    public Board(Cell initialCell) {
        this.initialCell = initialCell;
        fillChestBoard();
    }

    private void fillChestBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.chestBoard.add(i, new Cell(i, j, 0));
            }
        }
    }

    public String generateVisualization() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                result.append(chestBoard.get(j * BOARD_SIZE + i).getOrderNumber());
                result.append("\t");
            }
            result.append("\n");
        }

        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Board board = (Board) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(chestBoard, board.chestBoard)
                .append(initialCell, board.initialCell)
                .append(dateTime, board.dateTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(chestBoard)
                .append(initialCell)
                .append(dateTime)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("chestBoard", chestBoard)
                .append("initialCell", initialCell)
                .append("dateTime", dateTime)
                .toString();
    }
}
    