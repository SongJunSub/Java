/*
 * 대용량 데이터 처리 (실전)
 * - Spring Batch 실전 잡, 병렬 파일 처리, Spark/MapReduce 샘플
 */
import java.util.concurrent.*;

// Spring Batch 실전 잡 예시 (주석 참고)
/*
// build.gradle
implementation 'org.springframework.boot:spring-boot-starter-batch'

// Job/Step 구성 예시
@Configuration
public class BatchConfig {
    @Bean
    public Job sampleJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        Step step = stepBuilderFactory.get("step1")
            .tasklet((contribution, chunkContext) -> {
                System.out.println("Spring Batch 실행!");
                return RepeatStatus.FINISHED;
            }).build();
        return jobBuilderFactory.get("sampleJob").start(step).build();
    }
}
*/

// 병렬 파일 처리 예제
class ParallelFileProcessor {
    public void processFiles(String[] files) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (String file : files) {
            pool.submit(() -> System.out.println("파일 처리: " + file));
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}

// Spark/MapReduce 샘플 (주석 참고)
/*
// Spark 예제 (Scala)
val rdd = sc.textFile("data.txt")
rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect()

// Hadoop MapReduce 예제 (Java)
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    public void map(LongWritable key, Text value, Context context) {
        for (String word : value.toString().split(" ")) {
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
*/

public class BigDataExamples {
    public static void main(String[] args) throws Exception {
        // 병렬 파일 처리 실습
        String[] files = {"a.txt", "b.txt", "c.txt"};
        new ParallelFileProcessor().processFiles(files);
        System.out.println("Spring Batch, Spark, MapReduce 등은 주석의 예시를 참고하세요.");
    }
} 