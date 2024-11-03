package ua.com.reactive.tour_agency.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tour_agency.entity.Customer;
import ua.com.reactive.tour_agency.entity.Greeting;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Main page!"));
    }

    public Mono<ServerResponse> getClients(ServerRequest request) {

        String start = request
                .queryParam("start")
                .orElse("0");


        Flux<Customer> clients = Flux.just(
                new Customer(1L, "Vasya", "Pypkin", 18, false),
                new Customer(2L, "Iva", "Pypkina", 19, false),
                new Customer(3L, "Inna", "Pypkina", 20, true)
        )
                .skip(Long.parseLong(start))
                .take(3);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Customer.class);
    }

}
