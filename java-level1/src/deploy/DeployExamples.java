/*
 * 배포/운영 심화
 * - Dockerfile, Docker Compose, Kubernetes 배포 예시
 * - 운영 환경에서의 환경 변수, 설정 파일 관리
 */

// 예시: Docker, K8s, 환경 변수 (주석 참고)
/*
// Dockerfile 예제
FROM openjdk:21-jdk
COPY build/libs/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

// docker-compose.yml 예제
version: '3'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod

// Kubernetes 배포 예제
apiVersion: apps/v1
kind: Deployment
metadata:
  name: my-app
spec:
  replicas: 2
  template:
    spec:
      containers:
      - name: app
        image: my-app:latest
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: prod
*/

public class DeployExamples {
    public static void main(String[] args) {
        System.out.println("Docker, K8s, 환경 변수 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 