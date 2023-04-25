package kafka.luiz.kafka_producer.services;

import kafka.luiz.kafka_producer.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@RequiredArgsConstructor
@Service
public class JsonProducerService {

    private final  KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    public void sendMessage(Message message){
        log.info("Receive message {}", message.getMessage());
        Thread.sleep(1000);

        log.info("Sending message...");
        kafkaTemplate.send("***", message);
    }
}
