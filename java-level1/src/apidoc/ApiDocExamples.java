/*
 * API 문서화
 * - Swagger(OpenAPI), Spring REST Docs 등 API 문서 자동화 예제
 */

// 예시: Swagger, Spring REST Docs (주석 참고)
/*
// Swagger 예제 (Spring Boot)
implementation 'io.springfox:springfox-boot-starter:3.0.0'
@EnableOpenApi
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }
}

// Spring REST Docs 예제
@AutoConfigureRestDocs
public class UserControllerTest {
    @Test
    void test() throws Exception {
        mockMvc.perform(get("/api/user")).andDo(document("get-user"));
    }
}
*/

public class ApiDocExamples {
    public static void main(String[] args) {
        System.out.println("Swagger, Spring REST Docs 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 