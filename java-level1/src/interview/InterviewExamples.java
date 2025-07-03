/*
 * 실전 면접/코딩테스트 대비
 * - 자주 나오는 알고리즘/자료구조, 실전 면접 질문/답변 정리
 */

// 예시: 알고리즘, 자료구조, 면접 Q&A (주석 참고)
/*
// 1. 알고리즘 예제: 이진 탐색
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

// 2. 자료구조 예제: Stack
Stack<Integer> stack = new Stack<>();
stack.push(1); stack.pop();

// 3. 면접 Q&A
Q: Java에서 HashMap과 Hashtable의 차이점은?
A: HashMap은 동기화되지 않으며, Hashtable은 동기화되어 있습니다.
*/

public class InterviewExamples {
    public static void main(String[] args) {
        System.out.println("알고리즘, 자료구조, 면접 Q&A 등은 주석의 예시를 참고하세요.\n실행은 IDE에서 가능합니다.");
    }
} 