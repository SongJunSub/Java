/*
 * 실전 모듈화/플러그인 아키텍처 (심화)
 * - Spring Boot Starter 만들기, SPI 플러그인 구조, OSGi 번들 샘플
 */

// Spring Boot Starter 만들기 예제 (주석 참고)
/*
// build.gradle (starter 모듈)
dependencies {
    api 'org.springframework.boot:spring-boot-autoconfigure'
}
// META-INF/spring.factories
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
  com.example.starter.MyAutoConfiguration

// MyAutoConfiguration.java
@Configuration
public class MyAutoConfiguration {
    @Bean
    public MyService myService() { return new MyService(); }
}
*/

// SPI 플러그인 구조 예제 (주석 참고)
/*
// 인터페이스 정의
public interface PaymentPlugin {
    void pay(int amount);
}
// 구현체 등록 (META-INF/services/com.example.PaymentPlugin)
// com.example.plugin.KakaoPayPlugin
// com.example.plugin.NaverPayPlugin
*/

// OSGi 번들 샘플 (주석 참고)
/*
// MANIFEST.MF
Bundle-Name: MyBundle
Bundle-SymbolicName: com.example.mybundle
Bundle-Version: 1.0.0
Export-Package: com.example.mybundle
Import-Package: org.osgi.framework
*/

public class ModularExamples {
    public static void main(String[] args) {
        System.out.println("Spring Boot Starter, SPI 플러그인, OSGi 번들 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 