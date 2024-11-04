package ua.com.reactive.tour_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tour_agency.entity.Booking;
import ua.com.reactive.tour_agency.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Flux<Booking> list() {
        return bookingRepository.findAll();
    }

    public Mono<Booking> addOne(Booking booking) {
        return bookingRepository.save(booking);
    }
}
