package pl.kkowalewski.knightstour.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pl.kkowalewski.knightstour.model.base.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cell extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    private int pointX;
    private int pointY;
    private int orderNumber;

    /*------------------------ METHODS REGION ------------------------*/
    public Cell(int pointX, int pointY, int orderNumber) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(pointX, cell.pointX)
                .append(pointY, cell.pointY)
                .append(orderNumber, cell.orderNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(pointX)
                .append(pointY)
                .append(orderNumber)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("pointX", pointX)
                .append("pointY", pointY)
                .append("orderNumber", orderNumber)
                .toString();
    }
}
    