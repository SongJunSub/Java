/*
 * 컬렉션 프레임워크 심화
 * - List, Set, Map의 다양한 구현체 비교 및 활용
 * - 불변 컬렉션, 동기화 컬렉션, Concurrent 컬렉션
 */
import java.util.*;
import java.util.concurrent.*;

public class CollectionAdvancedExamples {
    public static void main(String[] args) {
        // 1. 다양한 List 구현체
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        arrayList.add("A"); arrayList.add("B");
        linkedList.add("X"); linkedList.add("Y");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 2. Set 구현체 (HashSet, TreeSet)
        Set<String> hashSet = new HashSet<>(Arrays.asList("A", "B", "A"));
        Set<String> treeSet = new TreeSet<>(Arrays.asList("B", "A", "C"));
        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet(정렬): " + treeSet);

        // 3. Map 구현체 (HashMap, TreeMap)
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        hashMap.put("one", 1); hashMap.put("two", 2);
        treeMap.put("one", 1); treeMap.put("two", 2);
        System.out.println("HashMap: " + hashMap);
        System.out.println("TreeMap(정렬): " + treeMap);

        // 4. 불변 컬렉션
        List<String> immutableList = List.of("A", "B");
        // immutableList.add("C"); // UnsupportedOperationException
        System.out.println("불변 List: " + immutableList);

        // 5. 동기화 컬렉션
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("A");
        System.out.println("동기화 List: " + syncList);

        // 6. Concurrent 컬렉션
        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        System.out.println("ConcurrentMap: " + concurrentMap);
    }
} 