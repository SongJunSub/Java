/*
 * 국제화(i18n), 로케일 처리 심화
 * - 다국어 지원, Locale/ResourceBundle 활용 예제
 */
import java.util.*;

public class I18nExamples {
    public static void main(String[] args) {
        // 1. Locale 사용
        Locale ko = new Locale("ko", "KR");
        Locale en = new Locale("en", "US");
        System.out.println("한국어: " + ko.getDisplayLanguage(ko));
        System.out.println("영어: " + en.getDisplayLanguage(en));

        // 2. ResourceBundle로 다국어 메시지
        ResourceBundle bundle = ResourceBundle.getBundle("messages", ko);
        System.out.println("메시지(ko): " + bundle.getString("greeting"));
        // messages_ko.properties, messages_en.properties 파일 필요
    }
} 