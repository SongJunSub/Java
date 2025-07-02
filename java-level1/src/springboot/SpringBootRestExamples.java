/*
 * Spring Boot 실전 예제
 * - REST API, Validation, ExceptionHandler, JPA 연동, 테스트, Security 등
 * - (실행은 별도 Spring Boot 프로젝트에서 필요)
 */

// Spring Boot REST Controller 예제 (주석 참고)
/*
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/hello")
    public String hello() { return "Hello, Spring Boot!"; }

    @PostMapping("/user")
    public String createUser(@Validated @RequestBody UserDto dto) { return dto.toString(); }

    @ExceptionHandler(Exception.class)
    public String handleEx(Exception e) { return "에러: " + e.getMessage(); }
}

class UserDto {
    @NotBlank String name;
    @Min(0) int age;
    // getter/setter 생략
}
*/

public class SpringBootRestExamples {
    public static void main(String[] args) {
        System.out.println("Spring Boot REST API 예제는 주석을 참고하세요.\n실행은 별도 Spring Boot 프로젝트에서 가능합니다.");
    }
} 