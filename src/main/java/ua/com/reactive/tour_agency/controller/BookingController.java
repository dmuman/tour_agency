package ua.com.reactive.tour_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tour_agency.entity.Booking;
import ua.com.reactive.tour_agency.service.BookingService;

@RestController
@RequestMapping("/bookingController")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public Flux<Booking> list (
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count
    ) {
        return bookingService.list();
    }

    @PostMapping
    public Mono<Booking> create(@RequestBody Booking booking) {
        return bookingService.addOne(booking);
    }
}
