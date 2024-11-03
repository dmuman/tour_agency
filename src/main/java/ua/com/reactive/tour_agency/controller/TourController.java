package ua.com.reactive.tour_agency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.reactive.tour_agency.entity.Tour;

@RestController
public class TourController {

    @GetMapping("/tours")
    public Flux<Tour> getTours() {
        Flux<Tour> tours = Flux.just(
                new Tour(1L, "Путівка в Іспанію", "Путівка", 5000, false),
                new Tour(2L, "Різдво в Ісландії", "Святкування", 8500, true),
                new Tour(3L, "Відпочинок у Мюнхені", "Відпочинок", 3000, false)
        )
                .skip(0)
                .take(2);

        return tours;
    }
}
