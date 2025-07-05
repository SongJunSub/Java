/*
 * 실전 API Gateway/서버리스 (심화)
 * - Spring Cloud Gateway 실전 라우팅, API Rate Limiting, Lambda 핸들러
 */

// Spring Cloud Gateway 실전 라우팅 예시 (주석 참고)
/*
// application.yml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: http://localhost:8081
          predicates:
            - Path=/user/**
          filters:
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 10
                redis-rate-limiter.burstCapacity: 20
*/

// API Rate Limiting 필터 예제 (Spring)
/*
@Component
public class RateLimitFilter implements GatewayFilterFactory<Object> {
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            // Redis 등으로 요청 수 체크 후 제한
            return chain.filter(exchange);
        };
    }
}
*/

// AWS Lambda 핸들러 예제
/*
public class HelloLambda implements RequestHandler<Map<String, String>, String> {
    public String handleRequest(Map<String, String> event, Context context) {
        return "Hello, Lambda!";
    }
}
*/

public class ApiGatewayExamples {
    public static void main(String[] args) {
        System.out.println("Spring Cloud Gateway 라우팅, Rate Limiting, Lambda 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 