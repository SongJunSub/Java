/*
 * 실전 메시지/이벤트 기반 아키텍처 (심화)
 * - SAGA/Outbox 패턴 실전 코드, Spring Event Sourcing, Kafka CQRS
 */

// SAGA 패턴 실전 코드 (주석 참고)
/*
@Service
public class OrderSagaService {
    @Transactional
    public void orderSaga() {
        // 1. 주문 저장
        // 2. 결제 서비스 호출
        // 3. 배송 서비스 호출
        // 4. 각 단계별 상태 저장 및 롤백 처리
    }
}
*/

// Outbox 패턴 실전 코드 (주석 참고)
/*
@Entity
public class OutboxEvent {
    @Id @GeneratedValue
    private Long id;
    private String type;
    private String payload;
    private LocalDateTime createdAt;
}
// 트랜잭션 내 OutboxEvent 저장, 별도 프로세스가 Kafka로 전송
*/

// Spring Event Sourcing 예제 (주석 참고)
/*
public class EventStore {
    private List<Event> events = new ArrayList<>();
    public void save(Event e) { events.add(e); }
    public List<Event> getEvents() { return events; }
}
*/

// Kafka CQRS 예제 (주석 참고)
/*
// Command: Kafka Producer로 명령 전송
// Query: Kafka Consumer로 상태 조회
*/

public class EventArchExamples {
    public static void main(String[] args) {
        System.out.println("SAGA/Outbox, Event Sourcing, Kafka CQRS 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 