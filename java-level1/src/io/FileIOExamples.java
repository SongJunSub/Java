package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.*;
import java.util.List;

public class FileIOExamples {
    public static void main(String[] args) throws Exception {
        // 1. 파일 쓰기 (기본 IO)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sample.txt"))) {
            writer.write("Hello, File IO!\nJava NIO2 Example");
        }
        // 2. 파일 읽기 (NIO2)
        List<String> lines = Files.readAllLines(Paths.get("sample.txt"));
        for (String line : lines) {
            System.out.println(line);
        }
        // 3. 비동기 파일 IO (간단 예시)
        Path path = Paths.get("sample.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                System.out.println("비동기 읽기: " + new String(attachment.array()).trim());
            }
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("비동기 읽기 실패");
            }
        });
        Thread.sleep(500); // 비동기 완료 대기
    }
}