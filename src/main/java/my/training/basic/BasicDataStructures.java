package my.training.basic;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

/**
 * 기본 자료구조와 알고리즘 구현
 *
 * 이 클래스는 배열, 문자열, 연결 리스트, 스택, 큐, 해시 테이블을 포함한 기본 자료구조와 알고리즘 문제의 구현을 다룹니다.
 */
public class BasicDataStructures {

    /**
     * 배열과 문자열 - 회문 확인
     *
     * @param inputString 입력 문자열
     * @return 주어진 문자열이 회문인지 여부
     */
    public boolean isPalindrome(String inputString) {
        int left = 0, right = inputString.length() - 1;
        while (left < right) {
            if (inputString.charAt(left) != inputString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 단일 연결 리스트 반전
     *
     * @param head 연결 리스트의 첫 번째 노드
     * @return 반전된 연결 리스트의 새로운 헤드
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * 괄호 유효성 검사
     *
     * @param s 검사할 문자열
     * @return 괄호들이 유효한지 여부
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 해시 테이블을 사용한 두 수의 합 문제
     *
     * @param nums 숫자 배열
     * @param target 목표 값
     * @return 두 수의 인덱스 배열
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }

    // 연결 리스트 노드 정의
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
