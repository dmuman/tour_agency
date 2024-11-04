package ua.com.reactive.tour_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tour {

    @Id
    private Long id;
    private String tourName;
    private String tourType;
    private double tourPrice;
    private boolean isHot;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour tour)) return false;
        return Objects.equals(getTourName(), tour.getTourName()) &&
                Objects.equals(getTourType(), tour.getTourType()) &&
                getTourPrice() == tour.getTourPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourName(), getTourType(), getTourPrice());
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", tourName='" + tourName + '\'' +
                ", tourType='" + tourType + '\'' +
                ", tourPrice=" + tourPrice +
                '}';
    }
}

// testing git
