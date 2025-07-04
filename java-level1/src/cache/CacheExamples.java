/*
 * 실전 캐시 전략
 * - Redis, Caffeine, Ehcache 등 활용법, 캐시 무효화/동기화 패턴
 */

// 예시: Redis, Caffeine, Ehcache (주석 참고)
/*
// Redis 예제 (Spring)
@Autowired
private StringRedisTemplate redisTemplate;
redisTemplate.opsForValue().set("key", "value");

// Caffeine 예제
Cache<String, String> cache = Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).build();
cache.put("key", "value");

// Ehcache 예제 (XML 설정)
<cache name="myCache" maxEntriesLocalHeap="1000" timeToLiveSeconds="600"/>
*/

public class CacheExamples {
    public static void main(String[] args) {
        System.out.println("Redis, Caffeine, Ehcache 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 