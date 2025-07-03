/*
 * 보안(Security) 심화
 * - Spring Security, JWT 인증/인가, OAuth2, XSS/CSRF 방어 등
 */

// 예시: Spring Security, JWT, OAuth2, XSS/CSRF (주석 참고)
/*
// Spring Security 설정 예제
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/public").permitAll()
            .anyRequest().authenticated();
    }
}

// JWT 인증 필터 예제
public class JwtFilter extends OncePerRequestFilter {
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) {
        // JWT 토큰 파싱 및 인증 처리
    }
}

// OAuth2 예제: application.yml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: xxx
            client-secret: xxx
*/

public class SecurityExamples {
    public static void main(String[] args) {
        System.out.println("Spring Security, JWT, OAuth2, XSS/CSRF 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 