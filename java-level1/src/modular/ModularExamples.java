/*
 * 실전 모듈화/플러그인 아키텍처
 * - OSGi, Spring Boot Starter, SPI(Service Provider Interface) 활용
 */

// 예시: OSGi, Spring Boot Starter, SPI (주석 참고)
/*
// OSGi 예제
BundleContext context = ...;
ServiceReference ref = context.getServiceReference(MyService.class.getName());
MyService service = (MyService) context.getService(ref);

// Spring Boot Starter 예제
// spring-boot-starter-data-jpa, spring-boot-starter-web 등

// SPI 예제
// META-INF/services/에 인터페이스 구현체 등록
*/

public class ModularExamples {
    public static void main(String[] args) {
        System.out.println("OSGi, Spring Boot Starter, SPI 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 