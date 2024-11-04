package ua.com.reactive.tour_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tour_agency.entity.Tour;
import ua.com.reactive.tour_agency.repository.TourRepository;

@Service
public class TourService {

    private final TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Flux<Tour> list() {
        return tourRepository.findAll();
    }

    public Mono<Tour> addOne(Tour tour) {
        return tourRepository.save(tour);
    }
}
