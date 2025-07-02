/*
 * Java Stream API 이론 및 실무 예제
 *
 * 1. Stream API란?
 *  - 자바 8부터 도입된 컬렉션 데이터 처리용 API
 *  - 선언형(what) 방식으로 데이터 필터링, 변환, 집계 가능
 *  - 원본 데이터 불변, 파이프라인 처리, 내부 반복(Internal Iteration)
 *
 * 2. 주요 특징
 *  - 데이터 소스: 컬렉션, 배열, 파일 등
 *  - 중간 연산: filter, map, sorted, distinct, limit, skip 등
 *  - 최종 연산: forEach, collect, reduce, count, anyMatch 등
 *  - 지연 연산, 병렬 처리(parallelStream)
 *
 * 3. 실무 활용 예제
 */

import java.util.*;
import java.util.stream.*;

public class StreamApiAdvancedExamples {
    // 1. 기본 사용법
    public static void basicUsage() {
        List<String> names = Arrays.asList("홍길동", "이순신", "강감찬", "홍길동");
        names.stream()
            .distinct()
            .filter(name -> name.startsWith("홍"))
            .sorted()
            .forEach(System.out::println);
    }

    // 2. 숫자 집계 및 변환
    public static void numberAggregate() {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("합계: " + sum);
        Arrays.stream(numbers)
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .forEach(System.out::println);
    }

    // 3. collect로 리스트 변환
    public static void collectToList() {
        List<String> names = Arrays.asList("홍길동", "이순신", "강감찬");
        List<String> threeLetterNames = names.stream()
            .filter(name -> name.length() == 3)
            .collect(Collectors.toList());
        System.out.println(threeLetterNames);
    }

    // 4. reduce로 누적 연산
    public static void reduceExample() {
        int[] numbers = {1, 2, 3, 4, 5};
        int product = Arrays.stream(numbers)
            .reduce(1, (a, b) -> a * b);
        System.out.println("곱셈 결과: " + product);
    }

    // 5. 병렬 스트림
    public static void parallelStreamExample() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum = numbers.parallelStream()
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("병렬 합계: " + sum);
    }

    // 6. 실무 예제: 객체 리스트 필터, 그룹핑, 통계
    static class Employee {
        String name;
        String department;
        int salary;
        int age;
        Employee(String name, String department, int salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }
        public String toString() {
            return name + "(" + department + ", " + salary + ", " + age + ")";
        }
    }

    public static void employeeExamples() {
        List<Employee> employees = Arrays.asList(
            new Employee("홍길동", "개발", 5000, 29),
            new Employee("이순신", "기획", 4000, 35),
            new Employee("강감찬", "개발", 6000, 41),
            new Employee("유관순", "디자인", 3500, 27),
            new Employee("김유신", "개발", 7000, 38)
        );

        // 1) 개발팀만 추출, 연봉 6000 이상만 이름 출력
        employees.stream()
            .filter(e -> e.department.equals("개발"))
            .filter(e -> e.salary >= 6000)
            .map(e -> e.name)
            .forEach(System.out::println);

        // 2) 부서별 인원수 집계
        Map<String, Long> deptCount = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
        System.out.println(deptCount);

        // 3) 부서별 평균 연봉
        Map<String, Double> avgSalary = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department, Collectors.averagingInt(e -> e.salary)));
        System.out.println(avgSalary);

        // 4) 연봉이 가장 높은 직원 찾기
        employees.stream()
            .max(Comparator.comparingInt(e -> e.salary))
            .ifPresent(e -> System.out.println("최고 연봉: " + e));

        // 5) 나이순 정렬 후 상위 3명 출력
        employees.stream()
            .sorted(Comparator.comparingInt(e -> e.age))
            .limit(3)
            .forEach(System.out::println);
    }

    // 7. 실무 예제: flatMap, Optional, 복합 데이터 처리
    public static void flatMapAndOptionalExample() {
        List<List<String>> nested = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D", "E"),
            Arrays.asList("F")
        );
        // 2차원 리스트를 1차원으로 평탄화
        List<String> flat = nested.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
        System.out.println(flat);

        // Optional: 특정 조건의 값 찾기
        List<Integer> nums = Arrays.asList(10, 20, 30, 40);
        Optional<Integer> found = nums.stream().filter(n -> n > 25).findFirst();
        found.ifPresent(n -> System.out.println("25보다 큰 첫 값: " + n));
    }

    // 8. 실무 예제: 파일에서 Stream 처리 (try-with-resources)
    public static void fileStreamExample(String filePath) throws Exception {
        try (Stream<String> lines = java.nio.file.Files.lines(java.nio.file.Paths.get(filePath))) {
            long count = lines.filter(line -> line.contains("Java")).count();
            System.out.println("'Java'가 포함된 라인 수: " + count);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("[기본 사용법]");
        basicUsage();
        System.out.println("\n[숫자 집계 및 변환]");
        numberAggregate();
        System.out.println("\n[collect로 리스트 변환]");
        collectToList();
        System.out.println("\n[reduce로 누적 연산]");
        reduceExample();
        System.out.println("\n[병렬 스트림]");
        parallelStreamExample();
        System.out.println("\n[실무 Employee 예제]");
        employeeExamples();
        System.out.println("\n[flatMap, Optional 예제]");
        flatMapAndOptionalExample();
        // 파일 스트림 예제는 파일 경로를 인자로 전달해야 합니다.
        // fileStreamExample("sample.txt");
    }
} 