package ua.com.reactive.tour_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tour_agency.entity.Customer;
import ua.com.reactive.tour_agency.service.CustomerService;

@RestController
@RequestMapping("/customerController")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Flux<Customer> list (
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count
    ) {
        return customerService.list();
    }

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer customer) {
        return customerService.addOne(customer);
    }
}
