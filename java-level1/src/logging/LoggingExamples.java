/*
 * 로깅 & 모니터링
 * - SLF4J, Logback, Log4j2, AOP 기반 로깅, ELK 연동 예시
 */

// 예시: SLF4J, Logback, Log4j2, AOP, ELK (주석 참고)
/*
// SLF4J + Logback 예제
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
Logger log = LoggerFactory.getLogger(getClass());
log.info("로그 메시지");

// AOP 기반 로깅 예제 (Spring)
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example..*Service.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("메서드 호출: " + joinPoint.getSignature());
    }
}

// ELK 연동: Logstash, Filebeat, Kibana 등 활용
*/

public class LoggingExamples {
    public static void main(String[] args) {
        System.out.println("SLF4J, Logback, Log4j2, AOP, ELK 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 