package ua.com.reactive.tour_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tour_agency.entity.Tour;
import ua.com.reactive.tour_agency.service.TourService;

@RestController
@RequestMapping("/tourController")
public class TourController {

    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public Flux<Tour> list (
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count
    ) {
        return tourService.list();
    }

    @PostMapping
    public Mono<Tour> create(@RequestBody Tour tour) {
        return tourService.addOne(tour);
    }
}
