package ua.com.reactive.tour_agency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.reactive.tour_agency.entity.Booking;

@RestController
public class BookingController {

    @GetMapping("/bookings")
    public Flux<Booking> getBookings() {

        return Flux.just(
                        new Booking(1L, 1L, 2L, "22/11/2024", 5000),
                        new Booking(2L, 3L, 1L, "15/07/2025", 3000),
                        new Booking(3L, 2L, 3L, "20/12/2024", 8500)
                        )
                .skip(0)
                .take(2);
    }

}
