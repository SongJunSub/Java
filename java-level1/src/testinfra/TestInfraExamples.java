/*
 * 테스트 자동화 & Mock 서버
 * - Testcontainers, WireMock, Embedded DB(H2) 등 실전 테스트 환경 구성법
 */

// 예시: Testcontainers, WireMock, H2 (주석 참고)
/*
// Testcontainers 예제
@Container
static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15");

// WireMock 예제
WireMockServer wireMockServer = new WireMockServer(options().port(8089));
wireMockServer.start();
wireMockServer.stubFor(get(urlEqualTo("/api/test")).willReturn(aResponse().withBody("ok")));

// Embedded H2 DB 예제
spring.datasource.url=jdbc:h2:mem:testdb
*/

public class TestInfraExamples {
    public static void main(String[] args) {
        System.out.println("Testcontainers, WireMock, H2 등은 주석의 예시를 참고하세요.\n실행은 별도 테스트 환경에서 가능합니다.");
    }
} 