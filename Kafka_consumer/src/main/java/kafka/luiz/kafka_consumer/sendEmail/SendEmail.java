package kafka.luiz.kafka_consumer.sendEmail;

import kafka.luiz.kafka_consumer.dto.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class SendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(Message message) {

        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(message.getFrom());
            mailMessage.setTo(message.getTo());
            mailMessage.setSubject(message.getSubject());
            mailMessage.setText(message.getText());

            javaMailSender.send(mailMessage);
            return "Email send";

        } catch (MailException e) {
            log.info(e);
            return "Error email send";
        }
    }
}
