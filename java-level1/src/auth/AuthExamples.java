/*
 * 실전 인증/인가 통합
 * - SSO, LDAP, SAML, OAuth2 Provider/Resource Server, MFA
 */

// 예시: SSO, LDAP, SAML, OAuth2, MFA (주석 참고)
/*
// SSO 예제 (Spring Security)
@EnableWebSecurity
public class SsoConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();
    }
}

// LDAP 예제
spring.ldap.urls=ldap://localhost:8389
spring.ldap.base=dc=springframework,dc=org

// SAML 예제: spring-security-saml2-service-provider
// OAuth2 Provider/Resource Server 예제: spring-authorization-server
*/

public class AuthExamples {
    public static void main(String[] args) {
        System.out.println("SSO, LDAP, SAML, OAuth2 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 