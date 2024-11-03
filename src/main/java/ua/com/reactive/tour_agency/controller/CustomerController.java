package ua.com.reactive.tour_agency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.reactive.tour_agency.entity.Customer;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    public Flux<Customer> getClients() {

        return Flux.just(
                        new Customer(1L, "Вася", "Пупкін", 18, false),
                        new Customer(2L, "Іва", "Пупкіна", 19, false),
                        new Customer(3L, "Інна", "Пупкіна", 20, true)
                )
                .skip(0)
                .take(2);
    }


}
