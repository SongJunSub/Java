/*
 * JVM & 성능 튜닝 심화
 * - GC(가비지 컬렉션), JVM 옵션, 프로파일링, 메모리/스레드 덤프 분석
 * - 실무에서 자주 쓰는 JVM 옵션 예시와 GC 동작 확인 코드
 */
public class JvmTuningExamples {
    public static void main(String[] args) {
        // 1. JVM 옵션 예시 (실행 시 적용)
        // -Xmx512m -Xms256m -XX:+UseG1GC -XX:+PrintGCDetails
        System.out.println("JVM 옵션: -Xmx512m -Xms256m -XX:+UseG1GC -XX:+PrintGCDetails");

        // 2. GC 동작 확인용 코드
        for (int i = 0; i < 100000; i++) {
            String s = new String("test" + i);
        }
        System.gc(); // 명시적 GC 호출 (테스트용)
        System.out.println("GC 호출 후 메모리 상태를 로그로 확인하세요.");

        // 3. 프로파일링/덤프 (jvisualvm, jcmd, jmap, jstack 등 활용)
        System.out.println("jvisualvm, jcmd, jmap, jstack 등으로 프로파일링/덤프 분석 가능");
    }
} 