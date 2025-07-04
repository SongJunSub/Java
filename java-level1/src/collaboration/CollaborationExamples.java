/*
 * 실전 코드 리뷰/협업/CI 정책
 * - PR 템플릿, 코드 리뷰 체크리스트, Branch 전략, 린트/포맷 자동화
 */

// 예시: PR 템플릿, 리뷰 체크리스트, Branch 전략, 린트 (주석 참고)
/*
// PR 템플릿 예시 (.github/pull_request_template.md)
- [ ] 기능 설명
- [ ] 테스트 코드 포함
- [ ] 리뷰어에게 중점적으로 봐줬으면 하는 부분

// 코드 리뷰 체크리스트
- 네이밍, 중복, 예외처리, 테스트, 성능, 보안 등

// Branch 전략
- main, develop, feature/bugfix/release 브랜치 분리

// 린트/포맷 자동화 (GitHub Actions)
- uses: actions/checkout@v3
- run: ./gradlew checkstyle
*/

public class CollaborationExamples {
    public static void main(String[] args) {
        System.out.println("PR 템플릿, 리뷰 체크리스트, Branch 전략, 린트 등은 주석의 예시를 참고하세요.\n실행은 별도 협업 환경에서 가능합니다.");
    }
} 