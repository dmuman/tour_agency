package ua.com.reactive.tour_agency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tour_agency.entity.Message;
import ua.com.reactive.tour_agency.service.MessageService;

@RestController
@RequestMapping("/mainController")
//@RequiredArgsConstructor(onConstructor = {@Autowired})
//@RequiredArgsConstructor
public class MainController {

    private final MessageService messageService;

    @Autowired
    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public Flux<Message> list (
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count
    ) {
        return messageService.list();
    }

    @PostMapping
    public Mono<Message> create(@RequestBody Message message) {
        return messageService.addOne(message);
    }
}
