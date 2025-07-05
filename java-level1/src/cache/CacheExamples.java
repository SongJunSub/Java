/*
 * 실전 캐시 전략 (심화)
 * - Redis 실전 캐시 코드, Caffeine 벤치마크, 캐시 무효화 전략
 */

// Redis 실전 캐시 코드 (Spring)
/*
@Service
public class UserService {
    @Autowired private StringRedisTemplate redisTemplate;
    public String getUserName(Long id) {
        String cacheKey = "user:name:" + id;
        String cached = redisTemplate.opsForValue().get(cacheKey);
        if (cached != null) return cached;
        String name = dbFindUserName(id); // DB 조회
        redisTemplate.opsForValue().set(cacheKey, name, 10, TimeUnit.MINUTES);
        return name;
    }
    private String dbFindUserName(Long id) { return "홍길동"; }
}
*/

// Caffeine 벤치마크 예제
/*
Cache<String, String> cache = Caffeine.newBuilder()
    .expireAfterWrite(10, TimeUnit.MINUTES)
    .maximumSize(1000)
    .build();
long start = System.nanoTime();
for (int i = 0; i < 100000; i++) cache.put("k"+i, "v"+i);
long end = System.nanoTime();
System.out.println("Caffeine put 10만건: " + (end-start)/1_000_000 + "ms");
*/

// 캐시 무효화 전략
/*
// 1. TTL(Time To Live) 설정
// 2. 데이터 변경 시 캐시 삭제(redisTemplate.delete(key))
// 3. Pub/Sub으로 캐시 동기화
// 4. Cache Aside 패턴 적용
*/

public class CacheExamples {
    public static void main(String[] args) {
        System.out.println("Redis, Caffeine 벤치마크, 캐시 무효화 전략 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 