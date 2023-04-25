package kafka.luiz.kafka_producer.resource;

import kafka.luiz.kafka_producer.dto.Message;
import kafka.luiz.kafka_producer.services.JsonProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class JsonProducerResource {

    private final JsonProducerService producerService;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message){

        producerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
