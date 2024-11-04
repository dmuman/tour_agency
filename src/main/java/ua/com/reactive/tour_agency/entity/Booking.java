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
public class Booking {

    @Id
    private Long id;
    private Long tourId;
    private Long customerId;
    private String bookingDate;
    private double totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(getId(), booking.getId()) &&
                Objects.equals(getTourId(), booking.getTourId()) &&
                Objects.equals(getCustomerId(), booking.getCustomerId()) &&
                Objects.equals(getBookingDate(), booking.getBookingDate()) &&
                getTotalPrice() == booking.getTotalPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTourId(), getCustomerId(), getBookingDate(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", tourId='" + tourId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", bookingDate=" + bookingDate + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
