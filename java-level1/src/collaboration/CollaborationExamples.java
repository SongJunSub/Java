/*
 * 실전 코드 리뷰/협업/CI 정책 (심화)
 * - 실제 PR 템플릿, 리뷰 체크리스트, GitHub Actions 린트/테스트 워크플로
 */

// 실제 PR 템플릿 예시 (.github/pull_request_template.md)
/*
### PR 내용 요약
- [ ] 기능/버그/리팩토링/문서화
- [ ] 테스트 코드 포함 여부
- [ ] 리뷰어에게 중점적으로 봐줬으면 하는 부분

### 체크리스트
- [ ] 코드 컨벤션 준수
- [ ] 네이밍/중복/예외처리/테스트/성능/보안
- [ ] 커밋 메시지 규칙 준수
*/

// 리뷰 체크리스트 예시 (주석 참고)
/*
- 변수/메서드/클래스 네이밍이 명확한가?
- 중복 코드/로직이 없는가?
- 예외처리/에러 핸들링이 적절한가?
- 테스트 코드가 충분한가?
- 성능/보안 이슈가 없는가?
*/

// GitHub Actions 린트/테스트 워크플로 예시 (.github/workflows/ci.yml)
/*
name: Java CI
on: [push, pull_request]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
      - name: Lint & Test
        run: ./gradlew check
*/

public class CollaborationExamples {
    public static void main(String[] args) {
        System.out.println("PR 템플릿, 리뷰 체크리스트, GitHub Actions 워크플로 등은 주석의 예시를 참고하세요.\n실행은 별도 협업 환경에서 가능합니다.");
    }
} 