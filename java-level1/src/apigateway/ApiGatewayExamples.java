/*
 * 실전 API Gateway/서버리스
 * - Spring Cloud Gateway, AWS Lambda, API Gateway, Function as a Service
 */

// 예시: Spring Cloud Gateway, Lambda, FaaS (주석 참고)
/*
// Spring Cloud Gateway 예제
@SpringBootApplication
public class GatewayApp {
    public static void main(String[] args) { SpringApplication.run(GatewayApp.class, args); }
}

// application.yml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: http://localhost:8081
          predicates:
            - Path=/user/**

// AWS Lambda 예제
public class HelloLambda implements RequestHandler<Map<String, String>, String> {
    public String handleRequest(Map<String, String> event, Context context) {
        return "Hello, Lambda!";
    }
}
*/

public class ApiGatewayExamples {
    public static void main(String[] args) {
        System.out.println("Spring Cloud Gateway, Lambda 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 