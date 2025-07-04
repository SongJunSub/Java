/*
 * 실전 메시지/이벤트 기반 아키텍처
 * - SAGA 패턴, Event Sourcing, CQRS, Outbox 패턴
 */

// 예시: SAGA, Event Sourcing, CQRS, Outbox (주석 참고)
/*
// SAGA 패턴 예제 (주문-결제-배송)
@Transactional
public void orderSaga() {
    // 주문 저장
    // 결제 서비스 호출
    // 배송 서비스 호출
    // 각 단계별 상태 저장 및 롤백 처리
}

// Event Sourcing 예제
class EventStore {
    List<Event> events;
    void save(Event e) { events.add(e); }
    List<Event> getEvents() { return events; }
}

// CQRS 예제
// Command: 데이터 변경, Query: 데이터 조회 분리

// Outbox 패턴 예제
// 트랜잭션 내 이벤트 테이블에 기록, 별도 프로세스가 메시지 브로커로 전송
*/

public class EventArchExamples {
    public static void main(String[] args) {
        System.out.println("SAGA, Event Sourcing, CQRS, Outbox 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 