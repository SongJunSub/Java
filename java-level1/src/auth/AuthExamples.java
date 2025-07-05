/*
 * 실전 인증/인가 통합 (심화)
 * - OAuth2 Resource Server, JWT Refresh Token, LDAP 인증 연동
 */

// OAuth2 Resource Server 예제 (Spring Security)
/*
// build.gradle
implementation 'org.springframework.boot:spring-boot-starter-oauth2-resource-server'

// application.yml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          jwk-set-uri: https://example.com/.well-known/jwks.json

// SecurityConfig.java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer().jwt();
    }
}
*/

// JWT Refresh Token 예제 (주석 참고)
/*
// 1. AccessToken, RefreshToken 분리 발급
// 2. RefreshToken 저장(DB/Redis) 및 만료 관리
// 3. RefreshToken으로 AccessToken 재발급 API 구현
*/

// LDAP 인증 연동 예제
/*
// application.yml
spring:
  ldap:
    urls: ldap://localhost:8389
    base: dc=springframework,dc=org
    username: uid=admin,ou=people,dc=springframework,dc=org
    password: password
*/

public class AuthExamples {
    public static void main(String[] args) {
        System.out.println("OAuth2 Resource Server, JWT Refresh Token, LDAP 인증 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 