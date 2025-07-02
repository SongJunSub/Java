/*
 * REST API 클라이언트/서버 심화
 * - HttpURLConnection, OkHttp, WebClient, 간단한 REST 서버/클라이언트 구현
 * - (실행은 환경에 따라 다름)
 */
import java.io.*;
import java.net.*;

public class RestApiClientExamples {
    public static void main(String[] args) throws Exception {
        // 1. HttpURLConnection으로 GET 요청
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        System.out.println("GET 결과: " + content);

        // 2. OkHttp, WebClient 등은 별도 라이브러리 필요 (주석 참고)
        /*
        // OkHttp 예제
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/posts/1").build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        */
    }
} 