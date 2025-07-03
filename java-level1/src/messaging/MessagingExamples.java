/*
 * 메시징/비동기 처리 심화
 * - Kafka, RabbitMQ, JMS, Spring Event 등 메시지 기반 아키텍처 예제
 */

// 예시: Kafka, RabbitMQ, JMS, Spring Event (주석 참고)
/*
// Kafka Producer 예제
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;
kafkaTemplate.send("topic", "메시지");

// RabbitMQ 예제
@Autowired
private AmqpTemplate amqpTemplate;
amqpTemplate.convertAndSend("queue", "메시지");

// JMS 예제
@Autowired
private JmsTemplate jmsTemplate;
jmsTemplate.convertAndSend("queue", "메시지");

// Spring Event 예제
@Component
public class MyEventPublisher {
    @Autowired ApplicationEventPublisher publisher;
    public void publish() { publisher.publishEvent(new MyEvent(this)); }
}
*/

public class MessagingExamples {
    public static void main(String[] args) {
        System.out.println("Kafka, RabbitMQ, JMS, Spring Event 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 