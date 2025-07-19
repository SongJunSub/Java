package collection;

import java.util.*;
import java.util.concurrent.*;

public class CollectionAdvancedExamples {

    public void listImplementations() {
        // ArrayList: 내부적으로 배열을 사용. 조회는 빠르나, 추가/삭제는 느릴 수 있음.
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        System.out.println("ArrayList: " + arrayList);

        // LinkedList: 내부적으로 양방향 연결 리스트를 사용. 추가/삭제는 빠르나, 조회는 느릴 수 있음.
        List<String> linkedList = new LinkedList<>();
        linkedList.add("X");
        linkedList.add("Y");
        System.out.println("LinkedList: " + linkedList);
    }

    public void setImplementations() {
        // HashSet: 순서를 보장하지 않음. 중복을 허용하지 않음.
        Set<String> hashSet = new HashSet<>(Arrays.asList("A", "B", "A"));
        System.out.println("HashSet: " + hashSet);

        // TreeSet: 정렬된 순서를 보장함. 중복을 허용하지 않음.
        Set<String> treeSet = new TreeSet<>(Arrays.asList("B", "A", "C"));
        System.out.println("TreeSet(정렬): " + treeSet);
    }

    public void mapImplementations() {
        // HashMap: 순서를 보장하지 않음.
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        System.out.println("HashMap: " + hashMap);

        // TreeMap: 키에 따라 정렬된 순서를 보장함.
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("one", 1);
        treeMap.put("two", 2);
        System.out.println("TreeMap(정렬): " + treeMap);
    }

    public void immutableCollections() {
        // List.of()로 생성된 리스트는 불변.
        List<String> immutableList = List.of("A", "B");
        System.out.println("불변 List: " + immutableList);
        // immutableList.add("C"); // 실행 시 UnsupportedOperationException 발생
    }

    public void synchronizedCollections() {
        // Collections.synchronizedList()로 동기화된 리스트를 생성.
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("A");
        System.out.println("동기화 List: " + syncList);
    }

    public void concurrentCollections() {
        // ConcurrentHashMap: 동시성 환경에서 안전하게 사용 가능.
        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        System.out.println("ConcurrentMap: " + concurrentMap);
    }

    public static void main(String[] args) {
        CollectionAdvancedExamples examples = new CollectionAdvancedExamples();
        examples.listImplementations();
        examples.setImplementations();
        examples.mapImplementations();
        examples.immutableCollections();
        examples.synchronizedCollections();
        examples.concurrentCollections();
    }
}