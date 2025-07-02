/*
 * 애노테이션 & 리플렉션 심화
 * - 커스텀 애노테이션 만들기
 * - 리플렉션을 활용한 동적 객체 생성/메서드 호출
 */
import java.lang.annotation.*;
import java.lang.reflect.*;

// 커스텀 애노테이션 정의
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RunImmediately {
    int times() default 1;
}

public class CustomAnnotationExamples {
    @RunImmediately(times = 3)
    public void hello() {
        System.out.println("Hello Annotation!");
    }

    public static void main(String[] args) throws Exception {
        CustomAnnotationExamples obj = new CustomAnnotationExamples();
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately anno = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < anno.times(); i++) {
                    method.invoke(obj);
                }
            }
        }
    }
} 