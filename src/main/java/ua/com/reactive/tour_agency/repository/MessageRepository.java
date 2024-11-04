package ua.com.reactive.tour_agency.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.tour_agency.entity.Message;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
