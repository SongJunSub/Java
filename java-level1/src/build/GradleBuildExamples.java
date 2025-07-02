/*
 * 빌드/배포 자동화 심화
 * - Gradle/Maven 빌드 스크립트, 멀티모듈, CI/CD 개념 및 예시
 * - (실행은 별도 빌드 환경에서 필요)
 */

// Gradle 빌드 스크립트 예시 (주석 참고)
/*
// build.gradle
plugins {
    id 'java'
}
group 'com.example'
version '1.0.0'
repositories { mavenCentral() }
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web:3.2.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}
test { useJUnitPlatform() }
*/

// CI/CD 예시 (주석 참고)
/*
// .github/workflows/ci.yml
name: Java CI
on: [push]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
      - name: Build with Gradle
        run: ./gradlew build
*/

public class GradleBuildExamples {
    public static void main(String[] args) {
        System.out.println("Gradle/Maven 빌드, CI/CD 예제는 주석을 참고하세요.\n실행은 별도 빌드 환경에서 가능합니다.");
    }
} 