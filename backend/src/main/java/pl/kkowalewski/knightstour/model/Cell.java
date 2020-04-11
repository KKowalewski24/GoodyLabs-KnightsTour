package pl.kkowalewski.knightstour.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pl.kkowalewski.knightstour.model.base.BaseEntity;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cell extends BaseEntity implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    private int pointX;
    private int pointY;

    /*------------------------ METHODS REGION ------------------------*/
    public Cell(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
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
                .append(pointX, cell.pointX)
                .append(pointY, cell.pointY)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(pointX)
                .append(pointY)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pointX", pointX)
                .append("pointY", pointY)
                .toString();
    }
}
    