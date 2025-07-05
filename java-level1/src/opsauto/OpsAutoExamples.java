/*
 * 운영 자동화/배포 스크립트 (실전)
 * - Blue-Green 배포, 롤백, 헬스체크, Prometheus 연동
 */

// Blue-Green 배포 스크립트 예시 (Shell)
/*
#!/bin/bash
# blue-green-deploy.sh
# 1. 새 버전(blue) 배포
# 2. 헬스체크 통과 시 트래픽 전환(green)
# 3. 실패 시 롤백

APP_NAME=myapp
NEW_VER=2.0.0
OLD_VER=1.0.0

echo "배포 시작: $NEW_VER"
docker run -d --name $APP_NAME-blue myapp:$NEW_VER
sleep 10
if curl -f http://localhost:8080/health; then
  echo "헬스체크 성공, 트래픽 전환"
  docker stop $APP_NAME-green
  docker rename $APP_NAME-blue $APP_NAME-green
else
  echo "헬스체크 실패, 롤백"
  docker stop $APP_NAME-blue
fi
*/

// Spring Boot 헬스체크/Prometheus 연동 샘플
/*
// build.gradle
implementation 'org.springframework.boot:spring-boot-starter-actuator'
implementation 'io.micrometer:micrometer-registry-prometheus'

// application.yml
management:
  endpoints:
    web:
      exposure:
        include: health, prometheus

// /actuator/health, /actuator/prometheus 엔드포인트 제공
*/

public class OpsAutoExamples {
    public static void main(String[] args) {
        System.out.println("Blue-Green 배포, 롤백, 헬스체크, Prometheus 연동 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 